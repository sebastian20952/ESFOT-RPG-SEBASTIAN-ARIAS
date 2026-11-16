
package personajes;

public class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int vidaMaxima, int ataque, int defensa, int fuerza) {
        super(nombre, nivel, vidaMaxima, ataque, defensa);
        this.fuerza = fuerza;
    }

    // Sobrescritura para sumar la fuerza al ataque
    @Override
    public void atacar(Personaje enemigo) {
        System.out.println(this.nombre + " (Guerrero) embiste a " + enemigo.getNombre());
        int potenciaTotal = this.ataque + this.fuerza;
        enemigo.recibirDanio(potenciaTotal);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("   -> Fuerza: " + fuerza);
    }
}
