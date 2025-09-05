import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework17 extends BaseTest {

    @Test
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        provideEmail("julia.munoz@testpro.io");
        providePassword("Ltdan25!");
        clickOnLoginBtn();

        searchSong("Dark Days");
        clickViewAllBtn();
        selectFirstSong();
        clickAddBtn();
        choosePlaylist();
        getAddToPlaylistSuccessMsg();
        System.out.println(getAddToPlaylistSuccessMsg());

        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }

    private String getAddToPlaylistSuccessMsg() {
        return notifMessage.getText();
    }

    private void choosePlaylist() {
        playListBtn.click();
    }

    private void clickAddBtn() {
        addToBtn.click();
    }

    private void selectFirstSong()  {
        firstSong.click();
    }


    private void clickViewAllBtn() {
       viewAllBtn.click();

    }

    private void searchSong(String song) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(song);
    }

    private void clickOnLoginBtn() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    private void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    private void navigateToPage(String url) {
        driver.get(url);
    }


}
