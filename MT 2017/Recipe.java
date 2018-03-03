import java.util.HashSet;

public class Recipe {

    private HashSet<RecipeStep> recipeSteps = new HashSet<>();

    public Recipe(String name) {
        //Lol, not even a getName test
    }

    public int getStepCount() {
        return recipeSteps.size();
    }

    public void addStep(RecipeStep rs) {
        recipeSteps.add(rs);
    }
}
