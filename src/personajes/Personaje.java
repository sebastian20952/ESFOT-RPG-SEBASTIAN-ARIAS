package personajes;

import java.security.KeyStore;
public class Personaje {
    protected String nombre;
    protected int nivel;
    protected int vida;
    protected int vidaMaxima;
    protected int ataque;
    protected int defensa;

    // Constructor con parámetros
    public Personaje(String nombre, int nivel, int vidaMaxima, int ataque, int defensa) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima; // Inicia con la vida al máximo
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public void recibirDanio(int cantidad) {
        int danioReal = Math.max(1, cantidad - this.defensa);
        this.vida = Math.max(0, this.vida - danioReal);
        System.out.println(this.nombre + " recibe " + danioReal + " de daño. Vida restante: " + this.vida);
    }

    // Ataque normal (Sobrecarga parte 1)
    public void atacar(Personaje enemigo) {
        System.out.println(this.nombre + " ataca a " + enemigo.nombre);
        enemigo.recibirDanio(this.ataque);
    }

    // Ataque con bonificación (Sobrecarga parte 2)
    public void atacar(Personaje enemigo, int bonificacion) {
        System.out.println(this.nombre + " ataca con bonificación a " + enemigo.nombre);
        int potenciaTotal = this.ataque + bonificacion;
        enemigo.recibirDanio(potenciaTotal);
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " | Nivel: " + nivel + " | Vida: " + vida + "/" + vidaMaxima + " | Ataque: " + ataque + " | Defensa: " + defensa);
    }

    // Getters necesarios
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
}