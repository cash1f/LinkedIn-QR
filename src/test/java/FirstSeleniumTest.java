
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSeleniumTest extends BaseTest {
    @Test
    public void checkPageTitle(){

        driver.get("https://practicesoftwaretesting.com");
        assertEquals("Practice Software Testing - Toolshop - v5.0", driver.getTitle());

    }

    @Test
    public void checkContactHeading(){

        driver.get("https://practicesoftwaretesting.com/contact");
        WebElement heading = driver.findElement(By.tagName("h3"));
                //document.getElementsByTagName("h3")[0].innerHTML
        String headingText = heading.getText();
        assertEquals("Contact", headingText);


    }

    @Test
    public void testContactFormSubmit(){
        driver.get("https://practicesoftwaretesting.com/contact");

        ContactPage contactPageForm = new ContactPage(driver);
        contactPageForm.fillForm();
        contactPageForm.submitForm();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement alert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("alert"))
        );

        String alertText = alert.getText().trim();
        assertEquals("Thanks for your message! We will contact you shortly.", alertText);
    }
}
