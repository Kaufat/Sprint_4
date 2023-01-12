package scootertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.OrderPage;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ScooterOrderTest extends TestBase {
    private final String buttonToMakeOrder;
    private final String name;
    private final String surName;
    private final String address;
    private final String metro;
    private final String telephoneNumber;
    private final String dateOfDelivery;
    private final String leasePeriod;
    private final String scooterColor;
    private final String commentsToCourier;

    public ScooterOrderTest(String buttonToMakeOrder, String name, String surName, String address,
                            String metro, String telephoneNumber, String dateOfDelivery,
                            String leasePeriod,String scooterColor, String commentsToCourier) {

        this.buttonToMakeOrder = buttonToMakeOrder;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.metro = metro;
        this.telephoneNumber = telephoneNumber;
        this.dateOfDelivery = dateOfDelivery;
        this.leasePeriod = leasePeriod;
        this.scooterColor = scooterColor;
        this.commentsToCourier = commentsToCourier;

    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
               {".//button[@class='Button_Button__ra12g']","Иван", "Соколов", "Интересный адресс", "Беговая",
                  "89675683478", "13.04.2022", ".//div[text()='трое суток']", ".//label[@for='black']", "Побыстрее"},
                {".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']","Петр", "Стрельцов", "Не скажу", "Рижская",
                        "89653354670", "03.09.2022", ".//div[text()='двое суток']", ".//label[@for='grey']", "Очень надо!"}
        };
    }

    @Test
    public void CheckSuccessOrderProcess (){
        MainPage mainPageObj = new MainPage(driver);
        OrderPage orderPageObj = new OrderPage(driver);

        mainPageObj.openSite();
        mainPageObj.clickButtonAcceptCookies();
        mainPageObj.clickButtonToMakeOrder(buttonToMakeOrder);
        orderPageObj.fillInputName(name);
        orderPageObj.fillInputSurName(surName);
        orderPageObj.fillInputAddress(address);
        orderPageObj.chooseMetro(metro);
        orderPageObj.fillInputTelephoneNumber(telephoneNumber);
        orderPageObj.clickButtonNext();
        orderPageObj.fillInputDateOfDelivery(dateOfDelivery);
        orderPageObj.chooseLeasePeriod(leasePeriod);
        orderPageObj.clickCheckBoxColor(scooterColor);
        orderPageObj.writeCommentsToCourier(commentsToCourier);
        orderPageObj.clickButtonMakeOrder();
        orderPageObj.clickButtonAcceptOrder();
        // На этом месте тест ложится, баг на браузере Yandex и Google Chrome. Не прогружается страница после подтверждения заказа.
        assertTrue(driver.findElement(By.xpath(".//div[@class='Order_NextButton__1_rCA']")).isDisplayed());



    }
}
