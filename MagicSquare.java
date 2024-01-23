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
        
        File scanFile = new File(file);
        int[][] magicSquare = readMatrix(file);
        this.array = magicSquare;
        
        this.magicNumber = (int) ((dimension)*(Math.pow((double) dimension, 2.0) + 1)/2);

    }

    /* running the correct matrix */
    public MagicSquare(String file, int n) throws IOException {
        if(n%2 == 1){
        
        this.magicNumber = (int) ((dimension)*(Math.pow((double) dimension, 2.0) + 1)/2);
        this.array = new int[n][n];
        int row;
        int col;
        row = n - 1;
        col = n / 2;
        int oldrow;
        int oldcol;
        for (int i = 1; i <= n*n; i++) {
            array[row][col] = i;
            oldrow = row;
            oldcol = col;
            row++;
            col++;
            if (row == n) {
                row = 0;
            }
            if (col == n) {
                col = 0;
            }
            if (array[row][col] != 0) {
                row = oldrow;
                col = oldcol;
                row--;
            }
        }
        writeMatrix(array, file);
    }
    }

    /*
     * constructor to make the magic square, have algorithm from the
     * assignment, run the right matrix --> make a private void method
     * for that. turn 2D array into file
     */
    

    /*
     * this is the priavte void method that is being created to read
     * through the file and then will be run in the magic square constructor
     */
    private int[][] readMatrix(String file) throws FileNotFoundException {
        File scanFile = new File(file);
    
        Scanner fileScan = new Scanner(scanFile);
        int n = Integer.parseInt(fileScan.nextLine());
        this.array = new int[n][n];
        int row = 0;
        while(fileScan.hasNextLine()){
            int col = 0;
            String newLine = fileScan.nextLine();
            Scanner lineScanner = new Scanner(newLine);

            while(lineScanner.hasNext()){
                array[row][col] = Integer.parseInt(lineScanner.next());
                col++;
            }
            row++;
        }
        return array;
    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException {

        int dimension = matrix.length;
        File file = new File(filename);
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        pw.print(dimension);
        for (int i = 0; i < dimension; i++) {
            pw.println();
            for (int j = 0; j < dimension; j++) {
                int value = array[i][j];
                pw.print(value);
                pw.print(" ");
            }
        }
        pw.close();

    }

    @Override
    public boolean isMagicSquare() {
        this.magicList = true;
        this.magicNumber = (int) ((dimension)*(Math.pow((double) dimension, 2.0) + 1)/2);

        int n = array.length;

        for (int i = 0; i < n; i++) {
            int test = 0;

            for (int j = 0; j < n; j++) {
                test += array[i][j];

            }
            if (test != magicNumber) {
                magicList = false;
            }

        }

        int testRight = 0;

        for (int i = 0; i < n; i++) {
            testRight += array[i][i];

        }
        if (testRight != magicNumber) {
            magicList = false;
        }

        int testLeft = 0;

        for (int i = n - 1; i >= 0; i--) {
            testLeft += array[i][i];

        }

        if (testLeft != magicNumber) {
            magicList = false;
        }

        int count = 0;
        for (int i = 0; i <= (n * n); i++) {
            count += i;
        }

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                counter += array[i][j];
            }
        }

        if (!(count == counter)) {
            magicList = false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (array[i][j] == array[i][j - 1]) {
                    magicList = false;
                }
            }
        }

        return magicList;

    }

    // preserves encapsulation by copying the magicsquare into a new array, then
    // returning that array
    public int[][] getMatrix() {
        int dimension = array.length;
        int[][] returnMatrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                returnMatrix[i][j] = array[i][j];
            }

        }

        return returnMatrix;
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
