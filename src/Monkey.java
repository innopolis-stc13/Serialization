import java.util.Objects;

public class Monkey {

    private String name;
    private String specied;
    private int age;
    private int weight;
    private int tailLenght;
    private boolean presenceOfChildren;


    public Monkey(String name, String specied, int age, int weight, int tailLenght, boolean presenceOfChildren) {
        this.name = name;
        this.specied = specied;
        this.age = age;
        this.weight = weight;
        this.tailLenght = tailLenght;
        this.presenceOfChildren = presenceOfChildren;
    }

    public Monkey() { }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", specied='" + specied + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monkey monkey = (Monkey) o;
        return Objects.equals(name, monkey.name) &&
                Objects.equals(specied, monkey.specied);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specied);
    }
}
