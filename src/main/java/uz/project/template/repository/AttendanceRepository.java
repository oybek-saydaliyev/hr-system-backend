package uz.project.template.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.project.template.base.BaseRepository;
import uz.project.template.entity.AttendanceEntity;
import uz.project.template.entity.enums.AttendanceStatus;

import java.util.List;

public interface AttendanceRepository extends BaseRepository<AttendanceEntity> {
    List<AttendanceEntity> findAllByUserId(Long userId);

    @Query(value = "SELECT t.* FROM attendance t INNER JOIN users u ON u.id = t.user_id WHERE u.group_id =:groupId and t.status =:status", nativeQuery = true)
    List<AttendanceEntity> findAllByUser_GroupIdAndStatus(@Param("groupId") Long groupId,@Param("status") AttendanceStatus status);
}