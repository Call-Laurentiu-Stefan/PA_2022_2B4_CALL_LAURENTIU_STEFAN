import java.util.*;
import java.util.stream.IntStream;

public class Problem {
    private List<Street> streetList = new LinkedList<>();
    private Set<Intersection> intersectionSet = new HashSet<>();
    private Map<Street, List<Intersection>> streets = new HashMap<>();
    private Map<Intersection, List<Street>> intersections = new HashMap<>();


    public Problem(){
        var nodes = IntStream.rangeClosed(0,9)
                .mapToObj(i -> new Intersection("i" + i) )
                .toArray(Intersection[]::new);
        var edges = IntStream.rangeClosed(0,16)
                .mapToObj(i -> new Street("s" + i) )
                .toArray(Street[]::new);
        edges[0].setLength(0);
    }

}
