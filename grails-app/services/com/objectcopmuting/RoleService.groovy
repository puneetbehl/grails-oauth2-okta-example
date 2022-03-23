package com.objectcopmuting

import com.objectcomputing.Role
import grails.gorm.services.Service

@Service(Role)
interface RoleService {
    Role save(Role role)
    Role save(String authority)
}