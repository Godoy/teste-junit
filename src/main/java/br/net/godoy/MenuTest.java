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
    private Company company;
    private Menu menu;

    @Before
    public void setUp() {
        company = new Company(10, 900.0);
        menu = new Menu(company);
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void testMenuOption1CallsCalculateProfit() {
        Company companyMock = spy(company);
        Menu mock = spy(new Menu(companyMock));

        systemInMock.provideLines("1");

        mock.show();
        verify(mock.company).calculateProfit();
    }

    @Test
    public void testMenuOption2EndProgram() {
        Company companyMock = spy(company);
        Menu mock = spy(new Menu(companyMock));

        systemInMock.provideLines("2");
        mock.show();

        verify(mock.company, never()).calculateProfit();
    }

    @Test
    public void testRunMenuGiveOptions() {
        systemOutRule.clearLog();

        menu.show();
        assertEquals("Menu\n1- Calcular participacao\n2- Sair\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
}