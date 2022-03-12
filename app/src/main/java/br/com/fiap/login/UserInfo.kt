import com.google.gson.annotations.SerializedName

data class UserInfo (

//    username pra login
    @SerializedName("login") val user_name: String,
//    id para ser usado de senha
    @SerializedName("node_id") val password: String,
//    @SerializedName("id") val cep: Int,
//    nome para ser mostrado
    @SerializedName("name") val full_name: String,
//    repositórios que o usuário tem publico para pontuação
    @SerializedName("public_repos") val points: String,
//    fot0 do usuário
    @SerializedName("avatar_url") val photo: String
    
)