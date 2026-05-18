# Plan de Pruebas de Software - Despertador Inteligente

Debido a que la práctica se centra exclusivamente en la validación de la lógica de negocio mediante simulación por consola (ejecutada con éxito en `Main.java`), se establece este documento como la planificación de caja negra para futuras fases de pruebas unitarias automatizadas.

## 🧪 Escenarios de Prueba Planificados

### 1. Gestión de Alarmas (`AlarmManager`)
* **Test ID 01 - Adición Correcta:** Validar que al añadir una alarma válida, el tamaño de `getActiveAlarms()` incrementa en 1.
* **Test ID 02 - Control de Nulos:** Verificar que el método `addAlarm(null)` lanza correctamente la excepción esperada `IllegalArgumentException`.

### 2. Regla de Negocio: Modo Vacaciones
* **Test ID 03 - Silencio en Vacaciones:** Configurar `setVacationMode(true)` y comprobar que al evaluar la hora exacta de una alarma con `checkAlarms()`, la lista devuelta permanece estrictamente vacía `isEmpty()`.

### 3. Módulo de Retos (`MathChallenge`)
* **Test ID 04 - Verificación Aritmética:** Forzar una instancia del reto, extraer la pregunta y comprobar que el método `verifyAnswer()` devuelve `true` únicamente con el valor esperado y `false` ante cualquier otra respuesta (como el intento erróneo `99`).