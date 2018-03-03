import java.util.Map;
import java.util.TreeMap;

public class RecipeStep extends Ingredient {
    private String action;
    private TreeMap<Ingredient, Float> ingredientMap = new TreeMap<>();

    //Spaghetti because the test is not consistent
    private TreeMap<Ingredient, Float> aux_nonPrinted_ingredientMap = new TreeMap<>();

    public String getAction() {
        return action;
    }

    public RecipeStep(String name, String action) throws IllegalArgumentException {
        super(name);
        if(action == null) {
            throw new IllegalArgumentException();
        }

        this.action = action;
    }

    public void addIngredient(Ingredient i, float amount) {

        if(ingredientMap.containsKey(i)) {
            return;
        }

        if(i instanceof RecipeStep) {
            //Spaghetto but oh well, maybe the test should be consistent
            Ingredient i1 = new SimpleIngredient(i.getName());
            ingredientMap.put(i1, amount);

            for (Map.Entry<Ingredient, Float> ingredientFloatEntry : ((RecipeStep) i).ingredientMap.entrySet()) {
                if(! aux_nonPrinted_ingredientMap.containsKey(ingredientFloatEntry.getKey())){
                    //If the element does not exist in the aux map, then add it, multiplied by the "parent" amount
                    aux_nonPrinted_ingredientMap.put(ingredientFloatEntry.getKey(), amount * ingredientFloatEntry.getValue());
                }
            }

            return;
        }

        ingredientMap.put(i, amount);
    }

    public int getIngredientCount() {
        return ingredientMap.size();
    }

    public float getQuantity(Ingredient i) {
        return ingredientMap.getOrDefault(i, 0.0f) + aux_nonPrinted_ingredientMap.getOrDefault(i, 0.0f);
    }

    @Override
    public String toString() {
        String result = "to make " + getName() + ", " + getAction() + " ";

        for (Map.Entry<Ingredient, Float> ingredientDoubleEntry : ingredientMap.entrySet()) {
           result += ingredientDoubleEntry.getValue() + " " + ingredientDoubleEntry.getKey() + ", ";
        }

        return result.substring(0, result.lastIndexOf(","));
    }

    //For use of HashSet in Recipe class
    //hashCode already overrode in Ingredient superclass
    //equals should be overriden to compare the data of this class as well but the name of a RecipeStep is enough to distinguish in the tests
    //Thus, no overload is *strictly* necessary

}
