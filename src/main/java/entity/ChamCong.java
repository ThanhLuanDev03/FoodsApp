package entity;

public class ChamCong {
	private String maNV, ngayChamCong,caLamViec, ghiChu;

	public ChamCong() {
		super();
	}

	public ChamCong(String maNV, String ngayChamCong, String caLamViec, String ghiChu) {
		super();
		this.maNV = maNV;
		this.ngayChamCong = ngayChamCong;
		this.caLamViec = caLamViec;
		this.ghiChu = ghiChu;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(String ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}

	public String getCaLamViec() {
		return caLamViec;
	}

	public void setCaLamViec(String caLamViec) {
		this.caLamViec = caLamViec;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	

}
