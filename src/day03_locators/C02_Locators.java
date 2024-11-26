package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_Locators {
    public static void main(String[] args) throws InterruptedException {
        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 3- “ONLINE BANKING” linkine tiklayin
        driver.findElement(By.id("onlineBankingMenu")).click();

        // 4- Resim altinda 6 islem basligi oldugunu test edin
        List<WebElement> baslikElementList = driver.findElements(By.className("headers"));
        int expectedElementSayisi = 6;
        int actualElementSayisi = baslikElementList.size();

        if (expectedElementSayisi == actualElementSayisi) {
            System.out.println("Element sayısı test PASSED");
        } else System.out.println("Element sayısı test FAILED");

        // 5- Islem basliklari icinde “Pay Bills” oldugunu test edin
        List<String> baslikListesiStr = new ArrayList<>();

        for (WebElement eachBaslik : baslikElementList) {
            baslikListesiStr.add(eachBaslik.getText());
        }
        System.out.println(baslikListesiStr);
        // [Account Summary, Account Activity, Transfer Funds, Pay Bills, My Money Map, Online Statements]

        if (baslikListesiStr.contains("Pay Bills")) {
            System.out.println("Pay Bills test PASSED");
        } else System.out.println("Pay Bills test FAILED");

        // 6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();

    }
}
