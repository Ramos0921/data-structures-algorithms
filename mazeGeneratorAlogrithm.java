/**
 * RamosMazeGen is a program that will create a maze.
 * The maze is created utlizing a recursive algorithm.
 * Completion time: 7 hours
 *
 * @author Eduardo Ramos, Acuna
 * @version 1.0, 1/16/2021
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RamosMazeGen
{
    //standard console size in characters.
    private static final int LEVEL_HEIGHT = 25;
    private static final int LEVEL_WIDTH = 80;

    private static final char ICON_WALL = '#';
    private static final char ICON_BLANK = ' ';

    /**
     * Returns a 2D array containing a statically created maze with dimentions 80x24.
     *
     * @return     2D array containing a maze
     */
    private static char[][] makeMazeStatic()
    {
        //the following maze was generated with the recursive division method and then modified by hand.

        char level[][] =
        {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

        return level;
    }

    /**
     * Creates a random maze in a 2D array.
     *
     * @see <a href="http://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_division_method">Recursive_division_method</a>
     * @return 2D array containing a maze
     */
    private static char[][] makeMaze()
    {
        char level[][] = createBlankLevel();

        makeMazeRecursive(level, 1, 1, LEVEL_WIDTH-2, LEVEL_HEIGHT-2); //TODO: may need to change but probably not.

        return level;
    }

    /**
     * Creates an empty level of standard level height and width. Level will be
     * blank but bordered with wall characters.
     *
     * @return  2D array containing a maze
     */
    private static char[][] createBlankLevel()
    {
        char level[][] = new char[LEVEL_HEIGHT][LEVEL_WIDTH];

        //reset level to be entirely blank
        for (int y = 0; y < LEVEL_HEIGHT; y++)
            for (int x = 0; x < LEVEL_WIDTH; x++)
                level[y][x] = ' ';

        //top barrier
        for (int x = 0; x < LEVEL_WIDTH; x++)
            level[0][x] = ICON_WALL;

        //bottom barrier
        for (int x = 0; x < LEVEL_WIDTH; x++)
            level[LEVEL_HEIGHT-1][x] = ICON_WALL;

        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++)
            level[y][0] = ICON_WALL;

        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++)
            level[y][LEVEL_WIDTH-1] = ICON_WALL;

        return level;
    }

    private static void makeMazeRecursive(char[][]level, int startX, int startY, int endX, int endY)
    {
        //base case
        if(((endX-startX) > 3) && ((endY-startY) > 3)){
            //Conditional insures endpoints are always greater than start points.
            if( (endY>startY) && (endX>startY)){
                //create randome variables x and y
                //use java.util.concurrent.ThreadLocalRandom for practice
                int randomX = ThreadLocalRandom.current().nextInt(startX, (endX-1))+1;
                int randomY = ThreadLocalRandom.current().nextInt(startY, (endY-1))+1;
                //create horizontal wall
                for(int i = startX; i <= endX; i++){
                    //conditional check to ensure no parallel walls are added or walles in the same x-axis
                    if((level[randomY][i] != ICON_WALL) && (level[randomY+1][i] != ICON_WALL) && (level[randomY-1][i] != ICON_WALL)){
                        //add wall icon
                        level[randomY][i] = ICON_WALL;
                    }
                }
                //create vertical wall
                for(int j = startY; j <= endY; j++){
                    //conditional check to ensure no parallel walls are added or walles in the same x-axis
                    if((level[j][randomX] != ICON_WALL) && (level[j][randomX+2] != ICON_WALL) && (level[j][randomX+1] != ICON_WALL) && (level[j][randomX-2] != ICON_WALL) && (level[j][randomX-1] != ICON_WALL)){
                        //add wall icon
                        level[j][randomX] = ICON_WALL;
                    }
                }
                /********** Random door selection ************************/
                //calculate wall lengths;
                int wallOneLen = randomX - startX;
                int wallTwoLen = randomY - startY;
                int wallThreeLen = endX - randomX;
                int wallFourLen = endY - randomY;
                //generate a random variable this time using a Random class
                Random rand = new Random();
                int wallPicker = rand.nextInt(4);
                //if wallPicker equal 0: walls: 1 2 3 will get a door
                //if one of the wall lengths is less than 3 wall 4 will get a wall
                if(wallPicker == 0){
                    //counter keeps track of door generated
                    int countA = 0;
                    if(wallOneLen > 3){
                        countA++;
                        //create random number for a door this time using Math.random
                        int door = (int)(Math.random() * ((randomX-2) - (startX +1)) + (startX+1));
                        //add door
                        level[randomY][door] = ICON_BLANK;
                    }
                    if(wallTwoLen > 3){
                        countA++;
                        //create random number for a door this time using Math.random
                        int doorTwo = (int)(Math.random() * ((randomY-1) - (startY +1)) + (startY+1));
                        //add door
                        level[doorTwo][randomX] = ICON_BLANK;
                    }
                    if(wallThreeLen > 3){
                        countA++;
                        //create random number for a door this time using Math.random
                        int doorThree = (int)(Math.random() * ((endX-1) - (randomX +2)) + (randomX+2));
                        //add door
                        level[randomY][doorThree] = ICON_BLANK;
                    }
                    //if few than 3 doors have been created and the length of wall 3 add door
                    if((countA < 3) && (wallFourLen > 3)){
                        int doorFour = (int)(Math.random() * ((endY-1) - (randomY +1)) + (randomY+1));
                        level[doorFour][randomX] = ICON_BLANK;
                    }
                }
                if(wallPicker == 1){
                    int countB = 0;
                    if(wallTwoLen > 3){
                        countB++;
                        int doorTwo = (int)(Math.random() * ((randomY-1) - (startY +1)) + startY);
                        level[doorTwo][randomX] = ICON_BLANK;
                    }
                    if(wallThreeLen > 3){
                        countB++;
                        int doorThree = (int)(Math.random() * ((endX-1) - (randomX +2)) + randomX);
                        level[randomY][doorThree] = ICON_BLANK;
                    }
                    if(wallFourLen > 3){
                        countB++;
                        int doorFour = (int)(Math.random() * ((endY-1) - (randomY +1)) + randomY);
                        level[doorFour][randomX] = ICON_BLANK;
                    }

                    if((countB < 3) && (wallOneLen > 3)){
                        int door = (int)(Math.random() * ((randomX-2) - (startX +1)) + startX);
                        level[randomY][door] = ICON_BLANK;
                    }
                }
                if(wallPicker == 2){
                    int countC=0;
                    if(wallThreeLen > 3){
                        countC++;
                        int doorThree = (int)(Math.random() * ((endX-1) - (randomX +2)) + (randomX+2));
                        level[randomY][doorThree] = ICON_BLANK;
                    }
                    if(wallFourLen > 3){
                        countC++;
                        int doorFour = (int)(Math.random() * ((endY-1) - (randomY +1)) + (randomY+1));
                        level[doorFour][randomX] = ICON_BLANK;
                    }
                    if(wallOneLen > 3){
                        countC++;
                        int door = (int)(Math.random() * ((randomX-2) - (startX +1)) + (startX+1));
                        level[randomY][door] = ICON_BLANK;
                    }
                    if((countC < 3) && (wallTwoLen > 3)){
                        int doorTwo = (int)(Math.random() * ((randomY-1) - (startY +1)) + (startY+1));
                        level[doorTwo][randomX] = ICON_BLANK;
                    }
                }
                if(wallPicker == 3){
                    int countD=0;
                    if(wallFourLen > 3){
                        countD++;
                        int doorFour = (int)(Math.random() * ((endY-1) - (randomY +1)) + (randomY+1));
                        level[doorFour][randomX] = ICON_BLANK;
                    }
                    if(wallOneLen > 3){
                        countD++;
                        int door = (int)(Math.random() * ((randomX-2) - (startX +1)) + (startX+1));
                        level[randomY][door] = ICON_BLANK;
                    }
                    if(wallTwoLen > 3){
                        countD++;
                        int doorTwo = (int)(Math.random() * ((randomY-1) - (startY +1)) + startY);
                        level[doorTwo][randomX] = ICON_BLANK;
                    }
                    if((countD < 3) && (wallThreeLen > 3)){
                        int doorThree = (int)(Math.random() * ((endX-1) - (randomX +2)) + (randomX+2));
                        level[randomY][doorThree] = ICON_BLANK;
                    }
                }
                //northwest box
                makeMazeRecursive(level, startX, startY, randomX-1, randomY-1);
                //northeast box
                makeMazeRecursive(level, randomX+1, startY, endX, randomY-1);
                // //southwest box
                makeMazeRecursive(level, startX, randomY+1, randomX-1, endY);
                // //south box
                makeMazeRecursive(level, randomX+1, randomY+1, endX, endY);
            }
        }else{
            return;
        }
    }

    /**
     * Displays a level in the console.
     *
     * @param level  2D array containing a maze
     */
    private static void drawLevel(char[][] level)
    {
        int y, x;

        for (y = 0; y < LEVEL_HEIGHT; y++)
        {
            for (x = 0; x < LEVEL_WIDTH; x++)
                System.out.print(level[y][x]);
            System.out.println();
        }
    }

    /**
     * Entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //show static maze (uncomment for sample output)
        //drawLevel(makeMazeStatic());
        //show recursive maze
       drawLevel(makeMaze());
    }
}