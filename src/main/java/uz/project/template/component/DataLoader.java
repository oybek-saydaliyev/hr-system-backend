package uz.project.template.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uz.project.template.repository.GroupRepository;

@Component
public class DataLoader {

    private final GroupRepository groupRepository;

    public DataLoader(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Bean
    public CommandLineRunner init(ApplicationContext ctx) {
        return args -> {
            //create SUPER_ADMIN
        };
    }

}
