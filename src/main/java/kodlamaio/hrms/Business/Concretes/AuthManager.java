package kodlamaio.hrms.Business.Concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Business.Abstracts.AuthService;
import kodlamaio.hrms.Business.Abstracts.CandidateService;
import kodlamaio.hrms.Business.Abstracts.EmployeeService;
import kodlamaio.hrms.Business.Abstracts.EmployerService;
import kodlamaio.hrms.Business.Abstracts.UserService;
import kodlamaio.hrms.Core.Utilities.Adapters.ValidationService;
import kodlamaio.hrms.Core.Utilities.Results.ErrorResult;
import kodlamaio.hrms.Core.Utilities.Results.Result;
import kodlamaio.hrms.Core.Utilities.Results.SuccessResult;
import kodlamaio.hrms.Entities.Concretes.Candidate;
import kodlamaio.hrms.Entities.Concretes.Employer;
@Service
public class AuthManager implements AuthService {
	private EmployerService employerService;
	private CandidateService candidateService;
	private ValidationService validationService;
	private UserService userService;
	
	@Autowired
	public AuthManager(EmployerService employerService, EmployeeService employeeService,CandidateService candidateService, ValidationService validationService,UserService userService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.validationService = validationService;
		this.userService = userService;
	}
	
	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkEmployerMissingInfo(employer)) {
			
			return new ErrorResult("Please fill in all blanks!");
		}
		
		if (!checkIfEmailExists(employer.getEmail())) {
			
			return new ErrorResult(employer.getEmail() + "already registered");
		}
		
		if (!checkIfEqualMailAndWebdomain(employer.getEmail(), employer.getWeb_address())) {
			
			return new ErrorResult("Email address does not match");
		}
		
		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {
			
			return new ErrorResult("passwords do not match");
		}
		
		employerService.add(employer);
		return new SuccessResult("The employer has been successfully registered");
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		
		if (checkIfRealPerson(candidate) == false) {
			
			return new ErrorResult("there is no person.");
		}
		
		if (!checkIfEmailExists(candidate.getEmail())) {
			
			return new ErrorResult(candidate.getEmail() + "already registered");
		}
		
		if (!checkCandidateMissingInfo(candidate, confirmPassword)) {
			
			return new ErrorResult("Please fill in all blanks!");
		}
		
		if (!checkIfIdentityExist(candidate.getIdentity_number())) {
			
			return new ErrorResult(candidate.getIdentity_number() + "already registered");
		}
		
		if (!checkIfEqualPasswordAndConfirmPassword(candidate.getPassword(), confirmPassword)) {
			
			return new ErrorResult("passwords do not match");
		}
		
		candidateService.add(candidate);
		return new SuccessResult("The candidate has been successfully registered");
	}

	
	private boolean checkIfEqualMailAndWebdomain(String email,String website) {
		
		String[] emailAry = email.split("@", 2);
		
		String domain = website.substring(4, website.length());
		
		if (emailAry[1].equals(domain)) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			
			return false;
		}
		
		return true;
	}
	
	private boolean checkIfEmailExists(String email) {
		
		if (this.userService.getByEmail(email).getData() == null) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean checkIfRealPerson(Candidate candidate) {
		
		if (validationService.mernisValidate(candidate)) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkIfIdentityExist(String identity) {
		
		if (candidateService.findByIdentity(identity).getData() == null) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkEmployerMissingInfo(Employer employer) {
		
		if (employer.getCompany_email() != null && employer.getWeb_address() != null && employer.getCompany_name() != null
				&& employer.getPhone_number() != null && employer.getPassword() != null) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkCandidateMissingInfo(Candidate candidate,String confirmPassword) {
		if (candidate.getIdentity_number() != null && candidate.getFirst_name() != null && 
				candidate.getLast_name() != null && candidate.getEmail() != null && confirmPassword != null &&
				candidate.getBirth_date() != null && candidate.getPassword() != null) {
			
			return true;
		}
		
		return false;
	}

}
