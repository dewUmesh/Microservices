package com.example.components.user.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class CreateUser {

	@NotEmpty
	private String nameString;
	private String id;
	@NotEmpty
	@Email
	private String emaiString;

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmaiString() {
		return emaiString;
	}

	public void setEmaiString(String emaiString) {
		this.emaiString = emaiString;
	}

	@Override
	public String toString() {
		return "User [nameString=" + nameString + ", id=" + id + ", emaiString=" + emaiString + "]";
	}

}
