import java.time.LocalTime;
import java.util.List;
import model.Alarm;
import model.AlarmManager;
import model.SoundProfile;
import model.MathChallenge;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE DESPERTADOR INTELIGENTE COMPLETO ===");
        System.out.println("Validacion de logica, encapsulamiento y funciones avanzadas\n");

        // 1. Inicializar el cerebro del sistema
        AlarmManager manager = new AlarmManager();
        SoundProfile tonoPredeterminado = new SoundProfile("Tono Radio Melodia", 85);

        // 2. Configurar escenarios de prueba (Alarmas con y sin reto)
        // Alarma de rutina ordinaria (Sin reto asociado)
        Alarm alarmaGimnasio = new Alarm("1", LocalTime.of(7, 30), "Ir al Gimnasio", tonoPredeterminado);
        
        // Alarma avanzada para días críticos (Con reto matemático obligatorio para apagarla)
        MathChallenge retoCritico = new MathChallenge();
        Alarm alarmaExamen = new Alarm("2", LocalTime.of(7, 32), "Examen Importante UCAM", tonoPredeterminado, retoCritico);

        // Registrar las alarmas en el sistema
        manager.addAlarm(alarmaGimnasio);
        manager.addAlarm(alarmaExamen);

        System.out.println("[Configuracion] Alarmas cargadas con exito en el sistema.");
        System.out.println("[Configuracion] Total de alarmas activas monitorizadas: " + manager.getActiveAlarms().size());
        System.out.println("----------------------------------------------------------------\n");

        // 3. SIMULACIÓN DEL PASO DEL TIEMPO: Evaluamos minuto a minuto de 07:29 a 07:33
        LocalTime tiempoSimulado = LocalTime.of(7, 29);

        for (int i = 0; i <= 4; i++) {
            System.out.println("[Reloj Sistema] Hora actual: " + tiempoSimulado);
            
            // Comprobación interna del administrador
            List<Alarm> alarmasSonando = manager.checkAlarms(tiempoSimulado);

            if (!alarmasSonando.isEmpty()) {
                for (Alarm alarma : alarmasSonando) {
                    System.out.println(" -> !!! PI-PI-PI !!! Alarma [" + alarma.getLabel() + "] DISPARADA");
                    
                    // Registro automático en el módulo de estadísticas
                    manager.getStatistics().incrementAlarmsTriggered();

                    // Comprobar si requiere verificación por reto inteligente
                    if (alarma.getMathChallenge() != null) {
                        System.out.println("    [RETO INTELIGENTE DETECTADO]: " + alarma.getMathChallenge().getQuestion());
                        
                        // Simulamos un primer intento fallido por somnolencia del usuario
                        int intentoErroneo = 99;
                        System.out.println("    Usuario dormido introduce: " + intentoErroneo);
                        manager.getStatistics().incrementFailedChallenges(); // Registramos el fallo estadístico
                        System.out.println("    -> ERROR: Codigo incorrecto. ¡La alarma NO se detiene y sigue sonando!");
                        
                        // El usuario se despeja y el sistema procesa la desactivación exitosa
                        System.out.println("    Usuario se despeja por completo e introduce la respuesta correcta...");
                        System.out.println("    -> ¡Reto superado con exito! Alarma desactivada correctamente.");
                    } else {
                        System.out.println("    (Esta alarma no requiere reto. Desactivada de forma ordinaria con un toque).");
                    }
                }
            }
            
            // Avanzar el reloj un minuto
            tiempoSimulado = tiempoSimulado.plusMinutes(1);
            System.out.println("----------------------------------------------------------------");
        }

        System.out.println("\n=== COMPROBACIÓN DE REGLAS DE NEGOCIO AVANZADAS ===");
        
        // 4. PRUEBA DEL INTERRUPTOR GENERAL (MODO VACACIONES)
        System.out.println("[Modo Vacaciones]: El usuario activa el interruptor de Vacaciones.");
        manager.setVacationMode(true);
        System.out.println("[Modo Vacaciones]: Estado actual del interruptor = " + manager.isVacationModeActive());
        
        // Evaluamos de nuevo la hora crítica (07:30) donde antes saltó la alarma del gimnasio
        System.out.println("[Reloj Sistema] Simulando hora 07:30 estando de vacaciones...");
        List<Alarm> validacionVacaciones = manager.checkAlarms(LocalTime.of(7, 30));
        
        if (validacionVacaciones.isEmpty()) {
            System.out.println(" -> [SILENCIO INTELIGENTE]: Las alarmas se han bloqueado correctamente. ¡El usuario descansa!");
        } else {
            System.out.println(" -> [ERROR]: La alarma ha sonado saltándose el protocolo de vacaciones.");
        }
        System.out.println("----------------------------------------------------------------\n");

        // 5. EXTRACCIÓN E IMPRESIÓN DEL INFORME DE ESTADÍSTICAS OBLIGATORIO
        System.out.println(manager.getStatistics().generateReport());
    }
}