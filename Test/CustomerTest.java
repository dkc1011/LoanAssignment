import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.security.acl.Owner;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)
public class CustomerTest {

    @Test
    public void testCustomer() throws Exception{
        System.out.println("In test");

        Customer customer = new Customer();

        Loan mockLoan = EasyMock.createMock(Loan.class);

        PowerMock.expectNew(Loan.class,5000.00,5).andReturn(mockLoan);

        expect(mockLoan.getMonthlyPayment()).andReturn(96.66);

        PowerMock.replay(mockLoan, Loan.class);

        double expResult = 96.66;

        customer.takeoutloan();

        double result = customer.getMonthlypayments();

        assertEquals(expResult, result, 0.05);

        PowerMock.verify(mockLoan, Loan.class);
    }

}