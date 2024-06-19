package com.blipkart.dto;

import java.util.Objects;

public class AdminDto {
	private int id;
	private String name;
	private String email;
	private String pass;
	
	
	
//	Alt + s + a => to generate constructors
	/** for adminAuthentication
	 * @param id
	 * @param name
	 * @param email
	 * @param pass
	 */
	public AdminDto(int id, String name, String email, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	public AdminDto() {
		super();
	}
	
	
	
//	Alt + s + r => to generate Getter & Setter

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


	

	
//	Alt + Shift + S + S + A => to generate toString method.
	@Override
	public String toString() {
		return "AdminDto [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";
	}
	
	
//	Alt+Shift+S+H to generate hashCode() & equals()
	
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
		AdminDto other = (AdminDto) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(pass, other.pass);
	}
	
	
	
	

}
