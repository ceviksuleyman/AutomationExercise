package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ReusableMethod {

    static Faker faker;
    static Actions actions;
    static SoftAssert softAssert;
    static Select select;
    static WebDriverWait wait;
    static Random random;

    public static Faker getFaker() {

        return faker = new Faker();
    }//

    public static Actions getActions() {

        return actions = new Actions(Driver.getDriver());
    }//

    public static SoftAssert getSoftAssert() {

        return softAssert = new SoftAssert();
    }//

    public static Select select(WebElement ddm) {

        return select = new Select(ddm);
    }//

    public static void jsScrollClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        try {
            webElement.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);
        }
    }


    public static WebDriverWait driverWait(WebDriver driver, Duration duration) {

        return wait = new WebDriverWait(driver, duration);
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Random random() {

        return random = new Random();
    }

    public static void jsScroll(WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    static DateTimeFormatter formater1, formater2;
    static String tarih1, tarih2;

    public static String dateMonth() {
        LocalDateTime date = LocalDateTime.now();
        formater1 = DateTimeFormatter.ofPattern("MM");

        return tarih1 = date.format(formater1);
    }

    public static String dateYear() {

        LocalDateTime date = LocalDateTime.now();
        formater2 = DateTimeFormatter.ofPattern("yyyy");

        return tarih2 = date.format(formater2);
    }
}//
