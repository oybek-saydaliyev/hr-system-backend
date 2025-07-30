package uz.project.template.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;

@Getter
@Setter
@Entity(name = "groups")
public class GroupEntity extends BaseEntity {
    private String name;
}
