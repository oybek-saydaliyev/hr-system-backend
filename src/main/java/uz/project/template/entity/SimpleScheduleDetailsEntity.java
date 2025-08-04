package uz.project.template.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;

import java.time.LocalTime;

@Getter
@Setter
@Entity(name = "simple_schedule_details")
public class SimpleScheduleDetailsEntity extends BaseEntity {
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;

    private LocalTime requiredDurationHour;

    private LocalTime lunchDurationHour;
    private Boolean isHaveLunchTime = false;
}
