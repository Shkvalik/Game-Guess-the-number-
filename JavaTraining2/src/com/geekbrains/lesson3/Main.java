package com.geekbrains.lesson3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hi! I am game created by the Shkvalik.\nLet's play the game! I will guess the number for you and you will have to guess it.\nChoose difficulty:\n1.Easy\n2.Medium\n3.Hard");
        int range = 0;
        int quantity_attempts = 0;
        int i = 0;
        String difficulty = scan.next();
        if (difficulty.equals("1") || difficulty.equals("Easy")) {
            range = 10;
            quantity_attempts = 5;
        } else if (difficulty.equals("2") || difficulty.equals("Medium")) {
            range = 20;
            quantity_attempts = 3;
        } else if (difficulty.equals("3") || difficulty.equals("Hard")) {
            range = 50;
            quantity_attempts = 1;
        } else {
            System.out.println("<Game is stopped>\nYou wrote an incorrect form\nPlease write the name of difficulty or its number");
            System.exit(0);
        }
        System.out.println("Nice! Now guess from 0 to " + range + "\nYou have " + quantity_attempts + " attempt");
        int number = (int) (Math.random() * range);
        while (i < quantity_attempts) {
            int input_number = scan.nextInt();
            if (input_number == number) {
                System.out.println("Awesome!You guessed right!");
            } else if (input_number > number) {
                System.out.println("Your answer is bigger than conceived number");
                i++;
            } else {
                System.out.println("Your answer is smaller than conceived number");
                i++;
            }
            System.out.println("You have left " + (quantity_attempts - i) + " attempts");
            }
        }
    }
