package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella"+ Keys.ENTER);
        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın
         List<WebElement> nutellaurunleri=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for (int i = 0; i <nutellaurunleri.size(); i++) {
            nutellaurunleri=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            nutellaurunleri.get(i).click();
            System.out.println(i+ ". URUN BASLIGI: "+driver.getTitle());
            driver.navigate().back();

        }

    }
}
