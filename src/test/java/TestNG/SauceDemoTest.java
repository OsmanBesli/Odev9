package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class SauceDemoTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    //test metodlarınd önce çalışır.(Sadece 1 kere tarayıcı ayaga kalkacak)
    @BeforeClass
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        System.out.println("Page Title: " + driver.getTitle());

        //Username, password ve girilir sonra  login butonuna tıla.
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='user-name']")));
        driver.findElement(By.cssSelector("[id='user-name']")).click();
        driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id='password']")).click();
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id='login-button']")).click();
        Thread.sleep(1000);

        //Sepete ekle ve sepete git butonuna tıkla.
        driver.findElement(By.cssSelector("[id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='shopping_cart_badge']")).click();
        driver.findElement(By.cssSelector("[id='checkout']")).click();
        Thread.sleep(1000);

        //Alıcı adı,  soyad ve posta kodunu gir.
        driver.findElement(By.cssSelector("[id='first-name']")).click();
        driver.findElement(By.cssSelector("[id='first-name']")).sendKeys("Osman");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id='last-name']")).click();
        driver.findElement(By.cssSelector("[id='last-name']")).sendKeys("Besli");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id='postal-code']")).click();
        driver.findElement(By.cssSelector("[id='postal-code']")).sendKeys("34000");
        Thread.sleep(1000);

        //Butun alanlar dolduktan sonra Continue-->Finish ve BackToHome butonlarına sırasıyla tıkla.
        driver.findElement(By.cssSelector("[id='continue']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id='finish']")).click();
        Thread.sleep(1000);
        //Back to home butonuna tıkla.
        driver.findElement(By.cssSelector("[id='back-to-products']")).click();
        Thread.sleep(1000);
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
