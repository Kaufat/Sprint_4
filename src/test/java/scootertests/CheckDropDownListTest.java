package scootertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.praktikum.MainPage;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CheckDropDownListTest extends TestBase{
    private final String arrowButton;
    private final String appropriateText;
    private final String expectedPanelText;
    public CheckDropDownListTest (String arrowButton, String appropriateText, String expectedPanelText){
        this.arrowButton = arrowButton;
        this.appropriateText = appropriateText;
        this.expectedPanelText = expectedPanelText;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {".//div[@class='accordion']/div[1]", "//div[@id='accordion__panel-0']", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {".//div[@class='accordion']/div[2]", "//div[@id='accordion__panel-1']", "Пока что у нас так: один заказ — один самокат. " +
                                                                                         "Если хотите покататься с друзьями, можете просто " +
                                                                                         "сделать несколько заказов — один за другим."},
                {".//div[@class='accordion']/div[3]", "//div[@id='accordion__panel-2']", "Допустим, вы оформляете заказ на 8 мая. Мы привозим" +
                                                                                         " самокат 8 мая в течение дня. Отсчёт времени аренды начинается" +
                                                                                         " с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат" +
                                                                                         " 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {".//div[@class='accordion']/div[4]", "//div[@id='accordion__panel-3']", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {".//div[@class='accordion']/div[5]", "//div[@id='accordion__panel-4']", "Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                                                                                         "в поддержку по красивому номеру 1010."},
                {".//div[@class='accordion']/div[6]", "//div[@id='accordion__panel-5']", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь" +
                                                                                         " суток — даже если будете кататься без передышек и во сне." +
                                                                                         " Зарядка не понадобится."},
                {".//div[@class='accordion']/div[7]", "//div[@id='accordion__panel-6']", "Да, пока самокат не привезли. Штрафа не будет, объяснительной" +
                                                                                         " записки тоже не попросим. Все же свои."},
                {".//div[@class='accordion']/div[8]", "//div[@id='accordion__panel-7']", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }


    @Test
    public void CheckAppropriateTextAppearAfterClickArrowButton(){
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.openSite();
        mainPageObj.clickButtonAcceptCookies();

        driver.findElement(By.xpath(arrowButton)).click();
        assertTrue(driver.findElement(By.xpath(appropriateText)).isDisplayed());
        assertEquals("Текст в панели не подходящий",expectedPanelText,driver.findElement(By.xpath(appropriateText)).getText());


    }

}
