package com.toroponz.splike.user.access.datastore.mysql.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object UserAuthenticationInformationTable : LongIdTable("user_authentication_information") {
    val userId = long("user_id").references(UserTable.id)
    val email = varchar("email", 191).uniqueIndex()
    val password = varchar("name", 191)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}
