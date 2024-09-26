package com.example.basic;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;



@Mapper
public interface ArticleDao {


    @Insert("""
            INSERT INTO article2
                SET title = #{title}
                    , `body` = #{body}
            """)
    void save(String title, String body);


    @Select("""
			SELECT * FROM article2
				ORDER BY id DESC
			""")
    public List<Article> getArticles();

    @Select("""
            SELECT * FROM article2
                WHERE id = #{id}
            """)
    public Article findById(Long id);
}