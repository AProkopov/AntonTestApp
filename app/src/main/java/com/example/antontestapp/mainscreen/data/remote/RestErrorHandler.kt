package com.example.antontestapp.mainscreen.data.remote

import com.example.antontestapp.base.BaseApiException
import io.reactivex.SingleTransformer
import retrofit2.HttpException
import retrofit2.Response
import java.net.HttpURLConnection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestErrorHandler @Inject constructor() {

    fun <T> get(): SingleTransformer<Response<T>, T> {

        return SingleTransformer { single ->
            single.map { response ->
                when {
                    response.isSuccessful -> return@map response.body()

                    // here we can add check for more error types
                    response.code() == HttpURLConnection.HTTP_UNAUTHORIZED -> throw HttpException(
                        response
                    )
                    else -> throw BaseApiException(
                        message = response.message(),
                        code = response.code(),
                    )
                }
            }
        }
    }
}