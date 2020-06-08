package co.autopair.spring.repository;

import co.autopair.spring.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}