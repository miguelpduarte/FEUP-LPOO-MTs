public class OvenStep extends RecipeStep {
    private int temperature;

    public OvenStep(String name, String action, int temperature) {
        super(name, action);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void addIngredient(SimpleIngredient si, int amount) {
    }
}
