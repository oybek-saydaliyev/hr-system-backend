package uz.project.template.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "role")
public class RoleEntity extends BaseEntity {
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<PermissionEntity> permissions = new HashSet<>();

}
