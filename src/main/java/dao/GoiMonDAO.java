package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.ThucDon;
import utils.XJdbc;

public class GoiMonDAO {
	public static ArrayList selectAll() {
		ArrayList<ThucDon> list = new ArrayList<ThucDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select maTD, tenTD, gia, hinhanh from ThucDon";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maTD = rs.getString("maTD");
				String tenTD = rs.getString("tenTD");
				int gia = rs.getInt("gia");
				String hinhanh = rs.getString("hinhanh");
				list.add(new ThucDon(maTD, tenTD, gia, null, null, hinhanh, null, null));
			}

			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<ThucDon> selectAllLoai(String str) {
		ArrayList<ThucDon> list = new ArrayList<ThucDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from ThucDon where loai like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			pstmt.setString(1, str);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maTD = rs.getString("maTD");
				String tenTD = rs.getString("tenTD");
				int gia = rs.getInt("gia");
				String loai = rs.getString("loai");
				String donViTinh = rs.getString("donViTinh");
				String hinhanh = rs.getString("hinhanh");
				String NCC = rs.getString("NCC");
				String moTa = rs.getString("moTa");

				list.add(new ThucDon(maTD, tenTD, gia, loai, donViTinh, hinhanh, NCC, moTa));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static ArrayList<ThucDon> selectAllTen(String str1, String str2) {
		ArrayList<ThucDon> list = new ArrayList<ThucDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from ThucDon where tenTD like ? and loai like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			pstmt.setString(1, str1.replaceAll("", "%"));
			pstmt.setString(2, str2);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maTD = rs.getString("maTD");
				String tenTD = rs.getString("tenTD");
				int gia = rs.getInt("gia");
				String loai = rs.getString("loai");
				String donViTinh = rs.getString("donViTinh");
				String hinhanh = rs.getString("hinhanh");
				String NCC = rs.getString("NCC");
				String moTa = rs.getString("moTa");

				list.add(new ThucDon(maTD, tenTD, gia, loai, donViTinh, hinhanh, NCC, moTa));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
