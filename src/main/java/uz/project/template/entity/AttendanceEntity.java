package uz.project.template.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
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

    private LocalTime checkInTime;
    private LocalTime checkOutTime;

    private LocalTime lateDuration;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;
}
