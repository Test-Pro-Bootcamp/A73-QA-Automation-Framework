import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class Homework17 extends BaseTest{

    @Test
    public void AddSongToAPlayList() throws InterruptedException {

        String expectedSongNotifMessage = "Added 1 song into \"Test Pro Playlist.\"";
        provideEmail("carina@testpro.io");
        providePassword("qatester");
        Thread.sleep(2000);
        clickOnLoginBtn();
        Thread.sleep(2000);

        searchASong("Dark Days");
        clickViewAllBtn();
        selectFirstSong();
        Thread.sleep(2000);
        clickAddBtn();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        getAddToPlayListSuccessMsg();
        Thread.sleep(2000);

        /*Verify that a notification message appears and contains the text
         "Added 1 song into your {playList}
         */

        Assert.assertEquals(getAddToPlayListSuccessMsg(), expectedSongNotifMessage);



    }



    private void searchASong(String song) throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        searchField.clear();
        searchField.sendKeys(song);

    }
    private void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();


    }
    private void selectFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']//tr[1]"));
        firstSong.click();

    }

    private void clickAddBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addToBtn.click();
    }

    private void choosePlaylist() {
        WebElement playListBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),  'Test Pro Playlist')]"));
        playListBtn.click();
    }

    private String getAddToPlayListSuccessMsg() {
        WebElement notifMessage = driver.findElement(By.xpath("//div[@class='success show']"));
        return notifMessage.getText();
    }






}



