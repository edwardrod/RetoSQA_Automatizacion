package co.sqasa.Steps;

import co.sqasa.pageObjects.Objects;
import net.serenitybdd.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class DatesStep {
    private Objects dates;

    @Step
    public void openPage(){ dates.openPage(); }

    @Step
    public void clickDatePicker(){
        dates.clickDatePicker();
    }

    @Step
    public void clickDayThisMonth(int day){
        dates.clickDateToday(day);
    }

    @Step
    public void navigateToNextMonth() { dates.navigateToNextMonth(); }

    @Step
    public void selectDayNextMonth(int day) { dates.clickDateToday(day); }

    @Step
    public String attemptManualDateEntry() {
        String antValue = dates.getSelectedDate();
        dates.attemptToTypeInDateField("12/25/2025");
        dates.waitABit(500);
        return antValue;
    }

    @Step
    public void validateFieldIsReadOnly(String antValue) {
        String currentValue = dates.getSelectedDate();
        assertThat(currentValue)
                .as("The field should not allow manual editing - the value should not change")
                .isEqualTo(antValue);
    }

    @Step
    public void validateCalendarIsVisible() {
        dates.clickDatePicker();
        boolean calendaVisible = dates.isCalendarDisplayed();
        assertThat(calendaVisible)
                .as("The calendar should be visible when clicking on the field")
                .isTrue();
    }

    @Step
    public void validateDate(){
        String selectedDate = dates.getSelectedDate();
        assertThat(selectedDate)
                .as("The selected date should appear in the text field")
                .isNotEmpty()
                .matches("\\d{2}/\\d{2}/\\d{4}");
    }

    @Step
    public void validateDateIsPresent() {
        String selectedDate = dates.getSelectedDate();
        assertThat(selectedDate)
                .as("La fecha seleccionada debe aparecer en el campo de texto")
                .isNotEmpty()
                .matches("\\d{2}/\\d{2}/\\d{4}");
    }

    @Deprecated
    @Step("select date today")
    public void clickDayThisMonth() {
        dates.clickDateToday();
    }

    @Deprecated
    @Step("Date Validate")
    public void validateDatePresent() {
        validateDateIsPresent();
    }
}