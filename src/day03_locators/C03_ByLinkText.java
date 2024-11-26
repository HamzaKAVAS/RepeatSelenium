package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementList.size();

        if (expectedLinkSayisi == actualLinkSayisi) {
            System.out.println("Link element sayısı PASSED");
        } else System.out.println("Link element sayısı FAILED");

        // 4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();

        // 5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferYazisiElementi = driver.findElement(By.id("sale_image"));
        if (specialOfferYazisiElementi.isDisplayed()) {
            System.out.println("Special Offer Test PASSED");
        } else System.out.println("Special Offer Test FAILED");

        // 6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
