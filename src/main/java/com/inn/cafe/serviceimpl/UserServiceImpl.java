package com.inn.cafe.serviceimpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.cafe.POJO.User;
import com.inn.cafe.constant.CafeConstant;
import com.inn.cafe.dao.UserDAO;
import com.inn.cafe.service.UserService;
import com.inn.cafe.utils.CafeUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	

	@Override
	public ResponseEntity<String> signup(Map<String, String> requesMap) {		
		log.info("Inside signup{}",requesMap);
		if(validateSignup(requesMap)) {
			User user = userDao.findByEmailId(requesMap.get("email"));
			if (Objects.isNull(user)) {
				userDao.save(getUserFromMap(requesMap));
				return CafeUtils.getResponseEntity("Succesfully Registered", HttpStatus.OK);
			}else {
				return CafeUtils.getResponseEntity("Email already existis", HttpStatus.BAD_REQUEST);
			}
			
		} else {
			return CafeUtils.getResponseEntity(CafeConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}		
	}
	
	private boolean validateSignup(Map<String, String>requesMap){
		if (requesMap.containsKey("name") && requesMap.containsKey("contactNumber")
		&& requesMap.containsKey("email")&& requesMap.containsKey("password")) {
			return true;
		}else {
			return false;
		}	
		
	}
	
	private User getUserFromMap(Map<String, String >requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));		
		user.setPassword(requestMap.get("password"));
		user.setRole(requestMap.get("role"));
		user.setStatus(requestMap.get("status"));
		return user;
	};
	
}
