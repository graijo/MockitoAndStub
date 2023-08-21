package business;

import data.TodoBusinessimplStub;
import data.TodoService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

//try to keep same folder structure of class to its test
public class TodoBusinessimplStubTest {
/*
Stub is a hard corded class which implement all methods of service interface
Stub can be used to test any dependency
here TodoBusinessimpl has dependency on TodoService
 */
    @Test
    //naming convention for test method name=test+name of the method
    public void testRetrieveToDoForSpring_UsingAStub_toVerifyCount(){
        //create object of TodoService
        //and make use of TodoBusinessimplStub
        TodoService todoServiceSub=new TodoBusinessimplStub();
        TodoBusinessimpl todoBusinessimpl=new TodoBusinessimpl(todoServiceSub);
        List<String> filteredTodos= todoBusinessimpl.retrieveToDoForSpring("Admin");
        Assert.assertEquals(2,filteredTodos.size());


    }

    @Test
    public void testRetrieveToDoForSpring_UsingAStub_hasExpected(){
        TodoService todoServiceStub=new TodoBusinessimplStub();
        TodoBusinessimpl todoBusinessimpl=new TodoBusinessimpl(todoServiceStub);
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("Learner novice");
        Assert.assertEquals("Learn spring ",filteredTods.get(0));
        Assert.assertEquals("Learn spring MVC",filteredTods.get(1));
    }
    @Test
    public void testRetrieveToDoForSpring_UsingAStub_hasZeroValues(){
        TodoService todoServiceStub=new TodoBusinessimplStub();
        TodoBusinessimpl todoBusinessimpl=new TodoBusinessimpl(todoServiceStub);
        List<String> filteredTods=todoBusinessimpl.retrieveToDoForSpring("");
        System.out.println("Filter has "+filteredTods);
        Assert.assertNotSame(2,filteredTods.size());
    }
}
