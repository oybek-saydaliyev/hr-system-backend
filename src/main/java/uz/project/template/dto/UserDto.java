package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.AuthUserEntity;

import java.time.LocalDate;
import java.util.List;

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
    private String email;
    private String phoneNumber;
    private String address;
    private String specialCode;
    private Long workTableId;
    private LocalDate dateOfBirth;
    private List<Long> roleIds;


    public static AuthUserEntity toEntity(UserDto dto, AuthUserEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setUsername(dto.getUsername() != null ? dto.getUsername() : entity.getUsername());
        entity.setPassword(dto.getPassword() != null ? dto.getPassword() : entity.getPassword());
        entity.setGroupId(dto.getGroupId() != null ? dto.getGroupId() : entity.getGroupId());
        entity.setEmail(dto.getEmail() != null ? dto.getEmail() : entity.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber() != null ? dto.getPhoneNumber() : entity.getPhoneNumber());
        return entity;
    }
}