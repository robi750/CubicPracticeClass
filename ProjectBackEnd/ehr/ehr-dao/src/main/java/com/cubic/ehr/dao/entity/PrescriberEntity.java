package com.cubic.ehr.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubic.ehr.common.Gender;
import com.cubic.ehr.common.Specialization;
import com.cubic.ehr.common.Status;

@Entity
@Table(name = "PRESCRIBER")
public class PrescriberEntity {

	@Id
	@SequenceGenerator(name = "pSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "pSeq")
	@Column(name = "ID")
	private Long id;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "PHONENUMBER")
	private Long phoneNumber;
	@Column(name = "FAXNUMBER")
	private Long faxNumber;
	@Column(name = "EMAILI")
	private String email;
	@Column(name = "DEANUMBER")
	private String deaNumber;
	@Column(name = "SPECIALIZATION")
	@Enumerated(EnumType.STRING)
	private Specialization specialization;
	@Column(name = "CREATEDDATE", updatable=false, insertable=false)
	private Date createdDate;
	@Column(name = "MODIFIEDDATE", updatable=false, insertable=false)
	private Date modifiedDate;
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public PrescriberEntity() {
	}

	public PrescriberEntity(Long id, String firstName, String lastName, Long phoneNumber, Long faxNumber, String email,
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
		return "PrescriberEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", faxNumber=" + faxNumber + ", email=" + email + ", deaNumber=" + deaNumber
				+ ", specialization=" + specialization + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", status=" + status + ", description=" + description + ", dob=" + dob + ", gender="
				+ gender + "]";
	}

}
