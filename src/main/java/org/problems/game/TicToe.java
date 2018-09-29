package org.problems.game;

import java.io.IOException;

public class TicToe {

    public static void main(String[] args) throws IOException {
        while (true) {
//            Console console = System.console();
//            String input = console.readLine("Enter move: ");
//            System.out.println(input);
            if ( System.in.available() > 0 )
            {
                char keyChar = (char)System.in.read();

                System.out.println(keyChar);
            }
        }
//        TicToeGame tt = new TicToeGame();
//        Player p1 = new AI(tt, "AI_1", 'X');
//        Player p2 = new Human(tt, "Human1", 'O');
//        //Player p2 = new AI(tt, "AI_2", 'O');
//        //Player p1 = new Human(tt, "Human1", 'O');
//        tt.startGame(3, p1, p2);
    }
}