package uz.project.template.dto;

import lombok.Getter;
import lombok.Setter;
import uz.project.template.entity.WorkTableEntity;
import uz.project.template.entity.enums.ScheduleType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link uz.project.template.entity.WorkTableEntity}
 */
@Getter
@Setter
public class WorkTableDto implements Serializable {
    private Long id;
    private String name;
    private ScheduleType scheduleType;
    private LocalDate startDate;
    private List<Long> flexibleDetails;
    private Long simpleDetails;

    public static WorkTableEntity toEntity(WorkTableDto dto, WorkTableEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
        entity.setScheduleType(dto.getScheduleType() != null ? dto.getScheduleType() : entity.getScheduleType());
        entity.setStartDate(dto.getStartDate() != null ? dto.getStartDate() : entity.getStartDate());
        entity.setFlexibleDetails(dto.getFlexibleDetails() != null ? dto.getFlexibleDetails() : entity.getFlexibleDetails());
        entity.setSimpleDetails(dto.getSimpleDetails() != null ? dto.getSimpleDetails() : entity.getSimpleDetails());
        return entity;
    }
}