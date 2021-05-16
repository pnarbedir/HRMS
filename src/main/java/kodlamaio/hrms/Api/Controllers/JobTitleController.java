package kodlamaio.hrms.Api.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.Business.Abstracts.JobTitleService;
import kodlamaio.hrms.Entities.Concretes.JobTitles;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleController {
	
	private JobTitleService jobTitleService;

	@Autowired
	public JobTitleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getall")
	public List<JobTitles> getAll(){
		return jobTitleService.getAll();
	}
}
