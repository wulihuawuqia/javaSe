package value;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * program javaSe
 * <p>
 * description
 *
 * @author wuqia
 * @date 2022-04-04 21:13
 **/
public class DoubeTest {

    @Test
    public void floatTest() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999964
        System.out.println(a == b);// false
    }

    @Test
    public void bigDecimalTest() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x); /* 0.1 */
        System.out.println(y); /* 0.1 */
        System.out.println(Objects.equals(x, y)); /* true */
    }
}
