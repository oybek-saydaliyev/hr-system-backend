package uz.project.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.project.template.base.ApiResponse;
import uz.project.template.dto.FlexibleScheduleDetailsDto;
import uz.project.template.entity.FlexibleScheduleDetailsEntity;
import uz.project.template.repository.FlexibleScheduleDetailsRepository;
import uz.project.template.service.FlexibleScheduleDetailsService;
import uz.project.template.utils.ResMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlexibleScheduleDetailsServiceImpl implements FlexibleScheduleDetailsService {
    private final FlexibleScheduleDetailsRepository flexibleScheduleDetailsRepository;

    @Override
    public ApiResponse<?> createList(List<FlexibleScheduleDetailsDto> dtos) {
        try{
            List<FlexibleScheduleDetailsEntity> entities = new ArrayList<>();
            for (FlexibleScheduleDetailsDto dto : dtos) {
                FlexibleScheduleDetailsEntity one = createOne(dto);
                entities.add(one);
            }
            return new ApiResponse<>(true, entities, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    private FlexibleScheduleDetailsEntity createOne(FlexibleScheduleDetailsDto dto) {
        try{
            FlexibleScheduleDetailsEntity entity = FlexibleScheduleDetailsDto.toEntity(dto, new FlexibleScheduleDetailsEntity());
            return flexibleScheduleDetailsRepository.save(entity);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        try{
            Optional<FlexibleScheduleDetailsEntity> byId = flexibleScheduleDetailsRepository.findById(id);
            if (byId.isPresent()) {
                return new ApiResponse<>(true, byId.get(), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Data not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> getAllByIds(List<Long> ids) {
        try{
            return new ApiResponse<>(true, flexibleScheduleDetailsRepository.findAllById(ids), ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> update(FlexibleScheduleDetailsDto dto) {
        try{
            Optional<FlexibleScheduleDetailsEntity> byId = flexibleScheduleDetailsRepository.findById(dto.getId());
            if (byId.isPresent()) {
                FlexibleScheduleDetailsEntity entity = FlexibleScheduleDetailsDto.toEntity(dto, byId.get());
                return new ApiResponse<>(true, flexibleScheduleDetailsRepository.save(entity), ResMessages.SUCCESS);
            }
            return new ApiResponse<>(false, "Data not found");
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        try{
            flexibleScheduleDetailsRepository.deleteById(id);
            return new ApiResponse<>(true, ResMessages.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
