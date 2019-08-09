package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SeleniumConfig {

    private static WebDriver driver;
    private static WebDriverWait webDriverWait;

    public SeleniumConfig() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 120);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    static {
        String path =  "." + File.separator + "Drivers" + File.separator + "chromedriver";
        if(System.getProperty("os.name").toLowerCase().indexOf( "win" ) >= 0)
            path += ".exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void enterRandomEmail(WebElement element) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        element.sendKeys(sb + "+wpt@wriketask.qaa");
    }

    public WebDriverWait getWaiter() {
        return webDriverWait;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getAttribute(WebElement webElement, String attribute) {
        return webElement.getAttribute(attribute);
    }
}
