//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
import juego.GestorJuego;
import personajes.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorJuego gestor = new GestorJuego();
        int opcion = 0;

        do {
            System.out.println("\n=== ESFOT RPG ===");
            System.out.println("1. Crear Guerrero");
            System.out.println("2. Crear Mago");
            System.out.println("3. Crear Arquero");
            System.out.println("4. Crear Paladín");
            System.out.println("5. Mostrar todos");
            System.out.println("6. Buscar por nombre");
            System.out.println("7. Atacar");
            System.out.println("8. Usar habilidad especial");
            System.out.println("9. Simular combate");
            System.out.println("10. Mostrar vivos");
            System.out.println("11. Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del teclado

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del Guerrero: ");
                    String n1 = scanner.nextLine();
                    gestor.registrarPersonaje(new Guerrero(n1, 1, 100, 15, 5, 10));
                    break;

                case 2:
                    System.out.print("Nombre del Mago: ");
                    String n2 = scanner.nextLine();
                    gestor.registrarPersonaje(new Mago(n2, 1, 80, 10, 3, 30));
                    break;

                case 3:
                    System.out.print("Nombre del Arquero: ");
                    String n3 = scanner.nextLine();
                    gestor.registrarPersonaje(new Arquero(n3, 1, 90, 12, 4, 5));
                    break;

                case 4:
                    System.out.print("Nombre del Paladín: ");
                    String n4 = scanner.nextLine();
                    gestor.registrarPersonaje(new Paladin(n4, 1, 120, 14, 8, 8, 20));
                    break;

                case 5:
                    gestor.mostrarTodos();
                    break;

                case 6:
                    System.out.print("Ingrese el nombre a buscar: ");
                    Personaje encontrado = gestor.buscarPorNombre(scanner.nextLine());
                    if (encontrado != null) {
                        encontrado.mostrarInformacion();
                    } else {
                        System.out.println("No se encontró al personaje.");
                    }
                    break;

                case 7:
                    System.out.print("Nombre del atacante: ");
                    Personaje pA = gestor.buscarPorNombre(scanner.nextLine());
                    System.out.print("Nombre del enemigo: ");
                    Personaje pB = gestor.buscarPorNombre(scanner.nextLine());
                    if (pA != null && pB != null) {
                        pA.atacar(pB);
                    } else {
                        System.out.println("Error: Uno de los personajes no existe.");
                    }
                    break;

                case 8:
                    System.out.print("Nombre del personaje: ");
                    Personaje p = gestor.buscarPorNombre(scanner.nextLine());
                    if (p == null) {
                        System.out.println("Personaje no encontrado.");
                        break;
                    }

                    // Uso sencillo de instanceof y casting seguro
                    if (p instanceof Mago) {
                        System.out.print("Enemigo objetivo: ");
                        Personaje enemigo = gestor.buscarPorNombre(scanner.nextLine());
                        if (enemigo != null) ((Mago) p).lanzarHechizo(enemigo);
                    } else if (p instanceof Arquero) {
                        System.out.print("Enemigo objetivo: ");
                        Personaje enemigo = gestor.buscarPorNombre(scanner.nextLine());
                        if (enemigo != null) ((Arquero) p).dispararFlecha(enemigo);
                    } else if (p instanceof Paladin) {
                        System.out.println("1. Curar  2. Activar Escudo");
                        int sub = scanner.nextInt();
                        scanner.nextLine();
                        if (sub == 1) {
                            System.out.print("A quién desea curar: ");
                            Personaje aliado = gestor.buscarPorNombre(scanner.nextLine());
                            if (aliado != null) ((Paladin) p).curar(aliado);
                        } else {
                            ((Paladin) p).activarEscudo();
                        }
                    } else {
                        System.out.println("El Guerrero no tiene habilidades especiales activas.");
                    }
                    break;

                case 9:
                    System.out.print("Primer combatiente: ");
                    Personaje c1 = gestor.buscarPorNombre(scanner.nextLine());
                    System.out.print("Segundo combatiente: ");
                    Personaje c2 = gestor.buscarPorNombre(scanner.nextLine());
                    if (c1 != null && c2 != null) {
                        gestor.simularCombate(c1, c2);
                    } else {
                        System.out.println("Error: Uno o ambos combatientes no existen.");
                    }
                    break;

                case 10:
                    gestor.mostrarVivos();
                    break;

                case 11:
                    System.out.println("Gracias vuelva pronto.....");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 11);

        scanner.close();
    }
}