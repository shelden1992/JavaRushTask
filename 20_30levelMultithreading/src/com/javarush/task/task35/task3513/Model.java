package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {//будет содержать игровую логику и хранить игровое поле.
    private static final int FIELD_WIDTH=4;  //определяющая ширину игрового поля.
    protected int score;    // счет  например если текущий счет 20 и было выполнено слияние ряда {4, 4, 4, 0}, счет должен увеличиться на 8.

    protected int maxTile; // максимальное значение плитки
    boolean isSaveNeeded=true;
    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates=new Stack<>();
    private Stack<Integer> previousScores=new Stack<>();


    public Model() {

        resetGameTiles();


    }

    private void saveState(Tile[][] tiles) {

        Tile[][] fieldToSave=new Tile[tiles.length][tiles[0].length];
        for (int i=0; i < tiles.length; i++) {
            for (int j=0; j < tiles[0].length; j++) {
                fieldToSave[i][j]=new Tile(tiles[i][j].value);
            }
        }

        previousScores.push(score);
        previousStates.push(fieldToSave);

        this.isSaveNeeded=false;


    }

    public void rollback() {
        if (!previousStates.empty()) {
            this.gameTiles=previousStates.pop();
        }
        if (!previousScores.empty()) {
            this.score=previousScores.pop();
        }

    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {  //который будет смотреть какие плитки пустуют и, если такие имеются,
        List<Tile> localList=getEmptyTiles();
        if (!localList.isEmpty()) {

            localList.get((int) ( localList.size() * Math.random() )).value=( Math.random() < 0.9 ? 2 : 4 );


        }

    }

    private List<Tile> getEmptyTiles() {  //Tile, у которых значение Value == 0;
        List<Tile> list=new ArrayList();
        for (Tile[] tiles : gameTiles
        ) {
            for (Tile til : tiles
            ) {
                if (til.isEmpty()) {
                    list.add(til);
                }

            }

        }
        return list;
    }

    public int getScore() {
        return score;
    }

    protected void resetGameTiles() {
        this.gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i=0; i < FIELD_WIDTH; i++) {
            for (int j=0; j < FIELD_WIDTH; j++) {
                this.gameTiles[i][j]=new Tile();
            }

        }

        //-----------------------------------------------------------test-----------------------//
//        {
//            Tile[] array1={new Tile(2), new Tile(8), new Tile(16), new Tile(32)};
//            Tile[] array2={new Tile(2), new Tile(4), new Tile(8), new Tile(2)};
//            Tile[] array3={new Tile(2), new Tile(2), new Tile(2), new Tile(4)};
//            Tile[] array4={new Tile(2), new Tile(8), new Tile(2), new Tile(4)};
//
//            this.gameTiles=new Tile[][]{array1, array2, array3, array4};
//        }
        //----------------------------------------------------------------------------------------//

        addTile();
        addTile();
        this.score=0;
        this.maxTile=0;

    }

    boolean compressTiles(Tile[] tiles) {  // Сжатие плиток, ряд  {4, 2, 0, 4}   -->  {0, 4, 2, 4}
//        Tile[] tiles2=new Tile[tiles.length];
//        System.arraycopy(tiles, 0, tiles2, 0, tiles.length);

        boolean anyChange=false;


        for (int i=0; i < tiles.length; i++) {

            if (tiles[i].value == 0) {
                outer:
                for (int j=i + 1; j < tiles.length; j++) {
                    if (tiles[j].value != 0) {
                        tiles[i].value=tiles[j].value;
                        tiles[j].value=0;
                        anyChange=true;
                        break outer;
                    }
                }
            }
        }

        return anyChange;

    }

    private boolean mergeTiles(Tile[] tiles) {  // //Слияние ряд превратится в {8, 8, 0, 0} <-- {4, 4, 4, 4}  а в {8, 4, 0, 0} <--{4, 4, 4, 0}{
        boolean flag=false;
        for (int i=0; i < tiles.length - 1; i++) {
            int localMax;
            if (tiles[i].value == tiles[i + 1].value) {
                if (tiles[i].value != 0) {
                    localMax=( tiles[i].value+=tiles[i + 1].value );
                    flag=true;
                    score+=localMax;
                    if (localMax > maxTile) {
                        maxTile=localMax;
                    }
                    tiles[i + 1].value=0;  //8  0  4   4
                    compressTiles(tiles);  // 8 4  4   0
                }

            }
        }
        return flag;

    }

    public void left() {

        if (isSaveNeeded) {
            saveState(gameTiles);
        }


        boolean isChange=false;
        for (int i=0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]))
                isSaveNeeded=true;
            isChange=true;
        }

        if (isChange) {
            addTile();
        }

    }

    public void right() {
        saveState(gameTiles);

        // -----------------------trashGame--------------
//        for (int i=0; i <Math.random()*100; i++)
        //----------------------------------------------------

        this.gameTiles=rotate(gameTiles);
        this.gameTiles=rotate(gameTiles);
        left();
        this.gameTiles=rotate(gameTiles);
        this.gameTiles=rotate(gameTiles);


    }

    public void down() {
        saveState(gameTiles);
        // -----------------------trashGame--------------

//        for (int i=0; i <Math.random()*100; i++)
        //----------------------------------------------------
        this.gameTiles=rotate(gameTiles);


        left();
        this.gameTiles=rotate(gameTiles);
        this.gameTiles=rotate(gameTiles);

        this.gameTiles=rotate(gameTiles);


    }

    public void up() {
        saveState(gameTiles);

        this.gameTiles=rotate(gameTiles);

        this.gameTiles=rotate(gameTiles);
        this.gameTiles=rotate(gameTiles);
        left();

        this.gameTiles=rotate(gameTiles);
    }


    public Tile[][] rotate(Tile[][] array) {


        Tile[][] retArr=new Tile[FIELD_WIDTH][FIELD_WIDTH];

        int retArrI=0;
        int retArrJ=array.length - 1;
        for (Tile[] srI : array) {
            for (Tile srJ : srI)
                retArr[retArrI++][retArrJ]=srJ;
            retArrI=0;
            retArrJ--;
        }
        return retArr;
    }

    public boolean canMove() {
//        Согласно правилам игры ход возможен, если на игровом поле есть хотя бы одна свободная клетка,
//        и если есть плитки, соприкасающиеся друг с другом и при этом к тому же имеющие одинаковые значения :=)
        boolean flag=false;

        for (Tile[] tl : gameTiles) {
            for (Tile tile : tl) {
                if (tile.value == 0)
                    flag=true;
            }

        }


        for (int i=0; i < FIELD_WIDTH - 1; i++) {
            for (int j=0; j < FIELD_WIDTH - 1; j++) {

                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    flag=true;

                }
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    flag=true;
                }

            }


        }

        return flag;
    }

    public void randomMove() {

        int n=( (int) ( Math.random() * 100 ) ) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }

    }

    public boolean hasBoardChanged() {// меняет ли ход состояние игрового поля?
        Tile[][] tl=previousStates.peek();
        int summeGameTiles=0;
        int summePreviousState=0;

        for (int i=0; i < FIELD_WIDTH; i++) {
            for (int j=0; j < FIELD_WIDTH; j++) {
                summeGameTiles+=gameTiles[i][j].value;
                summePreviousState+=tl[i][j].value;
            }

        }

        return summeGameTiles != summePreviousState;

    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()) moveEfficiency=new MoveEfficiency(getEmptyTiles().size(), score, move); // если поле меняется
//        тогда создаем
        else moveEfficiency=new MoveEfficiency(-1, 0, move);
        rollback();

        return moveEfficiency;
    }


    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.add( getMoveEfficiency( this::left));
        priorityQueue.add( getMoveEfficiency( this::right));
        priorityQueue.add( getMoveEfficiency( this::up));
        priorityQueue.add( getMoveEfficiency( this::down));
        Move move = priorityQueue.peek().getMove();
        move.move();

    }
}









