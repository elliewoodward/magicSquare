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
    private boolean magicList;
    private int magicNumber;

    /*
     * create a private void method outside of the constructor that
     * will read through the file, and then make sure to run the
     * method within the constructor
     */
    public MagicSquare(String file) throws FileNotFoundException {
        this.fileName = fileName;
        File scanFile = new File(file);
        int[][] magicSquare = readMatrix(file);
        this.array = magicSquare;

        this.magicNumber = (int) ((dimension)*(Math.pow((double) dimension, 2.0) + 1)/2);

    }

    /* running the correct matrix */
    public MagicSquare(String file, int dimension) {
        createMagicSquare(file);
        this.magicNumber = (int) ((dimension)*(Math.pow((double) dimension, 2.0) + 1)/2);
    }

    /*
     * constructor to make the magic square, have algorithm from the
     * assignment, run the right matrix --> make a private void method
     * for that. turn 2D array into file
     */
    public void createMagicSquare(String File) {
        int n = dimension;
        int[][] array = new int[n][n];
        int row;
        int col;
        row = n - 1;
        col = n / 2;
        int oldrow;
        int oldcol;
        for (int i = 1; i <= Math.pow(n, 2); i++) {
            array[row][col] = i;
            oldrow = row;
            oldcol = col;
            row++;
            col++;
            if (row == n) {
                n = 0;
            }
            if (col == n) {
                n = 0;
            }
            if (array[row][col] != 0) {
                row = oldrow;
                col = oldcol;
                row--;
            }
        }
    }

    /*
     * this is the priavte void method that is being created to read
     * through the file and then will be run in the magic square constructor
     */
    private int[][] readMatrix(String file) throws FileNotFoundException {
        File scanFile = new File(file);
        int[][] magicSquare = new int[dimension][dimension];
        Scanner fileScan = new Scanner(scanFile);
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            final String DELIMITERS = " ";
            lineScan.useDelimiter(DELIMITERS);
        }

        return magicSquare;
    }

    private void createMatrix(int[][] matrix, String filename) throws IOException {

        File file = new File(filename);
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        for (int i = 0; i < dimension; i++) {
            pw.println();
            for (int j = 0; j < dimension; i++) {
                String value = String.valueOf(array[i][j]);
                pw.print(value);
            }
        }
        pw.close();

    }

    @Override
    public boolean isMagicSquare() {
        this.magicList = true;

        for (int i = 0; i < dimension; i++) {
            int count = 0;

            for (int j = 0; j < dimension; j++) {
                count += array[i][j];
            }
            if(count != magicNumber){
                magicList = false;
            }

            for (int j = 0; j < dimension; j++) {
                count += array[j][i];
            }
            if(count != magicNumber){
                magicList = false;
            }
        }

        int count = 0;
        for(int i = 0; i< dimension; i++){
            count += array[i][i];
        }
        if(count != magicNumber){
            magicList = false;
        }
        for(int j = 0; j< dimension; j++){
            count += array[j][j];
        }
        if(count != magicNumber){
            magicList = false;
        }

        count = 0;
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j < dimension; j++){
                count += array[i][j];
            }
        }
        
        int test = 0;
        for(int i = 0; i < dimension*dimension; i++){
            test += i;
        }
        if(count != test){
            magicList = false;
        }

        return magicList;
    }

    @Override
    public int[][] getMatrix() {
        int[][] anotherArray = new int[dimension][dimension];
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                anotherArray[i][j] = array[i][j];
            }
        }
        return anotherArray;
    }

    @Override
    public String toString(){
        String newMatrix = "";
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                newMatrix += array[i][j];
            }
        }
        
        if(this.isMagicSquare()){
            newMatrix += "isMagicSquare";
        }
        else{
            newMatrix+= "isNotMagicSquare";
        }

        return newMatrix;
    }
}
