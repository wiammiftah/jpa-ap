package maenset.jpaenset.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import maenset.jpaenset.entities.Role;
import maenset.jpaenset.entities.User;
import maenset.jpaenset.repositories.RoleRepository;
import maenset.jpaenset.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
       return roleRepository.save(role);
    }

    @Override
    public User findUserByuserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByroleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=findUserByuserName(username);
        Role role=findRoleByroleName(roleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

        //userRepository.save(user);

    }
}
