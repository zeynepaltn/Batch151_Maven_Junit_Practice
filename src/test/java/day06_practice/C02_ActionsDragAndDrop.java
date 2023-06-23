package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void test1() {
        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");
        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions actions=new Actions(driver);
        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(drag,drop).perform();
        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        String yazi=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        String expected="Dropped!";
        Assert.assertEquals(yazi,expected);
    }
}
