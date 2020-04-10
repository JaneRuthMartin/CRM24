package com.automation.crm24.pages;

import com.automation.crm24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Message extends PageBase{
    @FindBy(xpath = "(//span[@class='feed-add-post-form-but feed-add-file'])[1]")
    private static WebElement uploadFile;

    @FindBy(xpath = "//span[@id=\"bx-b-link-blogPostForm\"]")
    private static  WebElement addLink;

    @FindBy(xpath = "//span[@id=\"bx-b-video-blogPostForm\"]")
    private static WebElement insertVideo;

    @FindBy(xpath = "//span[@id=\"bx-b-quote-blogPostForm\"]")
    private static WebElement quoteText;

    @FindBy(xpath = "//span[@id=\"bx-b-mention-blogPostForm\"]")
    private static WebElement addMention;

    @FindBy(xpath = "//span[@id=\"bx-b-tag-input-blogPostForm\"]")
    private static WebElement addTag;

    @FindBy(xpath = "//span[@class='feed-add-post-form-but-cnt feed-add-videomessage' and contains(text(),'Record Video')]")
    private static  WebElement recordVideo;

    @FindBy(className = "bx-editor-iframe")
    private static WebElement editorIframe;

    public void typeMessage(String message){
        driver.switchTo().frame(editorIframe).findElement(By.tagName("body")).sendKeys(message);
        BrowserUtils.wait(1);
        driver.switchTo().defaultContent();
    }

    public void uploadFileFromLocal(){
        //?????????????
    }

    public void uploadFileFromBitrix24(){
    }

    public void uploadFileFromExternalDrive(){
    }

    public void uploadFileFromDesktopApplication(){
    }
}