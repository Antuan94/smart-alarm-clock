package model;

import java.util.Random;

public class MathChallenge {
    private int operand1;
    private int operand2;
    private int correctAnswer;

    // Constructor: cada vez que se crea un reto, se inventa dos números al azar
    public MathChallenge() {
        Random random = new Random();
        this.operand1 = random.nextInt(10) + 1; // Número aleatorio del 1 al 10
        this.operand2 = random.nextInt(10) + 1; // Número aleatorio del 1 al 10
        this.correctAnswer = this.operand1 + this.operand2;
    }

    // Devuelve el texto que se le mostrará al usuario en pantalla
    public String getQuestion() {
        return "¿Cuanto es " + operand1 + " + " + operand2 + "?";
    }

    // Comprueba si la respuesta introducida por el usuario es la correcta
    public boolean verifyAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}