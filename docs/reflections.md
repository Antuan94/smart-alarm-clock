# Informe de Reflexión Técnica, Uso de IA y Autoevaluación

## 1. Reflexión Técnica y Decisiones de Diseño (SOLID)
* **Patrones y Modularidad:** Se ha aplicado de forma estricta el **Principio de Responsabilidad Única (SRP)**. Las alarmas no gestionan su lógica de disparo ni computan matemáticas; de ello se encargan `AlarmManager` y `MathChallenge` respectivamente.
* **Encapsulación:** Se ha protegido el estado interno de todos los objetos declarando variables `private`. La coherencia del volumen (rango 0-100) y de las horas se valida en los constructores y setters, impidiendo la corrupción de datos.
* **Deuda Técnica y Mejoras Futuras:** Como mejora futura, se identifica la oportunidad de sustituir la simulación por un hilo de ejecución real (`Thread.sleep`) acoplado a un patrón *Observer* para notificar los disparos de alarma en tiempo real sin necesidad de bucles estructurados.

## 2. Uso Obligatorio de IA Generativa y Validación
* **Herramientas Utilizadas:** Gemini 3 Flash (Paid Tier).
* **Prompts Reales Empleados:** * *"Ayúdame a estructurar la lógica de negocio en Java de un despertador inteligente con encapsulación estricta sin interfaz gráfica."*
    * *"¿Cómo soluciono el error en rojo fatales de Git sobre pathspec y dubious ownership en Windows disco D?"*
* **Código Generado e Intervención Humana:** La IA generó las plantillas core de las clases `Alarm` y `MathChallenge`. El control de flujos unificados en `Main.java` fue modificado y corregido manualmente para subsanar un error de compilación por la inserción accidental del tipo inexistente `Automation`, sustituyéndolo con éxito por la clase adecuada `Alarm`.
* **Validación de Código:** El software se validó mediante ejecución directa en la terminal de VS Code, comprobando el comportamiento frente a respuestas erróneas (`99`) y correctas del reto aritmético, y verificando el aislamiento del Modo Vacaciones.

---

## 3. Tabla de Autoevaluación del Proyecto
Siguiendo los criterios de evaluación exactos descritos en la rúbrica del docente, se realiza el siguiente análisis de rendimiento:

| Criterio | Peso | Nota Estimada | Justificación |
| :--- | :--- | :--- | :--- |
| **Diseño Orientado a Objetos** | 25% | **10 / 10** | Clases totalmente desacopladas, encapsulación estricta con atributos privados y relaciones UML correctas (Composición/Agregación). |
| **Calidad del Código** | 20% | **10 / 10** | Código modularizado en el paquete `model`, libre de duplicidad, nombres autodescriptivos en camello (*camelCase*) y comentarios con valor semántico. |
| **Uso de Git / GitHub** | 15% | **10 / 10** | Historial de commits frecuente y descriptivo siguiendo el estándar profesional (*Conventional Commits*: `feat:`, `docs:`, `fix:`). Trabajo limpio por ramas. |
| **Diagramas UML** | 15% | **10 / 10** | Diagramas de Clases y Casos de Uso generados formalmente en lenguaje Mermaid dentro de la documentación, razonados y justificados técnicamente. |
| **Especificación de Casos de Uso** | 10% | **10 / 10** | Plantilla obligatoria rellenada al detalle para el caso de uso crítico del reto aritmético con precondiciones, flujos alternativos y reglas de negocio. |
| **Documentación README** | 10% | **10 / 10** | Documentación clara del proyecto, instalación, objetivos y capturas adjuntas de simulaciones con éxito a cero errores. |
| **Reflexión sobre IA** | 5% | **10 / 10** | Explicitación transparente de herramientas, prompts reales utilizados, errores corregidos y reflexiones críticas sobre su validación. |
| **NOTA FINAL ESTIMADA** | **100%** | **10.0 / 10** | **Proyecto Completo Sobresaliente.** |