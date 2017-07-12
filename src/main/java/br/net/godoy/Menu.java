package br.net.godoy;


import java.util.Scanner;

public class Menu {
    public Profit profit;

    public Menu(Profit _profit) {
        profit = _profit;
    }

    public void show() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Menu\n1- Calcular participacao\n2- Sair");
        int option = 0;

        while(scan.hasNext()) {
            option = scan.nextInt();

            if(option == 1) {
                profit.calculateProfit();
            } else {
                break;
            }
        }
    }
}
