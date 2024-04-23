package Task81ExplixitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task82WebDriverWait {
    private WebDriver driver;

    @BeforeMethod
    public void beforetest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElementTask81(){
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        WebElement removeButton = driver.findElement(By.cssSelector("button[autocomplete='off']"));

        removeButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementIsInvisible(checkbox);

        WebElement text = driver.findElement(By.id("message"));
        assertEquals(text.getText(), "It's gone!");

        removeButton.click();

        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
