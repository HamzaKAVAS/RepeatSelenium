package day02_driverMethods_webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver","kurulumDosya/chromedriver.exe");
        // olmasada olur bazı şirketlerin kendi WebDriver objeleri vardır onu kullanmak için yine System.setProperty()
        // kullanılarak yazılır. Bazı şirketler güvenlik endişesiyle hazır Selenium'un WebDriver objesini kullanmak istemez
        // System.setProperty() Class'a tanıtmak için kullanılır
        WebDriver driver = new ChromeDriver();

        // 1) Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // url'in youtube icerdigini test edin
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Youtube Url Test PASSED");
        } else System.out.println("Youtube Url Test FAILED");

        // 2) Testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // Title'in "Test Otomasyonu" icerdigini test edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test otomasyon title PASSED");
        } else System.out.println("Test otomasyon title FAILED");

        // 3) Tekrar YouTube'sayfasina donelim
        driver.navigate().back();
        Thread.sleep(3000);

        // 4) Yeniden testotomasyonu sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(3000);

        // 5) Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(3000);

        // 6) Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();

    }
}
