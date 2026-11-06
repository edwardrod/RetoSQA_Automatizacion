package co.com.sqa.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class DatepickerPage {
    public static final Target FRAME = Target.the("demo del calendario").locatedBy("iframe.demo-frame");
    public static final Target DATE = Target.the("campo de fecha").locatedBy("#datepicker");
    public static final Target CALENDAR = Target.the("calendario emergente").locatedBy("#ui-datepicker-div");
    public static final Target TITLE = Target.the("mes y año visibles").locatedBy(".ui-datepicker-title");
    public static final Target NEXT = Target.the("mes siguiente").locatedBy(".ui-datepicker-next");
    public static final Target PREVIOUS = Target.the("mes anterior").locatedBy(".ui-datepicker-prev");
    public static final Target DAYS = Target.the("días seleccionables").locatedBy("#ui-datepicker-div td[data-handler='selectDay'] a");
    public static final Target FIRST_DAY = Target.the("primera fecha seleccionable").locatedBy("#ui-datepicker-div td[data-handler='selectDay']");
    private DatepickerPage() { }
}
