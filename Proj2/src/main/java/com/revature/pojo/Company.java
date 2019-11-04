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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "COMPANIES")
@Component
public class Company {

	@Id
	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "EMAIL")
	private String companyEmail;

	@Column(name = "LINK")
	private String companyLink;

	@Column(name = "PASS")
	private String password;

	@Column(name = "ACCESS_CODE")
	private String accessCode;

	@Column(name = "RATING")
	private double companyRating;

	@Enumerated(EnumType.STRING)
	@Column(name = "ACCESS_LEVEL")
	private AccessLevel accessLevel;

	@ManyToMany(mappedBy = "parentCompanies")
	private Set<User> employees = new HashSet<User>();

	@OneToMany(mappedBy = "referencedCompany", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Post> approvedPosts = new HashSet<Post>();

	@ManyToMany(fetch = FetchType.LAZY) // naming convention -> Should be Companies_Affiliated
	@JoinTable(name = "AFFILIATED_COMPANIES", joinColumns = @JoinColumn(name = "COMPANY_NAME"), inverseJoinColumns = @JoinColumn(name = "AFFILIATE_NAME"))
	private Set<Company> affiliatedCompanies = new HashSet<Company>();

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyLink() {
		return companyLink;
	}

	public void setCompanyLink(String companyLink) {
		this.companyLink = companyLink;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public double getCompanyRating() {
		return companyRating;
	}

	public void setCompanyRating(double companyRating) {
		this.companyRating = companyRating;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Set<User> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<User> employees) {
		this.employees = employees;
	}

	public Set<Post> getApprovedPosts() {
		return approvedPosts;
	}

	public void setApprovedPosts(Set<Post> approvedPosts) {
		this.approvedPosts = approvedPosts;
	}

	public Set<Company> getAffiliatedCompanies() {
		return affiliatedCompanies;
	}

	public void setAffiliatedCompanies(Set<Company> affiliatedCompanies) {
		this.affiliatedCompanies = affiliatedCompanies;
	}

	public Company(String companyName, String companyEmail, String companyLink, String password, String accessCode,
			double companyRating, AccessLevel accessLevel, Set<User> employees, Set<Post> approvedPosts,
			Set<Company> affiliatedCompanies) {
		super();
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyLink = companyLink;
		this.password = password;
		this.accessCode = accessCode;
		this.companyRating = companyRating;
		this.accessLevel = accessLevel;
		this.employees = employees;
		this.approvedPosts = approvedPosts;
		this.affiliatedCompanies = affiliatedCompanies;
	}

	public Company(String companyName, String companyEmail, String password, String accessCode) {
		super();
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.password = password;
		this.accessCode = accessCode;
	}

	public Company() {
		super();
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyEmail=" + companyEmail + ", companyLink=" + companyLink
				+ ", password=" + password + ", accessCode=" + accessCode + ", companyRating=" + companyRating
				+ ", accessLevel=" + accessLevel + ", employees=" + employees + ", approvedPosts=" + approvedPosts
				+ ", affiliatedCompanies=" + affiliatedCompanies + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessCode == null) ? 0 : accessCode.hashCode());
		result = prime * result + ((accessLevel == null) ? 0 : accessLevel.hashCode());
		result = prime * result + ((affiliatedCompanies == null) ? 0 : affiliatedCompanies.hashCode());
		result = prime * result + ((approvedPosts == null) ? 0 : approvedPosts.hashCode());
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + ((companyLink == null) ? 0 : companyLink.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(companyRating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Company other = (Company) obj;
		if (accessCode == null) {
			if (other.accessCode != null)
				return false;
		} else if (!accessCode.equals(other.accessCode))
			return false;
		if (accessLevel != other.accessLevel)
			return false;
		if (affiliatedCompanies == null) {
			if (other.affiliatedCompanies != null)
				return false;
		} else if (!affiliatedCompanies.equals(other.affiliatedCompanies))
			return false;
		if (approvedPosts == null) {
			if (other.approvedPosts != null)
				return false;
		} else if (!approvedPosts.equals(other.approvedPosts))
			return false;
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (companyLink == null) {
			if (other.companyLink != null)
				return false;
		} else if (!companyLink.equals(other.companyLink))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (Double.doubleToLongBits(companyRating) != Double.doubleToLongBits(other.companyRating))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	// open means posts go on open market boards. affiliated means the company has
	// some control over companies. closed mean only employees can see their posts
	public static enum AccessLevel {
		OPEN, AFFILIATED, CLOSED
	}

}
