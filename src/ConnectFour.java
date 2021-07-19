import java.util.Scanner;
public class ConnectFour { // I am writing this comment to make a change

    public static void printBoard(char[][] array) {
        for (int i = array.length - 1; i >= 0; i--) { // using the -- it prints the board from the bottom being row 0

            for (int j = 0; j < array[0].length; j++) { // goes through the rows and other for loop goes through columns
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void initializeBoard(char[][] array) {
        for (int i = 0; i < array.length; i++) { // goes through the rows

            for (int j = 0; j < array[0].length; j++) { // then goes through columns to populate each spot in the array with '-'
                array[i][j] = '-';
            }
        }
    }




    public static int insertChip(char[][] array, int col, char chipType) {
        for(int i = 0; i < array.length; i++){ // this goes through the columns

            if(array[i][col] == '-'){ // goes through the row first and then the column
                array[i][col] = chipType;
                return i; // this returns the row it was on
            }
        }
        return -1;

    }



    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        int count = 0;

        for(int i = 0; i < array.length; i++){ // this checks the vertical win

            if(array[i][col]==chipType){
                count++;

                if(count==4){ // if there is 4 in a row it returns true
                    return true;
                }
            }
            else {
                count = 0; // when there is not 4 in a row it stays false
            }
        }

        count=0; // resets the count

        for(int i = 0; i < array[0].length; i++){ // checks for horizontal win

            if(array[row][i]==chipType){
                count++;

                if(count==4){
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        return false; // returns false if it doesnt meet count = 4 so it keeps the loop going
    }




    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int height; // acts as the rows
        int length; // acts as the columns

        System.out.print("What would you like the height of the board to be ? ");
        height = sc.nextInt();

        System.out.print("What would you like the length of the board to be ? ");
        length = sc.nextInt();


        char array[][] = new char[height][length]; // initializes the array using the height and length as parameters

        initializeBoard(array); // initializes the board with all -

        printBoard(array); // prints out the board after it was filled with -

        System.out.println("Player 1 : x"); // shows the players there chip

        System.out.println("Player 2 : o");

        boolean switchChip = true; // this switches the chip so that it goes back and forth

        char chipType;

        int col=0;

        int result=0;

        boolean win =false; // used to keep the loop going, checks if you win if not it is false, if you win it returns true and stops

        int draw = 0; // used to check if the game is a draw

        while(true){

            if(switchChip){

                System.out.print("Player 1: Which column would you like to choose?");

                chipType = 'x';

            }else{

                System.out.print("Player 2: Which column would you like to choose?");

                chipType = 'o';

            }

            col = sc.nextInt(); // sets the column number to what the player chooses

            result = insertChip(array,col,chipType); //inserts the chip and returns result to keep track of where at



            printBoard(array); // prints the board so you can see where you placed the chip

            win =checkIfWinner(array,col,result,chipType); // checks if you win

            if(win){

                if(switchChip){

                            System.out.print("Player 1 won the game!"); // if it comes back true it goes here

                }
                else {

                            System.out.print("Player 2 won the game!");

                }

                break;

            }

                    switchChip = !switchChip;

                    draw++;


            if(draw == height * length){ // checks if the game is a draw by comparing the amount of elements are in the array and how many times the game has gone through

                System.out.println("Draw. Nobody wins.");

                break;

            }

        }

    }
}


