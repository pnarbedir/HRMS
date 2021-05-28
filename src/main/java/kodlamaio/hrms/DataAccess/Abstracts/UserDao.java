package kodlamaio.hrms.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {

	User findByEmail(String email);

}
