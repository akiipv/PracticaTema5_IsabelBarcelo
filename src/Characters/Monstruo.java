package Characters;

import java.util.Random;

public class Monstruo extends Personaje {

    private String raza;

    public Monstruo() {
        super();
        setRaza("");
    }

    public Monstruo(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, String tipo) {
        super(nombre, pv, atq, arm, nivel, vel, res);
        setRaza(tipo);
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        if (raza.equalsIgnoreCase("bestia") ||
                raza.equalsIgnoreCase("no-muerto") ||
                raza.equalsIgnoreCase("gigante"))
            this.raza = raza;
        else this.raza = "";
    }

    @Override
    public void subirNivel() {

        switch (raza.toLowerCase()) {
            case "bestia":
                statsMonstruo(50, 80, 15, 15, 80);
                break;
            case "no-muerto":
                statsMonstruo(30, 50, 30, 70, 5);
                break;
            case "gigante":
                statsMonstruo(100, 50, 50, 10, 10);
                break;
            default:
                System.err.println("ok mañana");
        }

        setNivel(getNivel() + 1);
        System.out.println(getNombre() + ", ¡ha subido de nivel!\n\t" + toString());
    }

    public void statsMonstruo(int pctPV, int pctATQ, int pctARM, int pctRES, int pctVEL) {
        if (prob(pctPV))
            setPv(getPv() + cantidad("pv"));

        if (prob(pctATQ))
            setAtq(getAtq() + cantidad("atq"));

        if (prob(pctARM))
            setArm(getArm() + cantidad("arm"));

        if (prob(pctRES))
            setRes(getRes() + cantidad("res"));

        if (prob(pctVEL))
            setVel(getVel() + cantidad("vel"));
    }

    public int cantidad(String stat) {
        int cantidad = 1;
        Random r = new Random();

        switch (raza.toLowerCase()) {
            case "bestia":
                if (stat.equalsIgnoreCase("atq") || stat.equalsIgnoreCase("vel"))
                    cantidad = 2;
                break;
            case "no-muerto":
                if (stat.equalsIgnoreCase("res"))
                    cantidad = 4;
                break;
            case "gigante":
                if (stat.equalsIgnoreCase("pv"))
                    cantidad = r.nextInt(2, 4);
                break;
        }

        return cantidad;
    }

    @Override
    public String toString() {
        String resultado = "Cargando datos del monstruo.. ૮ ․ ․ ྀིა " +
                "\n\t· Nombre: " + getNombre() +
                "\n\t· Vida: " + getPv() +
                "\n\t· Ataque: " + getAtq() +
                "\n\t· Armadura: " + getArm() +
                "\n\t· Raza: " + getRaza() +
                "\n\t· Nivel: " + getNivel();
        return coquetudo() + "\n\n" + resultado;
    }
}
