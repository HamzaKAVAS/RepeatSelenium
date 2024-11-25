package day02_driverMethods_webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_SepeteEkleme {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu sayfasına gidelim
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazalım ve aratalım
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone");
        Thread.sleep(3000);
        aramaKutusu.submit();

        // bulunan ürünlerden ilkinin içine girelim
        WebElement ilkUrun = driver.findElement(By.className("prod-img"));
        ilkUrun.getAttribute("APPLEL iPhone 13 (Starlight, 128 GB)");
        ilkUrun.click();
        Thread.sleep(3000);


        driver.quit();

    }
}
