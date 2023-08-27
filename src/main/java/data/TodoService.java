package data;

import java.util.List;

public interface TodoService {
//    retrive todos of a user
    //actual implementaion is not with us
    public List<String> retrieveTodos(String user);
    void deleteTodo(String todo);

}
