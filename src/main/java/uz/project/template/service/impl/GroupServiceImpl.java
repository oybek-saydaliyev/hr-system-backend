package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.GroupDto;
import uz.project.template.entity.GroupEntity;
import uz.project.template.repository.GroupRepository;
import uz.project.template.service.GroupService;
import uz.project.template.utils.ResMessages;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public ApiResponse<?> create(GroupDto dto) {
        try{
            GroupEntity groupEntity = GroupDto.toEntity(dto, new GroupEntity());
            GroupEntity save = groupRepository.save(groupEntity);
            return new ApiResponse<>(true, save, ResMessages.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<GroupEntity> byId = groupRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Group not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAll() {
        try{
            return new ApiResponse<>(true, groupRepository.findAll(), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(GroupDto dto) {
        try{
            Optional<GroupEntity> byId = groupRepository.findById(dto.getId());
            if (byId.isPresent()) {
                GroupEntity groupEntity = GroupDto.toEntity(dto, byId.get());
                groupRepository.save(groupEntity);
                return new ApiResponse<>(true, groupEntity, ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Group not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            groupRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
