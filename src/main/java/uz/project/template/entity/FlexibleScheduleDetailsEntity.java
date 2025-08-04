package uz.project.template.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;

import java.time.LocalTime;

@Getter
@Setter
@Entity(name = "flexible_schedule_details")
public class FlexibleScheduleDetailsEntity extends BaseEntity {

    private Integer dayNumber;
    private String dayName;

    private LocalTime firstStartTime;
    private LocalTime firstEndTime;

    private LocalTime secondStartTime;
    private LocalTime secondEndTime;

    private Boolean isActive = true;
    private Boolean isHaveLunch = false;

}
