package co.autopair.spring.resolver;

import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.TeamRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(String name) {
        return teamRepository.save(
                Team.builder().name(name).build()
        );
    }

    public Team updateName(String name) {
        teamRepository.updateName(1, name);
        return teamRepository.getOne(1);
    }

//    public void delete(Integer id) {
//        teamRepository.deleteById(id);
//    }
}
