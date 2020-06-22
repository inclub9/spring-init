package co.autopair.spring.resolver;

import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.TeamRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(String name) {
        return teamRepository.save(
                Team.builder().name(name).build()
        );
    }

//    public Team updateTeamName(String name) {
//        teamRepository.updateName(1, name);
//        return teamRepository.getOne(1);
//    }

    public List<Team> deleteTeam(Integer id) {
        teamRepository.deleteById(id);
        return teamRepository.findAll();
    }
}
