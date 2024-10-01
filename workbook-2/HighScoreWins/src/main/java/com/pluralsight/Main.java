package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a game score: ");
        String game = scanner.nextLine().trim();

        int colonIndex = game.indexOf(":");
        int pipeIndex = game.indexOf("|");

        String team1 = (game.substring(0, colonIndex).trim());
        String team2 = (game.substring(colonIndex + 1, pipeIndex).trim());

        String score = (game.substring(pipeIndex + 1).trim());

        int team1Score = (Integer.parseInt(score.substring(0, score.indexOf(":"))));
        int team2Score = (Integer.parseInt(score.substring(score.indexOf(":") + 1)));

        if (team1Score > team2Score) {
            System.out.println("Winner: " + team1);

        } else if (team1Score < team2Score) {
            System.out.println("Winner: " + team2);

        } else {
            System.out.println("It is a draw!");

        }

    }
}
