package day02_driverMethods_webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_DriverManageMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Thread.sleep(2000); Thread.sleep() method'u içine yazılan süre boyunca kodları bekletir
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); ise
        // 10 saniye içerisinde gelmesi gereken webelementi ya da sayfanın açılmasını bekler eğer gelirse 10 saniyeyi
        // beklemeden yoluna devam eder ama 10.saniyeyi 1 salise geçse exception fırlatır ve çalışmayı durdurur

    }
}
