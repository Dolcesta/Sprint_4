package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

// Класс содержит локаторы и вебэлементы главной странице
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage() {
    }

    // Локаторы на главной странице
    private final By ACCEPT_COOKIE_BUTTON = By.id("rcc-confirm-button");  // кнопка закрыть куки
    private final By IMG_SCOOTER = By.xpath("//img[@alt='Scooter blueprint']"); // элемент на главной станице картинка
    private final By HEADING_QUEST = By.xpath("//div[text() = 'Вопросы о важном']"); // элемент заголовка Вопросы о важном
    public final By ORDER_BUTTON_TOP = By.className("Button_Button__ra12g"); // кнопка заказать вверху сайта
    public final By ORDER_BUTTON_DOWN = By.xpath("//button[contains(@class, 'Button_Middle')]"); // кнопка заказать внизу сайта

    // Локаторы из списка вопросов и ответов
    private final By LIST_QUESTIONS = By.xpath("//*[@class='accordion__button']"); // элемент вопросов
    private final By LIST_ANSWER = By.xpath("//div[@data-accordion-component='AccordionItemPanel']"); // элемент ответов


    // Преобразование локаторов в вебэлементы
    public By getImage() {
        return IMG_SCOOTER;
    }

    public WebElement getCookie() {
        return driver.findElement(ACCEPT_COOKIE_BUTTON);
    }

    public WebElement getModQuest() {
        return driver.findElement(HEADING_QUEST);
    }

    public WebElement getOrderedTop() {
        return driver.findElement(ORDER_BUTTON_TOP);
    }

    public WebElement getOrderedDown() {
        return driver.findElement(ORDER_BUTTON_DOWN);
    }


    // Коллекция из элементов вопросов
    public List<WebElement> getListQuestions() {
        return driver.findElements(LIST_QUESTIONS);
    }

    // Коллекция из элементов ответов
    public List<WebElement> getListAnswer() {
        return driver.findElements(LIST_ANSWER);
    }

}