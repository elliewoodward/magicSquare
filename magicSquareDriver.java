import java.io.IOException;

public class magicSquareDriver {
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        if(args.length > 0){
            switch(args[0]){
                case "-create":

                MagicSquare newSquare = new MagicSquare(args[1], Integer.parseInt(args[2]));
                System.out.println(newSquare);
                break;

                case "-check":
                MagicSquare newMagicSquare = new MagicSquare(args[1]);
                System.out.println(newMagicSquare);
                break;

                default:
                System.out.println("Wrong order of commands");
                break;
            }
            System.out.println("Bye Bye!!");
        }
    }
}
