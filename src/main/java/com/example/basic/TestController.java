package com.example.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final ArticleDao articleDao;

    @RequestMapping("/save")
    @ResponseBody
    public String save(String title, String body) {

        articleDao.save(title, body);

        return "게시물이 성공적으로 저장되었습니다";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> List() {

        List<Article> articleList = articleDao.getArticles();

        return articleList;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Article findById(Long id) {

        Article article = articleDao.findById(id);

        return article;
    }
    //Path Variable 방식
    @RequestMapping("/findById1/{id}")
    //http://localhost:8081/findById1/3
    @ResponseBody
    public Article findById1(@PathVariable("id") Long id) {
                            //url 이름과 같아야함
        Article article1 = articleDao.findById(id);

        return article1;
    }

    @RequestMapping("/t1")
    @ResponseBody
    public String test() {

        return "test";
    }

    @RequestMapping("/t2")
    @ResponseBody
    public Integer t2(Integer num) {

        return num * 2;
    }

    @RequestMapping("/t3")
    @ResponseBody
    public Article t3() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("title1");
        article.setBody("body1");

        return article;
    }

    @RequestMapping("/t4")
    @ResponseBody
    public List<Article> t4() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("title1");
        article.setBody("body1");

        Article article2 = new Article();
        article2.setId(2L);
        article2.setTitle("title2");
        article2.setBody("body2");

        List<Article> articleList = new ArrayList<>() {{
            add(article);
            add(article2);
        }};

        return articleList;
    }


}