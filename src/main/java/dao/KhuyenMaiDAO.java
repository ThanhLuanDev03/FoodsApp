package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.KhuyenMai;
import entity.NguyenLieu;
import utils.XJdbc;

public class KhuyenMaiDAO {
	public static ArrayList selectAll() {
		ArrayList<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select maKM, tenKM, mota, giatri, soluong  from KhuyenMai";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maKM = rs.getString("maKM");
				String tenKM = rs.getString("tenKM");
				String mota = rs.getString("mota");
				int giatri = rs.getInt("giatri");
				int soluong = rs.getInt("soluong");
				list.add(new KhuyenMai(maKM, tenKM, mota, giatri, soluong));
			}

			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static int insert(KhuyenMai nl) {
		int ketQua = 0;
		try {
			Connection con = XJdbc.getConnection();

			 String sql = "INSERT INTO KhuyenMai (maKM, tenKM, mota, giatri, soluong) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nl.getMaKM());
			pstmt.setString(2, nl.getTenKM());
			pstmt.setString(3, nl.getMota());
			pstmt.setInt(4, nl.getGiatri());
			pstmt.setInt(5, nl.getSoluong());
			ketQua = pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public static int update(KhuyenMai nl) {
		int ketQua = 0;
		try {
			Connection con = XJdbc.getConnection();

			String sql = "UPDATE KhuyenMai SET  maKM=?, tenKM=?, mota=?, giatri=?, soluong=? WHERE maKM=?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nl.getMaKM());
			pstmt.setString(2, nl.getTenKM());
			pstmt.setString(3, nl.getMota());
			pstmt.setInt(4, nl.getGiatri());
			pstmt.setInt(5, nl.getSoluong());
			pstmt.setString(6, nl.getMaKM());
			ketQua = pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	public static int delete(String nl) {
		int ketQua = 0;
		try {
			Connection con = XJdbc.getConnection();

			String sql = "DELETE FROM KhuyenMai WHERE maKM=?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, nl);
			ketQua = pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
