package com.toroponz.splike.user.infrastructure.dependency

import com.toroponz.splike.user.access.datastore.dynamodb.AccessRepositoryImpl
import com.toroponz.splike.user.access.datastore.mysql.UserRepositoryImpl
import com.toroponz.splike.user.usecase.repository.AccessRepository
import com.toroponz.splike.user.usecase.repository.UserRepository
import org.koin.dsl.module

/**
 * access層への依存を解決する
 */
object AccessModuleBuilder {
    /**
     * 依存モジュール
     */
    val module = module {
        single<AccessRepository> { AccessRepositoryImpl() }
        single<UserRepository> { UserRepositoryImpl() }
    }
}
