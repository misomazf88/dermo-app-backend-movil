package com.dermo.app.ammj.common.route

/**
 * This object contains the routes constants
 */
object Route {

    const val HEALTH = "/health"

    object Diagnostic {
        const val DIAGNOSTIC = "/diagnostic"
        const val ACCOUNT = "/account/create"
        const val ACCOUNT_LOGIN = "/account/login"
        const val DIAGNOSTIC_CREATE = "/create"
    }

    object Cache {
        private const val CACHE = "/cache"
        const val DELETE_CACHE = "$CACHE/{key}"
    }
}
