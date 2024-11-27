package day04_relative_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli relative locator ile locate edip tiklayin
        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));
        driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon)).click();

        // 3 ) Acilan urunun DSLR Camera oldugunu test edin.
        WebElement acilanSayfadaUrunIsim = driver.findElement(By.xpath("//div[.='DSLR Camera']"));
        String expectedUrunIsim = "DSLR Camera";
        String actualUrunIsim = acilanSayfadaUrunIsim.getText();

        if (actualUrunIsim.contains(expectedUrunIsim)){
            System.out.println("Ürün ismi testi PASSED");
        } else System.out.println("Ürün ismi testi FAILED");

        Thread.sleep(2000);
        driver.quit();

    }
}
