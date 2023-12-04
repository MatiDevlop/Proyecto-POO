/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Steven Morocho
 */
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;
    public Juego(){
        this.jugadores=new ArrayList<>();
        this.lineaJuego=new ArrayList<>();
    }
    public ArrayList<Ficha> getLineaJuego() {
        return this.lineaJuego;
    }
    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }    
    public void agregarJugador(String nombre){
        Jugador j=new Jugador(nombre,Utilitaria.crearManoJugador());
        this.jugadores.add(j);
    }
    public int obtenerValorInicioLinea(){
        return this.lineaJuego.get(0).getLado1();
    }
    public int obtenerValorFinLinea(){
        return this.lineaJuego.get(this.lineaJuego.size()-1).getLado2();
    }
    public void mostrarLinea(){
        for(Ficha f:this.lineaJuego){
            System.out.println(f+"-");
        }
    }
    public boolean agregarFichaLinea(Ficha f,Jugador j){
        if(!(f instanceof FichaComodin)){
            if(this.lineaJuego.size()==0){
                this.lineaJuego.add(f);
            }
            else{
                if(f.getLado2()==this.obtenerValorInicioLinea()){
                    this.lineaJuego.add(f.getLado2(), f);
                    j.removerFicha(f);
                    return true;
                }
                else if(f.getLado1()==this.obtenerValorFinLinea()){
                    this.lineaJuego.add(f.getLado1(), f);
                    j.removerFicha(f);
                    return true;
                }
                else
                    return false;              
            }
        }
        else{
            if(this.lineaJuego.size()==0){
                this.lineaJuego.add(f);
                Scanner sc=new Scanner(System.in);
                System.out.println("Ingrese el valor del lado 1: ");
                int lado1=sc.nextInt();
                System.out.println("Ingrese el valor del lado 2: ");
                int lado2=sc.nextInt();
                FichaComodin fm = (FichaComodin)f;
                fm.setLado1(lado1);
                fm.setLado2(lado2);
            }
            else{
                FichaComodin fm = (FichaComodin)f;
                Scanner sc=new Scanner(System.in);
                System.out.println("Ingrese la posición donde quiere agregar la ficha (Inicio ó Fin): ");
                String posicion=sc.next();
                if(posicion.equals("Inicio")){
                    this.lineaJuego.add(0, f);
                    System.out.println("Ingrese el valor del lado 1: ");
                    int lado1=sc.nextInt();
                    fm.setLado1(lado1);
                }
                else if(posicion.equals("Fin")){
                    this.lineaJuego.add(this.lineaJuego.size()-1, f);
                    System.out.println("Ingrese el valor del lado 2: ");
                    int lado2=sc.nextInt();
                    fm.setLado2(lado2);
                }
            }
        }
        return true;
    }
}
