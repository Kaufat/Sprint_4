package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final WebDriver webDriver;
    //Кнопка принять куки
    private By buttonAcceptCookies = By.xpath(".//button[text()='да все привыкли']");

    //Верхняя кнопка "Заказать"
    private By upperButtonToMakeOrder = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Нижняя кнопка "Заказать"
    private By middleButtonToMakeOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка "Самокат"
    private By scooterButton = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    // Домашняя страница
    private By homePage = By.xpath(".//div[@class='Home_HomePage__ZXKIX']");


    public void openSite() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickButtonToMakeOrder(String button) {
        webDriver.findElement(By.xpath(button)).click();
    }
    public void clickButtonAcceptCookies() {
        if (webDriver.findElement(buttonAcceptCookies).isDisplayed()) {
            webDriver.findElement(buttonAcceptCookies).click();
        }
    }
    public void clickScooterButton() {
        webDriver.findElement(scooterButton).click();
    }
    public By getHomePage(){
        return homePage;

    }


}
