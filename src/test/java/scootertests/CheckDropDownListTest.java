package scootertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.yandex.praktikum.MainPage;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CheckDropDownListTest extends TestBase{
    private final String arrowButton;
    private final String appropriateText;
    public CheckDropDownListTest (String arrowButton, String appropriateText){
        this.arrowButton = arrowButton;
        this.appropriateText = appropriateText;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {".//div[@class='accordion']/div[1]", "//div[@id='accordion__panel-0']"},
                {".//div[@class='accordion']/div[2]", "//div[@id='accordion__panel-1']"},
                {".//div[@class='accordion']/div[3]", "//div[@id='accordion__panel-2']"},
                {".//div[@class='accordion']/div[4]", "//div[@id='accordion__panel-3']"},
                {".//div[@class='accordion']/div[5]", "//div[@id='accordion__panel-4']"},
                {".//div[@class='accordion']/div[6]", "//div[@id='accordion__panel-5']"},
                {".//div[@class='accordion']/div[7]", "//div[@id='accordion__panel-6']"},
                {".//div[@class='accordion']/div[8]", "//div[@id='accordion__panel-7']"},
        };
    }


    @Test
    public void CheckAppropriateTextAppearAfterClickArrowButton(){
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.openSite();
        mainPageObj.clickButtonAcceptCookies();

        driver.findElement(By.xpath(arrowButton)).click();
        assertTrue(driver.findElement(By.xpath(appropriateText)).isDisplayed());

    }

}
