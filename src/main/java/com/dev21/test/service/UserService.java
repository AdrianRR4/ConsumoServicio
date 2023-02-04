package com.dev21.test.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev21.test.dto.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	 RestTemplate restTemplate;
	
//	private final RestTemplate restTemplate = new RestTemplate();
	
	@Value("${spring.external.service.base-url}")
	private String basePath;
	
	public List<UserResponse> getUsers() {
		UserResponse[] response= restTemplate.getForObject(basePath +"/user", UserResponse[].class );
		return Arrays.asList(response);
	}

	public void createUser(UserResponse user) {
		
		restTemplate.postForObject(basePath +"/user", user, UserResponse.class);

	}

	public void updateUser(Integer id, UserResponse user) {

		restTemplate.put(basePath+"/user/"+id,user);
	}

	public void deleteUser(Integer id) {

		restTemplate.delete(basePath+"/user/"+id);
	
	}

	
}
