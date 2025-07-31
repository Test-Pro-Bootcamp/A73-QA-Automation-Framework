import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void updateProfileName() throws InterruptedException {
        provideEmail("carina@testpro.io");
        providePassword("qatester");
        Thread.sleep(2000);
        clickOnLoginBtn();
        Thread.sleep(2000);

        clickOnAvatarIcon();
        provideCurrentPass("qatester");
        String newName = generateRandomName();
        System.out.println("This is the new name: " + newName);
        provideNewProfileName(newName);
        clickOnSaveBtn();
        Thread.sleep(2000);

        WebElement popUpNotif = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(popUpNotif.isDisplayed());


    }

    private void clickOnSaveBtn() {
        WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn-submit']"));
        saveBtn.click();
    }

    private void provideNewProfileName(String newName) {
        WebElement nameField = driver.findElement(By.xpath("//input[@id='inputProfileName']"));
        nameField.clear();
        nameField.sendKeys(newName);
    }


    private void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.xpath("//img[@class='avatar']"));
        avatarIcon.click();
    }
    private void provideCurrentPass(String currentPass) {
        WebElement currentPassField = driver.findElement(By.xpath("//input[@id='inputProfileCurrentPassword']"));
        currentPassField.clear();
        currentPassField.sendKeys(currentPass);
    }

    public  String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","").substring(0,5);
    }


}
