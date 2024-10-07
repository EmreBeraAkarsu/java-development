package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String quotes[] = new String[10];

        try {
            quotes[0] = "Do one thing every day that scares you. -Eleanor Roosevelt";
            quotes[1] = "The way to get started is to quit talking and begin doing. -Walt Disney";
            quotes[2] = "The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart. -Helen Keller";
            quotes[3] = "It is during our darkest moments that we must focus to see the light. -Aristotle";
            quotes[4] = "Do not go where the path may lead, go instead where there is no path and leave a trail. -Ralph Waldo Emerson";
            quotes[5] = "Be yourself; everyone else is already taken. -Oscar Wilde";
            quotes[6] = "You must be the change you wish to see in the world. -Mahatma Gandhi";
            quotes[7] = "Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa";
            quotes[8] = "The only thing we have to fear is fear itself. -Franklin D. Roosevelt";
            quotes[9] = "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that. -Martin Luther King Jr.";


            System.out.println("Enter 1-10 to see a famous quotes: ");
            int option = input.nextInt();

            System.out.println(quotes[option - 1].toString());
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}
