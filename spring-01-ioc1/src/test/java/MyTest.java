import com.hllog.dao.UserDaoMysqlImpl;
import com.hllog.service.UserService;
import com.hllog.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        // UserService userService = new UserServiceImpl();
        // userService.getUser();

        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
