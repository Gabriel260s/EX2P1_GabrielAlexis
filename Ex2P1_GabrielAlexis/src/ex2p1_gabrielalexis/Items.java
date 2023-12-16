/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p1_gabrielalexis;

/**
 *
 * @author gabri
 */
public class Items {

    String Nombre = "";
    int HPpoints, MPoints;

    public Items(String Nombre, int HPpoints, int MPoints) {
        this.Nombre = Nombre;
        this.HPpoints = HPpoints;
        this.MPoints = MPoints;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getHPpoints() {
        return HPpoints;
    }

    public int getMPoints() {
        return MPoints;
    }
    

    @Override
    public String toString() {
        return "Item: " + Nombre + ", HPpoints=" + HPpoints + ", MPoints=" + MPoints;
    }

}
