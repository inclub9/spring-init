package co.autopair.spring.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "members")
@SuperBuilder
public class Member {

    @Id
    private Integer id;

    @NotNull
    private String nickName;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String position;

    @OneToOne(cascade = CascadeType.ALL)
    private Member leader;

    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
