import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class TestCalculate {

    private Calculator calculator;

    @BeforeTest
    public void init(){
         calculator = new Calculator();
    }

    public void emptyStringReturnsZero() throws Exception {
        assertEquals(calculator.calculate(""),0);
    }

    public void singleValueIsReplied() throws Exception {
        assertEquals(calculator.calculate("1"),1);
    }

    public void twoNumbersCommaDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2"),3);
    }

    public void twoNumbersNewLineDelimitedReturnsSum() throws Exception {
        assertEquals(calculator.calculate("1\n2"),3);
    }

    public void threeNumbersDelimitedBothWaysReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2,3"),6);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeInputReturnException() throws Exception {
        calculator.calculate("-1");
    }

    public void ignoresNumbersGreaerThan1000() throws Exception {
        assertEquals(calculator.calculate("10,10,1001"),20);
    }

}
