/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto;

import java.util.ArrayList;

/**
 *
 * @author Steven Morocho
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;
    public Jugador(String nombre, ArrayList<Ficha> mano){
        this.nombre=nombre;
        this.mano=new ArrayList<>(mano);
    }
    public String getNombre() {
        return this.nombre;
    }
    public Ficha getFicha(int x) {
        if(x>=0 && x<this.mano.size())
            return this.mano.get(x);
        else
            return null;
    }
    public void removerFicha(Ficha f){
        this.mano.remove(f);
    }
    public void imprimirMano(){
        for(int i=0;i<this.mano.size();i++){
            System.out.print(this.mano.get(i));
            if(i<this.mano.size()-1)
                System.out.print("-");
        }
    }
}
