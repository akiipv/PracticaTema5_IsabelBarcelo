package GameMap;

import java.util.Random;

public class Area {

    private String nombre;
    private String bioma;
    private int nivel;

    public Area() {
        nombre = "????";
        bioma = "Pradera";
        nivel = 1;
    }

    public Area(String nombre, String bioma) {
        setNombre(nombre);
        setBioma(bioma);
        asignarNivel();
    }

    public Area(Area copia) {
        this.nombre = copia.nombre;
        this.bioma = copia.bioma;
        this.nivel = copia.nivel;
    }

    public void setNombre(String n) {
        if (n.isEmpty() || n.contains(" ")) {
            System.err.println("Error. El nombre no puede dejarse en blanco ni contener espacios.");
        } else {
            nombre = n;
        }
    }

    public void setBioma(String b) {
        if (b.equals("Pradera") || b.equals("Jungla") || b.equals("Desierto") || b.equals("Montaña") || b.equals("Mazmorra")) {
            bioma = b;
        } else {
            System.err.println("Error. Bioma inválido. Respete las mayúsculas.");
        }
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBioma() {
        return bioma;
    }

    public int getNivel() {
        return nivel;
    }

    public void asignarNivel() {
        Random r = new Random();

        switch (bioma) {
            case "Pradera":
                nivel = r.nextInt(1, 11);
                break;

            case "Jungla":
                nivel = r.nextInt(11, 31);
                break;

            case "Desierto":
                nivel = r.nextInt(31, 61);
                break;

            case "Montaña":
                nivel = r.nextInt(61, 91);
                break;

            case "Mazmorra":
                nivel = r.nextInt(91, 106);
                break;
        }
    }

    public int generarPocion() {
        Random r = new Random();
        int pocion = 6767;

        switch (bioma) {
            case "Pradera":
                pocion = 15;
                break;

            case "Jungla":
                pocion = r.nextInt(15, 26);
                break;

            case "Desierto":
                pocion = r.nextInt(1, 31);
                break;

            case "Montaña":
                pocion = 30;
                break;

            case "Mazmorra":
                if (r.nextInt(0, 101) <= 20) {
                    pocion = -10;
                } else {
                    pocion = 20;
                }
                break;
        }
        return pocion;
    }


    public static Trampa generarTrampa(String t, int p, double f, Area area) {

        Trampa trampa;
        trampa = new Trampa();

        trampa.setTipo(t);
        trampa.setPerjuicio(p);
        trampa.setFracaso(f);

        area = new Area();
        String bioma = area.getBioma();

        switch (bioma) {

            case "Pradera", "Montaña":
                break;

            case "Jungla":
                if (t.equals("Serpientes")) {
                    trampa.setFracaso(trampa.getFracaso() - 10);
                }
                break;

            case "Desierto":
                if (t.equals("Brea")) {
                    trampa.setFracaso(trampa.getFracaso() - 15);
                }
                break;

            case "Mazmorra":
                if (t.equals("Pinchos")) {
                    trampa.setPerjuicio(trampa.getPerjuicio() + 5);
                }
                break;
        }
        return trampa;
    }

    public Area clone() {
        Area clon = new Area(this.nombre, this.bioma);
        return clon;
    }

    public String toString() {
        String resultado = "Cargando datos del área.. " +
                "\n\t· Nombre: " + nombre +
                "\n\t· Bioma: " + bioma +
                "\n\t· Nivel: " + nivel;
        return resultado;
    }
}