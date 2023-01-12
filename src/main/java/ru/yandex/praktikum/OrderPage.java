package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class OrderPage {

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final WebDriver webDriver;

    // Поле ввода "Имя"
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле ввода "Фамилия"
    private By inputSurName = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле ввода "Адресс"
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле ввода "Станция метро"
    private By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле ввода "Телефон"
    private By inputTelephoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Поле ввода "Когда привезти самокат"
    private By inputDateOfDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле ввода "Срок аренды"
    private By inputLeasePeriod = By.xpath(".//div[text()='* Срок аренды']");
    // Вариант "двое суток" в всплывающем окне "Срок аренды"
    private By LeasePeriodTwoDays = By.xpath(".//div[text()='двое суток']");
    // Чек бокс цвета черного жемчуга
    private By checkBoxDarkPerlColor = By.xpath(".//label[@for='black']");
    //Чек бокс цвета серой безысходности
    private By checkBoxGreyColor = By.xpath(".//label[@for='grey']");
    //Поле ввода "Комментарий для курьера
    private By commentsTOCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private By buttonMakeOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка подтверждения заказа
    private By buttonAcceptOrder = By.xpath(".//button[text()='Да']");
    // Всплывающее окно "Заказ оформлен"
    private By orderConfirmationWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public void fillInputName(String name) {
        webDriver.findElement(inputName).sendKeys(name);
    }
    public void fillInputSurName(String surName) {
        webDriver.findElement(inputSurName).sendKeys(surName);
    }
    public void fillInputAddress(String address) {
        webDriver.findElement(inputAddress).sendKeys(address);
    }
    public void chooseMetro(String metro) {
        webDriver.findElement(inputMetro).click();
        webDriver.findElement(inputMetro).sendKeys(metro);
        webDriver.findElement(inputMetro).sendKeys(Keys.ARROW_DOWN);
        webDriver.findElement(inputMetro).sendKeys(Keys.ENTER);
    }
    public void fillInputTelephoneNumber(String telephoneNumber) {
        webDriver.findElement(inputTelephoneNumber).sendKeys(telephoneNumber);
    }
    public void clickButtonNext() {
        webDriver.findElement(nextButton).click();
    }
    public void fillInputDateOfDelivery(String dateOfDelivery) {
        webDriver.findElement(inputDateOfDelivery).sendKeys(dateOfDelivery);
        webDriver.findElement(inputDateOfDelivery).sendKeys(Keys.ENTER);
    }
    public void chooseLeasePeriod(String period) {
        webDriver.findElement(inputLeasePeriod).click();
        webDriver.findElement(By.xpath(period)).click() ;
    }
    public void clickCheckBoxColor(String color) {
        webDriver.findElement(By.xpath(color)).click();
    }
    public void writeCommentsToCourier(String message) {
        webDriver.findElement(commentsTOCourier).sendKeys(message);
    }
    public void clickButtonMakeOrder() {
        webDriver.findElement(buttonMakeOrder).click() ;
    }
    public void clickButtonAcceptOrder() {
        webDriver.findElement(buttonAcceptOrder).click() ;
    }

}
