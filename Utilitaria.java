/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Steven Morocho
 */
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> fichas=new ArrayList<>();
        Random rd=new Random();
        do{
            int lado1=rd.nextInt(1, 7);
            int lado2=rd.nextInt(1, 7);
            Ficha f=new Ficha(lado1,lado2);
            fichas.add(f);
        }
        while(fichas.size()<4);
        fichas.add(new FichaComodin(1,1));
        return fichas;
    }
}
