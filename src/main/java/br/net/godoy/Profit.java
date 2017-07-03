package br.net.godoy;

import java.util.Scanner;

/**
 * Created by agodoy on 03/07/17.
 */
public class Profit {
    private int employersNumber;


    public int getEmployersNumber() {
        return this.employersNumber;
    }

    public void readInitialInputs() {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.close();

        this.employersNumber = input;
    }

}
