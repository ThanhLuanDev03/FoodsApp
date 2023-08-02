package TestScript;

import dao.NhanVienDAO;
import entity.NhanVien;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.DangNhapJframe;
import ui.QuanLyNhanVienJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.WindowEvent;

public class TestQLNhanVien {
    @BeforeClass
    public void setup() {
        System.out.println("bắt đầu test quản lý nhân viên");
    }

    @Test
    public void ad007() {
        //Kiểm tra tính năng thêm nhân viên khi không nhập thông tin các trường
        try {
            NhanVien NV = new NhanVien();
            NV.setMaNV("");
            NV.setTenNV("");
            NV.setSDT("");
            NV.setNgaySinh("");
            NV.setDiaChi("");
            NV.setNgayLamViec("");
            NV.setCalamviec("");
            NV.setCongviec("");
            NV.setMucluong(Integer.parseInt(""));
            NV.setHinhAnh("");
            NV.setMoTa("");

            NhanVienDAO nhanVienDAO = new NhanVienDAO();
            nhanVienDAO.insertNhanVien(NV);
            if (nhanVienDAO.insertNhanVien(NV) == 0) {
                System.out.println("thêm nhân viên thất bại");
            } else {
                System.out.println("thêm nhân viên thành công");
            }

        } catch (Exception e) {
            System.out.println("Vui lòng nhập đủ thông tin nhân viên");
        }
    }

    @Test
    public void ad008() {
        //Kiểm tra tính năng thêm nhân viên khi nhập đủ thông tin các trường
        try {
            NhanVien NV = new NhanVien();
            NV.setMaNV("PS00002");
            NV.setTenNV("Nguyễn Văn B");
            NV.setSDT("0123456789");
            NV.setNgaySinh("2003-09-12");
            NV.setDiaChi("TP HCM");
            NV.setNgayLamViec("2003-09-12");
            NV.setCalamviec("Ca 1");
            NV.setCongviec("Thu Ngân");
            NV.setMucluong(Integer.parseInt("20000"));
            NV.setHinhAnh("duidequay.png");
            NV.setMoTa("Test 01");

            NhanVienDAO nhanVienDAO = new NhanVienDAO();
            if (nhanVienDAO.insertNhanVien(NV) == 1) {
                System.out.println("thêm nhân viên thành công");
            } else {
                System.out.println("thêm nhân viên thất bại");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test
    public void ad009 (){
        try {
            //Kiểm tra tính năng chỉnh sửa nhân viên khi không nhập đầy đủ các thông tin nhân viên
            NhanVien NV = new NhanVien();
            NV.setMaNV("PS00002");
            NV.setTenNV(""); // bỏ trống tên
            NV.setSDT("0123456789");
            NV.setNgaySinh("2003-09-12");
            NV.setDiaChi("TP Hà Nội");// thay đổi địa chỉ
            NV.setNgayLamViec("2003-09-12");
            NV.setCalamviec("Ca 1");
            NV.setCongviec("Thu Ngân");
            NV.setMucluong(Integer.parseInt("20000"));
            NV.setHinhAnh("duidequay.png");
            NV.setMoTa("Test 01");

            NhanVienDAO nhanVienDAO = new NhanVienDAO();
            QuanLyNhanVienJFrame quanLyNhanVienJFrame = new QuanLyNhanVienJFrame();

            if (quanLyNhanVienJFrame.validateForm()==false){
                System.out.println("Cập nhật nhân viên thất bại!");

            }else{
                nhanVienDAO.updateByMaMaNV(NV);
                System.out.println("Cập nhật nhân viên thành công");
                Assert.assertTrue(false);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void ad010(){
        //Kiểm tra tính năng chỉnh sửa nhân viên khi  nhập đầy đủ các thông tin nhân viên
        try {
            NhanVien NV = new NhanVien();
            NV.setMaNV("PS00002");
            NV.setTenNV("Lung Thị Linh"); // đổi tên
            NV.setSDT("0123456789");
            NV.setNgaySinh("2003-09-12");
            NV.setDiaChi("TP Đà Nẵng");// đổi địa chỉ
            NV.setNgayLamViec("2003-09-12");
            NV.setCalamviec("Ca 2");
            NV.setCongviec("Thu Ngân");
            NV.setMucluong(Integer.parseInt("20000"));
            NV.setHinhAnh("duidequay.png");
            NV.setMoTa("Test 01");

            NhanVienDAO nhanVienDAO = new NhanVienDAO();

            if (nhanVienDAO.updateByMaMaNV(NV)==-1){
                System.out.println("Cập nhật nhân viên thất bại!");
                Assert.assertTrue(false);
            }else{
                System.out.println("Cập nhật nhân viên thành công");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void ad011(){
        //Kiểm tra tính năng xóa nhân viên
        try {
            String maNV = "PS00001";
            NhanVienDAO nhanVienDAO = new NhanVienDAO();
            if (nhanVienDAO.deleteByMaNV(maNV)==-1){
                System.out.println("Xóa nhân viên thất bại");
            }else {
                System.out.println("Xóa nhân viên thành công");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    @AfterClass
    void tearDown(){
        System.out.println("hoàn tất!");
    }

}
