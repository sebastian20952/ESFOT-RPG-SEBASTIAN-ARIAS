package personajes;

public class Arquero extends Personaje {
    private int flechas;

    public Arquero(String nombre, int nivel, int vidaMaxima, int ataque, int defensa, int flechas) {
        super(nombre, nivel, vidaMaxima, ataque, defensa);
        this.flechas = flechas;
    }

    public void dispararFlecha(Personaje enemigo) {
        if (this.flechas > 0) {
            this.flechas--;
            System.out.println(this.nombre + " dispara una flecha. Flechas restantes: " + this.flechas);
            enemigo.recibirDanio(this.ataque + 5);
        } else {
            System.out.println(this.nombre + " no tiene flechas.");
        }
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("   -> Flechas: " + flechas);
    }
}