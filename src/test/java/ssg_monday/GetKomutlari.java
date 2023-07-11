package ssg_monday;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class GetKomutlari extends TestBase {
    @Test
    public void getKomutlariTest() {
        // https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");
        //Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
        String actualdUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.kitapyurdu.com/";
        Assert.assertEquals(expectedUrl,actualdUrl);
        //Anasayfanın açıldığını sayfa başlığı ile doğrulayınız. (Kitapyurdu, Kitapla buluşmanın en kolay yolu)
        String expectedTitle=driver.getTitle();
        String actualTitle="Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        Assert.assertEquals(expectedTitle,actualTitle);
        //Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
        String pageSource=driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));
        //Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        WebElement girisButonu=driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        String girisButonuText=girisButonu.getText();
        Assert.assertEquals("Giriş Yap", girisButonuText);
        // “Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        WebElement uyeOl=driver.findElement(By.linkText("Üye Ol"));//linke ait metin demek linktext
        String uyeOlHref=uyeOl.getAttribute("href");//linkler href icinde olurlar
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register",uyeOlHref);
        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        List<WebElement> yazarIsimleri=driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement yazarIsmi:yazarIsimleri) {
            Assert.assertEquals("span",yazarIsmi.getTagName());//o locate'de tag ne ise onu verir bu method

        }
        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
        for (WebElement yazarIsim: yazarIsimleri) {
            Assert.assertEquals("Arial, Helvetica, sans-serif",yazarIsim.getCssValue("font-family"));

        }
        //Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
        //quit() ve close() metotları arasındaki farkı inceleyelim.


    }
}
