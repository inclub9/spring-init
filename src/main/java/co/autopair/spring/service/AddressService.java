package co.autopair.spring.service;


import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Value
@Service
@RequiredArgsConstructor
public class AddressService {
    AddressRepository addressRepository;
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public int updateDistrict(Integer id, String district) {
        return addressRepository.updateDistrict(id, district);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address find(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }
}
