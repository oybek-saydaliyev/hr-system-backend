package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.SimpleScheduleDetailsEntity;

import java.time.LocalTime;

/**
 * DTO for {@link uz.project.template.entity.SimpleScheduleDetailsEntity}
 */
@Getter
@Setter
public class SimpleScheduleDetailsDto extends BaseDto {
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime requiredDurationHour;
    private LocalTime lunchDurationHour;
    private Boolean isHaveLunchTime;

    public static SimpleScheduleDetailsEntity toEntity(SimpleScheduleDetailsDto dto, SimpleScheduleDetailsEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
        entity.setStartTime(dto.getStartTime() != null ? dto.getStartTime() : entity.getStartTime());
        entity.setEndTime(dto.getEndTime() != null ? dto.getEndTime() : entity.getEndTime());
        entity.setRequiredDurationHour(dto.getRequiredDurationHour() != null ? dto.getRequiredDurationHour() : entity.getRequiredDurationHour());
        entity.setLunchDurationHour(dto.getLunchDurationHour() != null ? dto.getLunchDurationHour() : entity.getLunchDurationHour());
        entity.setIsHaveLunchTime(dto.getIsHaveLunchTime() != null ? dto.getIsHaveLunchTime() : entity.getIsHaveLunchTime());
        return entity;
    }
}