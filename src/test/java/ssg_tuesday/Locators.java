package ssg_tuesday;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Locators extends TestBase {

    @Test
    public void test01() {
        //https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://kitapyurdu.com");
        //“En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
        List<WebElement> enCokSatanlarListesi=driver.findElements(By.className("bestseller-item"));
        String ilkUrunBaslik=enCokSatanlarListesi.get(0).getText().split("\n")[0];
        enCokSatanlarListesi.get(0).click();
        bekle(2);
        //Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
        WebElement kitapAdi=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(ilkUrunBaslik,kitapAdi.getText());
        //“Devamını Oku…” butonuna basınız.
        WebElement devaminiOku=driver.findElement(By.partialLinkText("Devamı"));
        devaminiOku.click();
        //Ürünü sepete ekleyiniz.
        WebElement sepetButonu=driver.findElement(By.id("button-cart"));
        sepetButonu.click();
        //Sepete gidiniz.
        WebElement sepeteGit=driver.findElement(By.linkText("sepetinize"));
        sepeteGit.click();
        //Ürüne ait kontrol kutusunu işaretleyiniz.
        WebElement kontrolKutusu=driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(kontrolKutusu.isSelected());
        if(!kontrolKutusu.isSelected()){
            kontrolKutusu.click();
        }

        //Ürün miktarını değiştiriniz.
        WebElement urunMiktari=driver.findElement(By.name("quantity"));
        urunMiktari.clear();
        bekle(1);
        urunMiktari.sendKeys("3");


    }
}
