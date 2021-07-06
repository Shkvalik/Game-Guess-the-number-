package com.geekbrains.lesson3;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in); //Add a scanner
    private int range;
    int quantity_attempts = 0;
    public static void main(String[] args) {
        System.out.println("Hi! I am game created by the Shkvalik." +
                "\nLet's play the game! I will guess the number for you and you will have to guess it." +
                "\nChoose difficulty:\n1.Easy\n2.Medium\n3.Hard"); //displaying a greeting
        int[] d_conditions = {0}; //variable for a range of random numbers
        int quantity_attempts = 0; //variable for count of attempts
        int i = 0; //variable for counting attempts
        ChooseLevel(range, quantity_attempts);
        System.out.println("Nice! Now guess from 0 to " + range + "\nYou have " + quantity_attempts + " attempt");//Say range of random number and have left attempts
        int number = (int) (Math.random() * range); //system expression for specifying the range of the hidden number
        PlayLevel(i, number, quantity_attempts);
    }
    private static void PlayLevel(int i, int number, int quantity_attempts){
            while (i < quantity_attempts) { //they say that the loop must work as long as the attempts used are less than the given by the difficulty
                int input_number = scan.nextInt();//remember a number
                if (input_number == number) { //conditions if user has written the correct number that
                    System.out.println("Awesome!You guessed right!");
                } else if (input_number > number) { //conditions if user has written the bigger number than conceived number
                    System.out.println("Your answer is bigger than conceived number");
                    i++;//increase the value by one
                } else { //conditions if user has written the smaller number than conceived number
                    System.out.println("Your answer is smaller than conceived number");
                    i++;//increase the value by one
                }
                if(i == quantity_attempts){//condition if attempts have no more
                    System.out.println("You Lose!\nThe hidden number - " + number);
                    System.exit(0);
                }
                System.out.println("You have left " + (quantity_attempts - i) + " attempts");//the remaining attempts are displayed
            }
    }
    private static void ChooseLevel(int range, int quantity_attempts){
        String difficulty = scan.next(); //remember the complexity entered by the user
        if (difficulty.equals("1") || difficulty.equals("Easy")) { //conditions of difficulties
            range = 10;
            quantity_attempts = 5;
        } else if (difficulty.equals("2") || difficulty.equals("Medium")) {//conditions of difficulties
            range = 20;
            quantity_attempts = 3;
        } else if (difficulty.equals("3") || difficulty.equals("Hard")) {//conditions of difficulties
            range = 50;
            quantity_attempts = 1;
        } else {// condition if user has written wrong form
            System.out.println("<Game is stopped>\nYou wrote an incorrect form\nPlease write the name of difficulty or its number");
            System.exit(0); //Stop code
        }
    }
}
/* TODO: 05.07.2021
commit all metod ChooseLevel and Return he in main metod
implement a level system with help cycle FOR
implement a score system
implement a save score system(work with file)
 */
