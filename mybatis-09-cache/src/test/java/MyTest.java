import com.hllog.mapper.UserMapper;
import com.hllog.pojo.User;
import com.hllog.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        User user2 = mapper.queryUserById(1);
        // 返回true表示有缓存
        // 一级缓存相当于map
        System.out.println(user == user2);
        sqlSession.close();
    }

    @Test
    public void testQueryUserById2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        sqlSession.close();

        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);

        System.out.println(user == user2);
        sqlSession2.close();
    }
}
