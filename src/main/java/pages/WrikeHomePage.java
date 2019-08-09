package pages;

import config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WrikeHomePage {

    private SeleniumConfig config;
    public static String title;
    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")
    public static WebElement getStartedForFree;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[1]/input")
    public static WebElement enterEmail;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[2]/button")
    public static WebElement createMyWrikeAccount;

    public WrikeHomePage(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
    }

    public void navigate(){
        this.config.navigateTo("https://www.wrike.com/");
        title = config.getTitle();
    }

    public String getPageTitle() {
        return title;
    }

    public void clickOnGetStartedForFree() {
        config.clickElement(getStartedForFree);
    }

    public void enterRandomEmail() {
        config.enterRandomEmail(enterEmail);
    }

    public ResendPage clickOnCreateMyWrikeAccount() {
        config.clickElement(createMyWrikeAccount);
        config.getWaiter().until(ExpectedConditions.urlMatches("https://www.wrike.com/resend*"));

        ResendPage resendPage = new ResendPage(config);
        PageFactory.initElements(config.getDriver(), resendPage);

        return resendPage;
    }
}
