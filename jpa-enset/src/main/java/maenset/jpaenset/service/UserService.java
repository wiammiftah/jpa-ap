package maenset.jpaenset.service;

import maenset.jpaenset.entities.Role;
import maenset.jpaenset.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByuserName(String username);
    Role findRoleByroleName(String roleName);
    void addRoleToUser(String username,String roleName);

}
