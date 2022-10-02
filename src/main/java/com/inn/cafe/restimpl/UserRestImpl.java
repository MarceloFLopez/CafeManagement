package com.inn.cafe.restimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.cafe.constant.CafeConstant;
import com.inn.cafe.rest.UserRest;
import com.inn.cafe.service.UserService;
import com.inn.cafe.utils.CafeUtils;

@RestController
public class UserRestImpl implements UserRest {

	@Autowired
	UserService service;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requesMap) {

		try {
			return service.signup(requesMap);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstant.SOME_STRING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
