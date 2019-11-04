package com.revature.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS")
@Component
public class User{

	@Id
	@Column(name = "EMAIL")
	// @Pattern(regexp = "\\w+", message = "Must start with a letter[a-z, A-Z]")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PHONE")
	private String phoneNumber;

	@ManyToMany
	@JoinTable(name = "COMPANY_USER", joinColumns = @JoinColumn(name = "EMAIL"), 
	inverseJoinColumns = @JoinColumn(name = "COMPANY_NAME"))
	@JsonIgnore
	private Set<Company> parentCompanies = new HashSet<Company>();

	@Column(name = "BIO")
	private String biography;

	@Column(name = "RESUME")
	private String resume;

	@OneToMany(mappedBy = "postingUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Post> postedPost = new HashSet<Post>();

	@ManyToOne
	@JoinColumn(name = "POST_ID")
	@JsonIgnore
	private Post acceptedPost;

	@Column(name = "RATING")
	private double rating;

	@Enumerated(EnumType.STRING)
	@Column(name = "ACCESS_LEVEL")
	private AccessLevel accessLevel;

	@Enumerated(EnumType.STRING)
	@Column(name = "WORK_TYPE")
	private WorkType workType;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Company> getParentCompanies() {
		return parentCompanies;
	}

	public void setParentCompanies(Set<Company> parentCompanies) {
		this.parentCompanies = parentCompanies;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Set<Post> getPostedPost() {
		return postedPost;
	}

	public void setPostedPost(Set<Post> postedPost) {
		this.postedPost = postedPost;
	}

	public Post getAcceptedPost() {
		return acceptedPost;
	}

	public void setAcceptedPost(Post acceptedPost) {
		this.acceptedPost = acceptedPost;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", parentCompanies=" + parentCompanies + ", biography=" + biography
				+ ", resume=" + resume + ", postedPost=" + postedPost + ", acceptedPost=" + acceptedPost + ", rating="
				+ rating + ", accessLevel=" + accessLevel + ", workType=" + workType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptedPost == null) ? 0 : acceptedPost.hashCode());
		result = prime * result + ((accessLevel == null) ? 0 : accessLevel.hashCode());
		result = prime * result + ((biography == null) ? 0 : biography.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((parentCompanies == null) ? 0 : parentCompanies.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((postedPost == null) ? 0 : postedPost.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		result = prime * result + ((workType == null) ? 0 : workType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (acceptedPost == null) {
			if (other.acceptedPost != null)
				return false;
		} else if (!acceptedPost.equals(other.acceptedPost))
			return false;
		if (accessLevel != other.accessLevel)
			return false;
		if (biography == null) {
			if (other.biography != null)
				return false;
		} else if (!biography.equals(other.biography))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (parentCompanies == null) {
			if (other.parentCompanies != null)
				return false;
		} else if (!parentCompanies.equals(other.parentCompanies))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (postedPost == null) {
			if (other.postedPost != null)
				return false;
		} else if (!postedPost.equals(other.postedPost))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		if (workType != other.workType)
			return false;
		return true;
	}

	public User(String email, String password, String firstName, String lastName, String phoneNumber,
			Set<Company> parentCompanies, String biography, String resume, Set<Post> postedPost, Post acceptedPost,
			double rating, AccessLevel accessLevel, WorkType workType) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.parentCompanies = parentCompanies;
		this.biography = biography;
		this.resume = resume;
		this.postedPost = postedPost;
		this.acceptedPost = acceptedPost;
		this.rating = rating;
		this.accessLevel = accessLevel;
		this.workType = workType;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static enum AccessLevel {
		OPEN, AFFILIATED, CLOSED;
	}

	public static enum WorkType {
		FRONTHOUSE, FLOOR, BACKHOUSE, HOST, MAITRED, WAITER, BARTENDER, BUSSER, BARBACK, SOMMELIER, HEADCHEF, PREPCHEF,
		LINECHEF
	}

	

}
