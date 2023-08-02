package Y5;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SaveTestNGResultToExcel {
    public WebDriver driver;
    public UIMap uimap;
    public UIMap datafile;
    public String workingDir;

    HSSFWorkbook workbook;
    HSSFSheet sheet;

    Map<String, Object[]> TestNGResult;

    public static String driverPath = "D:\\Fpt Polytechnic\\2023\\SOF304_Kiểm thử nâng cao\\TaiNguyen\\selenium-server-standalone-3.13.0";

    @Test(description = "Opens the TestNG Demo Website for Login Test", priority = 1)
    public void LaunchWebsite() throws Exception {
        try {
            driver.get("https://ap.poly.edu.vn/login");
            driver.manage().window().maximize();
            TestNGResult.put("2", new Object[]{1d, "Navigate to demo website", "Site gets opened", "Pass"});

        } catch (Exception e) {
            TestNGResult.put("2", new Object[]{1d, "Navigate to demo website", "Site gets opened", "Fail"});
            Assert.assertTrue(false);
        }
    }

    @Test(description = "Fill the Login Details", priority = 2)
    public void FillLoginDetails() throws Exception {
        try {
//            WebElement campusDropdown = driver.findElement(uimap.getLocator("Select_field"));
            Select campusSelect = new Select(driver.findElement(uimap.getLocator("Select_field")));
            campusSelect.selectByVisibleText("CĐ Hồ Chí Minh"); // thay Tên cơ sở bằng giá trị muốn chọn

            Thread.sleep(12000);
            //click the login button ap.poly
            WebElement btnlogin = driver.findElement(uimap.getLocator("Login_button"));
            btnlogin.click();

            //Điền email
            WebElement fillEmail = driver.findElement(By.id("identifierId"));
            fillEmail.sendKeys("trieuphps24912@fpt.edu.vn");
            Thread.sleep(5000);
            //click the login button gmail
            WebElement btnGoogleLogin = driver.findElement(By.id("identifierNext"));
            btnGoogleLogin.click();
            Thread.sleep(5000);
            //điền password
            WebElement fillPass = driver.findElement(By.className("whsOnd"));
            fillPass.sendKeys("phtgmail1209");
//            Thread.sleep(3000);
            //click the login button gmail
            WebElement btnGoogleLogin2 = driver.findElement(By.id("passwordNext"));
            btnGoogleLogin2.click();
            Thread.sleep(3000);

            TestNGResult.put("3", new Object[]{2d, "Fill Login form data (Username/Password",
                    "Login details gets filled", "Pass"});

        } catch (Exception e) {
            TestNGResult.put("3", new Object[]{2d, "Fill Login form data (Username/Password",
                    "Login form gets filled", "Fail"});
            Assert.assertTrue(false);
        }
    }

    @Test(description = "Perform Login", priority = 3)
    public void DoLogin() throws Exception {
        try {

            TestNGResult.put("4", new Object[]{3d, "Click Login and verify welcome message", "Login success", "Pass"});
        } catch (Exception e) {
            TestNGResult.put("4", new Object[]{3d, "Click Login and verify welcome message", "Login success", "Fail"});
            Assert.assertTrue(false);

        }
    }


    @BeforeClass(alwaysRun = true)
    public void suiteSetUp() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("TestNG Result Summary");
        TestNGResult = new LinkedHashMap<String, Object[]>();

        TestNGResult.put("1", new Object[]{"Test Step No.", "Action", "Expected Output", "Actual Output"});
        try {
            workingDir = System.getProperty("user.dir");
            datafile = new UIMap(workingDir + "\\src\\main\\resources\\datafile.properties");

            uimap = new UIMap(workingDir + "\\src\\main\\resources\\locator.properties");
//            System.setProperty("webdriver.chrome.driver", "D:\\Fpt Polytechnic\\2023\\SOF304_Kiểm thử nâng cao\\TaiNguyen\\chromedriver.exe");

//            ChromeOptions chromeOptions =  new ChromeOptions();
//            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new FirefoxDriver();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (Exception e) {
            throw new IllegalStateException("Cant start the Firefox Web Driver", e);
        }
    }

    @AfterClass
    public void suiteTearDown() {
        Set<String> keyset = TestNGResult.keySet();
        int rownum = 0;
        for (String key : keyset
        ) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = TestNGResult.get(key);
            int cellnum = 0;
            for (Object obj : objArr
            ) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream("SaveTestNGResultToExcel.xls");
            workbook.write(out);
            out.close();
            System.out.println("Succesfully saved Selenium WebDriver TestNG result to Excel File!!!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }
}


