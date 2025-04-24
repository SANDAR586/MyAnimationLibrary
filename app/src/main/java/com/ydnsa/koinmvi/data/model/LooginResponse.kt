import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val success: Boolean,
    val user: User
)

@Serializable
data class User(
    val id: Int,
    val name: String,
    val token: String
)
