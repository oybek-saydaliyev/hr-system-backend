package uz.project.template.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;

@Getter
@Setter
@Entity(name = "permission")
public class PermissionEntity extends BaseEntity {
    private String name;
}
