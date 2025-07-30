package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.AuthUserEntity;

/**
 * DTO for {@link uz.project.template.entity.AuthUserEntity}
 */
@Getter
@Setter
public class UserDto extends BaseDto{
    private Long id;
    private String username;
    private String password;
    private Long groupId;


    public static AuthUserEntity toEntity(UserDto dto, AuthUserEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setUsername(dto.getUsername() != null ? dto.getUsername() : entity.getUsername());
        entity.setPassword(dto.getPassword() != null ? dto.getPassword() : entity.getPassword());
        entity.setGroupId(dto.getGroupId() != null ? dto.getGroupId() : entity.getGroupId());
        return entity;
    }
}