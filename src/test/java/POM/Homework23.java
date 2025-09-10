package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;


import java.time.Duration;

public class Homework23 extends BaseTest {
    //public static Actions actions = null;
    String newPlayListName = "Gym";

    @Test
    public void renamePlaylist() {
        //String oldName = "Test Pro Playlist";
        //String newName = "Gym";
        String expectedRenameMessage = "Updated playlist \"" + "Gym" + "\"";

        // Initialize POM pages
        Loginpage loginPage = new Loginpage(driver);
        Homepage homepage = new Homepage(driver);

        //Login
        loginPage.login("julia.munoz@testpro.io", "Ltdan25!");

        //Rename playlist using PageFactory methods
        homepage.doubleClickPlaylist();
        homepage.enterNewPlaylistName("Gym");

        //Assert success msg
        Assert.assertEquals(
                homepage.getRenamePlaylistSuccessMsg(),
                expectedRenameMessage,
                "Playlist rename failed!"
        );

    }
}
