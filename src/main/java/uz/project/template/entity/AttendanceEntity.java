package uz.project.template.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import uz.project.template.base.BaseEntity;
import uz.project.template.entity.enums.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity(name = "attendance")
public class AttendanceEntity extends BaseEntity {
    private Long userId;
    private LocalDate data;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime checkInTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime checkOutTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime lateDuration;

    private AttendanceStatus status;
}
