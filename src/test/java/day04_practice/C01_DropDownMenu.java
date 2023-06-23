package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu  extends TestBase {
    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");
        // dropdown'dan "Books" secenegini secin (dropdown 3 adimda handle edilir)
        //1. adim dropdown'u locate edelim
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2. adim select objesi olusturulur
        Select select=new Select(ddm);
        //3. adim optionlardan bir tanesi secilir
        //select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        select.selectByVisibleText("Books");
        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucElementi.getText().contains("Java"));
    }
}
