
import java.util.InputMismatchException;
import java.util.Scanner;
// CÓDIGO FONTE: https://stackoverflow.com/questions/35415733/how-to-throw-a-customized-inputmismatchexception-java
public class Input {
   
    
    public int getIntLoop() throws RuntimeException{
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nDigite um valor inteiro!");
            return -1;
        }
    }

    public Double getDouble() throws RuntimeException{
        try {
            Scanner input = new Scanner(System.in);
            return input.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("\nDigite um valor inteiro!");
        }
    }


    public int getInt() throws RuntimeException{
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("\nDigite um valor inteiro!");
        }
    }
    
    public String getString(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    
}