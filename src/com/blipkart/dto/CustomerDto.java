package com.blipkart.dto;

import java.util.Objects;

public class CustomerDto {
	private int id;
	private String name;
	private String email;
	private String pass;

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param pass
	 */
	public CustomerDto(int id, String name, String email, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
	}

	/**
	 * 
	 */
	public CustomerDto() {
		super();
	}

	/**
	 * @param name
	 * @param email
	 * @param pass
	 */
	public CustomerDto(String name, String email, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";

	
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, pass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(pass, other.pass);
	}

}
