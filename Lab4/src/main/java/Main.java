import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        var nodes = IntStream.rangeClosed(0,9)
                .mapToObj(i -> new Intersection("i" + i) )
                .toArray(Intersection[]::new);
        Street s1 = new Street("s1", 2);
        Street s2 = new Street("s2", 2);
        Street s3 = new Street("s3", 2);
        Street s4 = new Street("s4", 3);
        Street s5 = new Street("s5", 1);
        Street s6 = new Street("s6", 2);
        Street s7 = new Street("s7", 2);
        Street s8 = new Street("s8", 2);
        Street s9 = new Street("s9", 3);
        Street s10 = new Street("s10", 1);
        Street s11 = new Street("s11", 3);
        Street s12 = new Street("s12", 1);
        Street s13 = new Street("s13", 1);
        Street s14 = new Street("s14", 2);
        Street s15 = new Street("s15", 1);
        Street s16 = new Street("s16", 1);


    }


}
