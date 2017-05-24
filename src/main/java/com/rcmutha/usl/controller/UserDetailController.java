package com.rcmutha.usl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcmutha.usl.repository.UserRepository;

@RestController
public class UserDetailController {

	private Logger logger = (Logger) LoggerFactory.getLogger(UserDetailController.class);
	
	@Autowired(required = true)
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String addNewUser(@RequestBody UserDetailModel user) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		logger.debug("in controller");
		UserDetailModel userDtl = new UserDetailModel();
		userDtl.setUser_id(user.user_id);
		userDtl.setUser_name(user.user_name);
		userDtl.setActive_status(user.active_status);
		userDtl.setPassword(user.password);

		userRepository.save(userDtl);
		return "Saved";
	}
}