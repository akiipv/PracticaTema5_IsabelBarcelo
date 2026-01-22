package Combat;

import Characters.Personaje;
import GameMap.*;

import java.util.Random;

public class Combate {

    public static void combatir(Personaje c1, Personaje c2) {

        // Ella jura 💜

        System.out.println("\nEmpieza el combate.. :)");

        int ronda = 0;
        Personaje primero;
        Personaje segundo;

        if (c1.getVel() >= c2.getVel()) {
            primero = c1;
            segundo = c2;
        } else {
            segundo = c2;
            primero = c1;
        }

        while (!primero.estaMuerto() && !segundo.estaMuerto()) {
            ronda++;
            System.out.println("\nRound " + ronda + ".. fight!\n");

            bucleCombate(primero, segundo);

            if (!segundo.estaMuerto()){
                bucleCombate(segundo, primero);
            }
        }
        imprimirGanador(primero, segundo);
    }

    public static void imprimirGanador(Personaje c1, Personaje c2) {

        // He cambiao el texto para que sea más inclusivo jeje

        if (c1.estaMuerto() && c2.estaMuerto()) {
            System.out.println("Empate: ambos jugadores han muerto.");
        } else if (c1.estaMuerto() && !c2.estaMuerto()) {
            System.out.println("El jugador ganador es: " + c2.getNombre() + " \uD83C\uDF89"); // he copiao y pegao el emoji de google por favo no m pegue
        } else System.out.println("El jugador ganador es: " + c1.getNombre() + " \uD83C\uDF89");
    }

    public static void trampita(Personaje player){
        Random r = new Random();
        Area area = new Area();

        if (r.nextInt(0, 100) <= 5) {
            String[] tipos = {"Pinchos", "Brea", "Serpientes"};
            int perjuicio = r.nextInt(5, 21);
            double fracaso = r.nextInt(0, 76);

            Trampa trampa = Area.generarTrampa(tipos[r.nextInt(tipos.length)], perjuicio, fracaso, area);

            perjuicio = trampa.activaTrampa();

            if (perjuicio > 0)
                player.caerTrampa(trampa);
            else {
                switch (trampa.getTipo()) {
                    case "Brea":
                        player.inspirar(trampa.getPerjuicio(), "defensa");
                        break;
                    case "Pinchos":
                        player.beberPocion(trampa.getPerjuicio());
                        break;
                    case "Serpientes":
                        player.inspirar(trampa.getPerjuicio(), "ataque");
                        break;
                }
            }
        }
    }

    /** todo tengo q terminar esto tmb pq me pegan en mi casa */
    public static void bucleCombate(Personaje ataca, Personaje recibe){

        int ataques = 1;
        String tipo = ataca.getTipoAtaque();

        if (ataca.getVel() >= recibe.getVel() * 2){
            ataques++;
        }

        for (int i = 0; i < ataques; i++) {
            ataca.atacar();
            recibe.setPv(recibe.getPv() - recibe.defender(ataca.getAtq(), tipo));
        }

        trampita(ataca);

        System.out.println(ataca.getNombre() + " golpea a " + recibe.getNombre() + " y causa " + recibe.defender(ataca.getAtq(), tipo) + " de daño.. dejándole a: " + recibe.getPv() + " puntos de vida.");

    }
}
