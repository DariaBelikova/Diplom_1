import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final static double DELTA = 0.00;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"Флюоресцентная булка", 988},
                {"Краторная булка", 1255}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), DELTA);
    }


}
