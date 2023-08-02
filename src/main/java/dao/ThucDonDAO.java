package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.ThucDon;
import utils.XJdbc;

public class ThucDonDAO {

	public static List<ThucDon> ls = new ArrayList<>();

	public static int add(ThucDon TD) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			String sql = "insert into ThucDon  values (?,?,?,?,?,?,?,?)";
			connection = XJdbc.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, TD.getMaTD());
			statement.setString(2, TD.getTenTD());
			statement.setInt(3, TD.getGia());
			statement.setString(4, TD.getLoai());
			statement.setString(5, TD.getDonViTinh());
			statement.setString(6, TD.getHinhanh());
			statement.setString(7, TD.getNCC());
			statement.setString(8, TD.getMoTa());

			if (statement.executeUpdate() > 0) {
				return 1;
			}
			connection.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

	public static int deleteByMaTD(String maTD) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "delete from ThucDon where maTD=?";
			connection = XJdbc.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, maTD);
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

	public static int updateThucDonByMaTD(ThucDon TD) {
		try {
			String sSQL = "update ThucDon set tenTD=? , gia=? ,loai =?,donViTinh = ?,  hinhanh=? , NCC = ? , moTa = ? where maTD=? ";
			Connection connection = XJdbc.getConnection();
			PreparedStatement statement = connection.prepareStatement(sSQL);
			statement.setString(1, TD.getTenTD());
			statement.setInt(2, TD.getGia());
			statement.setString(3, TD.getLoai());
			statement.setString(4, TD.getDonViTinh());
			statement.setString(5, TD.getHinhanh());
			statement.setString(6, TD.getNCC());
			statement.setString(7, TD.getMoTa());
			statement.setString(8, TD.getMaTD());
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

	public static List<ThucDon> getAllThucDon() {
		List<ThucDon> ls = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sSQL = "select * from ThucDon";
			connection = XJdbc.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sSQL);
			while (rs.next()) {
				ThucDon TD = new ThucDon();
				TD.setMaTD(rs.getString(1));
				TD.setTenTD(rs.getString(2));
				TD.setGia(rs.getInt(3));
				TD.setLoai(rs.getString(4));
				TD.setDonViTinh(rs.getString(5));
				TD.setHinhanh(rs.getString(6));
				ls.add(TD);
			}
			connection.close();
			statement.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());
		}
		return ls;

	}

	public static ThucDon selectByMaTD(String maTD) {
		ThucDon TD = null;
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from ThucDon where maTD like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maTD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TD = new ThucDon(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}

		return TD;
	}

	public static ArrayList<ThucDon> selectAllTen(String str) {
		ArrayList<ThucDon> list = new ArrayList<ThucDon>();
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from ThucDon where TenTD like ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, str.replace("", "%"));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ThucDon TD = new ThucDon();
				TD.setMaTD(rs.getString(1));
				TD.setTenTD(rs.getString(2));
				TD.setGia(rs.getInt(3));
				TD.setLoai(rs.getString(4));
				TD.setDonViTinh(rs.getString(5));
				TD.setHinhanh(rs.getString(6));
				TD.setNCC(rs.getString(7));
				TD.setMoTa(rs.getString(8));
				list.add(TD);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static ArrayList<ThucDon> selectAllByLoai(String str) {
		ArrayList<ThucDon> list = new ArrayList<ThucDon>();
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from ThucDon where loai like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, str);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ThucDon TD = new ThucDon();
				TD.setMaTD(rs.getString(1));
				TD.setTenTD(rs.getString(2));
				TD.setGia(rs.getInt(3));
				TD.setLoai(rs.getString(4));
				TD.setDonViTinh(rs.getString(5));
				TD.setHinhanh(rs.getString(6));
				TD.setNCC(rs.getString(7));
				TD.setMoTa(rs.getString(8));
				list.add(TD);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}


}
