package uz.project.template.controlller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.AttendanceDto;
import uz.project.template.entity.enums.AttendanceStatus;
import uz.project.template.service.AttendanceService;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AttendanceDto dto){
        return ApiResponse.controller(attendanceService.create(dto));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id){
        return ApiResponse.controller(attendanceService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam int page, @RequestParam int size){
        return ApiResponse.controller(attendanceService.getAll(PageRequest.of(page, size)));
    }

    @GetMapping("/getAllByUser")
    public ResponseEntity<?> getAllByUser(@RequestParam Long id, @RequestParam int page, @RequestParam int size){
        return ApiResponse.controller(attendanceService.getAllByUserId(id, PageRequest.of(page, size)));
    }

    @GetMapping("/getAllByGroup")
    public ResponseEntity<?> getAllByGroup(@RequestParam Long id, @RequestParam AttendanceStatus status,
                                           @RequestParam int page, @RequestParam int size){
        return ApiResponse.controller(attendanceService.getAllByGroupAndStatus(id, status, PageRequest.of(page, size)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AttendanceDto dto){
        return ApiResponse.controller(attendanceService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(attendanceService.delete(id));
    }
}
