package co.autopair.spring.service;


import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.entity.dao.MemberDAO;
import co.autopair.spring.entity.dao.TeamDAO;
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

    public void saveAllDAO(List<TeamDAO> teamDAOList) {
        List<Team> teamList = new ArrayList<>();
        for (TeamDAO item : teamDAOList) {
            Team team = new Team();
            team.setId(item.getId());
            team.setName(item.getName());
            teamList.add(team);
        }
        TeamRepository.saveAll(teamList);
    }
}
