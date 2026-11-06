# Resultados de ejecución

Evidencia recopilada: 2026-11-05T23:55:28-05:00, zona America/Bogota.

Entorno: Windows, Java 17.0.20.1, Gradle 8.14.3, Serenity 4.2.34 y Chrome headless (ventana 1365 x 900). La versión exacta del navegador se conserva en los JSON de Serenity cuando el controlador la informa.

| Prueba | Resultado | Duración |
| --- | --- | --- |
| cp02SelectSpecificDateInDifferentMonth | Aprobado | 20.383 s |
| cp04ReplacePreviouslySelectedDate | Aprobado | 49.971 s |

Resultado global: 2 ejecutadas, 2 aprobadas, 0 fallidas, 0 omitidas. Dos ejecuciones completas consecutivas aprobaron después del ajuste de sincronización. Esto verifica estos recorridos en este ambiente y no garantiza ausencia de fallos intermitentes futuros.

Comandos realmente ejecutados desde la carpeta del reto, con JDK 17 temporal en JAVA_HOME:

```powershell
.\herramientas\gradle-8.14.3\bin\gradle.bat -p RetoSQA_Automatizacion clean test --console=plain
.\herramientas\gradle-8.14.3\bin\gradle.bat -p RetoSQA_Automatizacion test --rerun-tasks --console=plain
```

El wrapper incluido está fijado a la misma distribución. Para otro equipo usar el comando `gradlew.bat clean test` descrito en README.

Durante la primera ejecución CP-02 seleccionó el valor esperado, pero no pasó la comprobación de cierre del calendario. Se evitó el clic redundante sobre el input y se esperó a que la opacidad del calendario alcanzara 1 antes de interactuar. La ejecución aislada y las dos ejecuciones completas posteriores aprobaron. No se reporta este fallo como defecto confirmado del producto.

Evidencias versionables: `docs/evidencias/ejecucion/resultados-junit.xml`, los JSON de Serenity y sus capturas. Informes completos generados localmente: `target/site/serenity/index.html` y `build/reports/tests/test/index.html`. Las cachés y las herramientas locales quedan excluidas del paquete.

Análisis SonarQube ejecutado el 6 de noviembre de 2026: Quality Gate OK, 0 incidencias abiertas y 96,7 % de cobertura del código de automatización. Perfil Java Sonar way comprehensive con 618 reglas. Se volvieron a ejecutar los dos casos con JaCoCo y ambos aprobaron. Ver docs/INFORME_SONARQUBE.md para el commit, evidencias e interpretación de la línea base.

Pendientes funcionales: compatibilidad en otros navegadores y móviles, fronteras de año y bisiesto, rango minDate/maxDate y envío/persistencia de formulario. Consultar el documento para la trazabilidad propuesta.
