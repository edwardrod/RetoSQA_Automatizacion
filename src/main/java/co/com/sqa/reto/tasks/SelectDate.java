package co.com.sqa.reto.tasks;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import co.com.sqa.reto.questions.DisplayedMonth;
import co.com.sqa.reto.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class SelectDate implements Task {
    private final LocalDate date;
    public SelectDate(LocalDate date) { this.date = date; }
    public static SelectDate on(LocalDate date) { return instrumented(SelectDate.class, date); }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!DatepickerPage.CALENDAR.resolveFor(actor).isVisible()) {
            actor.attemptsTo(Click.on(DatepickerPage.DATE));
        }
        actor.attemptsTo(WaitUntil.the(DatepickerPage.CALENDAR, isVisible()).forNoMoreThan(15).seconds());
        var wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(15));
        wait.until(driver -> "1".equals(DatepickerPage.CALENDAR.resolveFor(actor).getCssValue("opacity")));
        YearMonth desired = YearMonth.from(date);
        YearMonth visible = actor.asksFor(DisplayedMonth.value());
        long offset = ChronoUnit.MONTHS.between(visible, desired);
        if (Math.abs(offset) > 120) throw new IllegalArgumentException("La fecha supera el límite técnico de navegación de 120 meses");
        while (!visible.equals(desired)) {
            YearMonth previous = visible;
            actor.attemptsTo(Click.on(visible.isBefore(desired) ? DatepickerPage.NEXT : DatepickerPage.PREVIOUS));
            wait.until(driver -> !actor.asksFor(DisplayedMonth.value()).equals(previous));
            visible = actor.asksFor(DisplayedMonth.value());
        }
        var day = DatepickerPage.DAYS.resolveAllFor(actor).stream()
            .filter(element -> element.getText().equals(Integer.toString(date.getDayOfMonth())))
            .findFirst().orElseThrow(() -> new IllegalStateException("Fecha no seleccionable: " + date));
        actor.attemptsTo(Click.on(day),
            WaitUntil.the(DatepickerPage.CALENDAR, isNotVisible()).forNoMoreThan(15).seconds());
    }
}
