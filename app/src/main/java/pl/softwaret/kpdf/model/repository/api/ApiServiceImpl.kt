@file:Suppress("EXPERIMENTAL_API_USAGE")

package pl.softwaret.kpdf.model.repository.api

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.cookies.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import pl.softwaret.kpdf.model.repository.api.entity.LoginResponse
import pl.softwaret.kpdf.model.repository.api.entity.RegisterResponse
import pl.softwaret.kpdf.util.extenstion.mapError
import pl.softwaret.kpdf.util.extenstion.runTrying

class ApiServiceImpl : ApiService {

    companion object {
        private const val BASE_URL = "0.0.0.0:8080"
    }

    private val apiClient = HttpClient(CIO.create()) {
        install(HttpCookies)
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }

        HttpResponseValidator {
            validateResponse { response ->
                if (response.status.value !in 200..299) {
                    throw Exception("Invalid api response code")
                }
            }
        }
    }

    override suspend fun registerUser(login: String, password: String, name: String) =
        runTrying { apiClient.get<RegisterResponse>("$BASE_URL/register?login=$login&password=$password&name=$name") }
            .mapError { Unit }

    override suspend fun loginUser(login: String, password: String) =
        runTrying { apiClient.get<LoginResponse>("$BASE_URL/login?login=$login&password=$password") }
            .mapError { Unit }
}