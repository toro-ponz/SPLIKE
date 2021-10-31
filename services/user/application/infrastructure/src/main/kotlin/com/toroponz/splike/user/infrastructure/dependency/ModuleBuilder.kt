package com.toroponz.splike.user.infrastructure.dependency

/**
 * 依存を解決する
 */
object ModuleBuilder {
    val modules = listOf(
        AccessModuleBuilder.module,
        InfrastructureModuleBuilder.module,
        PresentationModuleBuilder.module,
        UsecaseModuleBuilder.module
    )
}
