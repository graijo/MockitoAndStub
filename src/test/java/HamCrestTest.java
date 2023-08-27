import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class HamCrestTest {

    @Test
    public void hamCrestTest(){
        List<Integer> score= Arrays.asList(33,2,66,47,22);
//        assertThat(score,hasSize(4));
        assertThat(score,hasItem(47));
//        assertThat(score,hasItems(234,55,43));
        assertThat(score,everyItem(greaterThan(1)));

        //String
        assertThat("",isEmptyOrNullString());
        //Array
        Integer[] intArr= {2,55,71,23};
        assertThat(intArr,arrayWithSize(4));
    }
}
