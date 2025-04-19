package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class FormDoldurmaGonderme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 1. Sayfaya git
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // 2. Form alanlarını doldur input oldugu icin nesne olusturmayiz
        driver.findElement(By.name("my-text")).sendKeys("Test Kullanıcısı");
        driver.findElement(By.name("my-password")).sendKeys("Sifre123");
        driver.findElement(By.name("my-textarea")).sendKeys("Bu bir test açıklamasıdır.");

        // Dropdown seçimi nesne olusturduk
        WebElement dropdown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");

        // Dropdown datalist seçimi
        driver.findElement(By.name("my-datalist")).sendKeys("New York");


        // Checkbox seçimi
        WebElement checkbox = driver.findElement(By.name("my-check"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        // Radio button seçimi
        driver.findElement(By.id("my-radio-1")).click();
        // Color picker
        driver.findElement(By.name("my-colors")).sendKeys("#00ff00");

        // Date picker
        driver.findElement(By.name("my-date")).sendKeys("2025-04-20");

        // Range (slider)
        driver.findElement(By.name("my-range")).sendKeys("1");

        // Submit butonuna tıkla
        WebElement loginButton = driver.findElement(By.cssSelector("button"));
        loginButton.click();

        //Sonuç mesajını kontrol et
        WebElement message = driver.findElement(By.id("message"));
        if (message.isDisplayed()) {
            System.out.println("✅ Form başarıyla gönderildi. Mesaj: " + message.getText());
        } else {
            System.out.println("❌ Mesaj görüntülenemedi.");
        }

        try {
            Thread.sleep(5000); // 5 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tarayıcıyı kapat
        driver.quit();
    }
}
