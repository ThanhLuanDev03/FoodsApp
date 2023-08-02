package entity;

public class ChiTietHoaDon {
	private String maHD, tenTD;
	private int gia, soluong;

	public ChiTietHoaDon(String maHD, String tenTD, int gia, int soluong) {
		super();
		this.maHD = maHD;
		this.tenTD = tenTD;
		this.gia = gia;
		this.soluong = soluong;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getTenTD() {
		return tenTD;
	}

	public void setTenTD(String tenTD) {
		this.tenTD = tenTD;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
}
