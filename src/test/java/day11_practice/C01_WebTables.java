package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test01() {
        girisYap();
        //Email basligindaki tum elementleri yazidirin
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if(basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }

        }
        List<WebElement> emailSutunu=driver.findElements(By.xpath("//tbody//tr//td["+(emailSutunNo+1)+"]"));
        emailSutunu.forEach(t-> System.out.println(t.getText()));

        //List<WebElement> emailSutunu=driver.findElements(By.xpath("//tbody//tr//td[3]")); //dinamik olmayan kod
        //emailSutunu.forEach(t-> System.out.println(t.getText()));


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
