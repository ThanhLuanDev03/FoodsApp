package entity;

public class TaiKhoan {
	private String maNV, tenTaiKhoan , matKhau , vaiTro;
	
	public TaiKhoan() {
		
	}
	
	public TaiKhoan( String tenTaiKhoan,String matKhau,String maNV, String vaiTro) {
		this.maNV = maNV;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	
}
