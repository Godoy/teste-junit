package br.net.godoy;

import java.util.Scanner;

/**
 * Created by agodoy on 03/07/17.
 */
public class Company {
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

    public Company(int _employersNumber, double _profitMargin) {
        employersNumber = _employersNumber;
        profitMargin = _profitMargin;
    }

    public int getEmployersNumber() {
        return this.employersNumber;
    }

    public double getProfitMargin() {
        return this.profitMargin;
    }

    private boolean willOffer() {
        return profitMargin > 10000.0*employersNumber;
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
