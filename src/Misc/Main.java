package Misc;

import Characters.*;
import Combat.Combate;
import GameMap.*;
import Misc.GameTest;

public class Main {
    public static void main(String[] args) {
        // Que luego dices que no pruebo lo que hago, hater 🥀

        Personaje Isa = new Clérigo("Isa", 3, 1, 31, 3, 2, 3, 6) {
        };
        Personaje Alejandro = new Ladrón("Alejandro", 2, 3, 4, 3, 2, 1);

        Isa.realizarTurno(Alejandro);
        Alejandro.realizarTurno(Isa);
    }
}