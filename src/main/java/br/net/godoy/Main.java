package br.net.godoy;

public class Main {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();

        int employersNumber = ui.readEmployersNumber();
        double profitMargin = ui.readProfitMargin();

        Company company = new Company(employersNumber, profitMargin);

        Menu menu = new Menu(company);
        menu.show();
    }
}
