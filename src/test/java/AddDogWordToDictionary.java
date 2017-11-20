import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.testng.FileAssert.fail;

public class AddDogWordToDictionary {
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
    public void addWord() {
        WebElement loginButton = driver.findElement(By.id("headEnterBtn"));
        loginButton.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/input"));
        Actions builder = new Actions(driver);
        Actions seriesOfActions = builder.moveToElement(email).click().sendKeys(email, "marina@astra.od.ua");
        seriesOfActions.perform();
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/input"));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button"));
        Actions seriesOfAction = builder.moveToElement(pass).click().sendKeys(pass, "qwe8989").click(login);
        seriesOfAction.perform();
        WebElement profileUser;
        profileUser = driver.findElement(By.cssSelector("body > div.l-wrapper-content.l-center > div.b-header.l-center > div > div.b-header__left > ul > li.selected > a"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("Tasks", mailUser);
        WebElement DictionaryButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/a"));
        DictionaryButton.click();
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"glossaryPage\"]/div[3]/div[2]/div[1]/div[2]/div/div/form/input"));
        searchField.sendKeys("dog");
        WebElement AddWordButton = driver.findElement(By.xpath("//*[@id=\"glossaryPage\"]/div[3]/div[2]/div[1]/div[2]/div/div/form/button"));
        AddWordButton.click();


        driver.close();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        }
    }

