package kodlamaio.hrms.Entities.Concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor

public class Employer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="web_address")
	private String web_address;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="company_email")
	private String company_email;
	
	@Column(name="is_activated")
	private boolean is_activated;
	

	public Employer(int id, String email, String password, int id2, String company_name, String web_address,
			String phone_number, String company_email, boolean is_activated) {
		super(id, email, password);
		id = id2;
		this.company_name = company_name;
		this.web_address = web_address;
		this.phone_number = phone_number;
		this.company_email = company_email;
		this.is_activated = is_activated;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getWeb_address() {
		return web_address;
	}


	public void setWeb_address(String web_address) {
		this.web_address = web_address;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getCompany_email() {
		return company_email;
	}


	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}


	public boolean isIs_activated() {
		return is_activated;
	}


	public void setIs_activated(boolean is_activated) {
		this.is_activated = is_activated;
	}
	

}
