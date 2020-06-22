package co.autopair.spring.repository;

import co.autopair.spring.entity.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AddressRepository extends CommonRepository<Address, Integer> {
    @Modifying
    @Query(value = "UPDATE addresses SET district = :district WHERE id = :id", nativeQuery = true)
    int updateDistrict(@Param("id") Integer id, @Param("district") String district);
}
