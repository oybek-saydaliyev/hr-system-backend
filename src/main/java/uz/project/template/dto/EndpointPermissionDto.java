package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.EndpointPermissionEntity;

@Getter
@Setter
public class EndpointPermissionDto extends BaseDto {
    private Long id;
    private String endPointPattern;
    private String httpMethod;
    private Long permissionId;

    public static EndpointPermissionEntity toEntity(EndpointPermissionDto dto, EndpointPermissionEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setEndPointPattern(dto.getEndPointPattern() != null ? dto.getEndPointPattern() : entity.getEndPointPattern());
        entity.setHttpMethod(dto.getHttpMethod());
        return entity;
    }

}
