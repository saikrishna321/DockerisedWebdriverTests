package com.test.accounts;

import com.test.entity.CustLogin;
import com.test.pages.ClientDetailsPage;
import com.test.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by saikrisv on 16/10/15.
 */
public class AccountsDemoTest extends BaseTest {

    String client_company_name = "DemoBootCamp";


    @Test
    @Category(Smoke.class)
    public void testPageObject() {
        System.out.println("***************Starting the Test ************");
        LoginPage lp = new LoginPage(driver);
        CustLogin custLogin = new CustLogin("hackerdemo@gmail.com","Hello123");
        ClientDetailsPage clientDetailsPage = lp.loginPage(custLogin.getUsername(),custLogin.getPassword())
                .searchClients("DemoBootCamp").editClientsDetails();
        Assert.assertNotEquals(clientDetailsPage.verifyClientDataIsEdited(), client_company_name);
    }

    @Test
    public void testNonSmokeTag(){
        System.out.println("Executed Non Smoke tag");
    }


}
