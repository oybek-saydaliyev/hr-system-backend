package uz.project.template.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.WorkTableDto;
import uz.project.template.service.WorkTableService;

@RestController
@RequestMapping("/api/v1/work/table")
public class WorkTableController {

    private final WorkTableService workTableService;

    public WorkTableController(WorkTableService workTableService) {
        this.workTableService = workTableService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody WorkTableDto dto){
        return ApiResponse.controller(workTableService.createOne(dto));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id){
        return ApiResponse.controller(workTableService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(workTableService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody WorkTableDto dto){
        return ApiResponse.controller(workTableService.update(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ApiResponse.controller(workTableService.deleteOne(id));
    }

}
