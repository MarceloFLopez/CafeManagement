package com.inn.cafe.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<String> signup(Map<String, String> requesMap);

}
