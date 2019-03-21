import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class LoanTest {


    @Rule
    public Timeout globalTimeout = Timeout.millis(900);

    @Test
    public void testLoanInstance()
    {
        Loan loan1 = new Loan(2600, 3);
        assertEquals(2600, loan1.getAmount(), 0);
        assertEquals(3, loan1.getPeriod());
    }

    //Positive Method Tests

    @Test
    public void monthlyPaymentTest()
    {
        Loan loan3 = new Loan(10000,5);
        assertEquals(175,loan3.getMonthlyPayment(),0);
    }

    @Test
    public void totalPaymentTest()
    {
        Loan loan1 = new Loan(2600, 3);
        assertEquals(2860, loan1.getTotalPayment(), 0);
    }

    //Positive Specification Tests

    @Test
    public void testCase1() {
        Loan loan = new Loan(2600, 3);
        assertEquals(2600, loan.getAmount(), 0);
        assertEquals(3,loan.getPeriod());
    }

    @Test
    public void testCase2() {
        Loan loan = new Loan(500, 1);
        assertEquals(500, loan.getAmount(), 0);
        assertEquals(1,loan.getPeriod());
    }

    @Test
    public void testCase3() {
        Loan loan = new Loan(10000, 5);
        assertEquals(10000, loan.getAmount(), 0);
        assertEquals(5,loan.getPeriod());
    }

    //Negative specification tests

    @Test (expected = IllegalArgumentException.class)
    public void testCase4() {
        Loan loan = new Loan(450, 3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase5() {
        Loan loan = new Loan(11250, 4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase6() {
        Loan loan = new Loan(0, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase7() {
        Loan loan = new Loan(800, -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase8() {
        Loan loan = new Loan(1200, 7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase9() {
        Loan loan = new Loan(499, 3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase10() {
        Loan loan = new Loan(10001, 4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase11() {
        Loan loan = new Loan(3200, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase12() {
        Loan loan = new Loan(4650, 6);
    }
}
