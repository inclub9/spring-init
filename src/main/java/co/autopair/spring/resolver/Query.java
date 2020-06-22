package co.autopair.spring.resolver;

import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.TeamRepository;
import co.autopair.spring.service.TeamService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> allTeam() {
        return teamRepository.findAll();
    }

    public Team team(Integer id) {
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }
}
