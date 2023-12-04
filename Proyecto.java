/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyecto;

import java.util.Scanner;

/**
 *
 * @author Steven Morocho
 */
public class Proyecto {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("DOMINÓ");
        System.out.println("Ingrese su nombre:");
        String nombre=sc.next();        
        Juego juego=new Juego();
        juego.agregarJugador(nombre);
        juego.agregarJugador("CPU");
        System.out.println("----------------------------------------------"); 
        for(int i=0;i<juego.getJugadores().size();i++){
            Jugador jugador=juego.getJugadores().get(i);
            System.out.print("Mano de "+jugador.getNombre()+" ->");
            jugador.imprimirMano();
            System.out.println(" ");
            System.out.println("Linea de juego ->");
            juego.mostrarLinea();
            System.out.print("Indice de ficha para jugar (0 es el primero): ");
            int indice=sc.nextInt();
            Ficha ficha=jugador.getFicha(i);
            if(juego.agregarFichaLinea(ficha, jugador)){
                System.out.println("Movimiento Valido");
                System.out.println();
            }
            else{
                System.out.println("Movimiento invalido.Intentalo de nuevo");
                System.out.println();
                i--;
            }
        }   
    }
}
