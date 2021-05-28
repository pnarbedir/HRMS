package kodlamaio.hrms.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
