package co.edu.uniquindio.ahorcado.Model;

import java.util.LinkedList;

public class Game {
    private String word;
    private int attempts;
    private final LinkedList<String> wordsAvailable;

    //Constructor
    public Game() {
        this.wordsAvailable = getWordsAvailable();
        this.word = wordsAvailable.get((int) (Math.random() * (wordsAvailable.size() - 1) + 1));
    }

    //Agregar letra
    public boolean addLetter(char letter) {
        boolean result = false;

        if(word.contains(String.valueOf(letter))) {
            result = true;
        } else {
            setAttempts();
        }

        return result;
    }

    //Reiniciar partida
    public void restartGame() {
        attempts = 0;
        setWord();
    }

    //Getters
    public LinkedList<String> getWordsAvailable() {
        LinkedList<String> palabras = new LinkedList<>();

        palabras.add("DESAGUE"); palabras.add("GATITO"); palabras.add("RODILLA"); palabras.add("COMUNIDAD");
        palabras.add("JUVENTUD"); palabras.add("GRABACION"); palabras.add("SOMBRERO"); palabras.add("RECOMENDACION");
        palabras.add("COMPORTAMIENTO"); palabras.add("PASTEL"); palabras.add("ENERGIA"); palabras.add("ARREPENTIMIENTO");
        palabras.add("BURRO"); palabras.add("TRASNPORTE"); palabras.add("TIA"); palabras.add("TRADICION");
        palabras.add("PIERNA"); palabras.add("REPUBLICA"); palabras.add("PALA"); palabras.add("BEBE");
        palabras.add("ASISTENCIA"); palabras.add("UNIDAD"); palabras.add("YUGO"); palabras.add("COMUNICACION");
        palabras.add("NERVIO"); palabras.add("LIBRO"); palabras.add("BASE"); palabras.add("CONDUCTOR");
        palabras.add("SIGNO"); palabras.add("EXPANSION"); palabras.add("OPORTUNIDAD"); palabras.add("CIERVO");
        palabras.add("MENU"); palabras.add("FERROCARRIL"); palabras.add("POLLO"); palabras.add("DISEÑO");
        palabras.add("DESEMPEÑO"); palabras.add("INICIO");

        return palabras;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getWord() {
        return word;
    }

    //Setters
    public void setWord() {
        String newWord = wordsAvailable.get((int) (Math.random() * (wordsAvailable.size() - 1) + 1));
        if(!newWord.equals(word)) {
            this.word = newWord;
        }
    }

    public void setAttempts() {
        if (attempts < 6) {
            attempts = attempts + 1;
        }
    }

}
