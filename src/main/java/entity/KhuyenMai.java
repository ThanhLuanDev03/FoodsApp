package entity;

public class KhuyenMai {
	private String maKM;
	private String tenKM;
	private String mota;
	private int giatri;
	private int soluong;

	public KhuyenMai() {
		
	}
	
	public KhuyenMai(String maKM, String tenKM, String mota, int giatri, int soluong) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.mota = mota;
		this.giatri = giatri;
		this.soluong = soluong;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getGiatri() {
		return giatri;
	}

	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	

}
