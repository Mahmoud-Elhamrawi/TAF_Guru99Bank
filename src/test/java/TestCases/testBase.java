package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class testBase {
    protected WebDriver driver ;
    @BeforeClass
    public void step()
    {
        driver = new FirefoxDriver();
        driver.get("https://www.demo.guru99.com/V4/index.php");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

    }




    @AfterMethod
    public void screenShotFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("fail...");
            System.out.println("taking screenshot.....");
            Helper.helper.capturescreenshot(driver, result.getName());
        }


    }



    @AfterClass
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
