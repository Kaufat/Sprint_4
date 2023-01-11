package scootertests;

import org.junit.Test;
import ru.yandex.praktikum.MainPage;

import static org.junit.Assert.assertTrue;

public class CheckTransferToMainPage extends TestBase {
    @Test
    public void checkTransferToMainPageAfterClickSkooterButton() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.openSite();
        mainPageObj.clickButtonAcceptCookies();
        mainPageObj.clickButtonToMakeOrder(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
        mainPageObj.clickScooterButton();
        assertTrue(driver.findElement(mainPageObj.getHomePage()).isDisplayed());
    }
}
