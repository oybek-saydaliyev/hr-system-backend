package uz.project.template.component;

import org.hibernate.validator.internal.engine.groups.Group;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.project.template.entity.*;
import uz.project.template.repository.*;

import java.util.HashSet;

@Component
public class DataLoader {

    private final GroupRepository groupRepository;

    public DataLoader(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Bean
    CommandLineRunner init(ApplicationContext ctx) {
        return args -> {
            //create SUPER_ADMIN

        };
    }

}
