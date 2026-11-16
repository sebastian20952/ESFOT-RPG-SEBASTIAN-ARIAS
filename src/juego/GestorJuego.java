package juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import personajes.Personaje;

public class GestorJuego {
    private List<Personaje> personajes = new ArrayList<>();
    private Map<String, Personaje> registro = new HashMap<>();

    public void registrarPersonaje(Personaje p) {
        if (registro.containsKey(p.getNombre())) {
            System.out.println("Ya existe un personaje con ese nombre.");
            return;
        }
        personajes.add(p);
        registro.put(p.getNombre(), p);
        System.out.println("¡Personaje registrado con éxito!");
    }

    public Personaje buscarPorNombre(String nombre) {
        return registro.get(nombre);
    }

    public void mostrarTodos() {
        for (Personaje p : personajes) {
            p.mostrarInformacion();
            System.out.println("-------------------");
        }
    }

    public void mostrarVivos() {
        for (Personaje p : personajes) {
            if (p.estaVivo()) {
                p.mostrarInformacion();
                System.out.println("-------------------");
            }
        }
    }

    public void simularCombate(Personaje p1, Personaje p2) {
        if (!p1.estaVivo() || !p2.estaVivo()) {
            System.out.println("No se puede combatir con personajes derrotados.");
            return;
        }

        System.out.println("\n--- ¡INICIA EL COMBATE! ---");
        int turno = 1;
        while (p1.estaVivo() && p2.estaVivo()) {
            if (turno % 2 != 0) {
                p1.atacar(p2);
            } else {
                p2.atacar(p1);
            }
            turno++;
        }

        Personaje ganador = p1.estaVivo() ? p1 : p2;
        System.out.println("GANADOR: " + ganador.getNombre() + "\n");
    }
}