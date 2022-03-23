package com.objectcomputing

import com.objectcopmuting.UserRoleService

class BootStrap {

    UserRoleService userRoleService

    def init = { servletContext ->
//        userRoleService.createUser("juan", "juan123", "ROLE_ADMIN")
    }
    def destroy = {}
}
