package com.testing.Pages;

import com.testing.Utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QualificationAndTrainingPage extends BasePage {

    public QualificationAndTrainingPage() {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//div[@class='col-12 mb-4']")
    private WebElement pageConfirmationMsg;


    @FindBy(xpath = "//button[@class='btn btn btn-primary full-width'][@testid='addQualificationButton']")
    private WebElement addQualificationButton;

    @FindBy(css = "button.react-date-picker__calendar-button.react-date-picker__button__icon")
    private WebElement calenderButton;


    @FindBy(xpath = "//div[@class='react-calendar__year-view__months']/button/time")
    private List<WebElement> datePickerButtons;

   @FindBy(xpath = "//span[@class='checked']")
       private List<WebElement> atThisTimeICompletedCheckBoxBtns;


    @FindBy(css = "select#title")
    private WebElement selectCareRelatedQualification;


    @FindBy(xpath = "//div[text()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//div[contains(text(),'Next')]")
    private WebElement nextButton;


    public void selectAddQualificatiobBtn() {
        addQualificationButton.click( );
    }

    public void fillingQualificationForm(String dateCompleted,String atThisTimeICompleted,String careRelatedQualification) {
        Utils.javaScriptExecutor(calenderButton);

        for (WebElement element : datePickerButtons) {
            if (element.getAttribute("datetime").contains(dateCompleted) ){
                Utils.javaScriptExecutor(element);
                break;
            }
        }


      for (WebElement element : atThisTimeICompletedCheckBoxBtns){

       if(element.getText().equals(atThisTimeICompleted)){
           element.click();
           break;
       }

      }

        Utils.selectFromList(selectCareRelatedQualification, careRelatedQualification);


    }

    public void selectAddBtn() {
        addButton.click( );
    }

    public void clickNxtBtn() {

        Utils.waitForElementClickable(nextButton);
        nextButton.click( );
    }

}
