package br.net.godoy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Numero de empregados: ");

        Profit profit_sharing = new Profit();

        profit_sharing.readInitialInputs();


        System.out.println("Numero: ");
        System.out.println(profit_sharing.getEmployersNumber());

    }
}
