package com.blipkart.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ProductDto {
	private int id;
	private String name;
	private float price;
	private LocalDate mfd;
	private String seller;
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param mfd
	 */
	public ProductDto(int id, String name, float price, LocalDate mfd, String seller) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.mfd = mfd;
		this.seller=seller;
	}
	
	/**
	 * @param name
	 * @param price
	 * @param mfd
	 * @param seller
	 */
	public ProductDto(String name, float price, LocalDate mfd, String seller) {
		super();
		this.name = name;
		this.price = price;
		this.mfd = mfd;
		this.seller = seller;
	}

	/**
	 * 
	 */
	public ProductDto() {
		super();
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", seller="+seller+", name=" + name + ", price=" + price + ", mfd=" + mfd + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, mfd, name, price, seller);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		return id == other.id && Objects.equals(mfd, other.mfd) && Objects.equals(name, other.name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(seller, other.seller);
	}
	
		
	
	
	

}
