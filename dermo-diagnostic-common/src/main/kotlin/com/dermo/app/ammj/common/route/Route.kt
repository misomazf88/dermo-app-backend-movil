package com.dermo.app.ammj.common.route

/**
 * This object contains the routes constants
 */
object Route {

    const val HEALTH = "/health"

    object Diagnostic {
        const val ACCOUNT = "/account/create"
        const val ACCOUNT_LOGIN = "/account/login"
        const val INJURY_CREATE = "/injury/create"
        const val INJURIES = "/injury/getall"
        const val INJURIES_ALL = "/injury/get/all"
        const val USER_PROFILE_CREATE = "/user/profile/create"
        const val USER_PROFILE_GET_ALL = "/user/profile/get/all"
    }

    object Cache {
        private const val CACHE = "/cache"
        const val DELETE_CACHE = "$CACHE/{key}"
    }
}
