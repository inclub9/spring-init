//package co.autopair.spring.resolver;
//
//import co.autopair.spring.entity.Author;
//import co.autopair.spring.entity.Tutorial;
//import co.autopair.spring.repository.AuthorRepository;
//import com.coxautodev.graphql.tools.GraphQLResolver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class TutorialResolver implements GraphQLResolver<Tutorial> {
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    public TutorialResolver(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }
//
//    public Author getAuthor(Tutorial tutorial) {
//        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
//    }
//}