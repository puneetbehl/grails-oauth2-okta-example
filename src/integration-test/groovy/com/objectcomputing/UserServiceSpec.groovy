package com.objectcomputing

import com.objectcopmuting.UserRoleService
import com.objectcopmuting.UserService
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class UserServiceSpec extends Specification {

    UserRoleService userRoleService
    UserService userService

    void "test UserRole.findAllByUser"() {
        given:
        userRoleService.createUser("juantest", "test@12345", "ROLE_TEST")
        User user = userService.findByUsername("juantest")

        expect:
        UserRole.findAllByUser(user)

    }
}
