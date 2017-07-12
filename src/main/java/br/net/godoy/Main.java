package br.net.godoy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Numero de empregados: ");
        int employers = scan.nextInt();

        System.out.println("Margem de lucro do ano: ");
        double margin = scan.nextDouble();


        Company company = new Company(employers, margin);

        Menu menu = new Menu(company);
        menu.show();
    }
}
