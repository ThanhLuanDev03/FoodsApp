package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.NhanVien;
import entity.ThucDon;
import utils.XJdbc;

public class NhanVienDAO {

	public static List<NhanVien> list = new ArrayList<>();

	public static int insertNhanVien(NhanVien NV) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into NhanVien values (?,?,?,?,?,?,?,?,?,?,?)";
			connection = XJdbc.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, NV.getMaNV());
			statement.setString(2, NV.getTenNV());
			statement.setString(3, NV.getSDT());
			statement.setString(4, NV.getNgaySinh());
			statement.setString(5, NV.getDiaChi());
			statement.setString(6, NV.getNgayLamViec());
			statement.setString(7, NV.getCalamviec());
			statement.setString(8, NV.getCongviec());
			statement.setInt(9, NV.getMucluong());
			statement.setString(10, NV.getHinhAnh());
			statement.setString(11, NV.getMoTa());
			statement.executeUpdate();
			connection.close();
			statement.close();
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	public static int deleteByMaNV(String maNV) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "delete from NhanVien where maNV=?";
			connection = XJdbc.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, maNV);
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

	public static  int updateByMaMaNV(NhanVien NV) {
		Connection connection = null;

		try {
			String sSQL = "update NhanVien set tenNV=? , SDT =?, ngaysinh=?,ngaylamviec =?, calamviec=?, congviec = ? ,  mucluong = ?, hinhanh = ? ,moTa = ? , diaChi = ? where maNV=? ";
			connection = XJdbc.getConnection();
			PreparedStatement statement = connection.prepareStatement(sSQL);
			statement.setString(11, NV.getMaNV());
			statement.setString(1, NV.getTenNV());
			statement.setString(2, NV.getSDT());
			statement.setString(3, NV.getNgaySinh());
			statement.setString(4, NV.getNgayLamViec());
			statement.setString(5, NV.getCalamviec());
			statement.setString(6,NV.getCongviec());
			statement.setInt(7, NV.getMucluong());
			statement.setString(8, NV.getHinhAnh());
			statement.setString(9, NV.getMoTa());
			statement.setString(10, NV.getDiaChi());

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

	public static List<NhanVien> getAllNhanVien() {
		List<NhanVien> ls = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sSQL = "select * from NhanVien";
			connection = XJdbc.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sSQL);
			while (rs.next()) {
				NhanVien NV = new NhanVien();
				NV.setMaNV(rs.getString(1));
				NV.setTenNV(rs.getString(2));
				NV.setSDT(rs.getString(3));
				NV.setNgaySinh(rs.getString(4));
				NV.setDiaChi(rs.getString(5));
				NV.setNgayLamViec(rs.getString(6));
				NV.setCalamviec(rs.getString(7));
				NV.setCongviec(rs.getString(8));
				NV.setMucluong(rs.getInt(9));
				NV.setHinhAnh(rs.getString(10));
				NV.setMoTa(rs.getString(11));
				ls.add(NV);

			}
			connection.close();
			statement.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());
		}
		return ls;

	}

	public static NhanVien selectByMaNV(String maNV) {
		NhanVien NV = null;
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from NhanVien where maNV like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				NV = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}

		return NV;
	}

	public static ArrayList<NhanVien> selectAllTen(String str) {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from NhanVien where tenNV like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, str.replace("", "%"));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				NhanVien NV = new NhanVien();
				NV.setMaNV(rs.getString(1));
				NV.setTenNV(rs.getString(2));
				NV.setSDT(rs.getString(3));
				NV.setNgaySinh(rs.getString(4));
				NV.setDiaChi(rs.getString(5));
				NV.setNgayLamViec(rs.getString(6));
				NV.setCalamviec(rs.getString(7));
				NV.setCongviec(rs.getString(8));
				NV.setMucluong(rs.getInt(9));
				NV.setHinhAnh(rs.getString(10));
				NV.setMoTa(rs.getString(11));
				list.add(NV);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static ArrayList<NhanVien> selectAllByVaiTro(String str) {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Connection connection = XJdbc.getConnection();
			String sql = "select * from NhanVien where congviec like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, str);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				NhanVien NV = new NhanVien();
				NV.setMaNV(rs.getString(1));
				NV.setTenNV(rs.getString(2));
				NV.setSDT(rs.getString(3));
				NV.setNgaySinh(rs.getString(4));
				NV.setDiaChi(rs.getString(5));
				NV.setNgayLamViec(rs.getString(6));
				NV.setCalamviec(rs.getString(7));
				NV.setCongviec(rs.getString(8));
				NV.setMucluong(rs.getInt(9));
				NV.setHinhAnh(rs.getString(10));
				NV.setMoTa(rs.getString(11));
				list.add(NV);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}


}
