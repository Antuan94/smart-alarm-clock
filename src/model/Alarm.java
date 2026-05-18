package model;

import java.time.LocalTime;

public class Alarm {
    private String id;
    private LocalTime time; // Guarda hora y minuto de forma eficiente
    private String label;
    private boolean active;
    private SoundProfile soundProfile; // Una alarma TIENE un sonido asignado

    public Alarm(String id, LocalTime time, String label, SoundProfile soundProfile) {
        if (time == null) {
            throw new IllegalArgumentException("La hora de la alarma no puede ser nula");
        }
        this.id = id;
        this.time = time;
        this.label = label;
        this.soundProfile = soundProfile;
        this.active = true; // Nace encendida por defecto
    }

    // Getters y Setters seguros para encapsular los datos
    public String getId() { return id; }
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public SoundProfile getSoundProfile() { return soundProfile; }
    public void setSoundProfile(SoundProfile soundProfile) { this.soundProfile = soundProfile; }
}
