package br.net.godoy;

public class Main {

    public static void main(String[] args) {

        Profit profit_sharing = new Profit();
        profit_sharing.readInitialInputs();

        profit_sharing.runMenu();
    }
}
