package maenset.jpaenset.repositories;

import maenset.jpaenset.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);
}
