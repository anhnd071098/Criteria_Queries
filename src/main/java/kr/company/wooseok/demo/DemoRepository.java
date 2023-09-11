package kr.company.wooseok.demo;

import kr.company.wooseok.common.Paging;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long>, JpaSpecificationExecutor<Demo> {
    @Query(value = "SELECT * FROM demo", nativeQuery = true)
    List<Demo> getDataDemo();

    @Query(value = "SELECT * " +
            " FROM demo " +
            " WHERE " +
            " CASE" +
            " WHEN (?1 = 'Đức Anh') THEN name = ?1" +
            " WHEN(?1 = 'Hải Anh') THEN status = ?2" +
            " END", nativeQuery = true)
    List<Demo> getDataByParam(String name, boolean status);

    @Query(value = "SELECT * FROM demo WHERE name = :name AND status = :status", nativeQuery = true)
    List<Demo> getDataByParam3(String name, boolean status);

    @Query(value = "SELECT * FROM demo", nativeQuery = true)
    List<Demo> getDataByParam4(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM demo", nativeQuery = true)
    int getDataByParam4();

    @Query(value =
            "SELECT * " +
                    " FROM demo" +
                    " WHERE" +
                    " CASE" +
                    " WHEN(:#{#paging.searchItem} = 'name') THEN UPPER(name) LIKE CONCAT('%',:#{#paging.keyWord},'%')" +
                    " WHEN(:#{#paging.searchItem} = 'status') THEN status = :#{#paging.keyWord}" +
                    " END", nativeQuery = true)
    List<Demo> testPaging(Pageable pageable, @Param("paging") Paging paging);

    @Query(value = "SELECT * FROM demo", nativeQuery = true)
    List<Demo> getByName(Pageable pageable, Specification<Demo> spec);
}
