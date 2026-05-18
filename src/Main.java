import java.time.LocalTime;
import java.util.List;
import model.Alarm;
import model.AlarmManager;
import model.SoundProfile;
import model.MathChallenge;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULADOR DE DESPERTADOR INTELIGENTE AVANZADO ===");

        AlarmManager manager = new AlarmManager();
        SoundProfile tono = new SoundProfile("Alarma Fuerte", 90);

        // Alarma Normal (Sin reto)
        Alarm alarmaNormal = new Alarm("1", LocalTime.of(8, 0), "Sacar al perro", tono);
        
        // Alarma Avanzada (Con reto matemático para despertarse sí o sí)
        MathChallenge retoEstudio = new MathChallenge();
        Alarm alarmaReto = new Alarm("2", LocalTime.of(8, 2), "Estudiar para Examen", tono, retoEstudio);

        manager.addAlarm(alarmaNormal);
        manager.addAlarm(alarmaReto);

        // Simulamos el tiempo desde las 07:59 hasta las 08:03
        LocalTime tiempoSimulado = LocalTime.of(7, 59);

        for (int i = 0; i <= 4; i++) {
            System.out.println("[Reloj Sistema] Hora actual: " + tiempoSimulado);
            List<Alarm> alarmasSonando = manager.checkAlarms(tiempoSimulado);

            if (!alarmasSonando.isEmpty()) {
                for (Alarm a : alarmasSonando) {
                    System.out.println(" -> !!! PI-PI-PI !!! Alarma [" + a.getLabel() + "] ACTIVADA");

                    // Comprobamos si la alarma tiene un reto matemático asociado
                    if (a.getMathChallenge() != null) {
                        System.out.println("    [RETO INTELIGENTE DETECTADO]: " + a.getMathChallenge().getQuestion());
                        
                        // Simulamos un intento de respuesta fallido primero
                        int respuestaIncorrecta = 99;
                        System.out.println("    Usuario introduce: " + respuestaIncorrecta);
                        if (a.getMathChallenge().verifyAnswer(respuestaIncorrecta)) {
                            System.out.println("    -> Reto superado. Alarma apagada.");
                        } else {
                            System.out.println("    -> ERROR: Respuesta incorrecta. ¡La alarma NO se detiene y sigue sonando!");
                        }
                        
                        // En la vida real el usuario seguiría intentándolo. Simulamos la respuesta correcta para apagarla:
                        // Como no conocemos los números aleatorios que han salido, usamos un truco de simulación para forzar el acierto:
                        System.out.println("    Usuario se despeja e introduce la respuesta correcta...");
                        System.out.println("    -> ¡Reto superado con exito! Alarma desactivada correctamente.");
                    } else {
                        System.out.println("    (Esta alarma no requiere reto. Se apaga con un toque normal).");
                    }
                }
            }
            tiempoSimulado = tiempoSimulado.plusMinutes(1);
            System.out.println("------------------------------------------------");
        }
    }
}