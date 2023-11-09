package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_LoginPage extends pageBase{
    public P01_LoginPage(WebDriver driver) {
        super(driver);
    }


    private By  userIdInp = By.xpath("//input[@name=\"uid\"]");
    private  By userPassInp = By.xpath("//input[@name=\"password\"]");
    private By loginBtn = By.xpath("//input[@type=\"submit\"]");
    private  By assertTitle = By.cssSelector("tr[align=\"center\"] td");

    public void loginFunction( String id , String pass)
    {
        enterTxt(driver.findElement(userIdInp) , id);
        enterTxt(driver.findElement(userPassInp),pass);
        clickEle(driver.findElement(loginBtn));
    }

    public WebElement assertOnTitle()
    {
        return driver.findElement(assertTitle);
    }








}
