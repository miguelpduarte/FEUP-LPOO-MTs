//package recipes;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class RecipesTests {
	// auxiliary methods
		private void fieldsArentPublic(Class<?> ... classes) {
			for (Class<?> c: classes)
				for (Field f : c.getDeclaredFields())
					assertFalse(Modifier.isPublic(f.getModifiers()));
		}	
		private void isAbstract(Class<?> c) {
			assertTrue(Modifier.isAbstract(c.getModifiers()));
		}
	
    @Test
    public void testIngredient() {
        SimpleIngredient apple = new SimpleIngredient("apple");
        SimpleIngredient milk = new SimpleIngredient("milk");
        
        assertEquals("apple", apple.getName());
        assertEquals("milk", milk.getName());
        fieldsArentPublic(SimpleIngredient.class);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIngredientName() {
        new SimpleIngredient(null);
    }

    @Test
    public void testStep() {
        RecipeStep slice = new RecipeStep("mixed fruits", "slice");
        assertEquals("mixed fruits", slice.getName());
        assertEquals("slice", slice.getAction());
        
        try {
        	new RecipeStep(null, "slice");
        	fail("Constructor has null argument");
        } catch (IllegalArgumentException e) {
        	// exception thrown!
        }
        
        try {
        	new RecipeStep("mixed fruits", null);
        	fail("Constructor has null argument");
        } catch (IllegalArgumentException e) {
        	// exception thrown!
        } 
        
        fieldsArentPublic(RecipeStep.class);
    }
    
    @Test
    public void testEquals() {
    	SimpleIngredient a = new SimpleIngredient("flower");
    	SimpleIngredient b = new SimpleIngredient("flower");
    	SimpleIngredient c = new SimpleIngredient("rice");
    	assertFalse(a.equals(c));
    	assertFalse(a.equals((Object)c));
		assertTrue(a.equals(b)); 
		assertTrue(a.equals((Object)b));		
    }
    
    @Test
    public void testRecipeStepIngredients() {
        SimpleIngredient apple = new SimpleIngredient("apple");
        SimpleIngredient orange = new SimpleIngredient("orange");
        SimpleIngredient milk = new SimpleIngredient("milk");
        
        RecipeStep mixedFruits = new RecipeStep("mixed fruits", "slice");
        mixedFruits.addIngredient(apple, 1.4f);
        mixedFruits.addIngredient(orange, 0.7f);
       
        assertEquals(2, mixedFruits.getIngredientCount());
        mixedFruits.addIngredient(apple, 0.3f);
        assertEquals(2, mixedFruits.getIngredientCount());
        
        assertEquals(1.4f, mixedFruits.getQuantity(apple), 0);
        assertEquals(0.7f, mixedFruits.getQuantity(orange), 0);
        assertEquals(0f, mixedFruits.getQuantity(milk), 0);
    }

    @Test
    public void testOvenStep() {
        SimpleIngredient pizza = new SimpleIngredient("pizza");
        
        OvenStep bake = new OvenStep("hot pizza", "bake", 220);
        bake.addIngredient(pizza, 1);
        
        assertEquals("hot pizza", bake.getName());        
        assertEquals("bake", bake.getAction());        
        assertEquals(220, bake.getTemperature());      
        
        fieldsArentPublic(OvenStep.class);
    }

    @Test
    public void testQuantities() {
        Ingredient apple = new SimpleIngredient("apple");
        Ingredient orange = new SimpleIngredient("orange");
        Ingredient sugar = new SimpleIngredient("sugar");

        RecipeStep mixedFruits = new RecipeStep("mixed fruits", "slice");
        mixedFruits.addIngredient(apple, 1.3f);
        mixedFruits.addIngredient(orange, 0.9f);

        RecipeStep sweetFruits = new RecipeStep("sweet fruits", "mix");
        sweetFruits.addIngredient(mixedFruits, 1);
        sweetFruits.addIngredient(sugar, .3f);

        assertEquals(1.3f, mixedFruits.getQuantity(apple), 0);
        assertEquals(0.9f, mixedFruits.getQuantity(orange), 0);

        assertEquals(1, sweetFruits.getQuantity(mixedFruits), 0);
        assertEquals(.3f, sweetFruits.getQuantity(sugar), 0);
        
        fieldsArentPublic(Ingredient.class);
        isAbstract(Ingredient.class);
    }

    @Test
    public void testTotalQuantities() {
        SimpleIngredient apple = new SimpleIngredient("apple");
        SimpleIngredient orange = new SimpleIngredient("orange");
        SimpleIngredient sugar = new SimpleIngredient("sugar");

        RecipeStep mixedFruits = new RecipeStep("mixed fruits", "slice");
        mixedFruits.addIngredient(apple, 1.1f);
        mixedFruits.addIngredient(orange, 0.5f);

        RecipeStep sweetFruits = new RecipeStep("sweet fruits", "mix");
        sweetFruits.addIngredient(mixedFruits, 2);
        sweetFruits.addIngredient(sugar, .3f);

        assertEquals(2.2f, sweetFruits.getQuantity(apple), 0);
        assertEquals(1.0f, sweetFruits.getQuantity(orange), 0);
    }

    @Test
    public void testToString() {
        SimpleIngredient apple = new SimpleIngredient("apple");
        SimpleIngredient orange = new SimpleIngredient("orange");
        SimpleIngredient sugar = new SimpleIngredient("sugar");

        RecipeStep mixedFruits = new RecipeStep("mixed fruits", "slice");
        mixedFruits.addIngredient(apple, 1.2f);
        mixedFruits.addIngredient(orange, 0.8f);

        RecipeStep sweetFruits = new RecipeStep("sweet fruits", "mix");
        sweetFruits.addIngredient(mixedFruits, 2);
        sweetFruits.addIngredient(sugar, .3f);

        assertEquals("apple", "" + apple);
        assertEquals("orange", "" + orange);
        assertEquals("sugar", "" + sugar);
        
        // ingredients always come in alphabetical order
        assertEquals("to make mixed fruits, slice 1.2 apple, 0.8 orange", "" + mixedFruits);
        assertEquals("to make sweet fruits, mix 2.0 mixed fruits, 0.3 sugar", "" + sweetFruits);
    }

    @Test 
    public void testRecipe() {
    	SimpleIngredient cheese = new SimpleIngredient("cheese");
        SimpleIngredient ham = new SimpleIngredient("ham");
        SimpleIngredient bread = new SimpleIngredient("bread");
        SimpleIngredient sauce = new SimpleIngredient("francesinha sauce");
        SimpleIngredient olive = new SimpleIngredient("olive");
        SimpleIngredient toothPick = new SimpleIngredient("tooth pick");

        RecipeStep sandwich = new RecipeStep("mixed sandwich", "stack");
        sandwich.addIngredient(cheese, 1);
        sandwich.addIngredient(ham, 1);
        sandwich.addIngredient(bread, 2);

        RecipeStep grill = new OvenStep("grilled mixed sandwich", "grill", 250);
        grill.addIngredient(sandwich, 1);
        grill.addIngredient(sauce, 0.2f);
        
        RecipeStep decorate = new RecipeStep("decorated grilled mixed sandwich", "decorate");
        decorate.addIngredient(olive, 1);
        decorate.addIngredient(toothPick, 1);
	
        Recipe recipe1 = new Recipe("tosta mista especial");
        
        fieldsArentPublic(Recipe.class);
        
        assertEquals(0, recipe1.getStepCount());
        
        recipe1.addStep(sandwich);
        recipe1.addStep(grill);
        
        assertEquals(2, recipe1.getStepCount());
        
        recipe1.addStep(decorate);
        
        assertEquals(3, recipe1.getStepCount());
        
        recipe1.addStep(decorate);
        
        assertEquals(3, recipe1.getStepCount());

        // printout ingredients sorted by their names (alphabetically)
        
        TreeSet<Ingredient> ss = new TreeSet<Ingredient>();
        ss.add(cheese);
        ss.add(ham);
        ss.add(bread);
        ss.add(olive);
        ss.add(sauce);
        ss.add(toothPick);
        
        String s = "";
        Iterator<Ingredient> i = ss.iterator();
        while (i.hasNext()) {
        	s += "[" + i.next().getName() + "]";
        }
        
        assertEquals("[bread][cheese][francesinha sauce][ham][olive][tooth pick]",s);
    }

}
