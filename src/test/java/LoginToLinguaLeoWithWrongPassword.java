import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginToLinguaLeoWithWrongPassword {


    private static WebDriver driver;

    @BeforeTest
    public static void SetUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\Courses AUTO QA\\drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://lingualeo.com/ru#welcome");
    }

    @Test
    public void userLoginWrongPass() {
        WebElement loginButton = driver.findElement(By.id("headEnterBtn"));
        loginButton.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/input"));
        Actions builder = new Actions(driver);
        Actions seriesOfActions = builder.moveToElement(email).click().sendKeys(email, "marina@astra.od.ua");
        seriesOfActions.perform();
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/input"));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button"));
        Actions seriesOfAction = builder.moveToElement(pass).click().sendKeys(pass, "qwe89899").click(login);
        seriesOfAction.perform();
        WebElement profileUser;
        profileUser = driver.findElement(By.cssSelector("body > div.simple-dialog.simple-dialog_is_shaking > div.simple-dialog__popup > div > div.simple-dialog__content > div > div.uauth-f__slider > div > div.uauth-f__login.uauth-form__email-auth_state_expanded.uauth-form__email-auth_state_error > div > div.uauth-email > div > p"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("Пароль/email введены неверно", mailUser);
        driver.close();
    }
}


