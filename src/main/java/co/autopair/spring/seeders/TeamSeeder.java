package co.autopair.spring.seeders;

import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.TeamRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;

@Component
public class TeamSeeder {
    @Autowired
    private TeamRepository teamRepository;

    public void run() {
        String[] teams = {
                "Chief",
                "Operation",
                "Admin",
                "Accountant",
                "Tester",
                "Data",
                "Customer",
                "Product",
                "Developer"
        };
        LinkedList<Team> teamList = new LinkedList<>();
        for (String item : teams) {
            Team team = new Team(item);
            teamList.push(team);
        }
        teamRepository.saveAll(teamList);
    }
}