# Reto inicial SQA con Serenity Screenplay

Autor: Eduar Stiven Rodriguez Cortes.

Automatización de HU-001 en https://jqueryui.com/datepicker/ con Java 17, Gradle 8.14.3, Serenity 4.2.34, Selenium y JUnit 4. La versión se fija para mantener una combinación comprobable; no se afirma que sea la más reciente.

## Escenarios

| Caso | Prueba | Resultado esperado |
| --- | --- | --- |
| CP-02 | Día 15 del mes siguiente al mostrado por el calendario | Valor exacto MM/dd/yyyy y conservación al reabrir |
| CP-04 | Día 10 del mes actual y cambio al día 20 del mes anterior | Reemplazo exacto y conservación del nuevo valor |

Las fechas se derivan del mes del navegador, evitando valores absolutos que caduquen o diferencias de zona horaria entre Java y el navegador. No se escribe la fecha ni se usa JavaScript para simular la selección. El iframe se espera explícitamente. Cada prueba crea su propia sesión y valida el atributo value del input. Las esperas se basan en estados, sin pausas fijas.

## Ejecutar

Requisitos: Java 17 y Chrome; Internet para Gradle, Maven, Selenium Manager y la demo. Establecer JAVA_HOME a la carpeta del JDK y añadir su bin a PATH.

```powershell
.\gradlew.bat clean test
# Modo visible
.\gradlew.bat test -Dheadless.mode=false "-Dchrome.switches=--window-size=1365,900"
# Prueba individual
.\gradlew.bat test --tests '*DatepickerTest.cp02SelectSpecificDateInDifferentMonth'
```

macOS/Linux: `chmod +x gradlew` y `./gradlew clean test`.

Informes: `target/site/serenity/index.html`, `build/reports/tests/test/index.html` y XML en `build/test-results/test/`. JaCoCo 0.8.13 genera cobertura real de las clases de automatización en `build/reports/jacoco/test/jacocoTestReport.xml` y el informe HTML en `build/reports/jacoco/test/html/index.html`. Esta cobertura no mide el código del sitio jQuery UI. No subir target completo con cachés; guardar las evidencias revisadas que solicite SQA. Ver `docs/RESULTADOS.md` y `docs/INFORME_SONARQUBE.md` para los resultados, y `docs/SONARQUBE.md` para reproducir el análisis.

## Diseño Screenplay

Actor Eduar; habilidad BrowseTheWeb; Tasks OpenDatepicker y SelectDate; Interaction EnterDemo; Questions DisplayedMonth y SelectedDate; Targets en DatepickerPage. Las aserciones de negocio están en DatepickerTest. El límite de 120 meses es una protección técnica de la tarea, no una regla de negocio de la HU.

## Cobertura y límites

Los dos escenarios cubren apertura, selección, formato, navegación anterior/siguiente y retención en el campo al reabrir. La demo predeterminada no configura minDate/maxDate ni tiene backend para enviar el formulario. No se afirma persistencia después de recargar, cobertura móvil real, accesibilidad completa o pruebas de restricciones. CP-05 a CP-10 del documento quedan como cobertura propuesta.

## Repositorio personal y entrega

Repositorio de entrega: https://github.com/edwardrod/RetoSQA_Automatizacion

La implementación se publica sobre el commit inicial de la plantilla de SQA (`483f82a0f638034b8222d8db04386964a71459d3`). Las evidencias de SonarQube identifican el commit local analizado y los hashes de los archivos; la publicación añade documentación sin modificar ese código. El repositorio es público. Sigue pendiente confirmar el mecanismo de acceso o revisión solicitado por SQA.

1. En https://github.com/Proyecto-SQA/Reto_Tecnico seleccionar Use this template / Create a new repository bajo la cuenta personal.
2. Copiar esta solución en el nuevo repositorio, conservar un commit base y un commit de implementación. No copiar cachés .gradle, .idea, credenciales ni herramientas locales.
3. Ejecutar los dos casos y SonarQube sobre el commit final. Guardar evidencias de ejecución y análisis real en docs/evidencias.
4. Usar la URL de entrega indicada arriba en el formulario y verificar acceso del evaluador. Para compartir con gestion.conocimiento@sqasa.co se necesita el usuario GitHub correspondiente o el mecanismo corporativo indicado por SQA.
5. Revisar los criterios y pesos con los formatos internos de SQA y enviar por el formulario del taller cuando el responsable confirme la fecha vigente.

No se envió el formulario ni se contactó a terceros. El Gobierno SQA y sus formatos no estaban disponibles; las convenciones son una propuesta que requiere validación.

## Referencias

- https://github.com/Proyecto-SQA/Reto_Tecnico
- https://jqueryui.com/datepicker/
- https://api.jqueryui.com/datepicker/
- https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals

## Entendimiento y estimación adaptados

El formato oficial diligenciado está en docs/entendimiento/. Ver docs/REVISION_LINEAMIENTOS.md para el contraste con el video, el cálculo de 83 h base y 125 h con incertidumbre, y los pendientes de validación. Los inventarios CSV y docs/MANUAL_TECNICO_USUARIO.md documentan la entrega y transferencia. La estimación es prospectiva y todavía requiere aprobación del tutor.
