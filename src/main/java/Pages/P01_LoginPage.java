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

    //SS1
    public void validLoginFunction(String id , String pass)
    {
        enterTxt(driver.findElement(userIdInp) , id);
        enterTxt(driver.findElement(userPassInp),pass);
        clickEle(driver.findElement(loginBtn));
    }

    //SS2
    public void invalidLoginFunctionUserID(String invalid , String pass)
    {
        enterTxt(driver.findElement(userIdInp) , invalid);
        enterTxt(driver.findElement(userPassInp),pass);
        clickEle(driver.findElement(loginBtn));
    }

    //SS3
    public void invalidLoginFunctionPassID(String id , String invalidPass)
    {
        enterTxt(driver.findElement(userIdInp) , id);
        enterTxt(driver.findElement(userPassInp),invalidPass);
        clickEle(driver.findElement(loginBtn));
    }

    //SS4
    public void invalidLoginFunctionUserIDAndPassID(String invalidUserid , String invalidPass)
    {
        enterTxt(driver.findElement(userIdInp) , invalidUserid);
        enterTxt(driver.findElement(userPassInp),invalidPass);
        clickEle(driver.findElement(loginBtn));
    }


    public WebElement assertOnTitle()
    {
        return driver.findElement(assertTitle);
    }








}
