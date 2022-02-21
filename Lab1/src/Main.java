public class Main {
    public static void printHello(){
        System.out.println("Hello World!");
    }

    /**
     * method used to generate a random number
     * @return a random number
     */
    public static int randomNr(){
        return ((int) (Math.random()*1_000_000));
    }

    /**
     * method used to calculate a number n, multiplying it by 3, then adding the converted to integer result for binary number 10101 and hexadecimal number FF, multiplying it again by 6
     * @param n the number who will be modified
     * @return the result of the operations mentioned previously
     */
    public static int calculateN(int n){
        n=n*3+Integer.parseInt("10101",2)+Integer.parseInt("FF",16);
        n*=6;
        return n;
    }

    /**
     * method used to compute the sum of the digits until the result has one digit
     * @param n the number who will be modified
     * @return a singe digit number
     */
    public static int sumOfDigits(int n){
        int sum=0,aux=0;
        while(n>0){
            aux+=n%10;
            n/=10;
        }
        if(aux<10){
            return aux;
        }
        while(aux>9){
            sum+=aux%10;
            aux/=10;
        }
        sum+=aux;
        return sum;
    }

    /**
     * method used to display one string from the array of strings, with the given number
     * @param n the number who will pick which string will be selected
     */
    public static void magicMessage(int n){
        String languages [] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println("Willy-nilly, this semester I will learn "+ languages[n]);
    }

    public static void main(String[] args) {
        int n = randomNr();
        int newN = calculateN(n);
        int result = sumOfDigits(newN);
        System.out.println(n);
        System.out.println(newN);
        System.out.println(result);
        magicMessage(result);
    }
}
