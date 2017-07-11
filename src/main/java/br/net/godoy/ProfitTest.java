package br.net.godoy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

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

    @Test
    public void testMenuOption1CallsCalculateProfit() {
        Profit mock = spy(new Profit());

        systemInMock.provideLines("1");

        mock.runMenu();
        verify(mock).calculateProfit();

    }


}