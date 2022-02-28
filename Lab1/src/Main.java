import java.util.Random;

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

    public static String createRandomWord(int len, char[] alphabet){
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }

    public static void main(String[] args) {
//        int n = randomNr();
//        int newN = calculateN(n);
//        int result = sumOfDigits(newN);
//        System.out.println(n);
//        System.out.println(newN);
//        System.out.println(result);
//        magicMessage(result);
        long start = System.nanoTime();
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int len = args.length - 2;
        char alphabet[] = new char[len];
        for(int i = 2 ;i< args.length;i++){
            alphabet[i-2] = args[i].charAt(0);
            if (!Character.isLetter(alphabet[i-2])) {
                throw new IllegalArgumentException("Nu este litera");
            }
        }
        String words[] = new String[n];
        for (int i = 0; i < n ; i++) {
            words[i] = createRandomWord(m,alphabet);
        }
        String vecini[][] = new String[n][n-1];
        boolean mat[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ok = 0;
                for (int z = 0; z < len; z++) {
                    if (words[i].charAt(z) == words[j].charAt(z)) {
                        ok++;
                        break;
                    }
                }
                mat[i][j] = mat[j][i] = (ok==1);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j]){
                    vecini[i][count]= words[j] + " ";
                    count++;
                }
                if (count > max){
                    max = count;
                }
            }
        }
        for(int i =0; i< n; i++){
            System.out.println("Vecinii cuvantului " + words[i] + " sunt: ");
            for (int j = 0; j < max; j++) {
                System.out.print(vecini[i][j]);
            }
            System.out.println();
        }
        long end= System.nanoTime();
        System.out.println("Timpul de executie este: "+ (end-start)+" nanosecunde");
    }

}
