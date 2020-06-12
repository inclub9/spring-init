package co.autopair.spring.repository;

import co.autopair.spring.entity.Team;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeamRepository extends CommonRepository<Team, Integer> {


    @Modifying
    @Query(value = "UPDATE teams SET name = :name WHERE id = :id", nativeQuery = true)
    int updateName(@Param("id") Integer id, @Param("name") String name);

    @Query(value = "SELECT * FROM teams  ORDER BY RAND ( ) LIMIT :limit", nativeQuery = true)
    Team randomData(@Param("limit") Integer limit);


}
