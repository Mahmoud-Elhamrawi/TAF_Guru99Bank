package TestCases;

import Pages.P01_LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_LoginTest extends testBase{

  SoftAssert  softAssert = new SoftAssert();
  P01_LoginPage loginPage ;



    @Test
    public void validLogin()
    {

        loginPage = new P01_LoginPage(driver);
        loginPage.loginFunction("mngr538118","vysehat");
        softAssert.assertTrue(driver.getCurrentUrl().contains("manager/Managerhomepage.php"));

         String expectVal =loginPage.assertOnTitle().getText() ;

          softAssert.assertEquals( "Manger Id : mngr538118", expectVal);

        softAssert.assertAll();
    }
}
