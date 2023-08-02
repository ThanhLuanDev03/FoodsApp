package TestScript;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dao.ThucDonDAO;
import entity.ThucDon;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.QuanLyThucDonJFrame;
import ui.ThucDonJInternalFrame;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

import static org.testng.Assert.*;
import static ui.ThucDonJInternalFrame.tableThucDon;

public class TestQLThucDon {
    private String name;
    public String generateUniqueName(String prefix, List<String> usedNames) {
         name = prefix + "_" + System.currentTimeMillis() + "_" + new Random().nextInt(1000);

        while (usedNames.contains(name)) {
            name = prefix + "_" + System.currentTimeMillis() + "_" + new Random().nextInt(1000);
        }

        usedNames.add(name);
        return name;
    }
    @BeforeClass
    public void setUp(){
        System.out.println("bắt đầu test QL Thực Đơn");
    }
    @Test(priority = 1)
    public void ad001() {
        //Kiểm tra tính năng thêm thực đơn khi không nhập đủ thông tin các trường
        // Chỉ nhập thông tin cho tên thưc đơn
        ThucDon TD = new ThucDon();
        ThucDonDAO thucDonDAO = new ThucDonDAO();

        try {
            if (thucDonDAO.add(TD)==1){
                System.out.println("Thêm thực đơn thành công!");
            }else {
                System.out.println("Thêm thực đơn thất bại!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test(priority = 2)
    public void ad002(){
        //Kiểm tra tính năng Thêm thực đơn khi nhập đủ thông tin các trường
        //nhập dữ liệu
        ThucDon TD = new ThucDon();
        ThucDonDAO thucDonDAO =  new ThucDonDAO();
        List<String> usedNames = new ArrayList<>();
        TD.setMaTD(generateUniqueName("testMa",usedNames));
        TD.setTenTD("testTen");
        TD.setLoai("Thức ăn");
        TD.setDonViTinh("Kg");
        TD.setGia(100000);
        TD.setHinhanh("biatiger.jpg");
        TD.setNCC("CP Foods");
        TD.setMoTa("testMoTa");

        try {
            if (thucDonDAO.add(TD) == 1) {
                System.out.println("Thêm món thành công");
            } else {
                System.out.println("Thêm món thất");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test(priority = 4)
    public void ad005(){
        //kiểm tra xóa thực đơn
        //nhập mã
        ThucDon TD = new ThucDon();
        TD.setMaTD(name);
        try {
            ThucDonDAO.deleteByMaTD(TD.getMaTD());
            System.out.println("Xóa thành công!");
        } catch (Exception e) {
            System.out.println("Xóa thất bại!");
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void ad003(){
        //Kiểm tra cập nhật thực đơn vào bảng khi nhập đủ thông tin
        //nhập dữ liệu
        ThucDon TD = new ThucDon();
        ThucDonDAO thucDonDAO =  new ThucDonDAO();
        List<String> usedNames = new ArrayList<>();
        TD.setMaTD("testMa_1680943728364_193");
        TD.setTenTD("");
        TD.setLoai("Thức ăn");
        TD.setDonViTinh("Kg");
        TD.setGia(90);
        TD.setHinhanh("biatiger.jpg");
        TD.setNCC("CP Foods");
        TD.setMoTa("testMoTa");

        try {
            System.out.println(name);
            thucDonDAO.updateThucDonByMaTD(TD);
            System.out.println("Cập nhật thành công");
        }catch (Exception e){
            System.out.println("Cập nhật thất bại");
        }
//        Assert.assertTrue(false);

    }

    @AfterClass
    public void rp(){
        System.out.println("hoàn tất");
    }
}
