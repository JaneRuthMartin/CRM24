package com.automation.crm24.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;

    private Driver(){

    }

    public static WebDriver getDriver(){
        if(driver==null){
            String browser=ConfigurationReader.getProperty("browser").toLowerCase();
            String os = System.getProperty("os.name").toLowerCase();

            if(os.contains("windows")&&browser.equalsIgnoreCase("safari")  ||  os.contains("mac")&&browser.equalsIgnoreCase("edg")){
                driver= null;
                throw  new RuntimeException("==> Incompatible browser choosen for "+os.toUpperCase()+"!! <==");
            }
            switch (browser){
                case "chrome":{
                    WebDriverManager.chromedriver().version("79").setup();
                    driver= new ChromeDriver();
                    break;
                }
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                }
                case "edge":{
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                }
                case "safari":{
                    driver= new SafariDriver();
                    break;
                }
                case "chromeheadless":{
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options=new ChromeOptions();
                    options.setHeadless(true);
                    driver=new ChromeDriver(options);
                    break;

                }
                default:{
                    throw new RuntimeException("Wrong browser name!!");
                }
            }

        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }



}