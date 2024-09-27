package com.ip.locator.data.remote.response

sealed interface Results<out D, out E: Error> {
    data class Success<out D>(val data: D): Results<D, Nothing>
    data class Error<out E: com.ip.locator.data.remote.response.Error>(val error: E): Results<Nothing, E>
}

inline fun <T, E: Error, R> Results<T, E>.map(map: (T) -> R): Results<R, E> {
    return when(this) {
        is Results.Error -> Results.Error(error)
        is Results.Success -> Results.Success(map(data))
    }
}

fun <T, E: Error> Results<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {  }
}

inline fun <T, E: Error> Results<T, E>.onSuccess(action: (T) -> Unit): Results<T, E> {
    return when(this) {
        is Results.Error -> this
        is Results.Success -> {
            action(data)
            this
        }
    }
}
inline fun <T, E: Error> Results<T, E>.onError(action: (E) -> Unit): Results<T, E> {
    return when(this) {
        is Results.Error -> {
            action(error)
            this
        }
        is Results.Success -> this
    }
}

typealias EmptyResult<E> = Results<Unit, E>