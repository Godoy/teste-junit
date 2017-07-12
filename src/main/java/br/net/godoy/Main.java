package br.net.godoy;

public class Main {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();

        int employersNumber = ui.readEmployersNumber();
        double profitMargin = ui.readProfitMargin();

        Company company = new Company(employersNumber, profitMargin);

        while(true) {
            ui.printMenu();
            int option = ui.getMenuOption();

            if (option == 1)
                company.calculateProfit();
            else if (option == 2)
                System.exit(0);

        }

    }
}
