package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.GroupEntity;

@Getter
@Setter
public class GroupDto extends BaseDto {
    private Long id;
    private String name;

    public static GroupEntity toEntity(GroupDto dto, GroupEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
        return entity;
    }
}
