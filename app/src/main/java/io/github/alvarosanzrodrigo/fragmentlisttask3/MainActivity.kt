package io.github.alvarosanzrodrigo.fragmentlisttask3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //@BindView(R.id.editText2) lateinit var txtEmail : EditText
    lateinit var txtEmail: EditText
    lateinit var txtPsw: EditText
    lateinit var btnGo: Button
    val mailPattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEmail = findViewById(R.id.editText2)
        txtPsw = findViewById(R.id.editText3)
        btnGo = findViewById(R.id.btnGo)
        btnGo.setTextColor(resources.getColor(R.color.grey))
        title="U-Tad Manager"
        txtWatch(txtEmail)
        txtWatch(txtPsw)
    }

    fun onGoPressed(view: View) {
        if (txtEmail.text.toString().equals("ejemplo@ejemplo.com") && txtPsw.text.toString().equals("123")) {
            val intent = Intent(this, PrincipalActivity::class.java)

           // val us = User()
            //us.email = txtEmail.text.toString()
           // us.password = txtPsw.text.toString()
            //intent.putExtra(User.intentKey, us)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_LONG).show()
        }
    }

    fun txtWatch(txt: EditText) {
        txt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (mailPattern.matcher(txtEmail.text.toString()).matches()) {
                    btnGo.isEnabled = !txtPsw.text.toString().equals("")
                    btnGo.setTextColor(resources.getColor(R.color.white))
                }else{
                    txtEmail.error = "Is not a valid email"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (mailPattern.matcher(txtEmail.text.toString()).matches()) {
                    btnGo.isEnabled = !txtPsw.text.toString().equals("")
                    btnGo.setTextColor(resources.getColor(R.color.white))
                }else{
                    txtEmail.error = "Is not a valid email"
                }
            }
        })
    }
}
