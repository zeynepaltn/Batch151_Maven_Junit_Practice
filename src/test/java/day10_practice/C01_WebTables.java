package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.LinkedList;
import java.util.List;

public class C01_WebTables extends TestBase {

    // girisYap methodu olusturun
    // https://www.hotelmycamp.com adresine gidin
    // Log in butonuna tıklayın
    // Username: manager
    // Password: Manager1!

    // sutun sayısını yazdırın
    // tum body'i yazdirin
    // body'de bulunan satır sayısını yazdırın
    // body'de bulunan satırları yazdırın
    // 4.satırdaki elementleri yazdırın


    @Test
    public void test01() {

        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();

        // sutun sayısını yazdırın
        List<WebElement> sutunBasliklari=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun Basliklari sayisi = " + sutunBasliklari.size());
        bekle(2);
        // tum body'i yazdirin
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println("tum Body = " + tumBody.getText());
        System.out.println("*********************************");
        // body'de bulunan satır sayısını yazdırın
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir Sayisi = " + satirSayisi.size());
        System.out.println("*********************************");
        // body'de bulunan satırları yazdırın
        satirSayisi.forEach(t-> System.out.println(t.getText()));
        // 4.satırdaki elementleri yazdırın
        List<WebElement> satir4Elementleri=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        System.out.println("satir 4 Elementleri = " + satir4Elementleri.size());
        satir4Elementleri.forEach(t-> System.out.println(t.getText()));



    }

    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // GELİSMİS
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // GÜVENLİ DEGİL


        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // LOG IN

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        actions.
                click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
        bekle(2);



    }
}