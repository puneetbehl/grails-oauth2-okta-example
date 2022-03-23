package com.objectcopmuting

import com.objectcomputing.Role
import com.objectcomputing.User
import com.objectcomputing.UserRole
import grails.gorm.services.Service

@Service(UserRole)
abstract class UserRoleService {

    UserService userService
    RoleService roleService

    abstract UserRole save(UserRole userRole)

    void createUser(String username, String password, String[] authorities) {
        User user = userService.save(username, password)
        authorities.each {
            final Role role = roleService.save(it)
            save(new UserRole(user: user, role: role))
        }
    }


}
