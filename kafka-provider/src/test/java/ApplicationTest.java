import com.reinmind.entities.User;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationTest {
    @Test
    public void steamTest(){
        List<User> userList = Arrays.asList(new User(1,"Jason"),new User(2,"Tome"));
        userList.forEach(user -> {
            user.setName("Tom");
        });
        userList.forEach(System.out::println);
    }
}
