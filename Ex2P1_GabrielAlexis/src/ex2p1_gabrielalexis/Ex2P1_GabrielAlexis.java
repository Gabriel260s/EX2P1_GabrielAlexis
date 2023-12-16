/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2p1_gabrielalexis;

import java.beans.PersistenceDelegate;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author gabri
 */
//Fila 3 Asiento 10
public class Ex2P1_GabrielAlexis {

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static ArrayList<Personajes> party = new ArrayList<>();
    static ArrayList<Items> mochila = new ArrayList<>();
    static ArrayList<Personajes> reserve = new ArrayList<>();
    static Personajes Sora = new Personajes("Sora", 300, 300, 75, 15);
    static Personajes Donald = new Personajes("Donald", 150, 450, 45, 10);
    static Personajes Goofy = new Personajes("Goofy", 450, 100, 150, 50);
    static Personajes Mickey = new Personajes("Mickey", 100, 500, 150, 35);
    static Personajes Roxas = new Personajes("Roxas", 300, 300, 15, 75);
    static Personajes Kairi = new Personajes("Kairi", 200, 200, 50, 15);
    static ArrayList<Items> Magicos = new ArrayList<>();
    static Items Blizzard = new Items("Blizzard", 50, 50);
    static Items Firaga = new Items("Firaga", 25, 25);
    static Items Gravity = new Items("Gravity", 75, 100);

    static Items Pocion = new Items("Pocion", 50, 0);
    static Items Ether = new Items("Ether", 0, 50);
    static Items Elixir = new Items("Elixir", 100, 100);

    public static void main(String[] args) {

        int cont_salas = 0;
        int sala = 1;
        int opt = 0;

        party.add(Goofy);//0
        party.add(Donald);//1
        party.add(Sora);//2

        reserve.add(Kairi);//0
        reserve.add(Roxas);//1
        reserve.add(Mickey);//2

        mochila.add(Elixir);//0
        mochila.add(Pocion);//1
        mochila.add(Ether);//2

        Magicos.add(Elixir);//0
        Magicos.add(Firaga);//1
        Magicos.add(Gravity);//2

        while (cont_salas <= 20 || party.size() > 0) {
            System.out.println("Haz entrado a la sala " + sala);
            System.out.println("Desea seguir?");
            input.next();
            sala = rand.nextInt(1, 6);

            if (sala == 1) {
                batalla();

            } else {

                editMochila(sala);
            }
            cont_salas++;
            if (cont_salas >= 20) {
                System.out.println("Haz logrado salir del castillo!\n Fin del juego");
                System.exit(0);
            }

        }
    }

    public static void editMochila(int cuarto) {
        switch (cuarto) {
            case 2:
                System.out.println("Haz encontrado un cofre con una pocion!\n ");
                System.out.println("Pocion se ha agregado a tu mochila \n");
                mochila.add(Pocion);
                mostarMochila();
                break;
            case 3:
                System.out.println("Haz encontrado un ether!\n");
                System.out.println("Ether se ha agregado a tu mochila\n");
                mochila.add(Ether);
                mostarMochila();
                break;
            case 4:
                System.out.println("Haz encontrado un elixir!\n");
                System.out.println("Elixir se ha agregado a tu mochila\n");
                mochila.add(Elixir);
                mostarMochila();
                break;
            case 5:
                System.out.println("Te has encontrado items a amigos que ocupan tu ayuda y decides darles items:\n ");
                if (mochila.size() > 0) {
                    int cont_rand = rand.nextInt(mochila.size()) + 1;
                    System.out.println("Haz perdido " + cont_rand + " items");
                    for (int i = 0; i < cont_rand && mochila.size() > 0; i++) {
                        int randomIndex = rand.nextInt(mochila.size());
                        mochila.remove(randomIndex);
                    }
                    mostarMochila();
                } else {
                    System.out.println("No tienes items en la mochila para darle a tus amigos!.");
                }
                break;

        }
    }

    public static int attack(int i) {
        String nombre = party.get(i).getNombre();
        int ataque = party.get(i).getAttackPoints();
        System.out.println(nombre + " ataco");
        System.out.println(nombre + " ha hecho " + ataque + " de daño");
        return ataque;
    }

    public static void mostarParty() {
        for (int i = 0; i < party.size(); i++) {
            String mens = party.get(i).toString();
            System.out.println(i + " " + mens);
        }
    }

    public static void mostarMochila() {
        for (int i = 0; i < mochila.size(); i++) {
            String mens = mochila.get(i).toString();
            System.out.println(i + " " + mens);
        }
    }

    public static void mostarReserva() {
        for (int i = 0; i < reserve.size(); i++) {
            String mens = reserve.get(i).toString();
            System.out.println(i + " " + mens);
        }
    }

