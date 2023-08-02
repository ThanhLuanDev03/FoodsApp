package TestScript;

import dao.KhoDAO;
import entity.NguyenLieu;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.ThemKhoJFrame;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestQLKho {
    @BeforeClass
    void setUp(){
        System.out.println("bắt đầu test QL Kho");
    }
    @Test
    public void ad012(){
        //Kiểm tra tính năng thêm nguyên liệu khi không nhập đầy đủ các trường
        try {
            NguyenLieu cd = new NguyenLieu();
            cd.setMaNL("nlt01");
            cd.setTenNL(""); //bỏ trống tên nguyên liệu
            cd.setDonvi("Kg");
            cd.setDongia(180000);
            cd.setSoluong(Float.valueOf(20));
            cd.setGiatrinhap(180000);
            cd.setHansudung("2030-11-28");

            KhoDAO khoDAO = new KhoDAO();
            ThemKhoJFrame themKhoJFrame = new ThemKhoJFrame();

            if (themKhoJFrame.validate1()==true){
                System.out.println("Thêm nguyên liệu thành công");
            }else{
                khoDAO.insert(cd);
                System.out.println("Thêm nguyên liệu thất bại");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void ad013(){
        //Kiểm tra tính năng thêm nguyên liệu khi nhập đầy đủ các trường
        try {

            NguyenLieu cd = new NguyenLieu();
            cd.setMaNL("nlt01");
            cd.setTenNL("Cá mòi khô");
            cd.setDonvi("Kg");
            cd.setDongia(180000);
            cd.setSoluong(Float.valueOf(20));
            cd.setGiatrinhap(180000);
            cd.setHansudung("2030-11-28");

            KhoDAO khoDAO = new KhoDAO();
            if (khoDAO.insert(cd)==1){
                System.out.println("Thêm nguyên liệu thành công");
            }else{
                System.out.println("Thêm nguyên liệu thất bại");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void ad014(){
        //Kiểm tra tính năng Chỉnh sửa nguyên liệu khi không  nhập đầy đủ các trường
        try {
            NguyenLieu cd = new NguyenLieu();
            cd.setMaNL("nlt01");
            cd.setTenNL(""); //bỏ trống tên nguyên liệu
            cd.setDonvi("Kg");
            cd.setDongia(180000);
            cd.setSoluong(Float.valueOf(20));
            cd.setGiatrinhap(180000);
            cd.setHansudung("2030-11-28");

            KhoDAO khoDAO = new KhoDAO();
            ThemKhoJFrame themKhoJFrame = new ThemKhoJFrame();

            if (themKhoJFrame.validate1()==true){
                System.out.println("Cập nhật nguyên liệu thành công");
                Assert.assertTrue(false);
            }else{
                System.out.println("Cập nhật nguyên liệu thất bại");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void ad015(){
        //Kiểm tra tính năng Chỉnh sửa nguyên liệu khi nhập đầy đủ các trường
        try {
            NguyenLieu cd = new NguyenLieu();
            cd.setMaNL("nlt01");
            cd.setTenNL("Cá basa"); //bỏ trống tên nguyên liệu
            cd.setDonvi("Kg");
            cd.setDongia(180000);
            cd.setSoluong(Float.valueOf(20));
            cd.setGiatrinhap(180000);
            cd.setHansudung("2030-11-28");

            KhoDAO khoDAO = new KhoDAO();

            if (khoDAO.update(cd)==1){
                System.out.println("Cập nhật nguyên liệu thành công");
            }else{
                System.out.println("Cập nhật nguyên liệu thất bại");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void ad016(){
        //Kiểm tra tính năng xóa nguyên liệu
        try {
            String manl = "nlt01";
            KhoDAO khoDAO = new KhoDAO();

            if (khoDAO.delete(manl)==1){
                System.out.println("Xóa nguyên liệu thành công!");
            }else {
                System.out.println("Xóa nguyên liệu thất bại!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @AfterClass
    void tearDown(){
        System.out.println("hoàn tất");
    }

}
