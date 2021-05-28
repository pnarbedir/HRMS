package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.Utilities.Results.Result;
import kodlamaio.hrms.Entities.Concretes.Candidate;
import kodlamaio.hrms.Entities.Concretes.Employer;

public interface AuthService {
	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerCandidate(Candidate candidate, String confirmPassword);

}
