package checks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageobject.HomePage;
import pageobject.OrderPage;
import order.OrderData;
import services.Service;

@RunWith(Parameterized.class)
public class OrderTest {

    //public ChromeDriver driver;
    public FirefoxDriver driver;

    public Service objService;
    public OrderPage objOrderPage;
    public HomePage objHomePage;
    public OrderData objProfile;

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final String comment;
    private final By clickOrderButton;

    public OrderTest(String name, String surname, String address, String phoneNumber, String station, String comment, By clickOrderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.comment = comment;
        this.clickOrderButton = clickOrderButton;
    }


    @Parameterized.Parameters

    public static Object[][] getData() {
        HomePage homePage = new HomePage();
        return new Object[][]{
                {"Иван", "Иванов", "356872, г Москва, ул Болотная, д 36", "+79097652483", "Черкизовская", "Комментарий № 1", homePage.ORDER_BUTTON_TOP},
                {"Петр", "Петров", "777452, г Москва, ул Брянская, д 15", "89054973325", "Митино", "Комментарий № 2", homePage.ORDER_BUTTON_DOWN},
        };

    }

    @Before
    public void setUpOrder() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();

        objOrderPage = new OrderPage(driver);
        objHomePage = new HomePage(driver);
        objProfile = new OrderData(driver);
        objService = new Service(driver);

        System.out.println("START TEST");

        objService.inInputWebsite()
                .click(objHomePage.getCookie())
                .waitPageElement(objHomePage.getImage());
    }


    @Test // Создание заказа
    public void checkingOrderCompletion() {

        objService.click(clickOrderButton);
        objProfile.profileData(name, surname, address, phoneNumber, station);
        objService.click(objOrderPage.getNextButton());
        objProfile.orderrer();
        objService.click(objOrderPage.getColorScooter())
                .inputText(objOrderPage.getComment(), comment)
                .click((objOrderPage.getOrderButton()))
                .click((objOrderPage.getPlaceAnOrderYes()));

        assertTrue("Отсутствует сообщение об успешном создании заказа",
                objService.isElementPresent(objOrderPage.ORDER_PLACED_HEADER));

    }

    @After
    public void teardown() {
        System.out.println("CLOSE TEST");
        driver.quit();

    }
}