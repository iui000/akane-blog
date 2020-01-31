package github.akanemiku.akaneblog.repository;

import github.akanemiku.akaneblog.model.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {

    /**
     * 根据pageable分页
     *
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true, value = "select * from t_content order by created desc")
    Page<Content> findAll(Pageable pageable);

    /**
     * 通过分类获取文章
     *
     * @param category
     * @return
     */
    @Query(nativeQuery = true, value = "select * from t_content where categories=?1")
    List<Content> getArticleByCategory(@Param("category") String category);
}