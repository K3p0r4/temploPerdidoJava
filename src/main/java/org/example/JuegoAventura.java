package org.example;

import java.util.Scanner;


public class JuegoAventura {
    static Scanner sc = new Scanner(System.in);
    static boolean salir = false;
     static  Jugador player1 = new Jugador(0,0);



    static Direccion menu () {
        System.out.println(
                "\n¿Que quieres hacer?\n" +
                        "1. Ir al NORTE \n" +
                        "2. Ir al SUR \n" +
                        "3. Ir al ESTE\n" +
                        "4. Ir al OESTE\n" +
                        "5. MIRAR alrededor\n" +
                        "6. SALIR\n" +
                        "Elige una opcion (1-6): ");

            int opcion = sc.nextInt();
         switch (opcion) {
            case 1:{
                if(player1.getY() > 0){
                    System.out.println("Te has movido al NORTE");
                    player1.moverNorte();
                    return Direccion.MIRAR;
                }
                System.out.println("No te puedes mover al NORTE, hay un muro.");
                 return Direccion.MIRAR;

            }
            case 2: {
                    if(player1.getY() < TAMANO_MAPA - 1){
                        if(mapa[player1.getX()][player1.getY()] == mapa[2][1] && player1.tieneLlave()){
                            player1.moverSur();
                            System.out.println("Has entrado en la camara del tesoro.");
                        }else if (mapa[player1.getX()][player1.getY()] == mapa[2][1] && !player1.tieneLlave()){
                            System.out.println("No puedes pasar, necesitas una llave para abrir la puerta.");
                            return Direccion.MIRAR;
                        }else {
                            System.out.println("te has movido al SUR");
                            player1.moverSur();
                            return Direccion.SUR;
                        }
                    }else {
                        System.out.println("No te puedes mover al SUR, hay un muro.");
                        return Direccion.MIRAR;
                    }

            }
            case 3: {
                if (player1.getX() < TAMANO_MAPA - 1){
                    System.out.println("te has movido al ESTE");
                    player1.moverEste();
                    return Direccion.ESTE;
                }else {
                    System.out.println("No te puedes mover al ESTE, hay un muro.");
                    return Direccion.MIRAR;
                }

            }
            case 4: {
                if (player1.getX() <= 0){
                    System.out.println("No te puedes mover al OESTE, hay un muro.");
                    return Direccion.MIRAR;
                }else {
                    System.out.println("te has movido al OESTE");
                    player1.moverOeste();
                    return Direccion.OESTE;
                }

            }
            case 5: {
                System.out.println("MIRANDO alrededor...");
                return Direccion.MIRAR;
            }
            case 6: {
                System.out.println("SALIENDO del juego...");
                salir = true;
                return Direccion.SALIR;
            }
            default:
                System.out.println("Esa no es una opcion valida. Te quedas quieto.");
                return Direccion.MIRAR;
        }

    }

    private static void mostrarEstadoActual() {
        int x = player1.getX();
        int y = player1.getY();
        System.out.println("\n-------------------------------------------");
        System.out.println("Estás en: [" + x + "," + y + "] " + mapa[x][y]);
    }

    /**
     * Array 2D que representa el mapa del juego.
     */

    private static String[][] mapa;
    private static final int TAMANO_MAPA = 3;

    /**
     * Rellena el array 2D del mapa con las descripciones.
     */

    private static void inicializarMapa() {
        mapa = new String[TAMANO_MAPA][TAMANO_MAPA];

        mapa[0][0] = "La imponente ENTRADA del Templo.";
        mapa[0][1] = "Un pasillo oscuro. Apenas puedes ver.";
        mapa[0][2] = "Una sala circular llena de pilares de piedra.";

        mapa[1][0] = "Un pasillo húmedo. Ves algo brillante en el suelo.";
        mapa[1][1] = "Una encrucijada. Hay caminos en todas direcciones.";
        mapa[1][2] = "Un puente estrecho sobre un abismo oscuro.";

        mapa[2][0] = "Un viejo almacén de antorchas.";
        mapa[2][1] = "Una sala con una estatua gigante. Hay una PUERTA al sur.";
        mapa[2][2] = "La CÁMARA DEL TESORO.";
    }

static void main() {

        while (salir == false) {
            System.out.println("\n--- ISLA PERDIDA ---");
            inicializarMapa();
            menu();
            mostrarEstadoActual();
            if( mapa[player1.getX()][player1.getY()] == mapa[1][0] ){
                System.out.println("Encuentras una llave en el suelo.");
                player1.recogerLlave();
            }

            if(mapa[player1.getX()][player1.getY()] == mapa[2][2] ){
                System.out.println("¡Felicidades! Has encontrado el tesoro y completado el juego.");
                salir = true;
            }

        }

    }

}
