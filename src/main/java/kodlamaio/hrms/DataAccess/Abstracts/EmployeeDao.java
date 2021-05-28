package kodlamaio.hrms.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
