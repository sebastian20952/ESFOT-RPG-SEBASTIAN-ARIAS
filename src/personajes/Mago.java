package personajes;

public class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int vidaMaxima, int ataque, int defensa, int mana) {
        super(nombre, nivel, vidaMaxima, ataque, defensa);
        this.mana = mana;
    }

    public void lanzarHechizo(Personaje enemigo) {
        if (this.mana >= 10) {
            this.mana -= 10;
            System.out.println(this.nombre + " lanza un hechizo. Maná restante: " + this.mana);
            enemigo.recibirDanio(20);
        } else {
            System.out.println(this.nombre + " no tiene suficiente maná.");
        }
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("   -> Maná: " + mana);
    }
}
