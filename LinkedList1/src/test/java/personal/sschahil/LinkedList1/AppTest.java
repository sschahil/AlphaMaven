package personal.sschahil.LinkedList1;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for LinkedList1 App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
	App<String> list = new App<String>();

	list.add("hello", 0);
	list.add("my", 1);
	list.add("name", 2);
	list.add("is", 3);
	list.add("Joedy", 4);
	list.print();
        System.out.println();

	System.out.println("Removing the 2 and 3 position");
	list.remove(3);
	list.remove(2);
	list.print();
	System.out.println();
	
	System.out.println("Edit node 1 and node 2");
	list.editNode("hey", 1);
	list.editNode("his", 2);
	list.print();
	System.out.println();

	list.destroy();
	list.print();
	System.out.println();
	assertEquals(0, list.getSize());
    }
}
