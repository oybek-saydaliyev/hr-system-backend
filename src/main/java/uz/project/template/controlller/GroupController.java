package uz.project.template.controlller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.GroupDto;
import uz.project.template.service.GroupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody GroupDto dto){
        return ApiResponse.controller(groupService.create(dto));
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@RequestParam Long id){
        return ApiResponse.controller(groupService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(groupService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody GroupDto dto){
        return ApiResponse.controller(groupService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(groupService.delete(id));
    }

}
