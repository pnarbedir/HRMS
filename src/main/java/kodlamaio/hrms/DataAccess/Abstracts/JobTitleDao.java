package kodlamaio.hrms.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.JobTitles;

public interface JobTitleDao extends JpaRepository<JobTitles,Integer> {
	
	

}
