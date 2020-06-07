package co.autopair.spring.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "addresses")
public class Address {


    @Id
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
