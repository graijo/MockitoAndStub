package business;

import data.TodoService;

import java.util.ArrayList;
import java.util.List;
//business.TodoBusinessimpl is SUT
//data.TodoService is dependency of business.TodoBusinessimpl.becoz impl's method call service
//data.TodoService is implemented by another team that we dont have access
//so we'll create a stub for data.TodoService for unit testing which can be used for testing business.TodoBusinessimpl

public class TodoBusinessimpl {
    private TodoService todoService;

    public TodoBusinessimpl(TodoService todoService) {
        this.todoService = todoService;
    }
    //call to do service to retrieve to do and filter the one's wrt spring
    public List<String> retrieveToDoForSpring(String user){
        List<String> filteredTods=new ArrayList<String>();
        List<String> allTodos=todoService.retrieveTodos(user);
        for(String t:allTodos){
            if(t.contains("spring")){
                filteredTods.add(t);
            }

        }
        return filteredTods;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("Spring")) {
                todoService.deleteTodo(todo);
            }
        }
    }
}
