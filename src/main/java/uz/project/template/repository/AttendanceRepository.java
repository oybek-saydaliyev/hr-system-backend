package uz.project.template.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.project.template.base.BaseRepository;
import uz.project.template.entity.AttendanceEntity;
import uz.project.template.entity.enums.AttendanceStatus;

public interface AttendanceRepository extends BaseRepository<AttendanceEntity> {
    Page<AttendanceEntity> findAllByUserId(Long userId, Pageable pageable);

    @Query(value = "SELECT t.* FROM attendance t INNER JOIN users u ON u.id = t.user_id WHERE u.group_id =:groupId and t.status =:status", nativeQuery = true)
    Page<AttendanceEntity> findAllByUser_GroupIdAndStatus(@Param("groupId") Long groupId, @Param("status") AttendanceStatus status, Pageable pageable);
}