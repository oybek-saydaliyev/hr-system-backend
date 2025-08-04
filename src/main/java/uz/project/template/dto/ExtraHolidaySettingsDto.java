package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.ExtraHolidaySettingsEntity;
import uz.project.template.entity.ExtraHolidayTableEntity;

import java.io.Serializable;

/**
 * DTO for {@link uz.project.template.entity.ExtraHolidaySettingsEntity}
 */
@Getter
@Setter
public class ExtraHolidaySettingsDto extends BaseDto {
    private Long id;
    private String name;
    private String color;
    private String description;

    public static ExtraHolidaySettingsEntity toEntity(ExtraHolidaySettingsDto dto, ExtraHolidaySettingsEntity entity) {
        entity.setId(dto.getId() != null ?  dto.getId() : entity.getId());
        entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
        entity.setColor(dto.getColor() != null ? dto.getColor() : entity.getColor());
        entity.setDescription(dto.getDescription() != null ? dto.getDescription() : entity.getDescription());
        return entity;
    }
}