    public static void mostrarMagic() {
        for (int i = 0; i < Magicos.size(); i++) {
            String mens = Magicos.get(i).toString();
            System.out.println(i + " " + mens);
        }
    }

    public static void batalla() {
        int cont_heart = rand.nextInt(3) + 1;
        int heartvida = 75 * cont_heart;
        int heartataque = 25 * cont_heart;
        System.out.println("Haz encontrado " + cont_heart + " Heartless.");

        boolean partyMuerta = false;

        while (heartvida > 0 && mochila.size() > 0 && !partyMuerta) {
            mostarParty();
            System.out.println("Elige un personaje");
            int pers = input.nextInt();
            if (pers < 0 || pers >= party.size()) {
                System.out.println("Selección de personaje inválida. Inténtalo de nuevo.");
                continue;
            }

            System.out.println("*****Menu****");
            System.out.println("1. Attack \n2. Magic \n3. Items \n4. Party\n");
            int opc = input.nextInt();

            switch (opc) {
                case 1:
                    if (pers >= 0 && pers < party.size()) {
                        int dañoPers = attack(pers);
                        heartvida -= dañoPers;
                        if (heartvida < 0) {
                            heartvida = 0;
                        }
                    }
                    break;
                case 2:
                    mostrarMagic();
                    System.out.println("Elige un ataque magico para utilzar: ");
                    int magicOpc = input.nextInt();
                    if (magicOpc >= 0 && magicOpc < Magicos.size()) {
                        int costeMagic = Magicos.get(magicOpc).getMPoints();
                        if (party.get(pers).getMP() >= costeMagic) {
                            int dañoMagic = Magicos.get(magicOpc).getHPpoints();
                            heartvida -= dañoMagic;
                            if (heartvida < 0) {
                                heartvida = 0;
                            }
                            party.get(pers).setMP(party.get(pers).getMP() - costeMagic);
                            System.out.println("Has usado " + Magicos.get(magicOpc).getNombre() + " y has hecho " + dañoMagic + " de daño.");
                        } else {
                            System.out.println("No tienes suficiente MP para usar este ataque mágico.");
                        }
                    }
                    if (magicOpc < 0 || magicOpc >= Magicos.size()) {
                        System.out.println("Selección de ataque mágico inválida. Inténtalo de nuevo.");
                        continue;
                    }
                    break;

                case 3:
                    mostarMochila();
                    System.out.println("Elige un item a utilizar: ");
                    int itemOpt = input.nextInt();

                    if (itemOpt >= 0 && itemOpt < mochila.size()) {

                        int cantCurar = mochila.get(itemOpt).getHPpoints();
                        int cantHP = mochila.get(itemOpt).getMPoints();
                        String nombreItem = mochila.get(itemOpt).getNombre();
                        mostarParty();

                        System.out.println("Elige un personaje para usar el item: ");
                        pers = input.nextInt();

                        if (pers >= 0 && pers < party.size()) {

                            party.get(pers).curar(cantCurar);
                            party.get(pers).setMP(cantHP);

                            mochila.remove(itemOpt);

                            System.out.println("¡Has usado " + nombreItem + " en " + party.get(pers).getNombre() + "!");
                        } else {
                            System.out.println("Selección de personaje inválida.");
                        }
                    } else {
                        System.out.println("Selección de item inválida.");
                    }
                    break;

                case 4:
                    mostarReserva();
                    System.out.println("Elige un personaje para cambiar: ");
                    pers = input.nextInt();

                    if (pers >= 0 && pers < reserve.size()) {

                        party.remove(pers);

                        party.add(reserve.get(pers));
                        System.out.println("El personaje se ha cambiado!");
                    } else {
                        System.out.println("Selección de personaje inválida.");
                    }
                    break;

            }
            if (opc != 4) {
                System.out.println("Heartless ataca");
                int dañoHeartless = heartataque;
                int defensa = party.get(pers).getDefensePoints();

                int dañoFinal = dañoHeartless - defensa;

                if (dañoFinal < 0) {
                    dañoFinal = 0;
                }

                party.get(pers).dañoHecho(dañoFinal);
                System.out.println(party.get(pers).getNombre() + " ha recibido " + dañoFinal + " de daño.");
                if (party.get(pers).getHP() <= 0) {
                    System.out.println(party.get(pers).getNombre() + " ha muerto.");
                    party.remove(pers);
                    if (party.isEmpty()) {
                        partyMuerta = true;
                        System.out.println("¡Tu party ha sido derrotada!");
                        System.out.println("Fin del juego");
                        System.exit(0);
                    }
                }
            }

            System.out.println("*****Menu****");
            System.out.println("1. Attack \n2. Magic \n3. Items \n4. Party ");
            opc = input.nextInt();

        }

        if (heartvida <= 0 && !partyMuerta) {
            System.out.println("¡Has derrotado a los Heartless!");
            System.out.println("Puedes seguir avanzando");
        }
    }

}
