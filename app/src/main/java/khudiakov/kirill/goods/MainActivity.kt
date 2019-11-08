package khudiakov.kirill.goods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import khudiakov.kirill.goods.overview.OverviewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        browse_button.setOnClickListener {
            startActivity(Intent(this, OverviewActivity::class.java))
        }
    }
}
