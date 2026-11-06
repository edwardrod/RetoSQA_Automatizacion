# Manual técnico y de ejecución

## Preparación y ejecución

Instalar o disponer de JDK 17, Chrome e Internet. Establecer JAVA_HOME al JDK y añadir su bin a PATH. Desde la raíz del proyecto ejecutar `gradlew.bat test jacocoTestReport`. El wrapper descarga Gradle 8.14.3 y Selenium Manager obtiene el controlador compatible. Para ejecución individual y modo visible, consultar README.

## Arquitectura y responsabilidades

El actor Eduar dispone de BrowseTheWeb. OpenDatepicker abre la URL; EnterDemo espera el iframe; SelectDate compara YearMonth, navega y selecciona un día habilitado. DisplayedMonth y SelectedDate consultan el estado para las aserciones. DatepickerPage contiene Targets. DatepickerTest define CP-02 y CP-04 en sesiones independientes. La técnica es scripting parametrizado por fechas relativas; el patrón es Screenplay. No se requiere Cucumber ni un archivo de datos Excel para ejecutar la solución actual.

M es el mes inicialmente visible. CP-02 usa el día 15 de M+1; CP-04 usa el día 10 de M y lo cambia al 20 de M-1. La URL puede cambiar mediante la propiedad reto.baseUrl si el nuevo ambiente conserva la misma estructura de demo. No se introducen fechas mediante JavaScript ni escritura directa del input.

## Evidencias y diagnóstico

Consultar target/site/serenity/index.html, build/reports/tests/test/index.html y build/reports/jacoco/test/html/index.html. El análisis estático y sus respuestas API se conservan en docs/INFORME_SONARQUBE.md y docs/evidencias/sonarqube. Para repetirlo, configurar SONAR_HOST_URL y SONAR_TOKEN como explica docs/SONARQUBE.md.

Si no carga la página, revisar Internet y disponibilidad de la demo. Si falla el iframe o un localizador, revisar el DOM y los Targets antes de atribuirlo a un defecto de producto. Si falla una aserción, comparar esperado y observado en la captura y el informe; registrar caso, datos relativos, fecha, navegador, pasos y frecuencia. Los fallos deben conservar el estado fallido del build. No aumentar tiempos ni añadir reintentos para ocultarlos.

## Mantenimiento y transferencia

INVENTARIO_SCRIPTS.csv identifica cada método; INVENTARIO_OBJETOS.csv documenta los elementos y PUNTOS_CONTROL.csv vincula las validaciones al código. Modificar controles, datos o alcance requiere revisar esos inventarios, las pruebas y la estimación. Preservar aislamiento de sesiones y componentes reutilizables.

La transferencia pendiente comprende preparación del ambiente, ejecución individual y conjunta, lectura de resultados y diagnóstico de un fallo. El tutor debe validar el alcance antes del acta. La garantía corporativa no se presume acordada en este reto académico.
