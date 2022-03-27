import java.util.*;

public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Set<Intersection> intersectionSet = new HashSet<>();


    public Street(String name){
        this.name = name;
    }

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Set<Intersection> getIntersectionSet() {
        return intersectionSet;
    }

    public void setIntersectionSet(Set<Intersection> intersection) {
        this.intersectionSet = intersection;
    }

    @Override
    public int compareTo(Street other) {
        if (this.length == other.length) {
            return 0;
        } else if (this.length > other.length) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return name;
    }
}
