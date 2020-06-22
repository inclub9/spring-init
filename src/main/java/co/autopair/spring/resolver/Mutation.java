package co.autopair.spring.resolver;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.TeamRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private AddressRepository addressRepository;

    //Team
    public Team createTeam(String name) {
        return teamRepository.save(
                Team.builder().name(name).build()
        );
    }

    public int updateTeamName(Integer id, String name) {
        return teamRepository.updateName(id, name);
    }

    public List<Team> deleteTeam(Integer id) {
        teamRepository.deleteById(id);
        return teamRepository.findAll();
    }

    //Address
    public Address createAddress(
            String province,
            String district,
            String subDistrict,
            String postalCode,
            String other
    ) {
        return addressRepository.save(
                Address.builder()
                        .province(province)
                        .district(district)
                        .subDistrict(subDistrict)
                        .postalCode(postalCode)
                        .other(other)
                        .build()
        );
    }

    public int updateAddressDistrict(Integer id, String district) {
        return addressRepository.updateDistrict(id, district);
    }
//
//    public List<Address> deleteAddress(Integer id) {
//        addressRepository.deleteById(id);
//        return addressRepository.findAll();
//    }
}
