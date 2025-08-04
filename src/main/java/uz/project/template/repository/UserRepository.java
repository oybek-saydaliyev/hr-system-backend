package uz.project.template.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.project.template.base.BaseRepository;
import uz.project.template.entity.AuthUserEntity;

import java.util.Optional;


public interface UserRepository extends BaseRepository<AuthUserEntity> {
    Optional<AuthUserEntity> findByUsername(String username);

    @Query("FROM users t JOIN t.roles r WHERE r.id = :roleId")
    Page<AuthUserEntity> findAllByRoleId(@Param("roleId") Long roleId, Pageable pageable);

}