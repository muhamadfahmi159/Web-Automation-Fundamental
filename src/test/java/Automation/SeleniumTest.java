package Automation;

import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {

    private WebDriver driver;
    private IDriverManager driverManager = new ChromeDriverManager();

    @BeforeMethod
    public void setUp() {
        driverManager.openBrowser();
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitBrowser();
    }

    @Test
    public void yopmail() {
        driver.get("https://yopmail.com/");

        try {
            Thread.sleep(1000); // Menunggu sesaat sebelum mencari elemen
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Masukkan kota asal (Kulon Progo Regency, Indonesia)
        WebElement originInput = driver.findElement(By.id("login")); //input[@id='login']
        originInput.sendKeys("automationtest");
        // Tunggu beberapa saat
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Klik button Search
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='md']"));
        searchButton.click();

        // Tunggu beberapa detik agar hasil pencarian muncul
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Temukan iFrame dengan XPath atau ID
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='ifmail']"));

        // Beralih ke iFrame
        driver.switchTo().frame(iFrame);

        // Sekarang Anda dapat mencari elemen dalam iFrame
        WebElement elementInsideFrame = driver.findElement(By.xpath("//div[@class='ellipsis nw b f18']"));
        String elementInsideIFrame = elementInsideFrame.getText();
        System.out.println("Email: " + elementInsideIFrame);
//
//        // Setelah selesai, beralih kembali ke default content
//        driver.switchTo().defaultContent();
//
//        // Ekstrak value paling atas
//        WebElement topemail = driver.findElement(By.xpath("iframe[id='ifmail']"));
//        ////div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']
//        String topEmail = topemail.getText();
//
//        System.out.println("Email: " + topEmail);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Menutup browser
        driver.quit();
        // Perform actions and assertions
    }
}
