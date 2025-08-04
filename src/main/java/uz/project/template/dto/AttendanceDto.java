package uz.project.template.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseDto;
import uz.project.template.entity.AttendanceEntity;
import uz.project.template.entity.enums.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link uz.project.template.entity.AttendanceEntity}
 */
@Getter
@Setter
public class AttendanceDto extends BaseDto{
    private Long id;
    private Long userId;
    private LocalDate data;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private LocalTime lateDuration;
    private AttendanceStatus status;

    public static AttendanceEntity toEntity(AttendanceDto dto, AttendanceEntity entity) {
        entity.setId(dto.getId() != null ? dto.getId() : entity.getId());
        entity.setUserId(dto.getUserId() != null ? dto.getUserId() : entity.getUserId());
        entity.setData(dto.getData() != null ? dto.getData() : entity.getData());
        entity.setCheckInTime(dto.getCheckInTime() != null ? dto.getCheckInTime() : entity.getCheckInTime());
        entity.setCheckOutTime(dto.getCheckOutTime() != null ? dto.getCheckOutTime() : entity.getCheckOutTime());
        entity.setLateDuration(dto.getLateDuration() != null ? dto.getLateDuration() : entity.getLateDuration());
        entity.setStatus(dto.getStatus() != null ? dto.getStatus() : entity.getStatus());
        return entity;
    }
}