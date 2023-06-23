package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
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
    public void test01() throws InterruptedException {
        // https://www.techproeducation.com/ sayfasina gidin
        driver.get("https://techproeducation.com");

        // Title ve Url'ini alın ve yazdırın
        String techproTitle=driver.getTitle();
        System.out.println("site sayfa basligi: "+techproTitle);
        String sayfaUrl=driver.getCurrentUrl();
        System.out.println("Sayfanin URL'i: "+sayfaUrl);

        // Title'in "Online" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproTitle.contains("Online"));
        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(sayfaUrl.contains("techproeducation"));
        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://amazon.com");
        // Title'ini alın ve yazdırın
        String amazonTitle=driver.getTitle();
        System.out.println("Amazon sayfa basligi: "+amazonTitle);
        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));
        // techproeducation.com'a geri dönün
        driver.navigate().back();
        Thread.sleep(2000);
        // sayfayı yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);
        // amazon.com'a tekrar gelin
        driver.navigate().forward();


    }
}
