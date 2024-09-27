import com.ip.locator.data.remote.response.NetworkError
import com.ip.locator.data.remote.response.Results
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException
import io.ktor.client.request.*


class ApiService(val httpClient: HttpClient) {

    suspend inline fun <reified T> executeRequest(
        endpoint: String,
        method: HttpMethod,
        body: Any? = null // Optional request body for POST/PUT methods
    ): Flow<Results<T, NetworkError>> = flow {
        try {
            // Make the network request
            val response: HttpResponse = when (method) {
                HttpMethod.Get -> httpClient.get(endpoint)
                HttpMethod.Post -> httpClient.post(endpoint) {
                    setBody(body) // Set the body if it's not null
                }
                HttpMethod.Put -> httpClient.put(endpoint) {
                    setBody(body) // Set the body if it's not null
                }
                HttpMethod.Delete -> httpClient.delete(endpoint)
                else -> throw IllegalArgumentException("Unsupported HTTP method")
            }

            // Handle the response
            emit(when (response.status.value) {

                in 200..299 -> {
                    Results.Success(response.body<T>())
                }
                401 -> Results.Error(NetworkError.UNAUTHORIZED)
                409 -> Results.Error(NetworkError.CONFLICT)
                408 -> Results.Error(NetworkError.REQUEST_TIMEOUT)
                413 -> Results.Error(NetworkError.PAYLOAD_TOO_LARGE)
                in 500..599 -> Results.Error(NetworkError.SERVER_ERROR)
                else -> Results.Error(NetworkError.UNKNOWN)
            })
        } catch (e: UnresolvedAddressException) {
            emit(Results.Error(NetworkError.NO_INTERNET))
        } catch (e: SerializationException) {
            emit(Results.Error(NetworkError.SERIALIZATION))
        } catch (e: Exception) {
            emit(Results.Error(NetworkError.UNKNOWN)) // Catch-all for other exceptions
        }
    }
}