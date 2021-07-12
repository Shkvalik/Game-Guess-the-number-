package com.geekbrains.lesson3;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in); //Add a scanner
    public static void main(String[] args) {
        System.out.println("Hi! I am game created by the Shkvalik." +
                "\nLet's play the game! I will guess the number for you and you will have to guess it." +
                "\nFor the first Say me your name:");//displaying a greeting
        String name = scan.next();
        double[] d_conditions = {0, 0, 0, 0, 1}; //{final number, max_quantity_attempts, current_quantity_attempts, current_score, scale}
        System.out.println("Good!\nNext you must choose the mode:\n1.Easy\n2.Medium\n3.Hard\n4.Infinity");
        d_conditions = ChooseLevel(d_conditions);
        for (int cur_number = 5; cur_number <= d_conditions[0]; cur_number += 5){
            int number = (int) (Math.random() * cur_number);//system expression for specifying the range of the hidden number
            d_conditions = PlayLevel(cur_number, number, d_conditions);
            if (d_conditions[2] == d_conditions[1]){
                System.out.println("You Lose! The hidden number - " + number);
                System.out.println(d_conditions[3]);
                break;
            }
            System.out.println(d_conditions[3]);
        }
        System.out.println("Game is finished");
    }

    private static double[] PlayLevel(int cur_number, int number, double[] d_conditions){
        System.out.println("Nice! Now guess from 0 to " + cur_number + "\nYou have " + d_conditions[1] + " attempt");//Say range of random number and have left attempts
        System.out.println(number); //DELETE LATER!
        int input_number = -1;
        while (true) { //they say that the loop must work as long as the attempts used are less than the given by the difficulty
            input_number = scan.nextInt();
                if (input_number == number) { //conditions if user has written the correct number that
                    System.out.println("Awesome!You guessed right!");
                    d_conditions[3] = d_conditions[3] + (100 * d_conditions[4]);
                    ++d_conditions[4];
                    return d_conditions;
                } else if (input_number > number) { //conditions if user has written the bigger number than conceived number
                    System.out.println("Your answer is bigger than conceived number");
                    d_conditions[4] = 1;
                    d_conditions[2]++;//increase the value by one
                    System.out.println("You have left " + (d_conditions[1] - d_conditions[2]) + " attempts");//the remaining attempts are displayed
                } else {//conditions if user has written the smaller number than conceived number
                    System.out.println("Your answer is smaller than conceived number");
                    d_conditions[2]++;//increase the value by one
                    System.out.println("You have left " + (d_conditions[1] - d_conditions[2]) + " attempts");//the remaining attempts are displayed
                    d_conditions[4] = 1;
                }if (d_conditions[2] == d_conditions[1]) {
                break;
            }
        }
        return d_conditions;}
    private static double[] ChooseLevel(double[] d_conditions){
        String mode = scan.next(); //remember the complexity entered by the user
        if (mode.equals("1") || mode.equals("Easy")) { //conditions of difficulties
             d_conditions = new double[]{10, 5, 0, 0, 1};
        }
        else if (mode.equals("2") || mode.equals("Medium")) {//conditions of difficulties
            d_conditions = new double[]{20, 3, 0, 0, 1}; //{final number, max_quantity_attempts, current_quantity_attempts, current_score, scale}
        }
        else if (mode.equals("3") || mode.equals("Hard")) {//conditions of difficulties
            d_conditions = new double[]{50, 1, 0, 0, 1}; //{final number, max_quantity_attempts, current_quantity_attempts, current_score, scale}
        }
        else if (mode.equals("4") || mode.equals("Infinity")) {//conditions of difficulties
            d_conditions = new double[]{12.0/0, 10, 0, 0, 1}; //{final number, max_quantity_attempts, current_quantity_attempts, current_score, scale}
        } else {// condition if user has written wrong form
            System.out.println("<Game is stopped>\nYou wrote an incorrect form\nPlease write the name of mode or its number");
            System.exit(0); //Stop code
        }
        return d_conditions;
    }
}
/* TODO: 05.07.2021
implement a help system
implement a save score system(work with file)
 */
/* Done:
commit all metod ChooseLevel and Return he in main metod //Я МАТЬ ЕГО ЭТО СДЕЛАЛ!!!!! by Shkvalik
!implement a level system with help cycle FOR!//АХАХХАХ ТА Я МАТЬ ЕГО БОГ КОДИНГА!!!!by Shkvalik
implement a score system//Please call me THE FUCKING KING OF THIS FUCKING CODING !!!!!!!!!by Shkvalik
imlement infinity mode//nothing complicated...all is simple by Shkvalik
 */