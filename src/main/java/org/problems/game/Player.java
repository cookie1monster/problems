package org.problems.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

abstract class Player {
    public TicToeGame game;
    public String name;
    public char mark;

    public Player(TicToeGame game, String name, char mark) {
        this.game = game;
        this.name = name;
        this.mark = mark;
    }

    abstract int[] nextMove();
}

class Human extends Player {
    private Scanner in;

    public Human(TicToeGame game, String name, char mark) {
        super(game, name, mark);

        this.in = new Scanner(System.in);
    }

    public int[] nextMove() {
        char[][] board = game.getBoard();
        int r, c;
        do {
            System.out.println(name + ", enter row, col: ");
            r = in.nextInt();
            c = in.nextInt();
        } while (board[r][c] != Character.MIN_VALUE);
        board[r][c] = mark;
        return new int[]{r, c};
    }
}

class AI extends Player {

    public AI(TicToeGame game, String name, char mark) {
        super(game, name, mark);
    }

    public int[] nextMove() {
        Random rand = new Random();
        char[][] board = game.getBoard();
        int N = board.length;
        List<int[]> available = new ArrayList<>();
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (board[r][c] == Character.MIN_VALUE)
                    available.add(new int[]{r, c});
            }
        }
        int[] move = available.get(rand.nextInt(available.size()));
        board[move[0]][move[1]] = mark;
        return move;
    }
}
