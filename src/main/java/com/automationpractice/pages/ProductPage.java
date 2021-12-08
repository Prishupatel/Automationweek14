package com.automationpractice.pages;

import com.automationpractice.utility.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductPage extends Utilities {
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    //    @FindBy(xpath = "//a[normalize-space()='Faded Short Sleeve T-shirts']")
//    //a[normalize-space()='Blouse'
//
    @FindBy(css = "#quantity_wanted")
    WebElement inputboxQt;

    @FindBy(css = "#group_1")
    WebElement selectSizeDropDown;

    @FindBy(css = "button[name='Submit'] span")
    WebElement addToCartButton;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement verifyTEXT;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement close;

    @FindBy(xpath = "//a[normalize-space()='Blouse']")   //a[normalize-space()='Blouse']
    WebElement blouse;

    @FindBy(xpath = "//a[@id='color_8']")   //a[@id='color_8']
    WebElement colorWht;

    @FindBy(xpath = "(//a[@title='Printed Dress'][normalize-space()='Printed Dress'])[1]")
    WebElement printedDress;

    @FindBy(xpath = "//a[@id='color_13']")   //a[@id='color_13']
    WebElement colorOrg;

    @FindBy(xpath = "//a[normalize-space()='Printed Chiffon Dress']")
    WebElement priChiDress;

    @FindBy(xpath = "//a[@id='color_15']")  //a[@id='color_15']
    WebElement colorGrn;

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'][normalize-space()='Printed Summer Dress'])[2]")
    WebElement summerDress;

    @FindBy(xpath = "//a[@id='color_14']") //a[@id='color_14']
    WebElement colorBlu;


    public void selectedProduct(String Name) {
        if (Name.equalsIgnoreCase("Blouse")) {
            Reporter.log("Select " + Name.toString() + "<br>");
            clickOnElement(blouse);
        } else if (Name.equalsIgnoreCase("Printed Dress")) {
            Reporter.log("Select " + Name.toString() + "<br>");
            clickOnElement(printedDress);
        } else if (Name.equalsIgnoreCase("Printed Chiffon Dress")) {
            Reporter.log("Select " + Name.toString() + "<br>");
            clickOnElement(priChiDress);
        } else if (Name.equalsIgnoreCase("Printed Summer Dress with Price $28.98")) {
            Reporter.log("Select " + Name.toString() + "<br>");
            clickOnElement(summerDress);
        }
    }

    public void selColour(String color) {
        if (color.equalsIgnoreCase("White")) {
            Reporter.log("Select " + color.toString() + "<br>");
            clickOnElement(colorWht);
        } else if (color.equalsIgnoreCase("Orange")) {
            Reporter.log("Select " + color.toString() + "<br>");
            clickOnElement(colorOrg);
        } else if (color.equalsIgnoreCase("Green")) {
            Reporter.log("Select " + color.toString() + "<br>");
            clickOnElement(colorGrn);
        } else if (color.equalsIgnoreCase("Blue")) {
            Reporter.log("Select " + color.toString() + "<br>");
            clickOnElement(colorBlu);
        }
    }

    public void enterQuantity(String value) throws InterruptedException {
        //  Reporter.log("Entering qty :" +value+ " in the qtyAdd :" +inputboxQt.toString() + "<br>");
        clearValue(inputboxQt);
        Thread.sleep(1000);
        sendTextToElement(inputboxQt, value);
        System.out.println("");
    }

    public void selectYourComfortSize(String size) {
        Reporter.log("Select " + size.toString() + "<br>");
        selectByVisibleTextFromDropDown(selectSizeDropDown, size);
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click on" + addToCartButton.toString() + "<br>");
        clickOnElement(addToCartButton);
    }

    public void verifyTextForSuccessfullyadd(String msg) {
        verifyMessage(verifyTEXT, msg, "Product successfully added to your shopping cart");
    }

    public void clickToClose() {
        Reporter.log("Click on" + close.toString() + "<br>");
        clickOnElement(close);
    }

}

