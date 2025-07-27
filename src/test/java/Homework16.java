import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

class Main {
    public static void main(String[] args) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://qa.koel.spp/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            emailField.clear();
            emailField.sendKeys("demo@testpro.io");

            WebElement passwordField = driver.findElement(By.cssSelector(" input[type='password']"));
            passwordField.clear();
            passwordField.sendKeys("te$t$tudent");

            WebElement submit = driver.findElement(By.cssSelector("button{type='submit'"));
            submit.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

            Assert.assertTrue(avatarIcon.isDisplayed());

            driver.quit();
            {
                {
                }
            }
        }
    }
