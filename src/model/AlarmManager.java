package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AlarmManager {
    // Atributo privado: una lista dinámica que guardará todas las alarmas creadas
    private List<Alarm> alarms;

    // Constructor: Inicializa la lista vacía al crear el administrador
    public AlarmManager() {
        this.alarms = new ArrayList<>();
    }

    // REQUISITO OBLIGATORIO: Crear/Añadir alarma
    public void addAlarm(Alarm alarm) {
        if (alarm == null) throw new IllegalArgumentException("No se puede añadir una alarma nula");
        this.alarms.add(alarm);
    }

    // REQUISITO OBLIGATORIO: Eliminar alarma mediante su ID
    public boolean removeAlarm(String id) {
        // Busca en la lista y si encuentra el ID, la borra
        return this.alarms.removeIf(alarm -> alarm.getId().equals(id));
    }

    // REQUISITO OBLIGATORIO: Consultar próximas alarmas activas
    public List<Alarm> getActiveAlarms() {
        List<Alarm> activeList = new ArrayList<>();
        for (Alarm alarm : alarms) {
            if (alarm.isActive()) {
                activeList.add(alarm);
            }
        }
        return activeList;
    }

    // Método clave: Compara una hora dada (simulada) con las alarmas para saber cuál debe sonar
    public List<Alarm> checkAlarms(LocalTime currentTime) {
        List<Alarm> triggeredAlarms = new ArrayList<>();
        for (Alarm alarm : alarms) {
            // Si la alarma está encendida y coincide exactamente con la hora actual
            if (alarm.isActive() && alarm.getTime().equals(currentTime)) {
                triggeredAlarms.add(alarm);
            }
        }
        return triggeredAlarms;
    }

    // Getter para obtener todas las alarmas (útil para pruebas)
    public List<Alarm> getAllAlarms() {
        return this.alarms;
    }
}