package br.net.godoy;


import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static junit.framework.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


public class UserInterfaceTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void readEmployersNumberShouldReturnAInteger() {
        UserInterface ui = new UserInterface();

        systemInMock.provideLines("3");
        int employersNumber = ui.readEmployersNumber();

        assertEquals(employersNumber, 3);
    }

    @Test
    public void readEmployersNumberShouldAskAgainUntilFindANumber() {
        UserInterface ui = new UserInterface();

        systemInMock.provideLines("asfasgwd", "efefefef", "125");
        int employersNumber = ui.readEmployersNumber();

        systemOutRule.clearLog();

        assertEquals(employersNumber, 125);
    }


    @Test
    public void readProfitMarginShouldReturnADouble() {
        UserInterface ui = new UserInterface();

        systemInMock.provideLines("980.5");
        double profitMargin = ui.readProfitMargin();

        assertEquals(profitMargin, 980.5);
    }

    @Test
    public void readProfitMarginShouldAskAgainUntilFindADouble() {
        UserInterface ui = new UserInterface();

        systemInMock.provideLines("abcd", "490.90");
        double profitMargin = ui.readProfitMargin();

        systemOutRule.clearLog();

        assertEquals(profitMargin, 490.9);
    }

    @Test
    public void printMenuShouldPrintOptions() {
        UserInterface ui = new UserInterface();

        systemOutRule.clearLog();
        ui.printMenu();

        assertEquals("Menu\n1- Calcular participacao\n2- Sair\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void getMenuOptionShouldReturnAInteger() {
        UserInterface ui = new UserInterface();

        systemInMock.provideLines("1");
        int option = ui.getMenuOption();

        assertEquals(option, 1);
    }

}