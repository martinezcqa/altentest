package es.maincode.openbanktest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.maincode.openbanktest.R
import es.maincode.openbanktest.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}