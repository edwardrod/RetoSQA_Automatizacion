# Ejecutar el análisis SonarQube

El análisis del reto ya fue ejecutado. Consultar `INFORME_SONARQUBE.md` y `evidencias/sonarqube/` para sus resultados reales.

1. Usar un servidor autorizado y crear el proyecto `reto-sqa-datepicker`.
2. Elegir el perfil Java acordado. En la evidencia local se usó Sonar way comprehensive, con 618 reglas. Se conservó el gate Sonar way.
3. Con JDK 17 en JAVA_HOME, configurar SONAR_HOST_URL y guardar un token de análisis únicamente en SONAR_TOKEN.

```powershell
.\gradlew.bat test jacocoTestReport
.\gradlew.bat classes testClasses sonar "-Dsonar.host.url=$env:SONAR_HOST_URL" -Dsonar.qualitygate.wait=true
```

JaCoCo se genera después de test y el scanner importa su XML. La cobertura corresponde a las clases de automatización, no al código de jQuery UI.

4. Revisar Issues, Security Hotspots, Coverage y Quality Gate. Conservar respuestas o capturas, fecha, versión, perfil y commit analizado, sin tokens.
5. Validar resultados con el tutor y volver a analizar si se modifica el código. Un Quality Gate OK no garantiza cobertura funcional completa.

La instancia local del ejercicio está instalada fuera del repositorio y escucha únicamente en 127.0.0.1:9000. Las credenciales locales no están incluidas en los entregables ni en Git.
