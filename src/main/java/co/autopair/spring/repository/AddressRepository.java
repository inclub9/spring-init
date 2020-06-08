package co.autopair.spring.repository;

import co.autopair.spring.entity.Address;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface AddressRepository extends CommonRepository<Address, Integer> {
}
