# Informe de análisis estático con SonarQube

Autor del reto: Eduar Stiven Rodriguez Cortes. Proyecto: HU-001 Selección de fecha.

El análisis terminó correctamente con Quality Gate **OK**, sin incidencias abiertas y con **96,7 % de cobertura del código de automatización**. El informe se elaboró a partir de respuestas reales de la API de SonarQube y del reporte JaCoCo generado por los dos escenarios E2E.

## Identificación de la ejecución

- Fecha del análisis: 06/11/2026 00:09:15 -0500, hora de Colombia.
- SonarQube Community Build: 26.10.0.133078, instancia local en Windows con H2.
- Proyecto: `reto-sqa-datepicker`, versión `1.0.0`.
- Commit analizado: `7752973a49f3c0d2644d1035ce902e939bd2f859`.
- ID del análisis: `2c2aa885-1f63-400f-b217-e3ff94aebb0d`.
- Perfil Java: **Sonar way comprehensive**, con **618 reglas activas**.
- Quality Gate: **Sonar way**, con sus umbrales conservados.
- Herramientas: Gradle 8.14.3, plugin SonarQube 6.2.0.5505, JaCoCo 0.8.13. JDK 21 para el servidor y JDK 17 para el proyecto; el scanner aprovisiona su runtime compatible.

## Resultados

| Métrica | Resultado |
| --- | --- |
| Bugs | 0 |
| Vulnerabilidades | 0 |
| Problemas de mantenibilidad | 0 |
| Security Hotspots | 0 |
| Duplicación | 0.0 % |
| Cobertura SonarQube de la automatización | 96.7 % |
| Líneas de código principal sin comentarios | 115 |
| Clases principales | 6 |
| Pruebas JUnit importadas | 2 |
| Fallos de pruebas importados | 0 |

Fiabilidad, seguridad y mantenibilidad del código: calificación A. No se encontraron incidencias ni hotspots que requirieran corrección o revisión en esta ejecución.

## Interpretación de la cobertura y del Quality Gate

JaCoCo registró 50 de 50 líneas ejecutables cubiertas y 8 de 10 ramas cubiertas en las seis clases principales. SonarQube combina cobertura de líneas y condiciones para presentar 96,7 %. Las rutas técnicas no recorridas por los dos escenarios siguen sin prueba; no se añadieron exclusiones de cobertura para ocultarlas.

Esta medición corresponde a `src/main/java` del proyecto de automatización. El código del sitio público jQuery UI y sus servicios no forman parte del repositorio ni están instrumentados. El porcentaje no representa cobertura funcional de toda HU-001 ni cobertura del código del producto.

El Quality Gate evalúa el período de código nuevo definido por versión previa. Las primeras ejecuciones establecen la línea base y no todas las condiciones tienen datos nuevos que evaluar. En la respuesta final se evalúa ausencia de nuevas incidencias; la cobertura global se presenta por separado. El estado OK no demuestra por sí solo que todos los umbrales de código nuevo hayan sido evaluados sobre todo el repositorio. No se modificaron los umbrales del gate.

El análisis es una revisión local con el perfil incorporado de SonarSource. La conformidad con el Gobierno y el perfil corporativo de SQA requiere su validación por el tutor.

## Reproducción

Con JDK 17, servidor disponible y un token de análisis en `SONAR_TOKEN`, desde la raíz del proyecto:

```powershell
.\gradlew.bat test jacocoTestReport
.\gradlew.bat classes testClasses sonar "-Dsonar.host.url=$env:SONAR_HOST_URL" -Dsonar.qualitygate.wait=true
```

Usar `SONAR_HOST_URL=http://127.0.0.1:9000` para la instancia local. El token se transmite mediante variable de entorno y no se almacena en el repositorio. Para esta ejecución se creó un token temporal y se revocó al terminar cada análisis.

## Evidencias y trazabilidad

Las respuestas originales de métricas, incidencias, hotspots, Quality Gate, reglas, perfil, historial y archivos se encuentran en `docs/evidencias/sonarqube/`. La misma carpeta incluye JaCoCo XML, JUnit XML, metadatos y hashes SHA-256 de los archivos analizados. Los cambios de documentación posteriores al commit analizado no alteran las clases Java ni la configuración que se analizó.

Los dos escenarios aprobaron de nuevo al activar JaCoCo. Las evidencias funcionales están en `docs/evidencias/ejecucion/` y el informe local completo en `target/site/serenity/index.html`.

Pendientes de entrega: publicar en el repositorio personal creado desde el template, comprobar acceso del evaluador y validar lineamientos internos. El análisis SonarQube local queda ejecutado y documentado.

## Fuentes técnicas

- https://docs.sonarsource.com/sonarqube-community-build/server-installation/server-host-requirements
- https://docs.sonarsource.com/sonarqube-community-build/server-installation/from-zip-file/basic-installation
- https://docs.gradle.org/current/userguide/jacoco_plugin.html
