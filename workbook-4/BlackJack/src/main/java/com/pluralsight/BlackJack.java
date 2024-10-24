package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();

        ArrayList<Player> players = new ArrayList<>();

        ArrayList<Integer> values = new ArrayList<>();

        int numberOfPlayers;

        System.out.println("How many player are playing?");
        numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = numberOfPlayers; i > 0; i--){

            System.out.println("Enter the names of the players: ");
            String name = scanner.nextLine();

            Player player = new Player(name);

            Hand hand = new Hand();

            hand.deal(deck.deal());
            hand.deal(deck.deal());

            player.setHand(hand);

            players.add(player);

            values.add(player.getHand().getValue());
        }

        for (Integer value : values) {
            

        }




    }
}
