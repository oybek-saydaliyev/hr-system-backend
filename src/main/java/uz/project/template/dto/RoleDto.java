package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.RoleEntity;

import java.util.List;

@Getter
@Setter
public class RoleDto extends BaseDto {
    private Long id;
    private String name;
    private List<Long> permissions;

    public static RoleEntity toEntity(RoleDto dto, RoleEntity entity) {
        entity.setId(dto.getId() != null ? dto.id : entity.getId());
        entity.setName(dto.getName() != null ? dto.name : entity.getName());
        return entity;
    }
}
