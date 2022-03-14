package com.example.antontestapp.base

import androidx.annotation.VisibleForTesting

class BaseApiException : RuntimeException {
    var code = -1
        private set

    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(message: String?, code: Int) : this(message) {
        this.code = code
    }

    constructor(code: Int) : this("") {
        this.code = code
    }

    @get:Synchronized
    @get:VisibleForTesting
    override val cause: Throwable
        get() = super.cause!!
}