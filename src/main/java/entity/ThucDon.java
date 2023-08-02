package entity;

public class ThucDon {
	String maTD, tenTD, loai, donViTinh, hinhanh, NCC, moTa;
	int gia;

	public ThucDon() {
	}

	public ThucDon(String maTD, String tenTD, int gia, String loai, String donViTinh, String hinhanh, String nCC,
			String moTa) {
		super();
		this.maTD = maTD;
		this.tenTD = tenTD;
		this.loai = loai;
		this.donViTinh = donViTinh;
		this.hinhanh = hinhanh;
		this.NCC = nCC;
		this.moTa = moTa;
		this.gia = gia;
	}

	public String getMaTD() {
		return maTD;
	}

	public void setMaTD(String maTD) {
		this.maTD = maTD;
	}

	public String getTenTD() {
		return tenTD;
	}

	public void setTenTD(String tenTD) {
		this.tenTD = tenTD;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getNCC() {
		return NCC;
	}

	public void setNCC(String nCC) {
		this.NCC = nCC;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

}
