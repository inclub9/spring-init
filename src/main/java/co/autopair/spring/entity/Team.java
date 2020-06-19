package co.autopair.spring.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

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
