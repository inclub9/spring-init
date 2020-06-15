package co.autopair.spring.service;


import co.autopair.spring.entity.Address;
import co.autopair.spring.dao.AddressDAO;
import co.autopair.spring.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Value
@Service
@RequiredArgsConstructor
public class AddressService {
    AddressRepository addressRepository;

    public List<Address> saveAllDAO(List<AddressDAO> addressFileDAO) {
        List<Address> addressList = new ArrayList<>();
        for (AddressDAO item : addressFileDAO) {
            Address address = new Address();
            address.setProvince(item.getProvince());
            address.setDistrict(item.getDistrict());
            address.setSubDistrict(item.getSubDistrict());
            address.setPostalCode(item.getPostalCode());
            address.setOther(item.getOther());
            addressList.add(address);
        }
         return addressRepository.saveAll(addressList);
    }
}
