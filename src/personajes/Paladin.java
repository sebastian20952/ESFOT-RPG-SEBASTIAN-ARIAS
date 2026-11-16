package personajes;

public class Paladin extends Guerrero {
    private int energiaSagrada;
    private boolean escudoActivo;

    public Paladin(String nombre, int nivel, int vidaMaxima, int ataque, int defensa, int fuerza, int energiaSagrada) {
        super(nombre, nivel, vidaMaxima, ataque, defensa, fuerza);
        this.energiaSagrada = energiaSagrada;
        this.escudoActivo = false;
    }

    public void curar(Personaje objetivo) {
        if (this.energiaSagrada >= 10) {
            this.energiaSagrada -= 10;
            objetivo.setVida(objetivo.getVida() + 20);
            if (objetivo.getVida() > objetivo.vidaMaxima) {
                objetivo.setVida(objetivo.vidaMaxima);
            }
            System.out.println(this.nombre + " cura a " + objetivo.getNombre() + ". Energía restante: " + this.energiaSagrada);
        } else {
            System.out.println(this.nombre + " no tiene energía sagrada suficiente.");
        }
    }

    public void activarEscudo() {
        this.escudoActivo = true;
        System.out.println(this.nombre + " activa su escudo sagrado.");
    }

    // Sobrescribimos recibirDanio para que el escudo reste 5 de daño una sola vez
    @Override
    public void recibirDanio(int cantidad) {
        if (this.escudoActivo) {
            System.out.println("¡El escudo de " + this.nombre + " absorbió 5 de daño!");
            cantidad = cantidad - 5;
            this.escudoActivo = false; // Se desactiva después de usarse
        }
        super.recibirDanio(cantidad);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("   -> Energía Sagrada: " + energiaSagrada + " | Escudo Activo: " + escudoActivo);
    }
}