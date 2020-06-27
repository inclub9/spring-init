package co.autopair.spring.service;


import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Value
@Service
@RequiredArgsConstructor
public class TeamService {

    TeamRepository TeamRepository;

    public List<Team> findAll() {
        return TeamRepository.findAll();
    }

    public Team find(Integer id) {
        return TeamRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }

    public Team save(Team team) {
        return TeamRepository.saveAndFlush(team);
    }

    public Team replace(Team team) {
        find(team.getId());
        return TeamRepository.saveAndFlush(team);
    }

    public int updateName(Integer id, String name) {
        return TeamRepository.updateName(id, name);
    }

    public void delete(Integer id) {
        TeamRepository.deleteById(id);
    }

    public Team findByName(String name) {
        return TeamRepository.findByName(name);
    }

    public Team findOrCreate(String name) {
        Team resultFindByName = findByName(name);
        if (resultFindByName == null) {
            return TeamRepository.save(Team.builder().name(name).build());
        }
        return resultFindByName;
    }

    public List<Team> findAllOrCreate(List<Team> teams) {
        List<Team> teamList = new ArrayList<>();
        teams.stream().forEach(team -> {
            teamList.add(findOrCreate(team.getName()));
        });
        return teamList;
    }

    public List<Team> findAllByName(List<String> teamName) {
        List<Team> teamList = new ArrayList<>();
        teamName.stream().forEach(name -> {
            teamList.add(findByName(name));
        });
        return teamList;
    }

    public List<Team> saveAll(List<Team> asList) {
        return TeamRepository.saveAll(asList);
    }
}
