package com.mentor.authentication.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mentor")
public class Mentor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "me_id")
	private Long id;
	
	@Column(name = "me_firstname")
	private String firstName;
	
	@Column(name = "me_lastname")
	private String lastName;
	
	@Column(name = "me_contact_no")
	private String contactNo;
	
	@Column(name = "me_email")
	private String email;
	
	@Column(name = "me_userid")
	private String userID;
	
	@Column(name = "me_linkedin_Url")
	private String linkedInUrl;
		
	@Column(name = "me_years_of_experience")
	private Float yearsOfExperience;
	
/*	@Column(name = "me_active")
	private Boolean active;
*/	
	@Column(name = "me_password")
	private String password;
	
	@Column(name = "me_confirm_password")
	private String confirmPassword;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="mentorId")
	private Set<MentorSkills> mentorSkillsList;
	
	@OneToMany(mappedBy ="mentorId")
	private List<MentorCalendar> mentorSchedule ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	

	public Float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	

/*	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
*/
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	
	public List<MentorCalendar> getMentorSchedule() {
		return mentorSchedule;
	}

	public void setMentorSchedule(List<MentorCalendar> mentorSchedule) {
		this.mentorSchedule = mentorSchedule;
	}

	public Set<MentorSkills> getMentorSkillsList() {
		return mentorSkillsList;
	}

	public void setMentorSkillList(Set<MentorSkills> mentorSkillsList) {
		this.mentorSkillsList = mentorSkillsList;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", email=" + email + ", userID=" + userID + ", linkedInUrl=" + linkedInUrl + ", yearsOfExperience="
				+ yearsOfExperience + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

	/*@Override
	public String toString() {
		return "Mentor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", email=" + email + ", userID=" + userID + ", linkedInUrl=" + linkedInUrl + ", yearsOfExperience="
				+ yearsOfExperience + ", active=" + active + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}*/
	

	/*public Mentor(Long id, String firstName, String lastName, String contactNo, String email, String userID,
			String linkedInUrl, Float yearsOfExperience, Boolean active, String password, String confirmPassword,
			Set<MentorSkills> mentorSkillsList, List<MentorCalendar> mentorSchedule) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.userID = userID;
		this.linkedInUrl = linkedInUrl;
		this.yearsOfExperience = yearsOfExperience;
		this.active = active;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.mentorSkillsList = mentorSkillsList;
		this.mentorSchedule = mentorSchedule;
	}

	public Mentor() {
		super();
	}
*/
	
	
	
	
	

}
