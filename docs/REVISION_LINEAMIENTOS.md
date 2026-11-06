# Revisión de los lineamientos del reto SQA

Revisión realizada el 6 de noviembre de 2026. Se contrastó el proyecto existente con el video DocumentoEntendimiento y el formato Excel suministrado. El código Java y build.gradle no cambiaron durante esta adaptación documental; las evidencias funcionales y SonarQube existentes siguen correspondiendo al código analizado.

## Fuentes revisadas

- Video: https://vimeo.com/837002485/88ef561f2b?share=copy, duración verificada de 4 min 42 s. Se revisó su contenido hablado mediante transcripción local y se contrastó el método con las fórmulas del formato. La transcripción y el audio no forman parte de la entrega.
- SQA_Formato Documento Entendimiento Automatización_AAAAMMDD.xlsx, hojas ENTENDIMIENTO, ESTIMACION, Conocimiento, Desarrollo y Diseño. Se conservaron pestañas, estructura, notas, validaciones y tabla de coeficientes.
- HU-001 e instrucciones de la plantilla Word, implementación Screenplay y evidencias reales existentes.

## Qué cambia

| Tema | Versión anterior | Adaptación |
| --- | --- | --- |
| Entendimiento | Resumen incorporado en Word | Formato oficial diligenciado en sus cinco hojas y Word coherente con él |
| Diseño | Estimación global por actividades | Seis tipos de objetos por flujo; seis y siete puntos de control; complejidad media y coeficientes de la plantilla |
| Desarrollo común | Incluido en horas generales | Cinco métodos funcionales reutilizables, estimados una sola vez |
| Esfuerzo | 22 h más reserva propuesta del 20 %: 26,4 h | 83 h optimistas por etapas, factor del formato del 50 %, total redondeado de 125 h |
| Garantía y responsables | Sin detalle específico del formato | Aplicación de garantía sujeta a acuerdo; personas no designadas identificadas como pendientes |
| Arquitectura | Explicación textual | Diagrama de la solución realmente implementada |
| Entrega | README y evidencias | Inventarios de scripts, objetos y controles; manual técnico; pendientes de acta y capacitación |

El video ubica el formato en el marco tradicional (00:17–00:36), describe los apartados de entendimiento y estimación (01:18–02:03) y explica diseño por elementos mapeados, complejidad y validaciones (02:08–04:32). Al cierre aclara que ese cálculo solo corresponde a la capa de diseño (04:33–04:42). Estos puntos se aplican sin convertir el patrón POM o los ejemplos Cucumber de la plantilla en requisitos obligatorios: HU-001 exige Screenplay y el proyecto usa JUnit.

## Base de cálculo verificable

Los “campos” del formato se interpretan como elementos a mapear, incluidos botones y mensajes, según el video. Cada flujo utiliza iframe, input de fecha, calendario, navegación mensual, celda con metadatos de mes/año y día seleccionable. Son seis tipos por flujo y siete objetos distintos en el inventario conjunto, porque Next y Prev son diferentes. Los puntos de control se documentan en PUNTOS_CONTROL.csv. Las comprobaciones repetidas del mismo control dentro de un flujo no se cuentan como objetos nuevos.

La complejidad media es una hipótesis de planificación por el iframe y la navegación de fechas relativas. Se conservan los coeficientes del formato: 25 min por objeto, 60 min por punto de control y 15 % de mantenimiento de validaciones. Por ello CP-02 estima 564 min y CP-04 estima 633 min: 1197 min, redondeados a 20 h de diseño. La reutilización está implementada en las mismas tareas y preguntas; el formato sigue estimando la integración y validación de cada flujo. No se desarrollan trece preguntas ni doce clases de localizadores.

Conocimiento totaliza 94,7 min, redondeados a 2 h. Se registran cinco páginas funcionales de la plantilla Word original y se hacen explícitas las estimaciones manuales para fuentes sin paginación y la duración del video. Los documentos no recibidos no se presentan como leídos. Desarrollo contempla cinco métodos funcionales; con los factores originales suma 437 min y redondea a 8 h. Las fábricas instrumented y las constantes no se cuentan como métodos funcionales adicionales.

| Etapa | Horas optimistas |
| --- | ---: |
| Entendimiento y planeación | 10 |
| Implementación y ejecución | 41 |
| Documentación y entrega | 24 |
| Gestión del proyecto | 8 |
| Total | 83 |

La hoja ESTIMACION conserva sus coeficientes y redondeos, incluido el 25 % de almacenamiento/empacado y el factor global del 15 % de Desarrollo. Esto produce una estimación conservadora mayor que la primera aproximación. Conviene calibrar estos parámetros con el tutor antes de aprobarlos; no representan tiempos efectivamente consumidos.

Se clasifican tres riesgos como Media y tres como Baja. La ponderación original de F95 es (3×2 + 3×1)/(6×3) = 50 %. ENTENDIMIENTO!B13 enlaza ese factor y B12 calcula ROUNDUP(83×1,50,0) = 125 h. La reserva exacta es 41,5 h antes del redondeo final. Este índice es una convención de incertidumbre del formato, no una probabilidad estadística ni una segunda reserva añadida al 20 % anterior.

Se agregó una validación al cálculo para que una categoría de riesgo faltante o inválida muestre “Pendiente de riesgos” en lugar de reducir silenciosamente el total. Con las seis categorías válidas se conserva la ponderación original. La planificación por semanas es relativa, con reserva en S4 y sin fechas comprometidas.

## Verificación de la adaptación

Se recalcularon y exportaron los cinco apartados. Se comprobaron totales y dependencias: aumentar un objeto en CP-02 cambia la base de 83 a 85 h y el total de 125 a 128 h; elevar un riesgo Media a Alta cambia el total a 130 h; dejar un riesgo vacío muestra el pendiente. Se restauraron las entradas originales. El archivo final no contiene errores de fórmula en sus valores guardados. Se verificó que las siete notas y las dos validaciones de lista del original permanecen disponibles.

El motor de importación interpretaba 731 celdas de texto vacío de Desarrollo como su índice de cadena. Se normalizaron esas celdas reservadas a vacías para conservar su presentación y evitar datos ajenos. Las fórmulas no relacionadas y las pestañas se conservaron. No se alteró la lógica de los scripts, por lo que no se repitieron las pruebas E2E ni SonarQube solo por cambios de documentación.

## Pendientes de aceptación

1. Recibir Gobierno de Automatización, matriz oficial de priorización, bitácora/checklist de riesgos y confirmar los responsables.
2. Revisar con el tutor complejidad, conteos, coeficientes de estimación, tratamiento de reutilización y factor de incertidumbre. La cifra de 125 h es una propuesta del modelo, no una estimación aprobada.
3. Comprobar el acceso del evaluador a https://github.com/edwardrod/RetoSQA_Automatizacion y confirmar con SQA el mecanismo de revisión. La publicación conserva el commit inicial de la plantilla.
4. Realizar la demostración, capacitación y acta de entrega; no se simulan firmas, grabaciones ni aceptaciones.

El alcance sigue siendo dos escenarios en Chrome. Envío y persistencia en servidor, restricciones no configuradas, móviles, accesibilidad completa y demás ampliaciones continúan fuera de esta entrega.
