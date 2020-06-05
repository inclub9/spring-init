package co.autopair.spring.controller;

import co.autopair.spring.entity.Team;
import co.autopair.spring.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class TeamController extends CommonController {
    private final TeamService service;

    @GetMapping("/Teams")
    public List<Team> Teams() {
        return service.findAll();
    }

    @GetMapping("/Teams/{id}")
    public Team team(@PathVariable int id) {  //automatic type conversion
        return service.find(id);
    }

    @PostMapping("/Teams")
    public Team Teams(@RequestBody Team Team) {
        return service.save(Team);
    }

    @PutMapping("/Teams")
    public Team replace(@RequestBody Team team) {
        return service.replace(team);
    }


    @PatchMapping("/Teams/{id}/name/{name}")
    public int patch(@PathVariable int id, @PathVariable String name) {
        return service.updateName(id, name);
    }


    @DeleteMapping("/Teams/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
