import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import static org.testng.Assert.assertEquals;

public class Task73Upload {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTestTask73() {
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("C:/Users/joann/Desktop/has.txt");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedFiles.getText(), "has.txt");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}