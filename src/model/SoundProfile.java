package model;

public class SoundProfile {
    private String toneName;
    private int volume;

    public SoundProfile(String toneName, int volume) {
        this.toneName = toneName;
        setVolume(volume); // Valida el volumen al crearse
    }

    public String getToneName() { return toneName; }
    public int getVolume() { return volume; }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("El volumen debe estar entre 0 y 100");
        }
        this.volume = volume;
    }
}