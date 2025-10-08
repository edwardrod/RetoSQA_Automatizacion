package co.sqasa.pageObjects;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Objects extends PageObject {

    private static final String DATEPICKER_URL = "https://jqueryui.com/datepicker/";
    private static final String IFRAME_SELECTOR = ".demo-frame";

    @FindBy(id = "datepicker")
    private WebElementFacade dateInputField;

    @FindBy(css = ".ui-datepicker-next")
    private WebElementFacade nextMonthButton;

    @FindBy(css = ".ui-datepicker")
    private WebElementFacade calendar;

    public void openPage() {
        openUrl(DATEPICKER_URL);
        waitForPageToLoad();
        switchToDatepickerFrame();
    }

    private void switchToDatepickerFrame() {
        getDriver().switchTo().frame(
                getDriver().findElement(By.cssSelector(IFRAME_SELECTOR))
        );
        waitFor(dateInputField);
    }

    public void clickDatePicker() {
        dateInputField.waitUntilClickable().click();
        waitFor(calendar);
    }

    public void clickDateToday(int day) {
        String dayLocator = String.format(
                "//a[@class='ui-state-default' and text()='%d']", day
        );
        WebElementFacade dayElement = find(By.xpath(dayLocator));
        dayElement.waitUntilClickable().click();
    }

    public void navigateToNextMonth() {
        nextMonthButton.waitUntilClickable().click();
        waitABit(500);
    }

    public void attemptToTypeInDateField(String text) {
        dateInputField.click();
        dateInputField.sendKeys(text);
    }

    public boolean isCalendarDisplayed() {
        return calendar.isVisible();
    }

    public String getSelectedDate() {
        return dateInputField.getValue();
    }

    private void waitForPageToLoad() {
        waitForRenderedElementsToBePresent(By.cssSelector(IFRAME_SELECTOR));
    }

    @Deprecated
    public void clickDateToday() {
        selectDay(15);
    }
}