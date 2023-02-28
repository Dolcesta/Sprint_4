package order;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageobject.OrderPage;
import services.Service;

// Класс содержит методы для заполнение данных по заказу
public class OrderData {

    public OrderPage objOrderPage;
    private WebDriver driver;
    public Service objService;

    public OrderData(WebDriver driver) {
        this.driver = driver;
    }

    // Метод заполнения профиля клиента
    public OrderData profileData(String name, String surname, String address, String phoneNumber, String station) {
        objOrderPage = new OrderPage(driver);
        objService = new Service(driver);

        objService.waitPageElement(objOrderPage.getTitleOrder());
        objOrderPage.getName().sendKeys(name);
        objOrderPage.getSurname().sendKeys(surname);
        objOrderPage.getAddress().sendKeys(address);
        objOrderPage.getPhoneNumber().sendKeys(phoneNumber);
        new Actions(driver).moveToElement(objOrderPage.getStation()).click().sendKeys(station)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        return this;
    }

    // Метод заполнения данных по заказу
    public OrderData orderrer() {
        objOrderPage = new OrderPage(driver);
        objService = new Service(driver);

        objService.waitPageElement(objOrderPage.getTitleRent());
        objOrderPage.getCalendar().click();
        objOrderPage.getDate().click();
        objOrderPage.getRentalPeriod().click();
        objOrderPage.getRentalTimeOneDay().click();

        return this;
    }
}