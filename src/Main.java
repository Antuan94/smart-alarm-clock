import java.time.LocalTime;
import java.util.List;
import model.Alarm;
import model.AlarmManager;
import model.SoundProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULADOR DE DESPERTADOR INTELIGENTE ===");

        // 1. Creamos el cerebro del despertador
        AlarmManager manager = new AlarmManager();

        // 2. Creamos un perfil de sonido
        SoundProfile despertadorSuave = new SoundProfile("Sonido Naturaleza", 80);

        // 3. Creamos un par de alarmas de prueba
        // Alarma 1: Para ir a clase a las 07:30
        Alarm alarmaClase = new Alarm("1", LocalTime.of(7, 30), "Ir a la UCAM", despertadorSuave);
        // Alarma 2: Para el gimnasio a las 07:32
        Alarm alarmaGym = new Alarm("2", LocalTime.of(7, 32), "Entrenamiento", despertadorSuave);

        // 4. Añadimos las alarmas al administrador
        manager.addAlarm(alarmaClase);
        manager.addAlarm(alarmaGym);

        System.out.println("Alarmas configuradas con exito.");
        System.out.println("Numero de alarmas activas: " + manager.getActiveAlarms().size());
        System.out.println("------------------------------------------------");

        // 5. SIMULACIÓN DEL TIEMPO: Vamos a simular que el reloj avanza minuto a minuto
        // Empezamos a las 07:29 y avanzamos hasta las 07:33
        LocalTime tiempoSimulado = LocalTime.of(7, 29);

        for (int i = 0; i <= 4; i++) {
            System.out.println("[Reloj Sistema] Hora actual: " + tiempoSimulado);

            // El administrador comprueba si alguna alarma debe sonar a esta hora exacta
            List<Alarm> alarmasSonando = manager.checkAlarms(tiempoSimulado);

            if (!alarmasSonando.isEmpty()) {
                for (Alarm a : alarmasSonando) {
                    System.out.println(" -> !!! PI-PI-PI !!! Alarma [" + a.getLabel() 
                        + "] sonando con tono '" + a.getSoundProfile().getToneName() 
                        + "' al volumen " + a.getSoundProfile().getVolume() + "%!");
                }
            }

            // Avanzamos el reloj un minuto para la siguiente iteración
            tiempoSimulado = tiempoSimulado.plusMinutes(1);
            System.out.println("------------------------------------------------");
        }
    }
}