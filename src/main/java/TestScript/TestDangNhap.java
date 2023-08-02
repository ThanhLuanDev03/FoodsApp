package TestScript;


import dao.TaiKhoanDAO;
import entity.TaiKhoan;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.DangNhapJframe;

public class TestDangNhap {
    @BeforeClass
    public void setUp() {
        System.out.println("bắt đầu test đăng nhập");
    }

    @Test
    public void tc001() {
        //Kiểm tra tính năng đăng nhập khi bỏ trống "Mật khẩu"
        DangNhapJframe dangNhapJframe = new DangNhapJframe();
        String username = "VNT2206";
        String password = ""; //để trống mật khẩu

        dangNhapJframe.txtTenDangNhap.setText(username);
        dangNhapJframe.txtMatKhau.setText(password);

        try {
            if (dangNhapJframe.kiemTra() == false) {
                System.out.println("Đăng nhập thất bại!");
            } else {
                dangNhapJframe.DangNhap();
                System.out.println("Đăng nhập thành công!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void tc002() {

        //Kiểm tra tính năng đăng nhập khi bỏ trống "Tên đăng nhập"
        String username = "";//để trống tên đăng nhập
        String password = "2206";
        DangNhapJframe dangNhapJframe = new DangNhapJframe();

        dangNhapJframe.txtTenDangNhap.setText(username);
        dangNhapJframe.txtMatKhau.setText(password);

        try {
            if (dangNhapJframe.kiemTra() == false) {
                System.out.println("Đăng nhập thất bại!");
            } else {
                dangNhapJframe.DangNhap();
                System.out.println("Đăng nhập thành công!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void tc003() {
    //Kiểm tra tính năng đăng nhập khi nhập "Tên đăng nhập" không tồn tại
        DangNhapJframe dangNhapJframe = new DangNhapJframe();
        dangNhapJframe.txtTenDangNhap.setText("VNT1010");
        dangNhapJframe.txtMatKhau.setText("2206");
        try {
            if (dangNhapJframe.DangNhap()==false){
                System.out.println("Đăng nhập thất bại");
            }else{
                System.out.println("Đăng nhập thành công");
                Assert.assertTrue(false);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void tc004() {
        //Kiểm tra tính năng đăng nhập khi nhập "Mật khẩu" không chính xác
        DangNhapJframe dangNhapJframe = new DangNhapJframe();
        dangNhapJframe.txtTenDangNhap.setText("VNT2206");
        dangNhapJframe.txtMatKhau.setText("1010");
        try {
            if (dangNhapJframe.DangNhap()==false){
                System.out.println("Đăng nhập thất bại");
            }else{
                System.out.println("Đăng nhập thành công");
                Assert.assertTrue(false);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void tc005() {
        //Kiểm tra tính năng Đăng nhập khi nhập thông tin hợp lệ
        DangNhapJframe dangNhapJframe = new DangNhapJframe();
        dangNhapJframe.txtTenDangNhap.setText("VNT2206");
        dangNhapJframe.txtMatKhau.setText("2206");
        try {
            if (dangNhapJframe.DangNhap()==false){
                System.out.println("Đăng nhập thất bại");
            }else{
                System.out.println("Đăng nhập thành công");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @AfterClass
    public void rp() {
        System.out.println("hoàn tất");

    }
}
