package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AlarmManager {
    // Atributos privados
    private List<Alarm> alarms;
    private boolean vacationModeActive = false; // Control de modo vacaciones
    private SleepStatistics statistics = new SleepStatistics(); // Control de estadísticas

    // Constructor
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

    // Método clave: Compara la hora simulada aplicando la regla del Modo Vacaciones
    public List<Alarm> checkAlarms(LocalTime currentTime) {
        List<Alarm> triggeredAlarms = new ArrayList<>();
        
        // Si las vacaciones están activas, devolvemos la lista vacía inmediatamente (silencio total)
        if (this.vacationModeActive) {
            return triggeredAlarms;
        }

        for (Alarm alarm : alarms) {
            if (alarm.isActive() && alarm.getTime().equals(currentTime)) {
                triggeredAlarms.add(alarm);
            }
        }
        return triggeredAlarms;
    }

    // Getters para las funciones avanzadas
    public boolean isVacationModeActive() {
        return vacationModeActive;
    }

    public void setVacationMode(boolean active) {
        this.vacationModeActive = active;
    }

    public SleepStatistics getStatistics() {
        return this.statistics;
    }

    public List<Alarm> getAllAlarms() {
        return this.alarms;
    }
}