package com.cubic.ehr.prescriber.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.cubic.ehr.common.Gender;
import com.cubic.ehr.common.Specialization;
import com.cubic.ehr.common.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class PrescriberVO {

	private Long id;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private Long faxNumber;
	private String email;
	private String deaNumber;
	private Specialization specialization;
	private Date createdDate;
	private Date modifiedDate;
	private Status status;
	private String description;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
	private Date dob;
	private Gender gender;

	public PrescriberVO() {
	}

	public PrescriberVO(Long id, String firstName, String lastName, Long phoneNumber, Long faxNumber, String email,
			String deaNumber, Specialization specialization, Date createdDate, Date modifiedDate, Status status,
			String description, Date dob, Gender gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.email = email;
		this.deaNumber = deaNumber;
		this.specialization = specialization;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.description = description;
		this.dob = dob;
		this.gender = gender;
	}

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(Long faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeaNumber() {
		return deaNumber;
	}

	public void setDeaNumber(String deaNumber) {
		this.deaNumber = deaNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PrescriberVO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", faxNumber=" + faxNumber + ", email=" + email + ", deaNumber=" + deaNumber
				+ ", specialization=" + specialization + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", status=" + status + ", description=" + description + ", dob=" + dob + ", gender="
				+ gender + "]";
	}
}
