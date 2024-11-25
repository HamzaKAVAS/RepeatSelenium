package day02_driverMethods_webElements;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverManageMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "kurulumDosya/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Artık her class başında yapacagız HTML kodları erişilebilir olması için

        driver.get("https://www.testotomasyonu.com");

        // açılışta window size ve konumunu yazdırın
        System.out.println("Açılışta window boyut: " + driver.manage().window().getSize()); // Açılışta window size: (1552, 840)
        System.out.println("Açılışta window konum: " + driver.manage().window().getPosition()); // Açılışta window konum: (-8, -8)

        Thread.sleep(3000);

        // Window'u fullscreen yapın
        driver.manage().window().fullscreen();

        // Fullscreen yaptığımızda size ve konumu yazdırın
        System.out.println("Fullscreen window boyut: " + driver.manage().window().getSize()); // Fullscreen window boyut: (1536, 864)
        System.out.println("Fullscreen window konum: " + driver.manage().window().getPosition()); // Fullscreen window konum: (0, 0)

        Thread.sleep(3000);

        // istedidiğimiz konum ve boyuta getirelim
        driver.manage().window().setSize(new Dimension(400, 400));
        driver.manage().window().setPosition(new Point(200, 200));

        // istediğimiz boyutta iken size ve konumunu yazdırın
        System.out.println("İstediğimiz window boyut: " + driver.manage().window().getSize()); // İstediğimiz window boyut: (516, 403)
        System.out.println("İstediğimiz window konum: " + driver.manage().window().getPosition()); // İstediğimiz window konum: (200, 200)

        Thread.sleep(3000);
        driver.quit();

    }
}
