package uz.project.template.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.AuthUserEntity;
import uz.project.template.entity.RoleEntity;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto extends BaseDto {
    private Long id;
    private String username;
    private Long groupId;
    private Set<RoleEntity> roles;

    public UserResponseDto(Long id, String username, Long groupId, Set<RoleEntity> roles) {
        this.id = id;
        this.username = username;
        this.groupId = groupId;
        this.roles = roles;
    }

    public UserResponseDto(Long id, String username, Long groupId) {
        this.id = id;
        this.username = username;
        this.groupId = groupId;
        this.roles = new HashSet<>();
    }

    public void addRole(RoleEntity role) {
        this.roles.add(role);
    }


    public static UserResponseDto toDto(UserResponseDto dto, AuthUserEntity entity) {
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setGroupId(entity.getGroupId());
        dto.setRoles(entity.getRoles());
        return dto;
    }

}
