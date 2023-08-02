package entity;

import java.util.Date;

public class NguyenLieu {
	private String maNL;
	private String tenNL;
	private String donvi;
	private int dongia;
	private float soluong;
	private int giatrinhap;
	private String hansudung;
	public NguyenLieu() {
		
	}

	public NguyenLieu(String maNL, String tenNL, String donvi, int dongia, float soluong, int giatrinhap, String hansudung) {
		super();
		this.maNL = maNL;
		this.tenNL = tenNL;
		this.donvi = donvi;
		this.dongia = dongia;
		this.soluong = soluong;
		this.giatrinhap = giatrinhap;
		this.hansudung = hansudung;
	}

	public String getMaNL() {
		return maNL;
	}

	public void setMaNL(String maNL) {
		this.maNL = maNL;
	}

	public String getTenNL() {
		return tenNL;
	}

	public void setTenNL(String tenNL) {
		this.tenNL = tenNL;
	}

	public String getDonvi() {
		return donvi;
	}

	public void setDonvi(String donvi) {
		this.donvi = donvi;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

	public float getSoluong() {
		return soluong;
	}

	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}

	public int getGiatrinhap() {
		return giatrinhap;
	}

	public void setGiatrinhap(int giatrinhap) {
		this.giatrinhap = giatrinhap;
	}

	public String getHansudung() {
		return hansudung;
	}

	public void setHansudung(String hansudung) {
		this.hansudung = hansudung;
	}
	

}
