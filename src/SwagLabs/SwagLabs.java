package SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

// page_url = https://www.saucedemo.com

public class SwagLabs
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mcf\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");

        //Verify Page Title >> <title>Swag Labs</title>
        String actualTitle = driver.getTitle();
        driver.manage().window().maximize();
        String expectedTitle = "Swag Labs";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");

        //Find username
        WebElement txtbx_username =
                driver.findElement(By.id("user-name"));

        txtbx_username.sendKeys("standard_user");

        //Find password
        WebElement txtbx_password =
                driver.findElement(By.id("password"));

        txtbx_password.sendKeys("secret_sauce");

        //Click Submit
        driver.findElement(By.name("login-button")).click();

        //Add item to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        //Go to Sthe Cart
        driver.findElement(By.className("shopping_cart_link")).click();

        //Verify Continue Shopping Button
        driver.findElement(By.name("continue-shopping")).click();

        //Next verify items exist


    }

}