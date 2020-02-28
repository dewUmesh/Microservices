package com.example.components.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.components.user.model.CreateUser;
import sun.applet.resources.MsgAppletViewer;

/*
 *  This is the controller for user entity .
 *  Define operations (get,post,put,delete) entities
 */

@RestController
@RequestMapping("users")
public class Users {

	@Autowired
	CreateUser createUser;
	Map<String, CreateUser> usermap = new HashMap<>();

	@GetMapping
	public Map <String,CreateUser> getUsers(@RequestParam(value = "page", defaultValue = "50") int page,
									@RequestParam(value = "limit", defaultValue = "1") int limit) {
		String t=null;
		System.out.println(t.length());
		// "This is GET user RESTful service page : " + page + " :limit : " + limit;
		return usermap;
	}

	@GetMapping(path = "{uid}", produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

	public CreateUser getUser(@PathVariable(value = "uid") String uid) {

		return usermap.get(uid);
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public CreateUser createUser(@Valid @RequestBody CreateUser createdUser) {
		System.out.println("Inside post");
		createdUser.setId(UUID.randomUUID().toString());
		usermap.put(createdUser.getId(), createdUser);
		return usermap.get(createdUser.getId());
	}

	@PutMapping(path = "{uid}")
	public String updateUser(@PathVariable (value = "uid") String uid,@RequestBody CreateUser updateduser) {
		updateduser.setId(uid);
		usermap.put(uid,updateduser);
		return "This is UPDATE user RESTful service";

	}

	@DeleteMapping(path = "{uid}")
	public String deleteUser(@PathVariable (value = "uid") String uid) {
		usermap.remove(uid);


		return "This is DELETE user RESTful service";

	}
}
