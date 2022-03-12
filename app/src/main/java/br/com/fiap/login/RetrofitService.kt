import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

//    https://api.github.com/users/Vinicius-Mance
    @GET("{user}")

    fun getUser(@Path("user") user : String) : Call<UserInfo>
    
}