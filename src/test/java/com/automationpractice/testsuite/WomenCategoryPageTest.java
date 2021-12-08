package com.automationpractice.testsuite;

import com.automationpractice.customlisteneres.CustomListeners;
import com.automationpractice.pages.*;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class WomenCategoryPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;

    @BeforeMethod(groups = {"regression"})
    public void inIt() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"regression"}, dataProvider = "womenpagetest1", dataProviderClass = TestData.class)
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(String text) {
        homePage.clickonWomenButtonOnHomePage();
      //  Assert.assertEquals(womenCategoryPage.getWomenTitle(), text);

    }

    @Test(groups = {"regression"}, dataProvider = "womenpagetest2", dataProviderClass = TestData.class)
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {
        homePage.clickonWomenButtonOnHomePage();
        productPage.selectedProduct(product);
        Thread.sleep(1000);
        productPage.enterQuantity(qty);
        Thread.sleep(1000);
        productPage.selectYourComfortSize(size);
        Thread.sleep(1000);
        productPage.selColour(colour);
        Thread.sleep(1000);
        productPage.clickOnAddToCartButton();
        productPage.clickToClose();



    }


}
