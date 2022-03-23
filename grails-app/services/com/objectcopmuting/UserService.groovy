package com.objectcopmuting

import com.objectcomputing.User
import grails.gorm.services.Service

@Service(User)
interface UserService {
   User save(User user)
   User save(String username, String password)
   User findByUsername(String username)
}
