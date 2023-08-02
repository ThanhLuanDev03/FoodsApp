package entity;

public class NhanVien {
	private String maNV , tenNV, congviec, SDT, ngaySinh,diaChi, ngayLamViec,caLamViec, hinhAnh, moTa;
	private int mucluong;
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV, String tenNV,String sDT,  String ngaySinh, String diaChi,String ngayLamViec,String calamviec, String congviec, 
			 int mucluong , String hinhAnh , String moTa) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.congviec = congviec;
		SDT = sDT;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.ngayLamViec = ngayLamViec;
		this.mucluong = mucluong;
		this.caLamViec = calamviec;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getCongviec() {
		return congviec;
	}
	public void setCongviec(String congviec) {
		this.congviec = congviec;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getNgayLamViec() {
		return ngayLamViec;
	}
	public void setNgayLamViec(String ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
	}
	public int getMucluong() {
		return mucluong;
	}
	public void setMucluong(int mucluong) {
		this.mucluong = mucluong;
	}
	public String getCalamviec() {
		return caLamViec;
	}
	public void setCalamviec(String calamviec) {
		this.caLamViec = calamviec;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
}
