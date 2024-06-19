package com.blipkart.dto;

import java.time.LocalDate;
import java.util.Objects;

public class CartDto {
	
	private int id;
	private int pid;
	private String pname;
	private float pprice;
	private LocalDate pmfd;
	private int pquan;
	private String pbuyer;
	/**
	 * @param id
	 * @param pid
	 * @param pname
	 * @param pprice
	 * @param pmfd
	 * @param pquan
	 */
	public CartDto(int id, int pid, String pname, float pprice, LocalDate pmfd, int pquan) {
		super();
		this.id = id;
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pmfd = pmfd;
		this.pquan = pquan;
	}
	
	/**
	 * 
	 */
	public CartDto() {
		super();
	}
	
	/**
	 * @param pid
	 * @param pname
	 * @param pprice
	 * @param pmfd
	 * @param pquan
	 */
	public CartDto(int pid, String pname, float pprice, LocalDate pmfd, int pquan) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pmfd = pmfd;
		this.pquan = pquan;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

	public LocalDate getPmfd() {
		return pmfd;
	}

	public void setPmfd(LocalDate pmfd) {
		this.pmfd = pmfd;
	}

	public int getPquan() {
		return pquan;
	}

	public void setPquan(int pquan) {
		this.pquan = pquan;
	}

	public String getPbuyer() {
		return pbuyer;
	}

	public void setPbuyer(String pbuyer) {
		this.pbuyer = pbuyer;
	}

	@Override
	public String toString() {
		return "CartDto [id=" + id + ", pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pmfd=" + pmfd
				+ ", pquan=" + pquan + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pbuyer, pid, pmfd, pname, pprice, pquan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDto other = (CartDto) obj;
		return id == other.id && Objects.equals(pbuyer, other.pbuyer) && pid == other.pid
				&& Objects.equals(pmfd, other.pmfd) && Objects.equals(pname, other.pname)
				&& Float.floatToIntBits(pprice) == Float.floatToIntBits(other.pprice) && pquan == other.pquan;
	}
}
