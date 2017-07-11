package br.net.godoy;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Created by agodoy on 03/07/17.
 */
public class ProfitTest {
    private Profit profit;

    @Before
    public void setUp()
    {
        profit = new Profit();
        systemInMock.provideLines("10", "900.0");
        profit.readInitialInputs();
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testReadInitialInputsShouldSetEmployersNumber() {
        assertEquals(10, profit.getEmployersNumber());
    }


    @Test
    public void testReadInitialInputsShouldSetProfitMargin() {
        assertEquals(900.0, profit.getProfitMargin(), 0.0);
    }

    @Test
    public void testRunMenuGiveOptions() {
        systemOutRule.clearLog();
        profit.runMenu();
        assertEquals("Menu\n1- Calcular participacao\n2- Sair\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
}