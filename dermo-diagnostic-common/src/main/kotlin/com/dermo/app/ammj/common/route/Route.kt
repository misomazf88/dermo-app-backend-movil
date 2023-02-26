package com.dermo.app.ammj.common.route

/**
 * This object contains the routes constants
 */
object Route {

    const val HEALTH = "/health"

    object Diagnostic {
        const val ACCOUNT = "/account/create"
        const val ACCOUNT_LOGIN = "/account/login"
        const val DIAGNOSTIC_CREATE = "/diagnostic/create"
        const val DIAGNOSTIC_PROFILE_CREATE = "/diagnostic/profile/create"
        const val USER_PROFILE_CREATE = "/user/profile/create"
    }

    object Cache {
        private const val CACHE = "/cache"
        const val DELETE_CACHE = "$CACHE/{key}"
    }
}
