package br.net.godoy;

import java.util.Scanner;

/**
 * Created by agodoy on 03/07/17.
 */
public class Profit {
    private int employersNumber;
    private double profitMargin;

    public enum Roles {
        Trainee(1), Analista(2), Gerente(3);

        private final int value;
        Roles (int _value){
            value = _value;
        }
        public int getValue(){
            return value;
        }
    }

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

        this.employersNumber = employers;
        this.profitMargin = margin;
    }

    private boolean willOffer() {
        if(profitMargin > 10000.0*employersNumber) return true;
        else return false;
    }

    private int getEmployerPerformance(Scanner scan) {
        System.out.println("Qual a performance anual?");
        int employerPerformance = scan.nextInt();

        return employerPerformance;
    }

    private int getEmployerRole(Scanner scan) {
        System.out.println("Qual o cargo do empregado?");
        String employerRole = scan.nextLine();

        int employerRoleValue = Roles.valueOf(employerRole).getValue();

        return employerRoleValue;
    }

    public double calculateProfit() {
        double profitResult = 0.0;

        if (willOffer()) {
            Scanner scan = new Scanner(System.in);

            int employerRoleValue = getEmployerRole(scan);
            int employerPerformance = getEmployerPerformance(scan);

            profitResult = employerPerformance * employerRoleValue * (0.4 * profitMargin / employersNumber);
        }

        return profitResult;
    }
}
