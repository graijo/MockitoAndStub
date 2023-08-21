package business;

import data.TodoBusinessimplStub;
import data.TodoService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessimplMockTest {
    /*
    Mocking is creating object that simulate the behaviour of real objects.
    Unlike stub ,mocks can be created dynamically from code-at run time.
    mock offer more functionality than stub
    You can verify method calls and a lot of things.
    Mock is dynamic and Stub is static
     */
    @Test
    public void testRetrieveToDoForSpring_UsingMock_withEmptyList(){
        /*
        mock is a method in mockito class
        create mock object of class or interface
        Mockito mock return default values when they are not stubbed
         */
        TodoService todoService=mock(TodoService.class);
        when(todoService.retrieveTodos("intern_user")).thenReturn(Arrays.asList());
        TodoBusinessimpl todoBusinessimpl=new TodoBusinessimpl(todoService);
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("intern_user");
        Assert.assertEquals(0,filteredTods.size());



    }
    @Test
    public void testRetrieveToDoForSpring_UsingMock_withValidList(){
        /*
        mock is a method in mockito class
        create mock object of class or interface
        Mockito mock return default values when they are not stubbed

        Dependent interface and its method are not accessable will be mocked and then class and method will be
        called.
         */
        TodoService todoService=mock(TodoService.class);
        //Sets a return value to be returned when the method is called with a specific value
        when(todoService.retrieveTodos("intern_user"))
                .thenReturn(Arrays.asList("spring mvc","spring a","hibernate"));

        //Then actual method is called to see if it returns expected values
        //TodoBusinessimpl class contains method that needs to be tested.
        // for TodoBusinessimpl,need todoService dependency which mocked above
        TodoBusinessimpl todoBusinessimpl=new TodoBusinessimpl(todoService);
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("intern_user");
        Assert.assertEquals(2,filteredTods.size());

        //mock is flexible. Tests can be wrote on the fly without updating stub classes



    }
    @Test
    public void testRetrieveToDoForSpring_UsingMock_withWrongList(){
        TodoService todoService=mock(TodoService.class);
        when(todoService.retrieveTodos("intern_user"))
                .thenReturn(Arrays.asList("Java","Python","NodeJs"));
        TodoBusinessimpl todoBusinessimpl=new TodoBusinessimpl(todoService);
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("intern_user");
        Assert.assertEquals(0,filteredTods.size());

    }
}
