import java.util.*;

public class Intersection implements Comparable<Intersection> {
    private String name;
    private List<Street> streetList = new LinkedList<>();


    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Street> getIntersectionSet() {
        return streetList;
    }

    public void setStreetList(List<Street> street) {
        this.streetList = street;
    }

    public void orderByLength(){
        Collections.sort(streetList,
                ((u,v) -> u.compareTo(v)));
    }

    @Override
    public int compareTo(Intersection other) {
        return this.getName().compareTo(other.getName());
    }
    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }
}
