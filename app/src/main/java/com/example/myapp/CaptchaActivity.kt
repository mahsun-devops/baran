import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.safetynet.SafetyNet
import com.google.android.gms.tasks.OnSuccessListener

class CaptchaActivity : AppCompatActivity() {

    private val SITE_KEY = "YOUR_SITE_KEY_HERE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_captcha)

        findViewById<Button>(R.id.verify_button).setOnClickListener {
            verifyCaptcha()
        }
    }

    private fun verifyCaptcha() {
        SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
            .addOnSuccessListener { response ->
                if (response.tokenResult?.isNotEmpty() == true) {
                    // CAPTCHA doğrulama başarılı
                    Toast.makeText(this, "CAPTCHA doğrulandı!", Toast.LENGTH_SHORT).show()
                    // Burada sunucunuza doğrulama yapabilirsiniz
                }
            }
            .addOnFailureListener { e ->
                // CAPTCHA doğrulama başarısız
                Toast.makeText(this, "CAPTCHA doğrulanamadı: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}