package br.net.godoy;

import java.util.Scanner;

/**
 * Created by agodoy on 03/07/17.
 */
public class Profit {
    private int employersNumber;
    private double profitMargin;

    public int getEmployersNumber() {
        return this.employersNumber;
    }

    public double getProfitMargin() {
        return this.profitMargin;
    }

    public void readInitialInputs() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Numero de empregados: ");
        int employers = scan.nextInt();

        System.out.println("Margem de lucro do ano: ");
        double margin = scan.nextDouble();

        scan.close();

        this.employersNumber = employers;
        this.profitMargin = margin;
    }

    public void runMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Menu\n1- Calcular participacao\n2- Sair");
        int option = 0;

        while(scan.hasNext() && option != 2) {
            System.out.println("while");
            option = scan.nextInt();

            if(option == 1) {
                calculateProfit();
            } else {
                break;
            }
        }

    }

    public void calculateProfit() {
        System.out.println("Calculado");
    }
}
