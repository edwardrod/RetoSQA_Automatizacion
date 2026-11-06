package co.com.sqa.reto.questions;

import java.time.YearMonth;
import co.com.sqa.reto.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DisplayedMonth implements Question<YearMonth> {
    public static DisplayedMonth value() { return new DisplayedMonth(); }
    @Override
    public YearMonth answeredBy(Actor actor) {
        var firstDay = DatepickerPage.FIRST_DAY.resolveFor(actor);
        return YearMonth.of(Integer.parseInt(firstDay.getDomAttribute("data-year")),
            Integer.parseInt(firstDay.getDomAttribute("data-month")) + 1);
    }
}
