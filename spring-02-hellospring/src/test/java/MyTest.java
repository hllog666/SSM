import com.hllog.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // hello是由Spring创建的
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello);
    }
}
