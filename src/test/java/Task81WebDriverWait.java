import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
public class Task81WebDriverWait {

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
        WebElement removeButton = driver.findElement(By.cssSelector("button[autocomplete='off']"));
        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement text = driver.findElement(By.id("message"));
        assertEquals(text.getText(), "It's gone!");
    }

    @AfterMethod
     public void afterTest(){
        driver.close();
        driver.quit();
    }
}
