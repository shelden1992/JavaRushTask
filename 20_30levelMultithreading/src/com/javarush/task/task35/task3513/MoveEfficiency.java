package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;

    public int getScore() {
        return score;
    }

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles=numberOfEmptyTiles;
        this.score=score;
        this.move=move;
    }

    public Move getMove() {
        return move;
    }

    private Move move;

    @Override
    public int compareTo(MoveEfficiency o) {

        if (this.numberOfEmptyTiles > o.numberOfEmptyTiles) {
            return 1;

        } else if (this.numberOfEmptyTiles < o.numberOfEmptyTiles) {
            return -1;

        } else {
            return Integer.compare(this.score, o.score);


        }
    }
}
