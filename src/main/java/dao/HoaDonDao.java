package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.HoaDon;
import utils.XJdbc;

public class HoaDonDao {

	public static int insert(HoaDon hd) {
		try {
			Connection con = XJdbc.getConnection();

			String sqlInsert = "insert into HoaDon values (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sqlInsert);

			pstmt.setString(1, hd.getMaHD());
			pstmt.setString(2, hd.getNhanvien());
			pstmt.setString(3, hd.getHinhthuc());
			pstmt.setInt(4, hd.getSoban());
			pstmt.setString(5, hd.getTrangthai());
			pstmt.setString(6, hd.getGiotamtinh());
			pstmt.setString(7, hd.getGiothanhtoan());
			pstmt.setInt(8, hd.getTongtien());
			pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public static void update(String maHD, String trangthai, String giothanhtoan, int tongtien) {
		try {
			Connection con = XJdbc.getConnection();

			String sqlUpdate = "update HoaDon set trangthai  = ?, giothanhtoan  = ?, tongtien = ? where maHD = ?";

			PreparedStatement pstmt = con.prepareStatement(sqlUpdate);

			pstmt.setString(1, trangthai);
			pstmt.setString(2, giothanhtoan);
			pstmt.setInt(3, tongtien);
			pstmt.setString(4, maHD);

			pstmt.executeUpdate();

			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static int selectById(String maHD) {
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from HoaDon where maHD like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			pstmt.setString(1, maHD);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				return 1;
			}
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList<HoaDon> selectAll() {
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from HoaDon";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				String nhanvien = rs.getString("nhanvien");
				String hinhthuc = rs.getString("hinhthuc");
				int soban = rs.getInt("soban");
				String trangthai = rs.getString("trangthai");
				String giotamtinh = rs.getString("giotamtinh");
				String giothanhtoan = rs.getString("giothanhtoan");
				int tongtien = rs.getInt("tongtien");

				list.add(new HoaDon(maHD, nhanvien, hinhthuc, soban, trangthai, giotamtinh, giothanhtoan, tongtien));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<HoaDon> selectByTrangThai(String tt) {
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from HoaDon where trangthai like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			pstmt.setString(1, tt);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				String nhanvien = rs.getString("nhanvien");
				String hinhthuc = rs.getString("hinhthuc");
				int soban = rs.getInt("soban");
				String trangthai = rs.getString("trangthai");
				String giotamtinh = rs.getString("giotamtinh");
				String giothanhtoan = rs.getString("giothanhtoan");
				int tongtien = rs.getInt("tongtien");

				list.add(new HoaDon(maHD, nhanvien, hinhthuc, soban, trangthai, giotamtinh, giothanhtoan, tongtien));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<HoaDon> selectDoSearch(String textSearch, String tt) {
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from HoaDon where ( maHD like ? or soban like ? or nhanvien like ? ) and trangthai like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			pstmt.setString(1, textSearch.replace("", "%"));
			pstmt.setString(2, textSearch.replace("", "%"));
			pstmt.setString(3, textSearch.replace("", "%"));
			pstmt.setString(4, tt);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				String nhanvien = rs.getString("nhanvien");
				String hinhthuc = rs.getString("hinhthuc");
				int soban = rs.getInt("soban");
				String trangthai = rs.getString("trangthai");
				String giotamtinh = rs.getString("giotamtinh");
				String giothanhtoan = rs.getString("giothanhtoan");
				int tongtien = rs.getInt("tongtien");

				list.add(new HoaDon(maHD, nhanvien, hinhthuc, soban, trangthai, giotamtinh, giothanhtoan, tongtien));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<HoaDon> selectByDate(String tt, String tungay, String denngay) {
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from HoaDon where ( maHD like ? or soban like ? or nhanvien like ? ) and trangthai like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			pstmt.setString(1, tt);
			pstmt.setString(2, tungay);
			pstmt.setString(3, denngay);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				String nhanvien = rs.getString("nhanvien");
				String hinhthuc = rs.getString("hinhthuc");
				int soban = rs.getInt("soban");
				String trangthai = rs.getString("trangthai");
				String giotamtinh = rs.getString("giotamtinh");
				String giothanhtoan = rs.getString("giothanhtoan");
				int tongtien = rs.getInt("tongtien");

				list.add(new HoaDon(maHD, nhanvien, hinhthuc, soban, trangthai, giotamtinh, giothanhtoan, tongtien));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
