package controller;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.impl.BlogService;
import service.impl.CategoryService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;
    @ModelAttribute("cates")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping("/blog")
    public ModelAndView createBlog(){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        ModelAndView modelAndView =new ModelAndView("home","blog",new Blog());
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
    @PostMapping("/blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog){
        blog.setDate();
        blogService.save(blog);
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        ModelAndView modelAndView =new ModelAndView("home","blog",new Blog());
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
}
