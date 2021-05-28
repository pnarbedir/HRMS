
package kodlamaio.hrms.Entities.Concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidate extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="identity_number")
	private String identity;
	
	@Column(name="birth_date")
	private LocalDate  birth_date;


	public Candidate(int id, String email, String password, int id2, String first_name, String last_name,
			String identity_number, LocalDate  birth_date) {
		super(id, email, password);
		id = id2;
		this.first_name = first_name;
		this.last_name = last_name;
		this.identity = identity_number;
		this.birth_date = birth_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getIdentity_number() {
		return identity;
	}

	public void setIdentity_number(String identity_number) {
		this.identity = identity_number;
	}

	public LocalDate  getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDate  birth_date) {
		this.birth_date = birth_date;
	}

}
