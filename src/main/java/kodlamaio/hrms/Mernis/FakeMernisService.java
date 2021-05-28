package kodlamaio.hrms.Mernis;

import kodlamaio.hrms.Entities.Concretes.Candidate;

public class FakeMernisService {

	public boolean mernisValidate(Candidate candidate) {
		if(candidate.getIdentity_number() == "77777777777" && candidate.getFirst_name() =="Pınar" && candidate.getLast_name() == "Bedir"
				&& candidate.getBirth_date().getYear() == 1998) {
			return true;
		}
		return false;
	}
	

}
