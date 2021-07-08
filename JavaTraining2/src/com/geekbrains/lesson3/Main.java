package com.geekbrains.lesson3;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in); //Add a scanner
    public static void main(String[] args) {
        System.out.println("Hi! I am game created by the Shkvalik." +
                "\nLet's play the game! I will guess the number for you and you will have to guess it." +
                "\nFor the first Say me your name:");//displaying a greeting
        String name = scan.next();
        int[] d_conditions = {0, 0}; //variable for a range of random numbers
        int i = 0; //variable for counting attempts
        System.out.println("Good!\nNext you must choose the difficult:\n1.Easy\n2.Medium\n3.Hard");
        d_conditions = ChooseLevel(d_conditions);
        for (int cur_number = 5; cur_number <= d_conditions[0]; cur_number += 5){PlayLevel(i, cur_number, d_conditions);}
        System.out.println("You win! Game is passed");
    }

    private static void PlayLevel(int i, int cur_number, int[]d_conditions){
        System.out.println("Nice! Now guess from 0 to " + cur_number + "\nYou have " + d_conditions[1] + " attempt");//Say range of random number and have left attempts
        int number = (int) (Math.random() * cur_number);//system expression for specifying the range of the hidden number
        System.out.println(number); //DELETE LATER!
        int input_number = -1;
        while(number != input_number) { //they say that the loop must work as long as the attempts used are less than the given by the difficulty
            input_number = scan.nextInt();
                if (input_number == number) { //conditions if user has written the correct number that
                    System.out.println("Awesome!You guessed right!");
                } else if (input_number > number) { //conditions if user has written the bigger number than conceived number
                    System.out.println("Your answer is bigger than conceived number");
                    i++;//increase the value by one
                    System.out.println("You have left " + (d_conditions[1] - i) + " attempts");//the remaining attempts are displayed
                } else { //conditions if user has written the smaller number than conceived number
                    System.out.println("Your answer is smaller than conceived number");
                    i++;//increase the value by one
                    System.out.println("You have left " + (d_conditions[1] - i) + " attempts");//the remaining attempts are displayed
                }
                if(i == d_conditions[1]){//condition if attempts have no more
                    System.out.println("You Lose!\nThe hidden number - " + number);
                    System.exit(0);
                }
            }
    }
    private static int[] ChooseLevel(int[] d_conditions){
        String difficulty = scan.next(); //remember the complexity entered by the user
        if (difficulty.equals("1") || difficulty.equals("Easy")) { //conditions of difficulties
             d_conditions = new int[]{10, 5};
        } else if (difficulty.equals("2") || difficulty.equals("Medium")) {//conditions of difficulties
            d_conditions = new int[]{20, 3};
        } else if (difficulty.equals("3") || difficulty.equals("Hard")) {//conditions of difficulties
            d_conditions = new int[]{50, 1};
        } else {// condition if user has written wrong form
            System.out.println("<Game is stopped>\nYou wrote an incorrect form\nPlease write the name of difficulty or its number");
            System.exit(0); //Stop code
        }
        return d_conditions;
    }
}
/* TODO: 05.07.2021
Comment all metod ChooseLevel and Return he in main metod //Я МАТЬ ЕГО ЭТО СДЕЛАЛ!!!!! by Shkvalik
!implement a level system with help cycle FOR!//АХАХХАХ ТА Я МАТЬ ЕГО БОГ КОДИНГА!!!!by Shkvalik
implement a help system
implement a score system
implement a save score system(work with file)
 */
/* Done:
commit all metod ChooseLevel and Return he in main metod //Я МАТЬ ЕГО ЭТО СДЕЛАЛ!!!!!
 */