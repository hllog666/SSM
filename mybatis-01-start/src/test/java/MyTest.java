import com.hllog.dao.UserDao;
import com.hllog.pojo.User;
import com.hllog.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(3);
        System.out.println(user);
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 增删改需要提交事务
        int ret = mapper.addUser(new User(5, "赵云", "456789"));
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 增删改需要提交事务
        int ret = mapper.updateUser(new User(5, "张飞", "456789"));
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 增删改需要提交事务
        int ret = mapper.deleteUser(5);
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testGetUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 1);
        map.put("username", "张三");
        User user = mapper.getUserById2(map);
        System.out.println(user);
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testAddUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 6);
        map.put("passWord", "489312");
        // 增删改需要提交事务
        int ret = mapper.addUser2(map);
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testGetUserByName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserByName("%李%");
        userList.forEach(System.out::println);
        sqlSession.close();
    }
}
