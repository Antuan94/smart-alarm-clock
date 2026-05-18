package model;

public class SleepStatistics {
    private int totalAlarmsTriggered;
    private int totalFailedChallenges;

    public SleepStatistics() {
        this.totalAlarmsTriggered = 0;
        this.totalFailedChallenges = 0;
    }

    // Método para registrar que ha sonado una alarma
    public void incrementAlarmsTriggered() {
        this.totalAlarmsTriggered++;
    }

    // Método para registrar que el usuario ha fallado un reto despertándose
    public void incrementFailedChallenges() {
        this.totalFailedChallenges++;
    }

    // Getters para consultar los informes
    public int getTotalAlarmsTriggered() {
        return totalAlarmsTriggered;
    }

    public int getTotalFailedChallenges() {
        return totalFailedChallenges;
    }

    // Método para imprimir un resumen estadístico limpio
    public String generateReport() {
        return "=== INFORME DE CALIDAD DEL SUEÑO ===\n" +
               " -> Alarmas totales atendidas: " + totalAlarmsTriggered + "\n" +
               " -> Intentos fallidos en retos (somnolencia): " + totalFailedChallenges + "\n" +
               "====================================";
    }
}