package repository;

import model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepo extends PagingAndSortingRepository<Blog,Long> {
    List<Blog> findByOrderByDateAsc();
}
