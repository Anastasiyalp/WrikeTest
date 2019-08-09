package pages;

import config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ResendPage {
    private SeleniumConfig config;

    @FindBy(xpath = "/html/body/div[1]/main/div/div//div/form/button")
    WebElement submitResults;

    @FindBy(xpath = "/html/body/div[1]/main/div/div//div/form/div[3]//label[3]//span/input")
    WebElement inputFollow;

    @FindBy(xpath = "/html/body/div[1]/main/div/div//div/div[2]/div")
    WebElement windowChoose;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]/a")
    WebElement twitter;

    public ResendPage(SeleniumConfig config) {
        this.config = config;
    }

    public String getCurrentUrl(){
        return config.getCurrentUrl();
    }

    public void chooseInterest(int number) {
        String path1 = "/html/body/div[1]/main/div/div//div/form/div[1]//label[" + number + "]";
        WebElement choosedInterest = config.getDriver().findElement(By.xpath(path1));
        choosedInterest.click();
    }

    public void chooseCountMembers(int number) {
        String path2 = "/html/body/div[1]/main/div/div//div/form/div[2]//label[" + number + "]";
        WebElement choosedCountMembers = config.getDriver().findElement(By.xpath(path2));
        choosedCountMembers.click();
    }

    public void chooseFollow(int number) {
        String path3 = "/html/body/div[1]/main/div/div//div/form/div[3]//label[" + number + "]";
        WebElement choosedFollow = config.getDriver().findElement(By.xpath(path3));
        choosedFollow.click();
        if (number == 3) {
            inputFollow.sendKeys("Resently");
        }
    }

    public void submitResults() {
        config.clickElement(submitResults);
    }

    public boolean windowChooserInvisibile() {
        return ExpectedConditions.invisibilityOf(windowChoose).apply(config.getDriver());
    }

    public String thereContainsTwitter() {
        return config.getAttribute(twitter, "rel");
    }
    public String getLinkTwitter() {
        return config.getAttribute(twitter, "href");
    }

    public String getImgTwitter() {
        return config.getAttribute(twitter.findElement(By.tagName("use")), "xlink:href");
    }


}
