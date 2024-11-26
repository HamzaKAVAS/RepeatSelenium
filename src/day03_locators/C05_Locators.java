package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C05_Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        // 2- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        // 3- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.manage().window().maximize();

        // 4- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title test PASSED");
        } else System.out.println("Title test FAILED");

        // 5- Furniture linkine tiklayin
        driver.findElement(By.xpath("//li[@class='has-sub'][5]")).click();

        // 6- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        WebElement minFiyatKutusu = driver.findElement(By.xpath("//input[@class='form-control minPrice']"));
        minFiyatKutusu.clear();
        minFiyatKutusu.sendKeys("40");
        Thread.sleep(1000);

        WebElement maxFiyatKutusu = driver.findElement(By.xpath("//input[@class='form-control maxPrice']"));
        maxFiyatKutusu.clear();
        maxFiyatKutusu.sendKeys("200");
        Thread.sleep(1000);

        // 7- filtreleme sonucunda urun bulunabildigini test edin
        driver.findElement(By.xpath("//button[@class='price-range-button']")).click();
        WebElement aramaSonucuYaziElement = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        String expectedYazi = "2 Products Found";
        String actualYazi = aramaSonucuYaziElement.getText();
        if (actualYazi.contains(expectedYazi)) {
            System.out.println("Ürün bulunabilme testi PASSED");
        } else System.out.println("Ürün bulunabilme testi FAILED");

        // 8- Ilk urunu tiklayin
        driver.findElement(By.xpath("//a[.='Product Tax']")).click();
        Thread.sleep(2000);

        // 9- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyat = driver.findElement(By.xpath("//span[@id='priceproduct']"));
        String fiyatstr = urunFiyat.getText().replaceAll("\\D", ""); // 5000
        double fiyatDbl = Double.parseDouble(fiyatstr) / 100; // 50.00

        if (fiyatDbl >= 40 && fiyatDbl <= 200) {
            System.out.println("Urün fiyat test PASSED");
        } else System.out.println("Urun fiyat test FAILED");

        //10- Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
