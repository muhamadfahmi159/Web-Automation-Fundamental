package YopMailAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YopMailAutomation {
    public static void main(String[] args) {
        // Lokasi EdgeDriver, sesuaikan dengan path di komputer Anda
        System.setProperty("webdriver.edge.driver", "path_to_edgedriver");

        // Inisialisasi WebDriver untuk Edge
        WebDriver driver = new EdgeDriver();

        // Buka Yopmail.com
        driver.get("http://www.yopmail.com");

        // Cari elemen input untuk memasukkan email "automationtest"
        WebElement searchBox = driver.findElement(By.id("login"));
        searchBox.sendKeys("automationtest");
        searchBox.submit();

        // Tunggu hingga email muncul dan klik email pertama
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstEmail = driver.findElement(By.xpath("//div[@id='m1']"));
        firstEmail.click();

        // Switch ke iframe yang berisi konten email
        driver.switchTo().frame("ifmail");

        // Ekstrak konten dari email pertama
        WebElement emailContent = driver.findElement(By.tagName("body"));
        System.out.println(emailContent.getText());

        // Kembali ke default content
        driver.switchTo().defaultContent();

        // Tutup browser
        driver.quit();
    }
}