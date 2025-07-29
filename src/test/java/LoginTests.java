import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    public String url = "https://qa.koel.app/";

    @Test
    public void loginEmptyEmailPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {

      //  navigateToPage(url);
        Thread.sleep(2000);
        provideEmail("tes123@testpro.io");
        providePassword("qatester");
        Thread.sleep(2000);
        clickOnLoginBtn();

        Thread.sleep(2000);

        //Step 5 Validation of expected result
      //  WebElement avatar = driver.findElement(By.xpath("//img[@class='avatar']"));

       Assert.assertEquals(driver.getCurrentUrl(), url );

    }


}
