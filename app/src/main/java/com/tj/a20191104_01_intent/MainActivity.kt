package com.tj.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_user_info.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_CODE_FOR_NAME = 1000
    val REQ_CODE_FOR_PHONE = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInputBtn.setOnClickListener {
            var intent = Intent(this, EditUserInfoActivity::class.java)

            if (nameEdit.text.toString() != "이름 입력 필요") {


            }

//            startActivity(intent)
            startActivityForResult(intent,REQ_CODE_FOR_NAME)
        }

        phoneInputBtn.setOnClickListener {
            var intent = Intent(this, EditPhoneActivity::class.java)

            startActivityForResult(intent, REQ_CODE_FOR_PHONE)
        }

        phoneDialBtn.setOnClickListener {
            var uri = Uri.parse("tel:01031247792") //띄어쓰기 하면 안됨.
            var intent = Intent(Intent.ACTION_DIAL, uri)

            startActivity(intent)
        }

        phoneCallBtn.setOnClickListener {
//            var uri = Uri.parse("tel:01031247792")
//            var intent = Intent(Intent.ACTION_CALL, uri)
//            startActivity(intent)
        }

        smsBtn.setOnClickListener {
            var uri = Uri.parse("smsto:01031247792")
            var intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body","작업오더 2000이 진행되었습니다.")
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE_FOR_NAME) {
            if (resultCode == Activity.RESULT_OK) {
                var inputName = data?.getStringExtra("inputName")
//                nameText.text = inputName
                inputName?.let {
                    nameText.text=it
                }
            }
        }

        if (requestCode == REQ_CODE_FOR_PHONE) {
            if (resultCode == Activity.RESULT_OK) {
                var inputPhoneNum = data?.getStringExtra("phoneNum")
                inputPhoneNum?.let {
                    phoneText.text = it
                }
            }
        }
    }
}
