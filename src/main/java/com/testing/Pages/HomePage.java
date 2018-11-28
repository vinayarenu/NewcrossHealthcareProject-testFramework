package com.testing.Pages;

import com.mifmif.common.regex.Generex;
import com.testing.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "passwordConfirmation")
    private WebElement passwordConfirmationField;

    @FindBy(css = "span.checked")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//button[@type='submit'][@value='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@name='password']/div/span")
    private WebElement pwdErrorMsg;

    @FindBy(xpath = "//div[@name='rightToWork']/div/span")
    private WebElement rightToWorkErrorMsg;

    @FindBy(xpath = "//div[@name='hasExperience']/div/span")
    private WebElement hasExperienceErrorMsg;

    @FindBy(xpath = "//div[@name='consentDataStored']/div/span")
    private WebElement consentDataStoredErrorMsg;

    @FindBy(xpath = "//div[@name='agreeTermsConditions']/div/span")
    private WebElement agreeTermsAndConditionsErrormsg;

    @FindBy(xpath = "//div[@name='agreePrivacyPolicy']/div/span")
    private WebElement agreePrivacyPolicyErrorMsg;


    public void enterEmailId() {
        Random random = new Random( );
        String email = "johnsmith" + random.nextInt( ) + "@gmail.com";
        System.out.println(email);
        emailField.sendKeys(email);


    }

    public void shortPswrdAndConfirmationPswrd(String shortPswrd, String shortConfirmationPswrd) {
        passwordField.sendKeys(shortPswrd);
        passwordConfirmationField.sendKeys(shortConfirmationPswrd);

    }


    public void selectsRegister() {
        registerButton.click( );
    }

    public boolean pswrdErrorMessage() {
        return pwdErrorMsg.getText( ).equals("Password is less than 7 characters");
    }

    public boolean rightToWorkErrorMsg() {
        return rightToWorkErrorMsg.getText( ).equals("Please confirm you have the right to work in the UK");
    }

    public boolean hasExperienceErrorMsg() {
        return hasExperienceErrorMsg.getText( ).equals("Please confirm you have at least 3 months Care Experience");
    }

    public boolean consentDataStoredErrorMsg() {
        return consentDataStoredErrorMsg.getText( ).equals("Please give consent");
    }

    public boolean agreeTermsAndConditionsErrormsg() {
        return agreeTermsAndConditionsErrormsg.getText( ).equals("Please agree to Terms and Conditions");
    }

    public boolean agreePrivacyPolicyErrorMsg() {
        return agreePrivacyPolicyErrorMsg.getText( ).equals("Please agree to Newcross Privacy Policy");
    }

    public void correctPswrdAndConfirmationPswrd(String correctPswrd, String correctConfirmationPswrd) {
        passwordField.sendKeys(correctPswrd);
        passwordConfirmationField.sendKeys(correctConfirmationPswrd);
        Utils.sleep();

    }

    public void selectCheckBoxes() {
        for (WebElement element : checkBoxes) {
            if (!element.isSelected( )) {
                element.click( );
            }
        }
    }


}
