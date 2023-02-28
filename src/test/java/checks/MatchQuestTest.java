package checks;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.HomePage;
import services.Service;


import static org.junit.matchers.JUnitMatchers.containsString;

@RunWith(Parameterized.class)
public class MatchQuestTest {

    //public static ChromeDriver driver;
    public static FirefoxDriver driver;

    public static HomePage objHomePage;
    public static Service objService;

    private final String checkedText;
    private final int index;

    public MatchQuestTest(String checkedText, int index) {
        this.checkedText = checkedText;
        this.index = index;


    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},

        };
    }

    //Выполнится окрытие браузера и вход на сайт, перемещение к блоку вопросов
    @BeforeClass
    public static void globalSetup() {

        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        objService = new Service(driver);
        objHomePage = new HomePage(driver);
        objService.inInputWebsite();
        objService.click(objHomePage.getCookie());
        objService.click(objHomePage.getModQuest());

    }


    // коллекция тестов для проверки блока Вопросы о важном
    @Test
    public void checkingQuestions() {
        objService.click(objHomePage.getListQuestions().get(index));
        Assert.assertThat("Текст не совпадает: ", objHomePage.getListAnswer().get(index).getText(), containsString(checkedText));
    }

    @AfterClass
    public static void teardown() {
        System.out.println("CLOSE TEST");
        driver.quit();
    }
}