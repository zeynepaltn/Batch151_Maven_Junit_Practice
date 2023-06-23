package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {

    //http://demo.guru99.com/test/delete_customer.php adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //cıkan alert mesajını yazdırın
    //alerti kabul edin
    //cıkan 2. alert mesajını yazdırın
    //cıkan 2. alerti kabul edin

    @Test
    public void name() throws InterruptedException {

        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");


        bekle(2);

        //cookie iframe code
        WebElement iframe = driver.findElement(By.xpath("//*[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='mat-focus-indicator solo-button mat-button mat-button-base mat-raised-button']")).click();
        driver.switchTo().parentFrame();


        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("53920");

        bekle(2);



        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@name='submit']")).click();


        bekle(2);




        //cıkan alert mesajını yazdırın
        String alertYazisi = driver.switchTo().alert().getText();
        System.out.println("ALERT YAZISI: " + alertYazisi);

        bekle(2);



        //alerti kabul edin
        driver.switchTo().alert().accept();

        bekle(2);



        //cıkan 2. alert mesajını yazdırın
        String  alertYazisi2 = driver.switchTo().alert().getText();
        System.out.println("ALERT YAZISI" + alertYazisi2);


        bekle(2);

        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();

        bekle(2);


    }




}