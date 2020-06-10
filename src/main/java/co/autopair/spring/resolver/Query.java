//package co.autopair.spring.resolver;
//
//import co.autopair.spring.entity.*;
//import co.autopair.spring.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//
//@Component
//public class Query implements GraphQLQueryResolver {
//    private AuthorRepository authorRepository;
//    private TutorialRepository tutorialRepository;
//    private TeamRepository teamRepository;
//
//
//    @Autowired
//    public Query(
//            AuthorRepository authorRepository,
//            TutorialRepository tutorialRepository,
//            TeamRepository teamRepository
//    ) {
//        this.authorRepository = authorRepository;
//        this.tutorialRepository = tutorialRepository;
//        this.teamRepository = teamRepository;
//    }
//
//    public Iterable<Author> findAllAuthors() {
//        return authorRepository.findAll();
//    }
//
//    public Iterable<Team> findAllTeams() {
//        return teamRepository.findAll();
//    }
//
//    public Iterable<Tutorial> findAllTutorials() {
//        return tutorialRepository.findAll();
//    }
//
//    public long countAuthors() {
//        return authorRepository.count();
//    }
//
//    public long countTutorials() {
//        return tutorialRepository.count();
//    }
//
//}