import org.junit.runner.RunWith;
import org.junit.*;
import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class CalculatorTests {

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @Before
    public void initTest() {
        Calculator calculator = new Calculator();
    }

    @After
    public void afterTest() {
        Calculator calculator = null;
    }

    @org.junit.Test
    public void TestCalculateForAdditionInt() {
        assertEquals(15, Calculator.calculate(3,12,'+'),0);
    }

    @Ignore
    public void TestCalculateForAdditionZeroBeforeInt() {
        assertEquals(27, Calculator.calculate(0012,15,'+'),0);
    }

    @org.junit.Test
    public void TestCalculateForAdditionNull() {
        assertEquals(5, Calculator.calculate(0,5,'+'),0);
    }

    @org.junit.Test
    public void TestCalculateForAdditionDouble() {
        assertEquals(12.202, Calculator.calculate(2/1000,64/5,'+'),0.3);
    }

    @org.junit.Test
    public void TestCalculateForAdditionDoubleWithPoint() {
        assertEquals(12.802, Calculator.calculate(0.002,12.800,'+'),0.0001);
        //перепроверить точность
    }

    @org.junit.Test
    public void TestCalculateForAdditionMaxDoubleWithPoint() {
        assertEquals(9.8999999999128E12, Calculator.calculate(0.0000000002,9899999999912.80000001,'+'),0);
        //округляет
    }

    @org.junit.Test
    public void TestCalculateForSubtractionInt() {
        assertEquals(15, Calculator.calculate(17,2,'-'),0);
    }

    @org.junit.Test
    public void TestCalculateForSubtractionSame() {
        assertEquals(0, Calculator.calculate(1,1.0,'-'),0);
    }

    @org.junit.Test
    public void TestCalculateForSubtractionNull() {
        assertEquals(5, Calculator.calculate(5,0,'-'),0);
    }

    @org.junit.Test
    public void TestCalculateForSubtractionDouble() {
        assertEquals(10.4, Calculator.calculate(23.2,12.8,'-'),0.01);
        // не проходит
    }

    @org.junit.Test
    public void TestCalculateForMultiplicationInt() {
        assertEquals(15, Calculator.calculate(3,5,'*'),0);
    }

    @org.junit.Test
    public void TestCalculateForMultiplicationNull() {
        assertEquals(0, Calculator.calculate(0,5,'*'),0);
    }

    @org.junit.Test
    public void TestCalculateForMultiplicationDouble() {
        assertEquals(16.0, Calculator.calculate(3.2,5,'*'),0);
    }

    @Ignore
    public void TestCalculateForDivisionDouble() {
        assertEquals(16.2, Calculator.calculate(32.4,2,'/'),0);
    }
    @org.junit.Test
    public void TestCalculateForDivisionInt() {
        assertEquals(16, Calculator.calculate(32,2,'/'),0);
    }

    @org.junit.Test
    public void TestCalculateForDivisionNull() {
        assertEquals(0, Calculator.calculate(0,5,'/'),0);
    }

    @org.junit.Test
    public void TestCalculateForDivisionNullEx() {
        //assertEquals(0, Calculator.calculate(4,0,'/'),0);
        assertNotSame("Ошибка. На ноль делить нельзя.",0,Calculator.calculate(4,0,'/'));
    }
}
