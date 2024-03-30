package maenset.jpaenset.repositories;

import maenset.jpaenset.entities.Role;
import maenset.jpaenset.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
