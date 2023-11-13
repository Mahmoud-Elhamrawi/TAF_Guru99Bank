package TestCases;

import Data.ExcelReader;
import Pages.P01_LoginPage;
import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TC01_LoginTest extends testBase{

      SoftAssert  softAssert = new SoftAssert();
      P01_LoginPage loginPage ;

      @DataProvider(name = "excelData")
      public Object[][] userExcelData() throws IOException {
          ExcelReader er = new ExcelReader();
          return  er.getExcelData();
      }


    //SS1 valid User ID and Valid Password
    @Test(priority = 1 , dataProvider = "excelData")
    public void validLogin(String userID , String passwordID)
    {

        loginPage = new P01_LoginPage(driver);
        loginPage.validLoginFunction(userID,passwordID);
        softAssert.assertTrue(driver.getCurrentUrl().contains("manager/Managerhomepage.php"));

         String expectVal =loginPage.assertOnTitle().getText() ;

          softAssert.assertEquals( "Manger Id : mngr538118", expectVal);

        softAssert.assertAll();
    }

    //SS2 invalid User ID and valid Password
    @Test(priority = 2)
    public void invalidLoginUserID()
    {
       loginPage = new P01_LoginPage(driver);
       loginPage.invalidLoginFunctionUserID("mngr","vysehat");
        Alert alert =driver.switchTo().alert();
        System.out.println(alert.getText());
        String alertTXt = alert.getText();
        softAssert.assertEquals(alertTXt , "User or Password is not valid");
        alert.accept();

        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.demo.guru99.com/V4/index.php"));
        System.out.println(driver.getCurrentUrl());

        softAssert.assertAll();

    }


    //SS3 valid User ID and invalid Password
    @Test(priority = 3)
    public void inValidLoginPassID()
    {
        loginPage = new P01_LoginPage(driver);
        loginPage.invalidLoginFunctionPassID("mngr538118","vyse");
        Alert alert =driver.switchTo().alert();
        System.out.println(alert.getText());
        String alertTXt = alert.getText();
        softAssert.assertEquals(alertTXt , "User or Password is not valid");
        alert.accept();

        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.demo.guru99.com/V4/index.php"));
        System.out.println(driver.getCurrentUrl());

        softAssert.assertAll();
    }




    //SS4 invalid User ID and invalid Password
    @Test(priority = 4)
    public void inValidLoginPassIDAndUSerID()
    {
        loginPage = new P01_LoginPage(driver);
        loginPage.invalidLoginFunctionPassID("mngr","vyse");
        Alert alert =driver.switchTo().alert();
        System.out.println(alert.getText());
        String alertTXt = alert.getText();
        softAssert.assertEquals(alertTXt , "User or Password is not valid");
        alert.accept();

        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.demo.guru99.com/V4/index.php"));
        System.out.println(driver.getCurrentUrl());

        softAssert.assertAll();
    }




















}
