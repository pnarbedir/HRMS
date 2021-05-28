package kodlamaio.hrms.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	Candidate findByIdentity(String identity);

}
