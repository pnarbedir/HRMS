package kodlamaio.hrms.Core.Utilities.Adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.Entities.Concretes.Candidate;
import kodlamaio.hrms.Mernis.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean mernisValidate(Candidate candidate) {
		FakeMernisService client = new FakeMernisService();
		return client.mernisValidate(candidate);
	}

}
