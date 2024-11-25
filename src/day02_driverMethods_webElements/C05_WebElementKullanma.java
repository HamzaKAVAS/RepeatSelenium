package day02_driverMethods_webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_WebElementKullanma {
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

        // arama sonucunda ürün bulanabildiğini test edin
        // arama sonuç yazısını locate edip
        // oradaki yazının içinde bulunan sayının
        // 0'dan büyük olduğunu test edelim

        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));
        System.out.println(aramaSonucYaziElementi);
        // [[ChromeDriver: chrome on windows (c50c51ddbbefaccb24d53b1d661d59f7)] -> class name: product-count-text]

        System.out.println(aramaSonucYaziElementi.getText()); // 4 Products Found
        String sonucSayisiStr = aramaSonucYaziElementi.getText().replaceAll("\\D", "");
        System.out.println(sonucSayisiStr); // 4

        int sonucSayisi = Integer.parseInt(sonucSayisiStr); // sayı olan 4 oldu
        if (sonucSayisi > 0) {
            System.out.println("Arama testi PASSED"); // Arama testi PASSED
        } else System.out.println("Arama testi FAILED");

        Thread.sleep(3000);
        driver.quit();

    }
}
