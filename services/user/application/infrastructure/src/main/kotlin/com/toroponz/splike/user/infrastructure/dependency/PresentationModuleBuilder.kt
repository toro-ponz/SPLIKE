package com.toroponz.splike.user.infrastructure.dependency

import com.toroponz.splike.user.presentation.controller.AccessController
import com.toroponz.splike.user.presentation.controller.UserController
import org.koin.dsl.module

/**
 * presentation層への依存を解決する
 */
object PresentationModuleBuilder {
    /**
     * 依存モジュール
     */
    val module = module {
        single { AccessController(get(), get()) }
        single { UserController(get(), get()) }
    }
}
