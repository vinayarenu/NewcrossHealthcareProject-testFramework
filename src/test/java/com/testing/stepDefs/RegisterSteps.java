package com.testing.stepDefs;

import com.testing.Pages.HistoryPage;
import com.testing.Pages.HomePage;
import com.testing.Pages.PersonalDetailsPage;
import com.testing.Pages.QualificationAndTrainingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegisterSteps {

    HomePage homePage = new HomePage( );
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage( );
    QualificationAndTrainingPage qualificationAndTrainingPage = new QualificationAndTrainingPage( );
    HistoryPage historyPage = new HistoryPage();

    @Given("^User is on the home page$")
    public void user_is_on_the_home_page() {
        String url = homePage.getUrl( );
        Assert.assertEquals("http://test.oaf.healthforcego.com/", url);

    }

    @When("^I enter email, short password as \"([^\"]*)\" and confirmPassword as \"([^\"]*)\"$")
    public void i_enter_email_short_password_as_and_confirmPassword_as(String shortPswrd, String confirmationPswrd) {
        homePage.enterEmailId( );
        homePage.shortPswrdAndConfirmationPswrd(shortPswrd, confirmationPswrd);

    }

    @When("^I select register$")
    public void i_select_register() {
        homePage.selectsRegister( );

    }

    @Then("^I should see the error messages for password and unselected checkboxes$")
    public void i_should_see_the_error_messages_for_password_and_unselected_checkboxes() {
        boolean msg1 = homePage.pswrdErrorMessage( );
        Assert.assertTrue(msg1);

        boolean msg2 = homePage.rightToWorkErrorMsg( );
        Assert.assertTrue(msg2);

        boolean msg3 = homePage.hasExperienceErrorMsg( );
        Assert.assertTrue(msg3);

        boolean msg4 = homePage.consentDataStoredErrorMsg( );
        Assert.assertTrue(msg4);

        boolean msg5 = homePage.agreeTermsAndConditionsErrormsg( );
        Assert.assertTrue(msg5);

        boolean msg6 = homePage.agreePrivacyPolicyErrorMsg( );
        Assert.assertTrue(msg6);
    }

    @When("^I enter correct password as \"([^\"]*)\" and confirmPassword as \"([^\"]*)\"$")
    public void i_enter_correct_password_as_and_confirmPassword_as(String correctPswrd, String correctConfirmationPswrd) {
        homePage.correctPswrdAndConfirmationPswrd(correctPswrd, correctConfirmationPswrd);


    }

    @When("^I select all checkboxes$")
    public void i_select_all_checkboxes() {
        homePage.selectCheckBoxes( );

    }
    @When("^I reselect register$")
    public void i_reselect_register()  {
        homePage.selectsRegister( );

    }

    @Then("^I should navigate to personal details page$")
    public void i_should_navigate_to_personal_details_page() {
        String url = personalDetailsPage.getUrl();
    Assert.assertEquals("http://test.oaf.healthforcego.com/",url);

    }

    @When("^I enter personal details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void i_enter_personal_details_as(String title, String firstName, String lastName, String mobNo) {
        personalDetailsPage.enterPersonalDetails(title, firstName, lastName, mobNo);
    }

    @When("^I enter postcode as \"([^\"]*)\"$")
    public void i_enter_postcode_as(String postCode) {
        personalDetailsPage.enterPostcode(postCode);

    }

    @When("^I select Lookup address as \"([^\"]*)\"$")
    public void i_select_Lookup_address_as(String lookUpAddress) {
        personalDetailsPage.selectsLookUpAddress(lookUpAddress);

    }

    @When("^I select next button$")
    public void i_select_next_button() {
        personalDetailsPage.selectNextButton();

    }

    @Then("^I should see the error message as \"([^\"]*)\"$")
    public void i_should_see_the_error_message_as(String msg) {
        boolean message = personalDetailsPage.lastNameErrorMessage(msg);
        Assert.assertTrue(message);

    }
    @When("^I enter personal details again as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void i_enter_personal_details_again_as(String title, String firstName, String lastName, String mobNo) {
        personalDetailsPage.enterPersonalDetails(title, firstName, lastName, mobNo);
    }

    @When("^clicks next button$")
    public void clicks_next_button() {
        personalDetailsPage.selectNextButton();

    }

    @Then("^I should navigate to Qualification & Training page$")
    public void i_should_navigate_to_Qualification_Training_page() {
      String url =   qualificationAndTrainingPage.getUrl();
      Assert.assertEquals("http://test.oaf.healthforcego.com/personal-details",url);

    }

    @When("^I select Add Qualification$")
    public void i_select_Add_Qualification() {
        qualificationAndTrainingPage.selectAddQualificatiobBtn();

    }
    @When("^I fill the Qualification form as \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_fill_the_Qualification_form_as_and(String dateCompleted, String atThisTimeICompleted, String careRelatedQualification) throws Throwable {
        qualificationAndTrainingPage.fillingQualificationForm(dateCompleted,atThisTimeICompleted,careRelatedQualification);

    }



    @When("^I select add button$")
    public void i_select_add_button() {
        qualificationAndTrainingPage.selectAddBtn();

    }

    @When("^I click next button$")
    public void i_click_next_button() {
        qualificationAndTrainingPage.clickNxtBtn();


    }

    @Then("^I should navigate to history page$")
    public void i_should_navigate_to_history_page() {
        String url =   historyPage.getUrl();
        Assert.assertEquals("http://test.oaf.healthforcego.com/qualifications",url);




    }


}
