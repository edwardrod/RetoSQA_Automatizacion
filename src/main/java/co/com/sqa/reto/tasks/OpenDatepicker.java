package co.com.sqa.reto.tasks;

import co.com.sqa.reto.interactions.EnterDemo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenDatepicker implements Task {
    public static OpenDatepicker demo() { return instrumented(OpenDatepicker.class); }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(System.getProperty("reto.baseUrl", "https://jqueryui.com/datepicker/")), EnterDemo.frame());
    }
}
