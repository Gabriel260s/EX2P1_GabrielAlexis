/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p1_gabrielalexis;

import org.ietf.jgss.MessageProp;

/**
 *
 * @author gabri
 */
public class Personajes {

    String Nombre = "";
    int HP, MP, AttackPoints, DefensePoints;

    public Personajes(String Nombre, int HP, int MP, int AttackPoints, int DefensePoints) {
        this.Nombre = Nombre;
        this.HP = HP;
        this.MP = MP;
        this.AttackPoints = AttackPoints;
        this.DefensePoints = DefensePoints;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public int getAttackPoints() {
        return AttackPoints;
    }

    public int getDefensePoints() {
        return DefensePoints;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void curar(int HP) {
        this.HP = HP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public void setAttackPoints(int AttackPoints) {
        this.AttackPoints = AttackPoints;
    }

    public void setDefensePoints(int DefensePoints) {
        this.DefensePoints = DefensePoints;
    }

    public void dañoHecho(int daño) {
        HP -= daño;
        if (HP < 0) {
            HP = 0;
        }
    }

    @Override
    public String toString() {
        return "" + Nombre + ", HP=" + HP + ", MP=" + MP + ", AttackPoints=" + AttackPoints + ", DefensePoints=" + DefensePoints;
    }

}
