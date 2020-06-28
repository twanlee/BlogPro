package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.impl.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/cate")
    public ModelAndView showCate(){
        List<Category> cate = (List<Category>) categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("cate");
        modelAndView.addObject("cate", cate);
        return modelAndView;
    }
    @GetMapping("/cate-create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("createCate","cate",new Category());
        return modelAndView;

    }
    @PostMapping("/cate-create")
    public ModelAndView checkCate(@ModelAttribute("cate") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("createCate","cate",new Category());
        modelAndView.addObject("message","Done!");
        return modelAndView;
    }
    @GetMapping("/edit-cate/{id}")
    public ModelAndView edit(@PathVariable Long id){
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("editCate");
        modelAndView.addObject("cate",category);
        return modelAndView;
    }
    @PostMapping("edit-cate")
    public ModelAndView update(@ModelAttribute("cate") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("editCate");
        modelAndView.addObject("cate",category);
        modelAndView.addObject("message","Done");
        return modelAndView;
    }
}
