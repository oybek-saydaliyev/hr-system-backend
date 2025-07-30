package uz.project.template.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.project.template.entity.AuthUserEntity;
import uz.project.template.entity.EndpointPermissionEntity;
import uz.project.template.entity.PermissionEntity;
import uz.project.template.entity.RoleEntity;
import uz.project.template.repository.EndpointPermissionRepository;
import uz.project.template.repository.PermissionRepository;
import uz.project.template.repository.RoleRepository;
import uz.project.template.repository.UserRepository;

import java.util.HashSet;

@Component
public class DataLoader {

//    @Bean
    CommandLineRunner init(ApplicationContext ctx, PasswordEncoder passwordEncoder, PermissionRepository permissionRepository,
                           RoleRepository roleRepository,
                           EndpointPermissionRepository endpointPermissionRepository,
                           UserRepository userRepository) {
        return args -> {
            //create SUPER_ADMIN
            //permission
            PermissionEntity permissionEntity = new PermissionEntity();
            permissionEntity.setName("CREATE");
            PermissionEntity save = permissionRepository.save(permissionEntity);

            HashSet<PermissionEntity> permissions = new HashSet<>();
            permissions.add(save);

            //role
            RoleEntity role = new RoleEntity();
            role.setName("SUPER_ADMIN");
            role.setPermissions(permissions);
            RoleEntity roleSave = roleRepository.save(role);

            HashSet<RoleEntity> roles = new HashSet<>();
            roles.add(roleSave);

            //endpoint permission
            EndpointPermissionEntity endpointPermissionEntity = new EndpointPermissionEntity();
            endpointPermissionEntity.setHttpMethod("GET");
            endpointPermissionEntity.setEndPointPattern("/**");
            endpointPermissionEntity.setPermission(save);
            endpointPermissionRepository.save(endpointPermissionEntity);


            //user
            AuthUserEntity user = new AuthUserEntity("d", passwordEncoder.encode("sad"), roles);
            userRepository.save(user);
        };
    }

}
