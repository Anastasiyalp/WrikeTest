package junit;

import config.SeleniumConfig;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ResendPage;
import pages.WrikeHomePage;

import java.util.Random;

import static org.junit.Assert.*;

@Story("TS")
public class SeleniumPageObjectLiveTest {

    private SeleniumConfig config;
    private WrikeHomePage homePage;
    private ResendPage resendPage;

    @Before
    public void setUp() {
        config = new SeleniumConfig();
        homePage = new WrikeHomePage(config);
    }

    @After
    public void teardown() {
        config.close();
        config.getDriver().quit();
    }

    @Test
    @DisplayName("Check resend page")
    public void getStartedForFree() {
        homePage.navigate();

        assertEquals(homePage.getPageTitle(), "Your online project management software - Wrike");

        homePage.clickOnGetStartedForFree();
        homePage.enterRandomEmail();
        resendPage = homePage.clickOnCreateMyWrikeAccount();

        assertTrue(resendPage.getCurrentUrl().matches("^https:\\/\\/www.wrike.com\\/resend((-va)|(-vb))?\\/$"));

        resendPage.chooseInterest(new Random().nextInt(2) + 1);
        resendPage.chooseCountMembers(new Random().nextInt(5) + 1);
        resendPage.chooseFollow(new Random().nextInt(3) + 1);
        resendPage.submitResults();

        assertFalse(resendPage.windowChooserInvisibile());

        assertEquals(resendPage.thereContainsTwitter(), "dofollow");

        assertEquals(resendPage.getLinkTwitter(), "https://twitter.com/wrike");

        assertEquals(resendPage.getImgTwitter(), "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter");
    }
}