package br.net.godoy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by agodoy on 03/07/17.
 */
public class ProfitTest {
    private Profit profit;

    @Before
    public void setUp()
    {
        profit = new Profit();
        systemInMock.provideLines("10", "120000.0");
        profit.readInitialInputs();
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testReadInitialInputsShouldSetEmployersNumber() {
        assertEquals(10, profit.getEmployersNumber());
    }


    @Test
    public void testReadInitialInputsShouldSetProfitMargin() {
        assertEquals(120000.0, profit.getProfitMargin(), 0.0);
    }


    @Test
    public void testCalculateProfit() {
        systemInMock.provideLines("Trainee", "1");
        double profitResult = profit.calculateProfit();

        assertEquals(4800.0, profitResult, 0.0);
    }

    @Test
    public void testCalculateProfitWhenTotalProfitIsNotEnough() {
        systemInMock.provideLines("10", "99999.9");
        profit.readInitialInputs();

        systemInMock.provideLines("Trainee", "1");
        double profitResult = profit.calculateProfit();

        assertEquals(0.0, profitResult, 0.0);
    }


}