import java.util.Objects;

public abstract class Ingredient implements Comparable<Ingredient> {
    private String name;

    public String getName() {
        return name;
    }

    public Ingredient(String name) throws IllegalArgumentException {
        if(name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof SimpleIngredient) {
            return Objects.equals(((SimpleIngredient) o).getName(), this.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public int compareTo(Ingredient ingredient) {
        return this.name.compareTo(ingredient.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
