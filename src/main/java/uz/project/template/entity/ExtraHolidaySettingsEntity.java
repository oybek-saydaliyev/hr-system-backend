package uz.project.template.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.project.template.base.BaseEntity;

@Getter
@Setter
@Entity(name = "extra_holiday_settings")
public class ExtraHolidaySettingsEntity extends BaseEntity {
    private String name;
    private String color;
    private String description;
}
