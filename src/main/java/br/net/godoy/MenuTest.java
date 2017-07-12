package br.net.godoy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static junit.framework.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;


public class MenuTest {
    private Profit profit;
    private Menu menu;

    @Before
    public void setUp() {
        profit = new Profit(10, 900.0);
        menu = new Menu(profit);
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void testMenuOption1CallsCalculateProfit() {
        Profit profitMock = spy(profit);
        Menu mock = spy(new Menu(profitMock));

        systemInMock.provideLines("1");

        mock.show();
        verify(mock.profit).calculateProfit();
    }

    @Test
    public void testMenuOption2EndProgram() {
        Profit profitMock = spy(profit);
        Menu mock = spy(new Menu(profitMock));

        systemInMock.provideLines("2");
        mock.show();

        verify(mock.profit, never()).calculateProfit();
    }

    @Test
    public void testRunMenuGiveOptions() {
        systemOutRule.clearLog();

        menu.show();
        assertEquals("Menu\n1- Calcular participacao\n2- Sair\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
}