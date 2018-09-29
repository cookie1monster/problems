package org.problems.game;

class TicToeGame {
    private int N;
    private char[][] board;
    private int avalibleMove;

    public void startGame(int N, Player p1, Player p2) {
        this.N = N;
        board = new char[N][N];
        avalibleMove = N * N;

        Player p = p1;
        int[] move;
        do {
            print();
            if (isDraw()) {
                System.out.println("Draw!");
                return;
            }
            move = p.nextMove();
            p = (p == p1) ? p2 : p1;
            avalibleMove--;
        } while (!isWinner(move[0], move[1]));

        print();
        System.out.println((p == p1 ? p2 : p1).name + " win!");
    }

    public char[][] getBoard() {
        return board;
    }


    private boolean isWinner(int r, int c) {
        if (isWinner(r, 0, 0, 1, board[r][c])) return true;
        if (isWinner(0, c, 1, 0, board[r][c])) return true;
        if (isWinner(0, 0, 1, 1, board[r][c])) return true;
        if (isWinner(N - 1, 0, -1, 1, board[r][c])) return true;

        return false;
    }

    private void print() {
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                System.out.print("|" + (board[r][c] == Character.MIN_VALUE ? " " : board[r][c]));
            }
            System.out.println("|");
            for (int i = 0; i <= 2 * N; ++i)
                System.out.print("-");
            System.out.println();
        }
        System.out.println();
    }

    private boolean isWinner(int r, int c, int ir, int ic, char val) {
        while (c < N && r < N) {
            if (board[r][c] != val)
                return false;
            r += ir;
            c += ic;
        }
        return true;
    }

    private boolean isDraw() {
        return avalibleMove == 0;
    }
}


