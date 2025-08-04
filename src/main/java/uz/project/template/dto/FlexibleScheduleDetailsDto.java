package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.FlexibleScheduleDetailsEntity;

import java.time.LocalTime;

/**
 * DTO for {@link FlexibleScheduleDetailsEntity}
 */
@Getter
@Setter
public class FlexibleScheduleDetailsDto extends BaseDto {
    private Long id;
    private Integer dayNumber;
    private String dayName;
    private LocalTime firstStartTime;
    private LocalTime firstEndTime;
    private LocalTime secondStartTime;
    private LocalTime secondEndTime;
    private Boolean isActive;
    private Boolean isHaveLunch;

    public static FlexibleScheduleDetailsEntity toEntity(FlexibleScheduleDetailsDto dto, FlexibleScheduleDetailsEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setDayNumber(dto.getDayNumber() != null ? dto.getDayNumber() : entity.getDayNumber());
        entity.setDayName(dto.getDayName() != null ? dto.getDayName() : entity.getDayName());
        entity.setFirstStartTime(dto.getFirstStartTime() != null ? dto.getFirstStartTime() : entity.getFirstStartTime());
        entity.setFirstEndTime(dto.getFirstEndTime() != null ? dto.getFirstEndTime() : entity.getFirstEndTime());
        entity.setSecondStartTime(dto.getSecondStartTime() != null ? dto.getSecondStartTime() : entity.getSecondStartTime());
        entity.setSecondEndTime(dto.getSecondEndTime() != null ? dto.getSecondEndTime() : entity.getSecondEndTime());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : entity.getIsActive());
        entity.setIsHaveLunch(dto.getIsHaveLunch() != null ? dto.getIsHaveLunch() : entity.getIsHaveLunch());
        return entity;
    }
}