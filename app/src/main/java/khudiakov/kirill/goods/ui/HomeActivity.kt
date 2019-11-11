package khudiakov.kirill.goods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import khudiakov.kirill.goods.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        browse_button.setOnClickListener {
            startActivity(Intent(this, OverviewActivity::class.java))
        }
    }
}
