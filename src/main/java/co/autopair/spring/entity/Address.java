package co.autopair.spring.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "addresses")
@SequenceGenerator(name = "addresses_seq")
@SuperBuilder
public class Address {
    @Id
    @GeneratedValue(generator = "addresses_seq")
    private Integer id;

    @NotNull
    private String province;

    @NotNull
    private String district;

    @NotNull
    private String subDistrict;

    @NotNull
    private String postalCode;

    private String other;
}
