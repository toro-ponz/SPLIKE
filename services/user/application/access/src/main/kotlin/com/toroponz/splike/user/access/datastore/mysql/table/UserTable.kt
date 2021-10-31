package com.toroponz.splike.user.access.datastore.mysql.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object UserTable : LongIdTable("user") {
    val userKey = varchar("user_key", 191).uniqueIndex()
    val uuid = varchar("uuid", 191).uniqueIndex()
    val name = varchar("name", 191)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}
