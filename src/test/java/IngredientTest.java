import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.core.IsEqual.equalTo;

public class IngredientTest {
    private Ingredient ingredient;
    private String name = "Говяжий метеорит";
    private IngredientType type = IngredientType.FILLING;
    private float price = 3000f;

    @Before
    public void prepareData() {
        this.ingredient = new Ingredient(
                type,
                name,
                price
        );
    }

    @Test
    public void checkGetPrice() {
        MatcherAssert.assertThat(
                "Неверная стоимость ингредиента",
                ingredient.getPrice(),
                equalTo(price)


        );
    }

    @Test
    public void checkGetName() {
        MatcherAssert.assertThat(
                "Неверное название ингредиента",
                ingredient.getName(),
                equalTo(name)
        );
    }

    @Test
    public void checkGetType() {
        MatcherAssert.assertThat(
                "Неверный тип ингредиента",
                ingredient.getType(),
                equalTo(type)
        );
    }

}
