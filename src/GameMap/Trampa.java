package GameMap;

import java.util.Random;

public class Trampa {

    private String tipo;
    private int perjuicio;
    private double fracaso;

    public Trampa() {
        tipo = "";
        perjuicio = 0;
        fracaso = 0;
    }

    public Trampa(String categoria) {
        Random random = new Random();

        setTipo(categoria);
        setPerjuicio(random.nextInt(5, 21));
        setFracaso(random.nextInt(0, 76));
    }

    public Trampa(String categoria, int perjuicio) {
        Random random = new Random();

        setTipo(categoria);
        setPerjuicio(perjuicio);
        setFracaso(random.nextInt(0, 76));
    }

    public Trampa(Trampa copia) {
        this.tipo = copia.tipo;
        this.fracaso = copia.fracaso;
        this.perjuicio = copia.perjuicio;
    }

    public void setTipo(String t) {
        if (t.equals("Pinchos") || t.equals("Brea") || t.equals("Serpientes")) {
            tipo = t;
        } else {
            System.err.println("Tipo inválido.");
        }
    }

    public void setPerjuicio(int p) {
        if (p >= 5 && p <= 20) {
            perjuicio = p;
        } else {
            System.err.println("Perjuicio fuera del rango permitido.");
        }
    }

    public void setFracaso(double f) {
        if (f >= 0.0 && f <= 75.0) {
            fracaso = f;
        } else {
            System.err.println("Probabilidad de fracaso no válida.");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public int getPerjuicio() {
        return perjuicio;
    }

    public double getFracaso() {
        return fracaso;
    }

    public int activaTrampa() {
        Random r = new Random();
        if (r.nextInt(0, 101) > fracaso) {
            return perjuicio;
        } else {
            return 0;
        }
    }

    public boolean equals(Trampa otro) {
        boolean comparacion = true;
        if (!this.tipo.equals(otro.tipo) ||
                this.perjuicio != otro.perjuicio ||
                this.fracaso != otro.fracaso)
            comparacion = false;
        return comparacion;
    }

    public String toString() {
        String resultado = "Una trampa se ha activado.. " +
                "\n\t· Tipo de trampa: " + tipo +
                "\n\t· Probabilidad de fracaso: " + fracaso + "%" +
                "\n\t· Perjuicio: " + perjuicio;
        return resultado;
    }
}
