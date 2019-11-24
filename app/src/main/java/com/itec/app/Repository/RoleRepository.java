package com.itec.app.Repository;

import java.util.Optional;


import com.itec.app.Entity.Role;
import com.itec.app.Entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);

}
