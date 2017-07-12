package br.net.godoy;


import java.util.Scanner;

public class Menu {
    public Company company;

    public Menu(Company _company) {
        company = _company;
    }

    public void show() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Menu\n1- Calcular participacao\n2- Sair");
        int option = 0;

        while(scan.hasNext()) {
            option = scan.nextInt();

            if(option == 1) {
                double profitResult = company.calculateProfit();
                System.out.println(profitResult);
            } else {
                break;
            }

            System.out.println("Menu\n1- Calcular participacao\n2- Sair");
        }
    }
}
