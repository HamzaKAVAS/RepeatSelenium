package day02_driverMethods_webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTestOtomasyonu {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // 2. Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("Gidilen sayfanın title: " + actualTitle); // Gidilen sayfanın title: Test Otomasyonu - Test Otomasyonu

        // 3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin
        String expectedTitle = "Test Otomasyonu";
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title test PASSED"); // Title test PASSED
        } else System.out.println("Title test FAILED");

        // 4. Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Gidilen sayfanın url: " + actualUrl); // Gidilen sayfanın url: https://www.testotomasyonu.com/

        // 5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.
        String expectedUrl = "https://testotomasyonu.com/";
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Url test PASSED");
        } else System.out.println("Url test FAILED"); // Url test FAILED

        // 6. Sayfa handle degerini yazdirin
        System.out.println("Acılan Window'un window handle: " + driver.getWindowHandle());
        // Acılan Window'un window handle: CA667C06AD2801882F9EC4BCAEEDD64A

        // 7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin
        String expectedHTML = "otomasyon";
        String actualHTML = driver.getPageSource();
        if (actualHTML.contains(expectedHTML)) {
            System.out.println("aranan code PASSED"); // aranan code PASSED
        } else System.out.println("aranan code FAILED");

        // 8. Sayfayi kapatin.
        Thread.sleep(2000);
        driver.quit();

    }
}
