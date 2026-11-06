package co.com.sqa.reto.questions;

import co.com.sqa.reto.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SelectedDate implements Question<String> {
    public static SelectedDate value() { return new SelectedDate(); }
    @Override
    public String answeredBy(Actor actor) {
        return DatepickerPage.DATE.resolveFor(actor).getValue();
    }
}
