package Misc;

import Characters.*;
import Combat.Combate;
import GameMap.*;
import Misc.GameTest;

public class Main {
    public static void main(String[] args) {
        // Coquetería pura, ojalá que cuando lo pruebe no se cague encima

        Personaje p1 = new Coquette("Isa", 100, 10, 10, 10, 10, 10, 90);
        Personaje p2 = new Cazador("Alejandrito", 100, 10, 10, 10, 10, 10, "felino", "Isabelita");

        Combate.combatir(p1, p2);
    }
}