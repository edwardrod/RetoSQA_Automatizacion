package co.com.sqa.reto.runners;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import co.com.sqa.reto.questions.DisplayedMonth;
import co.com.sqa.reto.questions.SelectedDate;
import co.com.sqa.reto.tasks.OpenDatepicker;
import co.com.sqa.reto.tasks.SelectDate;
import co.com.sqa.reto.userinterfaces.DatepickerPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class DatepickerTest {
    @Managed(driver = "chrome", uniqueSession = false)
    WebDriver browser;
    private Actor user;
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM/dd/uuuu");

    @Before
    public void prepareActor() {
        user = Actor.named("Eduar").whoCan(BrowseTheWeb.with(browser));
        user.attemptsTo(OpenDatepicker.demo());
    }

    private YearMonth currentCalendarMonth() {
        user.attemptsTo(Click.on(DatepickerPage.DATE),
            WaitUntil.the(DatepickerPage.CALENDAR, isVisible()).forNoMoreThan(15).seconds());
        return user.asksFor(DisplayedMonth.value());
    }

    @Test
    public void cp02SelectSpecificDateInDifferentMonth() {
        LocalDate target = currentCalendarMonth().plusMonths(1).atDay(15);
        user.attemptsTo(SelectDate.on(target));
        user.should(seeThat("fecha mostrada en MM/dd/yyyy", SelectedDate.value(), equalTo(target.format(FORMAT))));
        user.attemptsTo(Click.on(DatepickerPage.DATE));
        user.should(seeThat("mes conservado al reabrir", DisplayedMonth.value(), equalTo(YearMonth.from(target))));
        user.should(seeThat("valor conservado al reabrir", SelectedDate.value(), equalTo(target.format(FORMAT))));
    }

    @Test
    public void cp04ReplacePreviouslySelectedDate() {
        YearMonth month = currentCalendarMonth();
        LocalDate original = month.atDay(10);
        LocalDate replacement = month.minusMonths(1).atDay(20);
        user.attemptsTo(SelectDate.on(original));
        user.should(seeThat("fecha inicial", SelectedDate.value(), equalTo(original.format(FORMAT))));
        user.attemptsTo(SelectDate.on(replacement));
        user.should(seeThat("fecha reemplazada", SelectedDate.value(), equalTo(replacement.format(FORMAT))));
        user.attemptsTo(Click.on(DatepickerPage.DATE));
        user.should(seeThat("mes de la nueva fecha", DisplayedMonth.value(), equalTo(YearMonth.from(replacement))));
        user.should(seeThat("nueva fecha conservada", SelectedDate.value(), equalTo(replacement.format(FORMAT))));
    }
}
