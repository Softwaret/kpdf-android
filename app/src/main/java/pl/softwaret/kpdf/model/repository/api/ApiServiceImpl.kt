@file:Suppress("EXPERIMENTAL_API_USAGE")

package pl.softwaret.kpdf.model.repository.api

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.cookies.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import pl.softwaret.kpdf.model.repository.api.entity.*
import pl.softwaret.kpdf.util.extenstion.mapError
import pl.softwaret.kpdf.util.extenstion.onValue
import pl.softwaret.kpdf.util.extenstion.runTrying

class ApiServiceImpl : ApiService {

    companion object {
        private const val BASE_URL = "https://0.0.0.0:8080"
    }

    private val apiClient = HttpClient(CIO.create()) {
        install(HttpCookies)
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }

        HttpResponseValidator {
            validateResponse { response ->
                if (response.status.value !in 200..299) {
                    throw Exception("Invalid api response code")
                }
            }
        }
    }

    private var loginToken: String? = null

    override suspend fun registerUser(login: String, password: String, name: String) = runRequest {
        apiClient.get<RegisterResponse>("$BASE_URL/register?login=$login&password=$password&name=$name")
    }

    override suspend fun loginUser(login: String, password: String) = runRequest {
        apiClient.get<LoginResponse>("$BASE_URL/login?login=$login&password=$password")
    }.onValue { loginToken = it.token }

    override suspend fun getPublication(id: Int) = runRequest {
        apiClient.get<GetPublicationResponse>("$BASE_URL/publications?publicationId=$id")
    }

    override suspend fun uploadPublication(
        name: String,
        pdfBase64: String,
        description: String
    ) = runRequest {
        apiClient.post<UploadPublicationResponse>("$BASE_URL/publications?name=$name&pdfBase64=$pdfBase64&description=$description")
    }

    override suspend fun updatePublication(publicationId: Int, pdfBase64: String) = runRequest {
        apiClient.put<UpdatePublicationResponse>("$BASE_URL/publications?publicationId=$publicationId&pdfBase64=$pdfBase64")
    }

    override suspend fun deletePublication(publicationId: Int) = runRequest {
        apiClient.delete<DeletePublicationResponse>("$BASE_URL/publications?publicationId=$publicationId")
    }

    private inline fun <reified T> runRequest(block: () -> T) =
        runTrying(block).mapError {}
}