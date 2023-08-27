import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito.*;

import static org.mockito.Mockito.*;

public class SpyVsMockTest {
    //spy used in legacy project to track what happened with dependencies
    @Test
    public void usingMockToTest(){

        ArrayList arrListMock=mock(ArrayList.class);
        Assert.assertEquals(0,arrListMock.size());
        arrListMock.add("new entry 1");
        Assert.assertEquals(0,arrListMock.size());

    }
    @Test
    public void usingSpyToTest(){
        /**
         * mock use default value if not implemented and do a dummy implementation if implemented.
         * mock-just mock not making any changes to actual object
         *
         * Spy - gets all logic from the class
         * A mock is a completely "virtual" object that has no relation whatsoever to the real code. A spy is more of an wrapper that Mockito puts "around" a real object of your class under test.
         *
         */

        List arrListSpy=spy(ArrayList.class);
        Assert.assertEquals(0,arrListSpy.size());
        arrListSpy.add("new entry 1");
        Assert.assertEquals(1,arrListSpy.size());

    }
    @Test
    public void usingSpyToTest2(){


        List arrListSpy=spy(ArrayList.class);
        stub(arrListSpy.size()).toReturn(5); //now method will always returns 5 becoz of stub
        /**
         * only size method is stubbed/overridded
         * hence spy is called partial mock
         */
        Assert.assertEquals(5,arrListSpy.size());
        arrListSpy.add("new entry 1");
        Assert.assertEquals(1,arrListSpy.size());

    }

    @Test
    public void usingSpyToTest3(){


        List arrListSpy=spy(ArrayList.class);
        arrListSpy.add("dummy");
        verify(arrListSpy).add("dummy"); //check whether add("dummy") method is made
        /**
         * Spy lets to watch real action and change behaviour
         */
        verify(arrListSpy,never()).clear(); //check clear never made

        Assert.assertEquals(5,arrListSpy.size());
        arrListSpy.add("new entry 1");
        Assert.assertEquals(1,arrListSpy.size());

    }

}
