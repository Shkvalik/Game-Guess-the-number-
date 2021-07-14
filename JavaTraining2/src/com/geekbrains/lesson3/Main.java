package com.geekbrains.lesson3;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
    private static final Scanner scan = new Scanner(System.in); //Add a scanner
    public static void main(String[] args) {
        System.out.println("Hi! I am game created by the Shkvalik.\nLet's play the game! I will guess the number for you and you will have to guess it.\nFor the first choose the mode:\n1.Easy\n2.Medium\n3.Hard\n4.Infinity");//displaying a greeting
        GameConfig config = ChooseLevel();//Accepts changed params from ChooseLevel
        for (int maxNumber = 5; maxNumber <= config.levelsCount; maxNumber += 5){//Loop for playing the levels
            Boolean userWin = PlayLevel(maxNumber, config);//reproduce the PlayLevel method and accept the return form
            System.out.println("Current Score: " + config.currentScore + "\n- - - - - -\n");
            if (!userWin){//condition if userWin will be equals False
                break; //stop the cycle
            }
        }
        //After the cycle, we suggest the user to save the result.
        System.out.println("Game is finished\nDo you want to save your result?\nyes/no");
        String answer = scan.next();
        if(answer.equals("yes")){
            save_result(config);
        } else{
            System.exit(0);
        }
    }
    private static Boolean PlayLevel(int maxNumber, GameConfig config){//method with the process of acting out the game
        int rightNumber = (int) (Math.random() * maxNumber);//system expression for specifying the range of the hidden number
        System.out.println("Nice! Now guess from 0 to " + maxNumber + "\nYou have " + config.maxAttemptsCount + " attempt");//Say range of random number and have left attempts

        int currentAttempt = 0;
        while (true) {//an endless loop that will repeat until the user guesses the number or runs out of attempts
            int inputNumber = scan.nextInt();
            if (inputNumber == rightNumber) { //conditions if user has written the correct number that
                config.scoreScale++;//add a point to the score multiplier
                config.currentScore = config.currentScore + (100 * config.scoreScale);//change the current score to the points for correct answer multiplied by points multiplier
                System.out.println("Awesome!You guessed right!");
                return true; // return true for continue the game

            } else if (currentAttempt < config.maxAttemptsCount) {  // wrong answer, but attempts left
                config.scoreScale = 1;// reset the scorescale
                currentAttempt++;//add point to the current attempt
                System.out.println("Your answer is " + (inputNumber > rightNumber ? "bigger" : "smaller") + "than conceived number");//displaying a response to the user depending on the response value. If input number will be bigger, displaying bigger, else displaying smaller
                System.out.println("You have left " + (config.maxAttemptsCount - currentAttempt) + " attempts");//displaying the remaining attempts to the user, subtracting the maximum number from the current attempt
            } else {
                System.out.println("You Lose! The hidden number - " + rightNumber);
                return false; // return false for the stop the cycle and game
            }
        }
    }

    private static GameConfig ChooseLevel(){// metod for
        String mode = scan.next(); //remember the complexity entered by the user
        if (mode.equals("1") || mode.equals("Easy")) { //conditions of difficulties
            return new GameConfig(10, 5); //return in config our new params

        } else if (mode.equals("2") || mode.equals("Medium")) {//conditions of difficulties
            return new GameConfig(20, 3); //return in config our new params

        } else if (mode.equals("3") || mode.equals("Hard")) {//conditions of difficulties
            return new GameConfig(50, 1); //return in config our new params

        } else if (mode.equals("4") || mode.equals("Infinity")) {//conditions of difficulties
            return new GameConfig(12.0/0, 10); //return in config our new params. 12.0/0 - Infinity
        } else {// condition if user has written wrong form
            System.out.println("<Game is stopped>\nYou wrote an incorrect form\nPlease write the name of mode or its number");
            System.exit(0); //Stop code
            return null;
        }
    }
    private static void save_result(GameConfig config){ //metod for save result
        System.out.println("Write your name");
        String name = scan.next();
        try (FileWriter writer = new FileWriter("Statistics.txt", true)) {//trying to write the result to an existing file
            writer.write(name + " : " + config.currentScore +'\n'); // write a result in like form (user name : score)
            writer.flush(); // close connect with file
            System.out.println("Your result successful saved\n" + name + " : " + config.currentScore);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static class GameConfig { //class with data for Game config
        double levelsCount;
        int maxAttemptsCount;
        int currentScore = 0;
        int scoreScale = 1;

        public GameConfig(double levelsCount, int maxAttemptsCount) { //metod for changed
            this.levelsCount = levelsCount;
            this.maxAttemptsCount = maxAttemptsCount;
        }
    }}