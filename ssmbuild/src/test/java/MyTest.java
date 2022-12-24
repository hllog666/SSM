import com.hllog.service.BooksService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksService = (BooksService) context.getBean("booksService");
        booksService.queryAllBook().forEach(System.out::println);
    }
}
