package data;

import java.util.Arrays;
import java.util.List;

//stub is a class which contains dummy data
//put interface and class implementing
public class TodoBusinessimplStub implements TodoService {
    /*
    Stubs are not recommended as Service (interface) can keep on adding method which
    needs more mothods to be implemented in the stub.The code keeps on incrementing.
    1-Dynamic condition , 2-Service definition
     */
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn spring ","Learn spring MVC","Learn python");
    }
}
