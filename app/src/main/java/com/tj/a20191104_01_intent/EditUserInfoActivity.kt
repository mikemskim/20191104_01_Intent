package com.tj.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_user_info.*

class EditUserInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user_info)

        okBtn.setOnClickListener {

            var intent = Intent()
            intent.putExtra("inputName",nameEdit.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        cancelBtn.setOnClickListener {
            finish() // 해당 엑티비티 종료
        }
    }
}
