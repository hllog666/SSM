import com.hllog.mapper.UserMapper;
import com.hllog.pojo.User;
import com.hllog.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyTest {
    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(4);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("testLog4j start");
        logger.error("error");
        logger.info("testLog4j end");
    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", 2);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetUserByRowBounds() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> userList = sqlSession.selectList("com.hllog.mapper.UserMapper.getUserByRowBounds", null, rowBounds);
        userList.forEach(System.out::println);
        sqlSession.close();
    }
}
