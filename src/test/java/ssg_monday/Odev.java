package ssg_monday;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev extends TestBase {
    @Test
    public void test01() {
       // https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://kitapyurdu.com");
       // Arama motorunda “Java” kelimesini aratınız.
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Java", Keys.ENTER);
       // Listedeki birinci ve ikinci ürünü sepete ekleyiniz.
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[4]")).click();
        bekle(2);
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[6]")).click();
        bekle(2);
       //  Sepetinize gidiniz.
        driver.findElement(By.xpath("//span[@id='cart-items']")).click();
        driver.findElement(By.xpath("//a[@id='js-cart']")).click();
       // Eklenen iki ürünün de sepette göründüğünü doğrulayınız.
        WebElement kitap1=driver.findElement(By.xpath("(//tbody//td)[2]"));
        WebElement kitap2=driver.findElement(By.xpath("(//tbody//td)[6]"));
        Assert.assertTrue(kitap1.isDisplayed());
        Assert.assertTrue(kitap2.isDisplayed());

       // İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
        WebElement kutu1=driver.findElement(By.xpath("(//input[@name='quantity'])[1]"));
        kutu1.clear();
        kutu1.sendKeys("2");
        WebElement kutu2=driver.findElement(By.xpath("(//input[@name='quantity'])[2]"));
        kutu2.clear();
        kutu2.sendKeys("3");

        //“Seçilenleri Daha Sonra Al” fonksiyonunun görünür olmadığını doğrulayınız.
       WebElement SecilenleriAlYazi= driver.findElement(By.xpath("//a[@id='cart-selected-button']"));
       Assert.assertFalse(SecilenleriAlYazi.isDisplayed());
       // Ürünlere ait kontrol kutularını seçili hale getiriniz.
        driver.findElement(By.xpath("//input[@id='select-all-cart']")).click();
       // Kontrol kutularının seçili olduğunu doğrulayınız.
        WebElement urunSecmeKutusu=driver.findElement(By.xpath("//input[@id='select-all-cart']"));
        Assert.assertTrue(urunSecmeKutusu.isSelected());
       // İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
        WebElement ikinciKutu=driver.findElement(By.xpath("(//input[@class='cart-select'])[2]"));
        ikinciKutu.click();
       // İkinci ürünün kontrol kutusunun seçili olmadığını doğrulayınız.
        Assert.assertFalse(ikinciKutu.isSelected());
       //“Seçilenleri Daha Sonra Al” fonksiyonunun aktif olduğunu doğrulayınız.
        WebElement secilenleriDahaSonraAlYazisi = driver.findElement(By.xpath("//*[@id='cart-selected-button']"));
        Assert.assertTrue(secilenleriDahaSonraAlYazisi.isDisplayed());


    }
}
