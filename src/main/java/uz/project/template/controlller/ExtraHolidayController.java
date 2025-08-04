package uz.project.template.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.ExtraHolidaySettingsDto;
import uz.project.template.dto.ExtraHolidayTableDto;
import uz.project.template.service.ExtraHolidaySettingsService;
import uz.project.template.service.ExtraHolidayTableService;

@RestController
@RequestMapping("/api/v1/extra/holiday")
public class ExtraHolidayController {

    private final ExtraHolidayTableService extraHolidayTableService;
    private final ExtraHolidaySettingsService extraHolidaySettingsService;

    public ExtraHolidayController(ExtraHolidayTableService extraHolidayTableService, ExtraHolidaySettingsService extraHolidaySettingsService) {
        this.extraHolidayTableService = extraHolidayTableService;
        this.extraHolidaySettingsService = extraHolidaySettingsService;
    }

    @PostMapping("/table/create")
    public ResponseEntity<?> createTable(@RequestBody ExtraHolidayTableDto dto){
        return ApiResponse.controller(extraHolidayTableService.create(dto));
    }

    @GetMapping("/table/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id){
        return ApiResponse.controller(extraHolidayTableService.getOne(id));
    }

    @GetMapping("/table/getAll")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(extraHolidayTableService.getAll());
    }

    @PutMapping("/table/update")
    public ResponseEntity<?> updateTable(@RequestBody ExtraHolidayTableDto dto){
        return ApiResponse.controller(extraHolidayTableService.update(dto));
    }

    @DeleteMapping("/table/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ApiResponse.controller(extraHolidayTableService.delete(id));
    }

    @PostMapping("/settings/create")
    public ResponseEntity<?> createSettings(@RequestBody ExtraHolidaySettingsDto dto){
        return ApiResponse.controller(extraHolidaySettingsService.create(dto));
    }

    @GetMapping("/settings/getOne")
    public ResponseEntity<?> getSettings(@RequestParam Long id){
        return ApiResponse.controller(extraHolidaySettingsService.getOne(id));
    }

    @GetMapping("/settings/getAll")
    public ResponseEntity<?> getAllSettings(){
        return ApiResponse.controller(extraHolidaySettingsService.getAll());
    }

    @PutMapping("/settings/update")
    public ResponseEntity<?> updateSettings(@RequestBody ExtraHolidaySettingsDto dto){
        return ApiResponse.controller(extraHolidaySettingsService.update(dto));
    }

    @DeleteMapping("/settings/delete")
    public ResponseEntity<?> deleteSettings(@RequestParam Long id){
        return ApiResponse.controller(extraHolidaySettingsService.delete(id));
    }
}
