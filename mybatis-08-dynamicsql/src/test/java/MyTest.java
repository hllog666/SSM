import com.hllog.mapper.BlogMapper;
import com.hllog.pojo.Blog;
import com.hllog.utils.IdUtils;
import com.hllog.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void testGetId() {
        System.out.println(IdUtils.getId());
    }

    @Test
    public void testAddBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("hllog");
        blog.setCreateTime(new Date());
        blog.setViews(6666);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring真好玩");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring MVC太妙了");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void testQueryBlogIf() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogList = mapper.queryBlogIf(map);
        blogList.forEach(System.out::println);
        System.out.println("==========================");
        map.put("title", "Mybatis如此简单");
        blogList = mapper.queryBlogIf(map);
        blogList.forEach(System.out::println);
        System.out.println("==========================");
        map.clear();
        map.put("author", "hllog");
        blogList = mapper.queryBlogIf(map);
        blogList.forEach(System.out::println);
        System.out.println("==========================");
        map.clear();
        map.put("title", "Mybatis如此简单");
        map.put("author", "hllog");
        blogList = mapper.queryBlogIf(map);
        blogList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryBlogChoose() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogList = mapper.queryBlogChoose(map);
        blogList.forEach(System.out::println);
        System.out.println("==========================");
        map.put("title", "Mybatis如此简单");
        blogList = mapper.queryBlogChoose(map);
        blogList.forEach(System.out::println);
        System.out.println("==========================");
        map.clear();
        map.put("author", "hllog");
        blogList = mapper.queryBlogChoose(map);
        blogList.forEach(System.out::println);
        System.out.println("==========================");
        map.clear();
        map.put("title", "Mybatis如此简单");
        map.put("author", "hllog");
        blogList = mapper.queryBlogChoose(map);
        blogList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testUpdateBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Mybatis如此简单");
        // map.put("author", "hllog666");
        map.put("id", "4301371592394228b6e67bd574a4f3e3");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> ids = new ArrayList<>();
        ids.add("4301371592394228b6e67bd574a4f3e3");
        ids.add("617a71b6b2354c6ab287699522e58604");
        // ids.add("9774d754624b40a7809035e5e238658c");
        map.put("ids", ids);
        List<Blog> blogList = mapper.queryBlogForeach(map);
        blogList.forEach(System.out::println);
        sqlSession.close();
    }
}
