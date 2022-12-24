package com.hllog.mapper;

import com.hllog.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    List<Blog> queryBlogIf(Map<String, Object> map);

    List<Blog> queryBlogChoose(Map<String, Object> map);

    int updateBlog(Map<String, Object> map);

    List<Blog> queryBlogForeach(Map<String, Object> map);
}
