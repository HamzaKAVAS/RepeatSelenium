package day01_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_WebDriverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testotomasyonu.com");
        // eğer https yazmassak kod çalışmaz ama www koymazsak kodun çalışmasına eneglleyen bir durum olmaz

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/  ( url verir )
        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu ( sayfanın başlığını bize getirir )
        System.out.println("==============================================");
        System.out.println(driver.getPageSource()); // sitenin html ve css codelarını getirir
        System.out.println("==============================================");
        System.out.println(driver.getWindowHandle()); // 8B1934CD544E5DDA6BACFEB5356FF67F  ( açılan widnow'un handle dır )
        System.out.println(driver.getWindowHandles()); // [8B1934CD544E5DDA6BACFEB5356FF67F] ( birden fazla açılan windowların handle'ını
        // bize bir Set halinde getitir )


        Thread.sleep(2000);
        driver.quit(); // birden fazla window kapatır
        // driver.close(); // bu ise tek bir window kapatır

    }
}
