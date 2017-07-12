package br.net.godoy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Numero de empregados: ");
        int employers = scan.nextInt();

        System.out.println("Margem de lucro do ano: ");
        double margin = scan.nextDouble();


        Profit profit_sharing = new Profit(employers, margin);

        Menu menu = new Menu(profit_sharing);
        menu.show();
    }
}
