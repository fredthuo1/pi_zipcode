// Jenkins test
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

        // These are initial variables used for the formula
        // They are static because they are accessed by different methods
        static final BigInteger TWO = BigInteger.valueOf(2) ;
        static final BigInteger THREE = BigInteger.valueOf(3) ;
        static final BigInteger FOUR = BigInteger.valueOf(4) ;
        static final BigInteger SEVEN = BigInteger.valueOf(7) ;

        static BigInteger q = BigInteger.ONE ;
        static BigInteger r = BigInteger.ZERO ;
        static BigInteger t = BigInteger.ONE ;
        static BigInteger k = BigInteger.ONE ;
        static BigInteger n = BigInteger.valueOf(3) ;
        static BigInteger l = BigInteger.valueOf(3) ;
        static int count;

        // Takes in zip as an input
        // Calculates pi digits
        // Looks for the digits in pi
        public static String calcPiDigits(char c ){
            BigInteger nn, nr ;
            int i = 0;
            ArrayList arr = new ArrayList(100000);
            boolean first = true ;
            while( true){
                if(FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1){
                    count++;
                    if (count == 1000000) {
                        System.exit(1);
                    }
                    
                    if (n.intValue() == Character.getNumericValue(c)) {
                        System.out.println(Character.getNumericValue(c) + " was found at #" + count);
                        return (Character.getNumericValue(c) + " was found at #" + count);
                    }

                    if(first){System.out.print("") ; first = false ;}
                    nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t))) ;
                    n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n)) ;
                    q = q.multiply(BigInteger.TEN) ;
                    r = nr ;
                    System.out.flush() ;
                }else{
                    nr = TWO.multiply(q).add(r).multiply(l) ;
                    nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l)) ;
                    q = q.multiply(k) ;
                    t = t.multiply(l) ;
                    l = l.add(TWO) ;
                    k = k.add(BigInteger.ONE) ;
                    n = nn ;
                    r = nr ;
                }
            }
        }
        // Gets input from the user and validates the input
        static int scan() {
            Scanner scanner = new Scanner(System.in);
            boolean validInput = false;
            int zip = 0;
            System.out.println("Enter zip code: ");
            while (!validInput) {
                try {
                    zip  = scanner.nextInt();
                    validInput = true;
                } catch ( InputMismatchException e ) {
                    System.out.println("Wrong input type. Please enter an integer!");
                    scanner.next();
                }
            }
            return zip;
        }

        // Tests the input from user
        static void test() {
            int zip = scan();
            int length = (int) (Math.log10(zip) + 1);
            if ( length < 5 || length > 5 ) {
                System.out.println("Zip must have 5 digits! Try again: ");
                test();
            } else {
                char[] digitsAsChar = String.valueOf(zip).toCharArray();
                for ( int i = 0; i < digitsAsChar.length; i++ ) {
                    calcPiDigits(digitsAsChar[i]);
                }
            }
        }

        // Main method that runs the program
        public static void main(String[] args) {
            Main p = new Main() ;
            test();
        }

}
