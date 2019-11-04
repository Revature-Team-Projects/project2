package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.Company;
import com.revature.pojo.User;

@Service
public class AuthService {

	private UserService userService;
	private CompanyService companyService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Object validateEntity(String email, String password) {

//		User validatedUser = new User("angularTest@tes.com", "angularTest", "angular", "test", "800-ang-ular",
//                null, "once upon a time there was angular", "angular is hard", null, null,
//                5.0, User.AccessLevel.OPEN, User.WorkType.BACKHOUSE);
//        
//        return validatedUser;

		User validatedUser = userService.getUserByEmail(email);

		if (validatedUser == null) {
			Company validatedCompany = companyService.getCompanyByEmail(email);

			if (validatedCompany != null && password.equals(validatedCompany.getPassword())) {
				return validatedCompany;
			}
		}

		if (validatedUser != null && password.equals(validatedUser.getPassword())) {
			return validatedUser;
		}

		return null;

	}

}
