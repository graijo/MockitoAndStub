import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class listMockBDDTest {

    @Test
    public void listSize_success(){
        //GIVEN - current state OR Setup
        List mockList=mock(List.class);
        when(mockList.size()).thenReturn(2);
        //WHEN - actual method call
        //THEN - asserts
        Assert.assertEquals(2,mockList.size());
    }

    @Test(expected = RuntimeException.class)
    public void should_ThrowRunTimeErr_When_Getlist_withArgumentMatcher(){
        List mockList=mock(List.class);
        /*
        Argument matcher
         */
        when(mockList.get(anyInt())).thenThrow(new RuntimeException("Invalid Int"));
        mockList.get(999);
    }

    @Test
    public void listSize_Mock_using_BDD(){
        //GIVEN - current state OR Setup
        List mockList=mock(List.class);
        given(mockList.size()).willReturn(2);
        //WHEN - actual method call
        int size=mockList.size();
        //THEN - asserts
        assertThat(size,is(2));
    }
}
