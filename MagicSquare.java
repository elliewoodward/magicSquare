import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.sound.midi.Track;

public class MagicSquare implements MagicSquareInterface {
    private int dimension;
    private String fileName;
    private int[][] array;


    /* create a private void method outside of the constructor that 
     * will read through the file, and then make sure to run the 
     * method within the constructor
     */
    public MagicSquare(String file){
            this.fileName = fileName;
            File scanFile = new File(file);
            try{
                int[][] magicSquare = readMatrix(file);
                this.array = magicSquare;
            }

            //ask for help!
            catch(FileNotFoundException e){
                System.out.print("File Not Found");
            }
    }

    /*running the correct matrix*/
    public MagicSquare(String file, int dimension){
        createMagicSquare(file);
    }

    /* constructor to make the magic square, have algorithm from the
     * assignment, run the right matrix --> make a private void method 
     * for that. turn 2D array into file
     */
    public void createMagicSquare(String File){
        int n = dimension;
        int[][] array = new int[n][n];
        int row;
        int col;
        row = n - 1;
        col = n / 2;
        int oldrow;
        int oldcol;
        for(int i = 0; i < Math.pow(n, 2); i++){
            array[row][col] = i;
            oldrow = row;
            oldcol = col;
            row++;
            col++;
            if(row == n){
                n = 0;
            }
            if(col == n){
                n = 0;
            }
            if(array[row][col] != 0){
                row = oldrow;
                col = oldcol;
                row--;
            }
        }
    }


    /* this is the priavte void method that is being created to read 
     * through the file and then will be run in the magic square constructor
     */
    private int[][] readMatrix(String file){
        File scanFile = new File(file);
        int[][] magicSquare = new int[dimension][dimension];


             try{
                Scanner fileScan = new Scanner(scanFile);
                while(fileScan.hasNextLine()){
                    String line = fileScan.nextLine();
                    Scanner lineScan = new Scanner(line);
                    final String DELIMITERS = " ";
                    lineScan.useDelimiter(DELIMITERS);
                }
            }
            catch(FileNotFoundException e){
                System.out.print("File Not Found");
            }
            return magicSquare;
    }

    private void createMatrix(int[][] matrix, String filename){
        try{
            File file = new File(filename);
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (int i = 0; i < dimension; i++){
                pw.println();
                for(int j = 0; j < dimension; i++){
                    String value = String.valueOf(array[i][j]);
                    pw.print(value);
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("IOExeception");
        }

    }


    @Override
    public boolean isMagicSquare() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isMagicSquare'");
    }

    @Override
    public int[][] getMatrix() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMatrix'");
    }

}
