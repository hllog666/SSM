import com.hllog.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest5 {
    public static void main(String[] args) {
        // 在配置文件加载时，所有的bean被实例化
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user4");
        System.out.println(user);
    }
}
