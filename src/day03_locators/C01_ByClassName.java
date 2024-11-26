package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        // 3- arama kutusuna phone yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // aramaKutusu.submit();

        // 4- Category bolumunde 8 element oldugunu test edin
        List<WebElement> categoryElementListesi = driver.findElements(By.className("panel-list"));
        int expectedCategorySayisi = 8;
        int actualCategorySayisi = categoryElementListesi.size();

        if (expectedCategorySayisi == actualCategorySayisi) {
            System.out.println("Category Element Test PASSED");
        } else System.out.println("Category Element Test FAILED");

        // 5- Category isimlerini yazdirin
        for (WebElement eachElement : categoryElementListesi) {
            System.out.println(eachElement.getText());
        }

        // 6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
