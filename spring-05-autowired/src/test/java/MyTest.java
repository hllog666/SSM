import com.hllog.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = (People) context.getBean("people");
        people.getDog().shout();
        people.getCat().shout();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = (People) context.getBean("people2");
        people.getDog().shout();
        people.getCat().shout();
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = (People) context.getBean("people3");
        people.getDog().shout();
        people.getCat().shout();
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        People people = (People) context.getBean("people");
        people.getDog().shout();
        people.getCat().shout();
    }
}
