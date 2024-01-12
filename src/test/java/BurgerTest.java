import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final static double DELTA = 0.00;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;


    @Test
    public void checkSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertTrue(
                "Ингредиент не добавлен",
                burger.ingredients.contains(ingredient)
        );
    }

    @Test
    public void checkRemoveIngredient() {
        Burger burger = new Burger();
        List<Ingredient> ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void checkMoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", (float) 80.0);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Говяжий метеорит", (float) 3000.0);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient2);
        ingredients.add(ingredient);

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredients, burger.ingredients);

    }

    @Test
    public void checkGetPrice() {

        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(ingredient.getPrice()).thenReturn(1337f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(
                "Цена расчитывается некорректно",
                3313f,
                equalTo(burger.getPrice())
        );

    }


    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(bun.getName()).thenReturn("СмолТести");
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(1337f);
        Mockito.when(ingredient.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient i : ingredients) {
            receipt.append(String.format("= %s %s =%n", i.getType().toString().toLowerCase(),
                    i.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", 3313f));
        assertEquals(receipt.toString(), burger.getReceipt());
    }


}
