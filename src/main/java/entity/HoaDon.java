package entity;

public class HoaDon {
	private String maHD, nhanvien, hinhthuc, trangthai, giothanhtoan, giotamtinh;
	private int soban, tongtien;

	public HoaDon(String maHD, String nhanvien, String hinhthuc, int soban, String trangthai, String giotamtinh,
			String giothanhtoan, int tongtien) {
		this.maHD = maHD;
		this.nhanvien = nhanvien;
		this.hinhthuc = hinhthuc;
		this.soban = soban;
		this.trangthai = trangthai;
		this.giothanhtoan = giothanhtoan;
		this.giotamtinh = giotamtinh;
		this.tongtien = tongtien;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getNhanvien() {
		return nhanvien;
	}

	public int getSoban() {
		return soban;
	}

	public void setSoban(int soban) {
		this.soban = soban;
	}

	public void setNhanvien(String nhanvien) {
		this.nhanvien = nhanvien;
	}

	public String getHinhthuc() {
		return hinhthuc;
	}

	public void setHinhthuc(String hinhthuc) {
		this.hinhthuc = hinhthuc;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public String getGiothanhtoan() {
		return giothanhtoan;
	}

	public void setGiothanhtoan(String giothanhtoan) {
		this.giothanhtoan = giothanhtoan;
	}

	public String getGiotamtinh() {
		return giotamtinh;
	}

	public void setGiotamtinh(String giotamtinh) {
		this.giotamtinh = giotamtinh;
	}

}
