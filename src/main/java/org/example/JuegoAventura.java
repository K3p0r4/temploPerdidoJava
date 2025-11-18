package org.example;

import java.util.Scanner;

public class JuegoAventura {
    static Scanner sc = new Scanner(System.in);

    static Direccion menu () {
        System.out.println(
                "\n¿Que quieres hacer?" +
                        "1. Ir al NORTE \n" +
                        "2. Ir al SUR \n" +
                        "3. Ir al ESTE\n" +
                        "4. Ir al OESTE\n" +
                        "5. MIRAR alrededor\n" +
                        "6. SALIR\n" +
                        "Elige una opcion (1-6): ");

            int opcion = sc.nextInt();
        switch (opcion) {
            case 1: return Direccion.NORTE;
            case 2: return Direccion.SUR;
            case 3: return Direccion.ESTE;
            case 4: return Direccion.OESTE;
            case 5: return Direccion.MIRAR;
            case 6: return Direccion.SALIR;
            default:
                System.out.println("Esa no es una opcion valida. Te quedas quieto.");
                return Direccion.MIRAR;
        }


    }

    public static void mostrarEstadoJugador(Jugador jugador, String[][] mapa) {
        int x = jugador.getX();
        int y = jugador.getY();
        System.out.println("Estas en: " + mapa[y][x]);
    }

    static void main() {



        String[][] mapa = {
                {"Entrada del templo", "Pasillo Humedo", "Sala de pilares"  },
                { "Pasillo Oscuro", "Encrucijada", "Sala de la Estatua" },
                { "Almacen de Antorchas", "Puente Estrecho", "Camara del Tesoro" } } ;


        menu();


    }

}
