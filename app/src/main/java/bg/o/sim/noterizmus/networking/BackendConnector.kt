package bg.o.sim.noterizmus.networking

import android.util.Log
import bg.o.sim.noterizmus.persistance.Note
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MongrelService {
    @GET("notes/all")
    fun getAllNotes(): Call<List<Note>>

    @POST("notes/save")
    fun saveNote(@Body note: Note): Call<Note>
}

val mongrelClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(30_000, TimeUnit.MILLISECONDS)
    .readTimeout(30_000, TimeUnit.MILLISECONDS)
    .addInterceptor(HttpLoggingInterceptor{ Log.d("HTTP LOG" /*TODO*/, "\n $it \n")}.setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

val backendService = Retrofit.Builder()
    .client(mongrelClient)
    .baseUrl(HttpUrl.Builder().scheme("http").host("192.168.1.7").port(19000).build())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(MongrelService::class.java)!!