package co.autopair.spring.repository;

import co.autopair.spring.entity.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public interface MemberRepository extends CommonRepository<Member, Integer> {


    @Modifying
    @Query(value = "UPDATE members SET position = :position WHERE id = :id", nativeQuery = true)
    int updatePosition(@Param("id") long id, @Param("position") String position);

    Optional<Collection<Member>> findAllByAddress_District(String district);
}
