package uz.project.template.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.SimpleScheduleDetailsDto;
import uz.project.template.service.SimpleScheduleDetailService;

@RestController
@RequestMapping("/api/v1/simple/schedule/details")
public class SimpleScheduleDetailController {

    private final SimpleScheduleDetailService simpleScheduleDetailService;

    public SimpleScheduleDetailController(SimpleScheduleDetailService simpleScheduleDetailService) {
        this.simpleScheduleDetailService = simpleScheduleDetailService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SimpleScheduleDetailsDto dto){
        return ApiResponse.controller(simpleScheduleDetailService.create(dto));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id){
        return ApiResponse.controller(simpleScheduleDetailService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(simpleScheduleDetailService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody SimpleScheduleDetailsDto dto){
        return ApiResponse.controller(simpleScheduleDetailService.update(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ApiResponse.controller(simpleScheduleDetailService.delete(id));
    }
}
