package day02_driverMethods_webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_ByClassname {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazıp aratın
        // Kodlarımız ile reel browser'daki bir webelement'i kullanabilmek için
        // önce o webelementi kodlarımızla tanımlayıp
        // bir obje olarak class'a kaydetmeliyiz

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone");
        Thread.sleep(3000);
        aramaKutusu.submit();

        // arama sonucunda urun bulunabildiğini test edin
        // bulunan urunleri class attribute'u sayesinde toplu olarak locate edebiliyoruz

        List<WebElement> bulunanElementUrunleriList = driver.findElements(By.className("prod-img")); // birden fazla ürün için

        int actualBulunanElementUrunleri = bulunanElementUrunleriList.size(); // 4

        if (actualBulunanElementUrunleri > 0) {
            System.out.println("Search Test PASSED"); // Search Test PASSED
        } else System.out.println("Search Test FAILED");

        Thread.sleep(2000);
        driver.quit();

    }
}
