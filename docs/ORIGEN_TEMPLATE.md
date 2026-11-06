# Origen y adaptación

Fuente: https://github.com/Proyecto-SQA/Reto_Tecnico, rama main, descargada el 5 de noviembre de 2026.

Se conservaron los lanzadores Gradle y la estructura Java/Gradle como base. La plantilla original usa Gradle 6.8, Serenity 2.0.80, JCenter y permite ignorar fallos. Se adaptó a Java 17, Gradle 8.14.3 y Serenity 4.2.34; se retiró JCenter y no se ignoran los fallos. Se añadió el JAR del wrapper, ausente en el ZIP de origen, desde Gradle oficial. Las clases de ejemplo se sustituyeron por Tasks, Questions, Interaction y Targets de Screenplay.

El repositorio personal de entrega es https://github.com/edwardrod/RetoSQA_Automatizacion. Se conserva como padre el commit inicial `483f82a0f638034b8222d8db04386964a71459d3`, que contiene la estructura y los ejemplos de la plantilla de SQA. Sobre esa base se publica la adaptación documentada. La API consultada no informa el campo template_repository, por lo que se deja constancia de la base observada sin atribuir metadatos que no están disponibles.
