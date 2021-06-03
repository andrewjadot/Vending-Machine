package com.techelevator.view;

import java.util.Scanner;

public class cashRegister {
    Scanner in = new Scanner(System.in);
    public String[] money;
    public String[] options = {"1) Feed Money", "2) Select Product", "3) Finish Transaction"};
    public int balance = 0;
    public String inputString;
    public int selectionNum = -1;
    public int selection;


    public cashRegister(String[] money) {
        this.money = money;
        this.balance = balance;
        this.selection = -1;
    }

    public void displayOptions() {
        for (int i = 0; i < this.options.length; i++) {

            System.out.println(this.options[i]);

        }



        System.out.println("\nCurrent money provided: $" + this.balance + ".00");

    }

    public int getOptionsSelected(){
        try {
            inputString = in.nextLine();
            selectionNum = Integer.parseInt(inputString);

            if(selectionNum > 0 && selectionNum <= this.options.length){
                return selectionNum;
            }
        } catch (NumberFormatException e) {}

        System.out.println("\nInvalid Input: " + inputString);
        return selectionNum;
    }
    public void processSelection(){

    }

    public void feedMoney() {
        System.out.println("Please add either $1, $2, $5, $10");
    }



    public void transaction(){}

    public static void main(String[] arg){}
}
