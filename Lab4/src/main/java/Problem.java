import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;
public class Problem {
    private List<Street> streetList = new LinkedList<>();
    private List<Intersection> intersectionList = new ArrayList<>();
    private Map<Street, Set<Intersection>> streets = new HashMap<>();
    private Map<Intersection, List<Street>> intersections = new HashMap<>();


    public Problem(){
        var nodes = IntStream.rangeClosed(0,9)
                .mapToObj(i -> new Intersection("i" + i) )
                .toArray(Intersection[]::new);
        var edges = IntStream.rangeClosed(0,16)
                .mapToObj(i -> new Street("s" + i) )
                .toArray(Street[]::new);
        edges[0].setLength(2);
        edges[1].setLength(3);
        edges[2].setLength(1);
        edges[3].setLength(1);
        edges[4].setLength(3);
        edges[5].setLength(3);
        edges[6].setLength(2);
        edges[7].setLength(2);
        edges[8].setLength(2);
        edges[9].setLength(1);
        edges[10].setLength(2);
        edges[11].setLength(2);
        edges[12].setLength(1);
        edges[13].setLength(2);
        edges[14].setLength(1);
        edges[15].setLength(1);

        nodes[0].setStreetList(Arrays.asList(edges[0],edges[6],edges[7]));
        nodes[1].setStreetList(Arrays.asList(edges[0],edges[1],edges[8]));
        nodes[2].setStreetList(Arrays.asList(edges[7],edges[8],edges[9],edges[10],edges[11]));
        nodes[3].setStreetList(Arrays.asList(edges[5],edges[6],edges[9]));
        nodes[4].setStreetList(Arrays.asList(edges[1],edges[2],edges[12],edges[13]));
        nodes[5].setStreetList(Arrays.asList(edges[4],edges[5],edges[10],edges[12]));
        nodes[6].setStreetList(Arrays.asList(edges[11],edges[14],edges[15]));
        nodes[7].setStreetList(Arrays.asList(edges[2],edges[3],edges[14]));
        nodes[8].setStreetList(Arrays.asList(edges[3],edges[4],edges[13],edges[15]));

        edges[0].setIntersectionSet(Set.of(nodes[0],nodes[1]));
        edges[1].setIntersectionSet(Set.of(nodes[2],nodes[3]));
        edges[2].setIntersectionSet(Set.of(nodes[5],nodes[8]));
        edges[3].setIntersectionSet(Set.of(nodes[7],nodes[8]));
        edges[4].setIntersectionSet(Set.of(nodes[5],nodes[8]));
        edges[5].setIntersectionSet(Set.of(nodes[3],nodes[5]));
        edges[6].setIntersectionSet(Set.of(nodes[0],nodes[3]));
        edges[7].setIntersectionSet(Set.of(nodes[0],nodes[2]));
        edges[8].setIntersectionSet(Set.of(nodes[1],nodes[2]));
        edges[9].setIntersectionSet(Set.of(nodes[2],nodes[3]));
        edges[10].setIntersectionSet(Set.of(nodes[2],nodes[5]));
        edges[11].setIntersectionSet(Set.of(nodes[2],nodes[6]));
        edges[12].setIntersectionSet(Set.of(nodes[4],nodes[5]));
        edges[13].setIntersectionSet(Set.of(nodes[4],nodes[8]));
        edges[14].setIntersectionSet(Set.of(nodes[6],nodes[7]));
        edges[15].setIntersectionSet(Set.of(nodes[6],nodes[8]));

        streetList.addAll(Arrays.asList(edges));
        intersectionList.addAll(Arrays.asList(nodes));
        for(Street street: streetList){
            streets.put(street, street.getIntersectionSet());
        }
        for(Intersection intersection: intersectionList){
            intersections.put(intersection,intersection.getStreetList());
        }
    }

    public Problem(int numberOfIntersections,int numberOfStreets){
        Faker faker = new Faker();
        Random value = new Random();
        
        var nodes = IntStream.rangeClosed(0,numberOfIntersections-1)
                .mapToObj(i -> new Intersection(faker.name().name()))
                .toArray(Intersection[]::new);
        var edges = IntStream.rangeClosed(0,numberOfStreets-1)
                .mapToObj(i -> new Street(faker.address().streetName()) )
                .toArray(Street[]::new);
        for (var edge : edges){
            edge.setLength(value.nextInt(1,6));
        }
        streetList.addAll(Arrays.asList(edges));
        intersectionList.addAll(Set.of(nodes));
        for(Street street: streetList){
            streets.put(street, street.getIntersectionSet());
        }
        for(Intersection intersection: intersectionList){
            intersections.put(intersection,intersection.getStreetList());
        }

        intersectionList.stream()
                .filter(v -> intersections.get(v).contains(edges));
            
    }

    public Map<Street, Set<Intersection>> getStreets() {
        return streets;
    }

    public Map<Intersection, List<Street>> getIntersections() {
        return intersections;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "streets=" + streets +
                ", intersections=" + intersections +
                '}';
    }
}
