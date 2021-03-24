import com.example.machinetesting.model.ResponseModel
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {

    @GET("list")
    fun vehicleList(): Call<List<ResponseModel>>

}