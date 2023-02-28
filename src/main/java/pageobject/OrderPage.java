package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// Класс содержит локаторы и вебэлементы для оформления заказа
public class OrderPage {
    private WebDriver driver;


    // Локаторы для проверки второго сценария
    private final By ORDER_HEADER = By.xpath("//div[(text()= 'Для кого самокат')]"); // элемент страницы заполнения данных
    private final By RENT_HEADER = By.xpath("//div[(text()= 'Про аренду')]"); // элемент страницы заполнения данных
    private final By INPUT_NAME = By.xpath("//input[@placeholder ='* Имя']"); // поле имя
    private final By INPUT_SURNAME = By.xpath("//input[@placeholder ='* Фамилия']"); // поле фамилия
    private final By INPUT_ADDRESS = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']"); // поле адреса
    private final By INPUT_METRO_STATION = By.xpath("//input[@placeholder ='* Станция метро']"); // поле метро
    private final By INPUT_PHONE_NUMBER = By.xpath("//input[@placeholder ='* Телефон: на него позвонит курьер']"); // поле телефон
    private final By INPUT_DATE_CALENDAR = By.xpath("//input[@placeholder ='* Когда привезти самокат']"); // поле календаря
    private final By INPUT_DATE = By.xpath("//div[contains(@class, 'day--today')]"); // поле выбора даты доставки
    private final By INPUT_RENTAL_PERIOD = By.className("Dropdown-placeholder"); // элемент выбора срока аренды
    private final By INPUT_RENTAL_DAY = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']"); // элемент выбора срока аренды
    private final By CHECKBOX_COLOUR = By.id("grey"); // элемент выбора цвета
    private final By INPUT_COMMENT = By.xpath("//input[@placeholder ='Комментарий для курьера']"); // поле коментария
    private final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // кнопка далее
    private final By ORDER_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]"); // кнопка заказать
    private final By ORDER_YES_BUTTON = By.xpath("//button[contains(text(), 'Да')]"); // кнопка подтверждения заказа
    public final By ORDER_PLACED_HEADER = By.xpath("//div[(text()= 'Заказ оформлен')]");  // элемент страницы подтвержденного заказа

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    // Преобразование локаторов в вебэлементы
    public WebElement getName() {
        return driver.findElement(INPUT_NAME);
    }

    public WebElement getSurname() {
        return driver.findElement(INPUT_SURNAME);
    }

    public WebElement getAddress() {
        return driver.findElement(INPUT_ADDRESS);
    }

    public WebElement getPhoneNumber() {
        return driver.findElement(INPUT_PHONE_NUMBER);
    }

    public WebElement getStation() {
        return driver.findElement(INPUT_METRO_STATION);
    }

    public WebElement getCalendar() {
        return driver.findElement(INPUT_DATE_CALENDAR);
    }

    public WebElement getDate() {
        return driver.findElement(INPUT_DATE);
    }

    public WebElement getRentalPeriod() {
        return driver.findElement(INPUT_RENTAL_PERIOD);
    }

    public WebElement getRentalTimeOneDay() {
        return driver.findElement(INPUT_RENTAL_DAY);
    }

    public WebElement getColorScooter() {
        return driver.findElement(CHECKBOX_COLOUR);
    }

    public WebElement getComment() {
        return driver.findElement(INPUT_COMMENT);
    }

    public WebElement getNextButton() {
        return driver.findElement(NEXT_BUTTON);
    }

    public WebElement getOrderButton() {
        return driver.findElement(ORDER_BUTTON);
    }

    public WebElement getPlaceAnOrderYes() {
        return driver.findElement(ORDER_YES_BUTTON);
    }

    public By getTitleOrder() {
        return ORDER_HEADER;
    }

    public By getTitleRent() {
        return RENT_HEADER;
    }

}