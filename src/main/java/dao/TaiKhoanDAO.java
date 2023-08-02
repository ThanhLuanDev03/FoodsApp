package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;
import entity.TaiKhoan;
import utils.XJdbc;

public class TaiKhoanDAO {
	public static List<TaiKhoan> list = new ArrayList<TaiKhoan>();
	
	public static int insertTaiKhoan(TaiKhoan TK) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into TaiKhoan values (?,?,?,?)";
			connection = XJdbc.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, TK.getTenTaiKhoan());
			statement.setString(2, TK.getMatKhau());
			statement.setString(3, TK.getMaNV());
			statement.setString(4, TK.getVaiTro());
			statement.executeUpdate();
			connection.close();
			statement.close();
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	

	public static int deleteByTenTK(String tenTK) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "delete from TaiKhoan where tendangnhap=?";
			connection = XJdbc.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, tenTK);
			if (statement.executeUpdate() > 0) {
				return 1;
			}
			connection.close();
			statement.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());

		}
		return -1;
	}

	public static  int updateByMaTenTK(TaiKhoan TK) {
		Connection connection = null;
	
		try {
			String sSQL = "update TaiKhoan set  matkhau = ?, vaiTro = ? where tendangnhap=  ?";
			connection = XJdbc.getConnection();
			PreparedStatement statement = connection.prepareStatement(sSQL);
			statement.setString(1, TK.getMatKhau());
			statement.setString(2,TK.getVaiTro());
			statement.setString(3, TK.getTenTaiKhoan());
			if (statement.executeUpdate() > 0) {
				return 1;
			}
			connection.close();
			statement.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());

		}
		return -1;
	}
	
	public static TaiKhoan selectByMaNV(String maNV) {
		TaiKhoan TK = null;
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from TaiKhoan where maNV like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TK = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}

		return TK;
	}
	
	public static boolean selectTKByMaNV(String maNV) {
		 boolean check = false;
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select tendangnhap from TaiKhoan where maNV like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String tenTaiKhoan = rs.getString(1);
				check = true;
			}
			
			connection.close();
		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}

		return check  ;
	}
	
	public static TaiKhoan selectTKByTenDN(String tenDN) {
		 TaiKhoan tk = null;
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from TaiKhoan where tendangnhap like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tenDN);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String tendangnhap = rs.getString("tendangnhap");
				String maNV = rs.getString("maNV");
				String matkhau = rs.getString("matkhau");
				String vaiTro = rs.getString("vaitro");
				tk = new TaiKhoan(tendangnhap, matkhau,maNV, vaiTro);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}

		return tk  ;
	}
	
	
	

}
