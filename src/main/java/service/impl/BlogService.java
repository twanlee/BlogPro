package service.impl;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BlogRepo;
import service.FullService;

public class BlogService implements FullService<Blog> {
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepo.delete(id);
    }
}
