package com.example.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleDao articleDao;

    @RequestMapping("/article/main")
    public String main() {

        return "article/main";
    }

    @RequestMapping("/article/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);

        return "article/detail";
    }

    @RequestMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = articleDao.findAll();
        model.addAttribute("articleList", articleList);

        return "article/list";
    }

    @GetMapping("/article/write")
    public String articleWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    public String write(String title, String body) {

        if(title.trim().length() == 0 || title == null) {
            throw new IllegalArgumentException("제목입력은 필수입니다.");
        }

        if(body.trim().length() == 0 || body == null) {
            throw new IllegalArgumentException("내용입력은 필수입니다.");
        }

        // 코드 정리 단축키 -> 컨트롤 + 알트 + L
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleDao.save(article);

        return "redirect:/article/list"; //redirect: url작성 != 템플릿이름아님!
    }

    @RequestMapping("/article/delete/{id}")
    public String delete(@PathVariable long id) {

        articleDao.deleteById(id);

        return "redirect:/article/list";
    }

    @RequestMapping("/article/modify/{id}")
    public String update(@PathVariable("id") long id, String title, String body) {

        if(title.trim().length() == 0 || title == null) {
            throw new IllegalArgumentException("제목입력은 필수입니다.");
        }

        if(body.trim().length() == 0 || body == null) {
            throw new IllegalArgumentException("내용입력은 필수입니다.");
        }
        // 빌더 방식
        Article article = Article.builder()
                .id(id)
                .title(title)
                .body(body)
                .build();

        articleDao.update(article);

        return "redirect:/article/detail/%d".formatted(id);
    }


    @RequestMapping("/show-html")
    public String showHtml() {
        return "test"; // .html 확장자를 스프링부트가 자동으로 붙여줌
    }



}