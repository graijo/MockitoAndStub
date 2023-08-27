package business;

import data.TodoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * When a test class is annotated with @RunWith(MockitoJUnitRunner.class),
 * Then @Mock will create mock method and available to us .
 * TodoService todoService=mock(TodoService.class);
 *
 * No. of lines of code removed from application will improve the maintainability of the code.
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessimplMockitoInjectMockTest {
    @Mock
    TodoService todoService;
//    @InjectMocks will look for all dependencies in TodoBusinessimpl class for TodoService.
    //@RunWith(MockitoJUnitRunner.class) will ensure that @InjectMocks will create instance and
// appropriate mock are passed and values are injected.
    @InjectMocks
    TodoBusinessimpl todoBusinessimpl;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveToDoForSpring_UsingMock_withEmptyList(){
// @Mock removed below
//        TodoService todoService=mock(TodoService.class);
        when(todoService.retrieveTodos("intern_user")).thenReturn(Arrays.asList());
        // @InjectMocks removed below
//        TodoBusinessimpl todoBusinessimpl=new TodoBusinessimpl(todoService);
        //invocation
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("intern_user");
        Assert.assertEquals(0,filteredTods.size());



    }
    @Test
    public void testRetrieveToDoForSpring_UsingMock_withValidList(){


        when(todoService.retrieveTodos("intern_user"))
                .thenReturn(Arrays.asList("spring mvc","spring a","hibernate"));

        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("intern_user");
        Assert.assertEquals(2,filteredTods.size());


    }

    @Test
    public void testRetrieveToDoForSpring_UsingMock_withWrongList(){
        when(todoService.retrieveTodos("intern_user"))
                .thenReturn(Arrays.asList("Java","Python","NodeJs"));
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("intern_user");
        Assert.assertEquals(0,filteredTods.size());

    }

    //TODO BDD mockito
    @Test
    public void testRetrieveToDoForSpring_UsingMock_withValidList_BDD(){
        //GIVEN
//        when(todoService.retrieveTodos("intern_user"))
//                .thenReturn(Arrays.asList("spring mvc","spring a","hibernate"));
        //OR
        given(todoService.retrieveTodos("intern_user"))
                .willReturn(Arrays.asList("spring mvc","spring a","hibernate"));
        //WHEN
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("intern_user");
        //THEN
//        Assert.assertEquals(2,filteredTods.size());
        //OR
        assertThat(filteredTods.size(),is(2));

    }

    @Test
    public void captureArgument() {
        given(todoService.retrieveTodos("Antony")).willReturn(Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance"));

        todoBusinessimpl.deleteTodosNotRelatedToSpring("Antony");
        verify(todoService).deleteTodo(stringArgumentCaptor.capture());

        assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
    }
}
