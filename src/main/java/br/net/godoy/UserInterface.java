package br.net.godoy;

import java.util.Scanner;


public class UserInterface {
    private Scanner scan;

    public UserInterface() {
        scan = new Scanner(System.in);
    }

    public int readEmployersNumber() {

        int employers = -1;

        do {
            System.out.println("Quantos funcionarios ha na empresa?");

            if(scan.hasNextInt()){
                employers = scan.nextInt();
            } else {
                scan.nextLine();
                System.out.println("Por favor, forneca um numero.");
            }

        } while(employers == -1);

        return employers;
    }

    public double readProfitMargin() {
        double profitMargin = 0.0;
        boolean couldGetADouble = false;

        do {
            System.out.println("Qual a margem de lucro do ano?");

            if(scan.hasNextDouble()){
                profitMargin = scan.nextDouble();
                couldGetADouble = true;
            } else {
                scan.next();
                System.out.println("Por favor, forneca um numero.");
            }

        } while(!couldGetADouble);

        return profitMargin;
    }


    public void printMenu() {
        System.out.println("Menu\n1- Calcular participacao\n2- Sair");
    }

    public int getMenuOption() {
        int option = -1;

        do {
            if(scan.hasNextInt()){
                option = scan.nextInt();
            } else {
                scan.nextLine();
                System.out.println("Por favor, forneca uma das opcoes.");
            }

        } while(option == -1);

        return option;
    }
}
