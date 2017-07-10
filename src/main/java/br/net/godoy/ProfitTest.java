package br.net.godoy;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


/**
 * Created by agodoy on 03/07/17.
 */
public class ProfitTest {
    private Profit profit;

    @Before
    public void setUp()
    {
        profit = new Profit();
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();


    @Test
    public void testReadInitialInputsShouldSetEmployersNumber() {
        systemInMock.provideLines("12", "213.2");
        profit.readInitialInputs();

        assertEquals(12, profit.getEmployersNumber());
    }


    @Test
    public void testReadInitialInputsShouldSetProfitMargin() {
        systemInMock.provideLines("23", "452.32");
        profit.readInitialInputs();

        assertEquals(452.32, profit.getProfitMargin(), 0.0);
    }


}