package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.ExtraHolidayTableEntity;
import uz.project.template.entity.enums.HolidayType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * DTO for {@link uz.project.template.entity.ExtraHolidayTableEntity}
 */
@Getter
@Setter
public class ExtraHolidayTableDto extends BaseDto {
    private Long id;
    private HolidayType type;
    private LocalDate date;
    private LocalTime duration;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> usersId;
    private Long extraHolidaySettingsId;
    private String description;


    public static ExtraHolidayTableEntity toEntity(ExtraHolidayTableDto dto, ExtraHolidayTableEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setType(dto.getType() != null ? dto.getType() : entity.getType());
        entity.setDate(dto.getDate() != null ? dto.getDate() : entity.getDate());
        entity.setDuration(dto.getDuration() != null ? dto.getDuration() : entity.getDuration());
        entity.setStartDate(dto.getStartDate() != null ? dto.getStartDate() : entity.getStartDate());
        entity.setEndDate(dto.getEndDate() != null ? dto.getEndDate() : entity.getEndDate());
        entity.setUsersId(dto.getUsersId() != null ? dto.getUsersId() : entity.getUsersId());
        entity.setExtraHolidaySettingsId(dto.getExtraHolidaySettingsId() != null ? dto.getExtraHolidaySettingsId() : entity.getExtraHolidaySettingsId());
        entity.setDescription(dto.getDescription() != null ? dto.getDescription() : entity.getDescription());
        return entity;
    }
}