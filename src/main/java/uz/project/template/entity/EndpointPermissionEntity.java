package uz.project.template.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;

@Getter
@Setter
@Entity
public class EndpointPermissionEntity extends BaseEntity {
    @Column(nullable = false)
    private String endPointPattern;
    @Column(nullable = false)
    private String httpMethod;

    @ManyToOne
    private PermissionEntity permission;
}
