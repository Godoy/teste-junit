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
public class CompanyTest {
    private Company company;

    @Before
    public void setUp()
    {
        company = new Company(10, 120000.0);
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void constructorShouldSetEmployersNumber() {
        assertEquals(10, company.getEmployersNumber());
    }


    @Test
    public void constructorShouldSetProfitMargin() {
        assertEquals(120000.0, company.getProfitMargin(), 0.0);
    }


    @Test
    public void testCalculateProfit() {
        systemInMock.provideLines("Trainee", "1");
        double profitResult = company.calculateProfit();

        assertEquals(4800.0, profitResult, 0.0);
    }

    @Test
    public void testCalculateProfitWhenTotalProfitIsNotEnough() {
        company = new Company(10, 99999.9);

        systemInMock.provideLines("Trainee", "1");
        double profitResult = company.calculateProfit();

        assertEquals(0.0, profitResult, 0.0);
    }


}