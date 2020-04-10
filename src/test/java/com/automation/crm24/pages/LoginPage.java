package com.automation.crm24.pages;

import com.automation.crm24.utilities.ConfigurationReader;
import com.automation.crm24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (name = "USER_LOGIN")
    private WebElement userName;

    @FindBy (name = "USER_PASSWORD")
    private WebElement password;

    @FindBy (className = "login-btn")
    private WebElement login;

    @FindBy (className="login-link-forgot-pass")
    private WebElement forgotPassword;


    public LoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    /**
     * This is for different use login credentials
     * @param userValue accepts a user email
     * @param passwordValue accepts a password
     */
    public void login (String userValue, String passwordValue) {
        userName.sendKeys(userValue);
        // password.sendKeys(passwordValue, Keys.ENTER);
        // Or
        password.sendKeys(passwordValue);
        login.click();
    }

    /**
     * Choose user type for different user levels
     * @param userType help_desk, marketing, hr
     */
    public void loginAs(String userType){
        userName.sendKeys(ConfigurationReader.getProperty(userType));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }

    /**
     * Login as HR user
     */
    public void loginAsHr(){
        userName.sendKeys(ConfigurationReader.getProperty("hr"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }

    /**
     * Login as Help Desk User
     */
    public void loginAsHelpDesk(){
        userName.sendKeys(ConfigurationReader.getProperty("help_desk"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }
    /**
     * Login as Marketing User
     */
    public void loginAsMarketing(){
        userName.sendKeys(ConfigurationReader.getProperty("marketing"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }

}
