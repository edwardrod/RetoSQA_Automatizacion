package co.sqasa.StepDef;

import co.sqasa.Steps.DatesStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class TestStepDefinition {
    DatesStep dateStep = new DatesStep();

    @Given("^the user opens the JQuery Datepicker home page$")
    public void theUserOpensTheJQueryDatepickerHomePage() {dateStep.openPage();}

    @When("^the user clicks on the date selection field$")
    public void theUserClicksOnTheDateSelectionField() {dateStep.clickDatePicker();}

    @And("^select day of the current month$")
    public void selectDayOfTheCurrentMonth(int day) {dateStep.clickDayThisMonth(day);}

    @And("^navigate to next month$")
    public void navigateToNextMonth() {dateStep.navigateToNextMonth();}

    @And("^select day of the next month$")
    public void selectDayOfTheNextMonth(int day) {dateStep.selectDayNextMonth(day);}

    @And("^The user attempts to manually enter a date into the text field$")
    public void theUserAttemptsToManuallyEnterADateIntoTheTextField() {dateStep.attemptManualDateEntry();}

    @And("^the field must not allow manual editing$")
    public void theFieldMustNotAllowManualEditing() {dateStep.validateFieldIsReadOnly(antValue);}

    @And("^It should only be possible to select one date from the calendar$")
    public void itShouldOnlyBePossibleToSelectOneDateFromTheCalendar() {dateStep.validateCalendarIsVisible();}

    @Then("^the selected date should appear in the text field$")
    public void theSelectedDateShouldAppearInTheTextField() {dateStep.validateDate();}

}
