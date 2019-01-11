package later.corporation.adliraihan.schedule_app.DatabaseSchedule_app

import android.content.Context
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import later.corporation.adliraihan.schedule_app.splashing
import okhttp3.*
import org.json.JSONArray
import java.io.IOException
import java.lang.IllegalStateException
import java.security.KeyStore
import java.security.Policy
import java.security.Policy.setPolicy
import java.util.*
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

//================================================//
// Any question : ask me @ adliraihan001@gmal.com //
//===============================================//
val tags = "common_database[DEV]"
class common_database : AppCompatActivity(){

    companion object {
        val defaultUri = "http://192.168.43.159:81/schedule_app/index.php?do=read&id=1"
        val ruleConnection = ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS)
            .tlsVersions(TlsVersion.TLS_1_2,TlsVersion.TLS_1_1,TlsVersion.TLS_1_0).cipherSuites(
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA
            ).build()
    }
    fun onReadIDTarget(context: Context){
        getCertificate().onGet()?.build()!!.newCall(Request.Builder()
            .url( defaultUri).build())
            .enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    println(e.toString() + "${call}")
                }
                override fun onResponse(call: Call, response: Response) {
                    if(!response.isSuccessful){
                        throw IOException("code Error ${response}")
                    }else{
                        runOnUiThread {
                            try{
                                JSONArray(response?.body()?.string()).apply {
                                    if(this.length() < 0 )
                                        println("Kosong")

                                    for(i:Int in 0..(this.length()-1)){
                                        println("Hello , ${getJSONObject(i)} !")
                                    }
                                }
                            }
                            catch (E:Exception){
                                throw IOException("tidak terholder ${E.printStackTrace()}")
                            }
                            //
                        }
                        //
                    }
                    //
                }
                //
            })
    }
    class getCertificate{
        fun onGet() : OkHttpClient.Builder?{
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()).apply {
                init(null as KeyStore?)
                trustManagers.apply {
                    SSLContext.getInstance("SSL").also {
                        it.init(null, arrayOf(trustManagers[0] as X509TrustManager),null).apply {
                            return OkHttpClient.Builder().sslSocketFactory(it.socketFactory,trustManagers[0] as X509TrustManager)
                        }
                        //
                    }
                    //
                }
                //
            }
            //
            return null
        }
    }
}