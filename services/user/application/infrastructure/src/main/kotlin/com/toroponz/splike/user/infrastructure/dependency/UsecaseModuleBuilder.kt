package com.toroponz.splike.user.infrastructure.dependency

import com.toroponz.splike.user.usecase.service.AccessCreateService
import com.toroponz.splike.user.usecase.service.AccessCreateServiceImpl
import com.toroponz.splike.user.usecase.service.AccessListService
import com.toroponz.splike.user.usecase.service.AccessListServiceImpl
import com.toroponz.splike.user.usecase.service.UserCreateService
import com.toroponz.splike.user.usecase.service.UserCreateServiceImpl
import com.toroponz.splike.user.usecase.service.UserFindService
import com.toroponz.splike.user.usecase.service.UserFindServiceImpl
import org.koin.dsl.module

/**
 * usecase層への依存を解決する
 */
object UsecaseModuleBuilder {
    /**
     * 依存モジュール
     */
    val module = module {
        single<AccessCreateService> { AccessCreateServiceImpl(get(), get()) }
        single<AccessListService> { AccessListServiceImpl(get(), get()) }
        single<UserCreateService> { UserCreateServiceImpl(get()) }
        single<UserFindService> { UserFindServiceImpl(get()) }
    }
}
