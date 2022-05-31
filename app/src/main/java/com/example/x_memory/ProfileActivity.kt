package com.example.x_memory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.ui.AppBarConfiguration
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.example.x_memory.databinding.ActivityProfileBinding

import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class ProfileActivity : AppCompatActivity() {

    private lateinit var auth:AWSMobileClient
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        auth = AWSMobileClient.getInstance()

        val userID = SharedPreferences.prefs.getString("id", "")
        binding.accountName.text = userID

        binding.btnLogout.setOnClickListener {
            logout_function()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_tab, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.signOut_button -> {
                logout_function()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun logout_function(){
        val i = Intent(this@ProfileActivity, AuthActivity::class.java)
        startActivity(i)
        finish()
//        AWSMobileClient.getInstance().initialize(
//            applicationContext,
//            object : Callback<UserStateDetails?> {
//                override fun onResult(userStateDetails: UserStateDetails?) {
//                    // 로그아웃 후 로그인 창으로 이동
//                    AWSMobileClient.getInstance().signOut()
//                    val i = Intent(this@ProfileActivity, AuthActivity::class.java)
//                    startActivity(i)
//                    finish()
//                }
//
//                override fun onError(e: Exception) {}
//            })
    }
}