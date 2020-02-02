package github.akanemiku.akaneblog.repository;

import github.akanemiku.akaneblog.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MetaRepository extends JpaRepository<Meta, Integer> {

    /**
     * 查找某一类型的总个数
     *
     * @param type
     * @return
     */
    @Query(nativeQuery = true, value = "select count(*) from t_meta where type like %?1%")
    Long findMetasCountByType(@Param("type") String type);

    /**
     * 通过名称和类型查找某一Meta
     *
     * @param type
     * @param name
     * @return
     */
    @Query(nativeQuery = true, value = "select * from t_meta where type=?1 and name=?2")
    Meta findMetaByNameAndType(@Param("type") String type, @Param("name") String name);

    /**
     * 查找某一类型的所有项目
     *
     * @param type
     * @return
     */
    List<Meta> findAllByType(@Param("type") String type);
}
