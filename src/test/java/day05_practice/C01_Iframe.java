package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_Iframe extends TestBase {
    @Test
    public void test1() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");
    // Videoyu görecek kadar asagiya ininiz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//perform action isleminin tamamlandigini gostermek icin kullaniliyor ve onemli
    // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
        /*
        play'i dogru locate edip click yapmamiza ragmen video yu ilk etapta calistirmadi.Bunun uzerine
        html kodlarini inceleyince pay'in iframe icersinide oldugunu gorduk. Bu durumda once iframe'i locate edip
        sonra switchTo() ile iframe'e gecmeliyiz.
         */
        WebElement playKey =driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playKey.click();
        bekle(4);
    // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        bekle(2);

    // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        bekle(2);
    // videoyu calıstırınız
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        bekle(2);
    // videoyu kucultunuz
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        bekle(2);
    // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();

    // Videoyu calistirdiginizi test ediniz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).isDisplayed();

    // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement yazi=driver.findElement(By.xpath("//h1[text()='jQuery Flexy Plugin Demos']"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
