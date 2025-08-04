package uz.project.template.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.FlexibleScheduleDetailsDto;
import uz.project.template.service.FlexibleScheduleDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flexible/schedule/details")
public class FlexibleScheduleDetailController {

    private final FlexibleScheduleDetailsService flexibleScheduleDetailsService;

    public FlexibleScheduleDetailController(FlexibleScheduleDetailsService flexibleScheduleDetailsService) {
        this.flexibleScheduleDetailsService = flexibleScheduleDetailsService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody List<FlexibleScheduleDetailsDto> dtos){
        return ApiResponse.controller(flexibleScheduleDetailsService.createList(dtos));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam("id") Long id){
        return ApiResponse.controller(flexibleScheduleDetailsService.getOne(id));
    }

    @GetMapping("/getAllById")
    public ResponseEntity<?> getAllById(@RequestParam("ids") List<Long> ids){
        return ApiResponse.controller(flexibleScheduleDetailsService.getAllByIds(ids));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody FlexibleScheduleDetailsDto dto){
        return ApiResponse.controller(flexibleScheduleDetailsService.update(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Long id){
        return ApiResponse.controller(flexibleScheduleDetailsService.delete(id));
    }
}
