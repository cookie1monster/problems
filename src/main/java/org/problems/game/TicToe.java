package org.problems.game;

public class TicToe {

    public static void main(String[] args) {
        TicToeGame tt = new TicToeGame();
        Player p1 = new AI(tt, "AI_1", 'X');
        Player p2 = new Human(tt, "Human1", 'O');
        //Player p2 = new AI(tt, "AI_2", 'O');
        //Player p1 = new Human(tt, "Human1", 'O');
        tt.startGame(3, p1, p2);
    }
}