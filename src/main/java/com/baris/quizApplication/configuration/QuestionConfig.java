package com.baris.quizApplication.configuration;

import com.baris.quizApplication.model.Question;
import com.baris.quizApplication.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository questionRepository) {
        return args -> {
            questionRepository.saveAll(List.of(
                    new Question("Spring Boot is used for developing?", "Web applications", "Distributed applications (Restful web services)", "Microservices", "All of the options", "springboot", "All of the options"),
                    new Question("What is Spring Initializer?", "Web-based tool to bootstrap Spring projects and generate project skeletons with the necessary configurations and dependencies.", "A command-line tool for generating a basic Spring Boot project structure", "A tool for initializing a Spring-based application with a specific set of dependencies", "A tool for creating a Spring Boot application with a specific set of features", "springboot", "Web-based tool to bootstrap Spring projects and generate project skeletons with the necessary configurations and dependencies."),
                    new Question("What does Spring Boot do to simplify the configuration of a Spring-based application?", "Automatically configures necessary beans and dependencies", "Uses annotations to configure beans and dependencies", "Allows for the use of XML configuration files", "Provides a command line interface for configuring the application", "springboot", "Automatically configures necessary beans and dependencies"),
                    new Question("How can a Spring Boot application be packaged and distributed?", "As a JAR file", "As a WAR file", "As a ZIP file", "All of the options", "springboot", "All of the options"),
                    new Question("Which Spring annotation is used to create RESTful web services using Spring MVC?", "@RestController", "@Controller", "@Component", "@Rest", "springboot", "@RestController"),
                    new Question("@RestController annotation is a combination of the below two annotations", "@Component and @ResponseBody annotations", "@Controller and @ResponseBody annotations", "@Service and @ResponseBody annotations", "None of the options", "springboot", "@Controller and @ResponseBody annotations"),
                    new Question("Which Spring annotation is used to handle HTTP POST requests?", "@GetMapping", "@PutMapping", "@CreateMapping", "@PostMapping", "springboot", "@PostMapping"),
                    new Question("Which Spring annotation is used to handle HTTP GET requests?", "@GetMapping", "@PutMapping", "@CreateMapping", "@PostMapping", "springboot", "@GetMapping"),
                    new Question("Which Spring annotation is used to handle HTTP DELETE requests?", "@GetMapping", "@PutMapping", "@CreateMapping", "@PostMapping", "springboot", "@DeleteMapping"),
                    new Question("Which Spring annotation is used to handle HTTP PUT requests?", "@GetMapping", "@PutMapping", "@CreateMapping", "@PostMapping", "springboot", "@PutMapping"),
                    new Question("Which annotation do we use to mark the class as a Service class/component?", "@Component", "@Service", "@Controller", "@Repository", "springboot", "@Service"),
                    new Question("Which is the default implementation class of the JpaRepository interface?", "SimpleJpaRepository class", "JpaRepositoryImpl class", "CustomJpaRepository class", "DefaultJpaRepository class", "springboot", "SimpleJpaRepository class"),
                    new Question("Which of the following is not a keyword in java?", "static", "Boolean", "void", "private", "java", "Boolean"),
                    new Question("What is the default value of short variable?", "0.0", "0", "null", "not defined", "java", "0"),
                    new Question("Which of the following stands true about default modifier of class members?", "By default, variables, methods and constructors can be accessed by subclass only.", "By default, variables, methods and constructors can be accessed by any class lying in any package.", "By default, variables, methods and constructors can be accessed by any class lying in the same package.", "None of the options", "java", "By default, variables, methods and constructors can be accessed by any class lying in the same package."),
                    new Question("What is Encapsulation?", "Encapsulation is a technique to define different methods of same type.", "Encapsulation is the ability of an object to take on many forms.", "Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods.", "None of the options", "java", "Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods."),
                    new Question("What kind of variables a class can consist of?", "class variables, instance variables", "class variables, local variables, instance variables", "class variables", "class variables, local variables", "java", "class variables, local variables, instance variables"),
                    new Question("Method Overriding is an example of", "Static Binding.", "Dynamic Binding.", "Both of the above.", "None of the above.", "java", "Dynamic Binding.")));
        };
    }
}
