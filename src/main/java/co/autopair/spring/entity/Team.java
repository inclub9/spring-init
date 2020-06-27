package co.autopair.spring.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuperBuilder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "teams")
@SequenceGenerator(name = "teams_seq")
public class Team {
    @Id
    @GeneratedValue(generator = "teams_seq")
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Member> members = new ArrayList<>();
}
