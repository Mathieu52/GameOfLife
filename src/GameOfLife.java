import lib.console.Console;

public class GameOfLife
{
    public static void main(String[] args) {
        new GameOfLife(100, 70);
    }

    boolean[][] lifeBoard;
    public GameOfLife(int xZ, int yZ) {
        lifeBoard = new boolean[xZ][yZ];
        fillBoard(50);
        Console c = new Console();
        c.calibrate();
        //System.out.println("Test");
        //updateBoard();
        while(true) {
            c.clear();
            updateBoard();
            displayBoard();
            c.delay(50);
        }

        //while(true) {
            //System.out.println("Test2");
            //updateBoard();
            //displayBoard();
       //}
    }

    //Randomly fill lifeBoard
    public void fillBoard(int fillPourcentage) {

        for (int i = 0; i < lifeBoard.length; i++)
            for (int j = 0; j < lifeBoard[0].length; j++)
                lifeBoard[i][j] = Math.random()*100.0 < fillPourcentage;

    }

    //Updates our lifeBoard
    public void updateBoard() {

        //Copy our last board
        boolean[][] lastBoard = new boolean[lifeBoard.length][lifeBoard[0].length];
        for (int i = 0; i < lastBoard.length; i++)
            for (int j = 0; j < lastBoard[0].length; j++)
                lastBoard[i][j] = lifeBoard[i][j] ? true : false;

        int neighbour = 0;


        //Float.NaN;

        for (int x = 0; x < lifeBoard.length; x++) {
            for (int y = 0; y < lifeBoard[0].length; y++) {

                neighbour = 0;
                for (int xx = x - 1; xx <= x + 1; xx++) {
                    for (int yy = y - 1; yy <= y + 1; yy++) {

                        if (!((xx==x)&&(yy==y)) && xx >= 0 && xx < lifeBoard.length && yy >= 0 && yy < lifeBoard[0].length) {
                            neighbour += lastBoard[xx][yy] ? 1 : 0;
                        }
                    }
                }

                if (lastBoard[x][y]) {
                    if (neighbour < 2 || neighbour > 3) {
                        lifeBoard[x][y] = false;
                    }
                } else if (neighbour == 3) {
                    lifeBoard[x][y] = true;
                }

            }
        }

    }

    public void displayBoard() {
        //System.out.print("\f");
        //System.console().
        //for(int i=0; i<25; i++)
            //System.out.println();
        String line = "";
        for (int y = 0; y < lifeBoard[0].length; y++) {
            line = "";
            for (int x = 0; x < lifeBoard.length; x++)
                //█
                //□
                line += lifeBoard[x][y] ? "██" : "  ";
            System.out.println(line);
        }
    }
}
