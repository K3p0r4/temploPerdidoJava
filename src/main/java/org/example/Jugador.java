package org.example;

public class Jugador {

    //variables
    private int x ;
    private int y ;
    private  boolean tieneLlave;

    //Constructor
    Jugador (int x, int y){
        this.x = x;
        this.y = y;
        this.tieneLlave = false;
    }

    //Metodos
    public void moverNorte() {
        this.y--;
    }
    public void moverSur() {
        this.y++;
    }
    public void moverEste() {
        this.x++;
    }
    public void moverOeste() {
        this.x--;
    }

    //SETTERS AND GETTERS
    public int getX (){
        return  this.x;
    }
    public int getY (){
        return  this.y;
    }

    public boolean tieneLlave() {
        return this.tieneLlave;
    }


    void recogerLlave(){
        tieneLlave = true;
        System.out.println("¡Has recogido la llave!");
    }

    void tieneLaLlave(){
        if(tieneLlave){
            System.out.println("El jugador tiene la llave.");
        } else {
            System.out.println("El jugador no tiene la llave.");
        }
    }

}
