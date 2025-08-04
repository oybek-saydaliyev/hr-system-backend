package uz.project.template.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;
import uz.project.template.entity.enums.HolidayType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "extra_holidays_table")
public class ExtraHolidayTableEntity extends BaseEntity {
    private HolidayType type;

    private LocalDate date;
    private LocalTime duration;

    private LocalDate startDate;
    private LocalDate endDate;

    private List<Long> usersId;

    @Column(nullable = false)
    private Long extraHolidaySettingsId;

    @Column(columnDefinition = "TEXT")
    private String description;
}
