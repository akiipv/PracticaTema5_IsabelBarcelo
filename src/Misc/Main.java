package Misc;

import Characters.Guerrero;
import Characters.Ladrón;
import Characters.Mago;
import Characters.Personaje;
import Combat.Combate;
import GameMap.*;
import Misc.GameTest;

public class Main {
    public static void main(String[] args) {
        // Que luego dices que no pruebo lo que hago, hater 🥀

        Personaje Isa = new Mago("Isa", 3, 1, 31, 3, 2, 3, 4);
        Personaje Alejandro = new Ladrón("Alejandro", 2, 3, 4, 3, 2, 1);

        Isa.realizarTurno();
    }
}