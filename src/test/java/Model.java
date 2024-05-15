import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public  class Model {

    public static void getElement() {

        WebDriver driver = Drivers.driver;

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.takealot.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("ab-close-button")).click();
        driver.findElement(By.xpath("(//a[@href='/sell'])[1]")).click();
        //Assert.assertEquals("",driver.findElement(By.className("cell sot-banner-module_banner-content_2bdae")) );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='#pricing']")).click();
        //driver.findElement(By.xpath("//a[@class='button fees-calculator-btn']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if(driver.findElement(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']")).isDisplayed())
        {
            driver.findElement(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']")).click();
        }
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@class='button fees-calculator-btn']")));
        action.build().perform();
        driver.findElement(By.xpath("//a[@class='button fees-calculator-btn']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String origionalWidnow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!origionalWidnow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.findElement(By.xpath("//div[@class='ui mini input']//input[@name='width']")).sendKeys("10");
        driver.findElement(By.xpath("//div[@class='ui mini input']//input[@name='length']")).sendKeys("20");
        driver.findElement(By.xpath("(//input[@size='5'])[3]")).sendKeys("20");

        driver.findElement(By.xpath("//div[@class='ui mini input']//input[@name='width']")).getAttribute("Value");
        driver.findElement(By.xpath("//div[@class='ui mini input']//input[@name='length']")).getAttribute("Value");
        if( driver.findElement(By.xpath("//div[@class='ui mini input']//input[@name='width']")).getAttribute("Value").equals(driver.findElement(By.xpath("//div[@class='ui mini input']//input[@name='length']")).getAttribute("Value")))
        {
            driver.findElement(By.xpath("(//input[@class='search'])[1]")).click();
            driver.findElement(By.xpath("(//input[@class='search'])[1]")).sendKeys("Home");


        }else
        {
            //driver.findElement(By.xpath("(//input[@class='search'])[1]")).click();
            Select drop=new Select(driver.findElement(By.xpath("//div[@class='ui active visible search selection dropdown']")));
            drop.selectByVisibleText("Home");

//            driver.findElement(By.xpath("(//input[contains(@class,'search')])[2]")).click();
//            driver.findElement(By.xpath("(//input[contains(@class,'search')])[2]")).sendKeys("DIY");

        }

    }

    //code to be added
}