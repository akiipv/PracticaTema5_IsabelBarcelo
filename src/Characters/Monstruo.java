package Characters;

import java.util.Random;

public class Monstruo extends Personaje{

    private String tipo;

    public Monstruo() {
        super();
        setTipo("");
    }

    public Monstruo(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, String tipo) {
        super(nombre, pv, atq, arm, nivel, vel, res);
        setTipo(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.toLowerCase() == "bestia" ||
                tipo.toLowerCase() == "no-muerto" ||
                tipo.toLowerCase() == "gigante")
        this.tipo = tipo;
        else this.tipo = "";
    }

    @Override
    public void subirNivel() {
        if (prob(50))
            setPv(getPv() + 1);


        if (prob(50))
            setAtq(getAtq() + 1);;


        if (prob(50))
            setArm(getArm() + 1);


        if (prob(50))
            setRes(getRes() + 1);


        if (prob(50))
            setVel(getVel() + 1);


        setNivel(getNivel() + 1);
        System.out.println(getNombre() + ", ¡ha subido de nivel!\n\t" + toString());
    }

    /* public void suicidio(int limite, String stat, int subida){
        Random r = new Random();
        if (r.nextInt(0, 101) <= 50) {
            setPv(getPv() + subida);
        }
    } */

}
