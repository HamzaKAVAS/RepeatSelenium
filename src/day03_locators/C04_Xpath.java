package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@id='sub-btn']")).click();
        Thread.sleep(2000);

        // 3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButton = driver.findElement(By.xpath("//button[@class='remove-btn']"));
        if (removeButton.isDisplayed()) {
            System.out.println("Remove butonu testi PASSED");
        } else System.out.println("Remove butonu testi FAILED");

        // 4- Remove tusuna basin
        driver.findElement(By.xpath("//button[@class='remove-btn']")).click();
        Thread.sleep(2000);

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement = driver.findElement(By.tagName("h2"));
        if (addRemoveElement.isDisplayed()) {
            System.out.println("Add remove element test PASSED");
        } else System.out.println("Add remove element test FAILED");

        Thread.sleep(2000);
        driver.quit();
    }
}
