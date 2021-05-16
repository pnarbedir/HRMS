package kodlamaio.hrms.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Business.Abstracts.JobTitleService;
import kodlamaio.hrms.DataAccess.Abstracts.JobTitleDao;
import kodlamaio.hrms.Entities.Concretes.JobTitles;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}


	@Override
	public List<JobTitles> getAll() {
		// TODO Auto-generated method stub
		return jobTitleDao.findAll();
	}

}
