package co.autopair.spring.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

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
}
