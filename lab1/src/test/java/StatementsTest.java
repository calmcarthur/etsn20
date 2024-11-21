
import static org.junit.Assert.assertEquals;

import lab1.NextDate;

import org.junit.Test;

public class StatementsTest {
    
    @Test
    // Day in month that has 31 days
    public void statementTest1() {	  
       NextDate d = new NextDate(1, 4, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("1/5/2003", result);    
    }

    @Test
    // Last day of month with 31 days
    public void statementTest2() {	   
       NextDate d = new NextDate(1, 31, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("2/1/2003", result);    
    }

    @Test
    // Day in month that has 30 days
    public void statementTest3() {	   
       NextDate d = new NextDate(4, 5, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("4/6/2003", result);    
    }

    @Test
    // Last day in month that has 30 days
    public void statementTest4() {	   
       NextDate d = new NextDate(4, 30, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("5/1/2003", result);    
    }


    @Test
    // Day is 31 or more for a month with 30 days
    public void statementTest5() {	   
       NextDate d = new NextDate(4, 31, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("Invalid Input Date", result);    
    }

    @Test
    // Day in month 12
    public void statementTest6() {	   
       NextDate d = new NextDate(12, 5, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("12/6/2003", result);    
    }

    @Test
    // Last day in month 12 for a year not 2021
    public void statementTest7() {	   
       NextDate d = new NextDate(12, 31, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("1/1/2004", result);    
    }

    @Test
    // Last day in month 12 when year is 2021
    public void statementTest8() {	   
       NextDate d = new NextDate(12, 31, 2021);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("Invalid Input Date", result);    
    }

    @Test
    // Day in February that is not the 28th or 29th
    public void statementTest9() {	   
       NextDate d = new NextDate(2, 6, 2003);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("2/7/2003", result);    
    }

    @Test
    // 28th day in February when leap year by mod 100 and 400
    public void statementTest10() {	   
       NextDate d = new NextDate(2, 28, 2000);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("2/29/2000", result);    
    }

    @Test
    // 28th day in February when leap year by mod 100, but not 400
    public void statementTest11() {	   
       NextDate d = new NextDate(2, 28, 1900);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("3/1/1900", result);    
    }

    @Test
    // 28th day in February when leap year by mod 4, but not 100
    public void statementTest12() {	   
       NextDate d = new NextDate(2, 28, 2004);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("2/29/2004", result);    
    }

    @Test
    // Last day in February when leap year by mod 100 and 400
    public void statementTest13() {	   
       NextDate d = new NextDate(2, 29, 2000);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("3/1/2000", result);    
    }

    @Test
    // Last day in February when leap year by mod 100, but not 400
    public void statementTest14() {	   
       NextDate d = new NextDate(2, 29, 1900);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("Invalid Input Date", result);    
    }

    @Test
    // Last day in February when leap year by mod 4, but not 100
    public void statementTest15() {	   
       NextDate d = new NextDate(2, 29, 2004);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("3/1/2004", result);    
    }
    
    @Test
    // Day is greater than 29 in February
    public void statementTest16() {	   
       NextDate d = new NextDate(2, 30, 2004);
       String result = d.run(d.month, d.day, d.year);
       assertEquals("Invalid Input Date", result);    
    }

}