import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters()
    public static Object[][] TypeName() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeIsCorrect() {

        MatcherAssert.assertThat("Отсутствует ингридиент " + type,
                IngredientType.valueOf(type.toUpperCase()).toString(),
                equalTo(type));
    }


}
