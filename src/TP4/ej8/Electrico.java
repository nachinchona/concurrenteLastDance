/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej8;

/**
 *
 * @author nacho
 */
public class Electrico extends Thread{
    private Gestor gestor;
    
    public Electrico(Gestor unGestor){
        gestor = unGestor;
    }
}
