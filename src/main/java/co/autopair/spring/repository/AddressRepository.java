package co.autopair.spring.repository;

import co.autopair.spring.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AddressRepository extends CommonRepository<Address, Integer> {
    @Query(value = "SELECT * FROM addresses ORDER BY RAND ( ) LIMIT :limit", nativeQuery = true)
    Address randomData(@Param("limit") Integer limit);
}
