package peter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="USERS")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=3, max=30, message="Pole od 3 do 30")
	@Column(name="first_name")
	private String firstName;
	
	@Size(min=3, max=30, message="Pole od 3 do 30")
	@Column(name="second_name")
	private String secondName;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull
	@Column(name="birth_date")
	private Date birthDate;
	
	public User() {	
	}
	
	public User(int id, String firstName, String secondName, Date birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDate = birthDate;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
