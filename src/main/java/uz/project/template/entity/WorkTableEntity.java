package uz.project.template.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;
import uz.project.template.entity.enums.ScheduleType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "work_table")
public class WorkTableEntity extends BaseEntity {
    private String name;
    private ScheduleType scheduleType;

    private LocalDate startDate;

    private List<Long> flexibleDetails = new ArrayList<>();
    private Long simpleDetails;
}
