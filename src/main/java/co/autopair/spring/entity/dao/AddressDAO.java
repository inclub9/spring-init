package co.autopair.spring.entity.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDAO {
    Integer id;
    String province;
    String district;
    String subDistrict;
    String postalCode;
    String other;
}
