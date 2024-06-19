package com.blipkart.dto;

import java.util.Objects;

public class SellerDto {
	
	private int id;
	private String name;
	private String email;
	private String pass;
	private String verify;
	
	
	
	
	
	
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param pass
	 * @param verify
	 */
	public SellerDto(int id, String name, String email, String pass, String verify) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.verify = verify;
	}
	
	/**
	 * @param name
	 * @param email
	 * @param pass
	 * @param verify
	 */
	public SellerDto(String name, String email, String pass, String verify) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.verify = verify;
	}

	/**
	 * 
	 */
	public SellerDto() {
		super();
	}









	@Override
	public String toString() {
		return "SellerDto [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", verify=" + verify
				+ "]";
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
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, pass, verify);
	}









	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellerDto other = (SellerDto) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(pass, other.pass) && Objects.equals(verify, other.verify);
	}
	
	
	
	
	

}
