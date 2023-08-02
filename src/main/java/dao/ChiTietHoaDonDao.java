package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.ChiTietHoaDon;
import utils.XJdbc;

public class ChiTietHoaDonDao {

	public static int insert(ChiTietHoaDon cthd) {
		try {
			Connection con = XJdbc.getConnection();

			String sqlInsert = "insert into ChiTietHoaDon values (?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sqlInsert);

			pstmt.setString(1, cthd.getMaHD());
			pstmt.setString(2, cthd.getTenTD());
			pstmt.setInt(3, cthd.getGia());
			pstmt.setInt(4, cthd.getSoluong());
			pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			return 0;
		}
		return 1;
	}

	public static int delete(String maHD) {
		int ketQua = 0;
		try {
			Connection con = XJdbc.getConnection();

			String sqlDelte = "delete from ChiTietHoaDon where maHD like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlDelte);

			pstmt.setString(1, maHD);
			ketQua = pstmt.executeUpdate();

			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	public static ArrayList<ChiTietHoaDon> selectAllByID(String s) {
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from Chitiethoadon where maHD like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);
			pstmt.setString(1, s);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				String tenTD = rs.getString("tenTD");
				int gia = rs.getInt("gia");
				int soluong = rs.getInt("soluong");

				list.add(new ChiTietHoaDon(maHD, tenTD, gia, soluong));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
