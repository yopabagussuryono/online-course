package com.example.homepage.Activity


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import com.example.homepage.R

class ActivityAssigment : AppCompatActivity() {

    public lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assigment)
        setSupportActionBar(findViewById(R.id.tbasigmt))


        val actionbar = supportActionBar
        actionbar!!.title = "Assigment"
        actionbar.setDisplayHomeAsUpEnabled(true)

        image = findViewById(R.id.tesimage)

        val btnAss : Button = findViewById(R.id.btnasig)
        btnAss.setOnClickListener(View.OnClickListener {

            CostumDialog().show(supportFragmentManager,"SELECT CONTENT")
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val cls : Class<MainActivity> = MainActivity::class.java
        val inten : Intent = Intent(this,cls)
        startActivity(inten)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        val cls : Class<MainActivity> = MainActivity::class.java
        val inten : Intent = Intent(this,cls)
        startActivity(inten)
        finish()
        return true
    }

    class CostumDialog : DialogFragment(){

        override fun onCreateView(inflater: LayoutInflater,
            container: ViewGroup?,savedInstanceState: Bundle?
        ): View? {
            dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_card_green)
            return inflater.inflate(R.layout.alert_dialog_pick_file,container,false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val camera : Button = view.findViewById(R.id.btn_camera_dialog)
            val galery : Button = view.findViewById(R.id.btn_galery_dialog)
            val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result:ActivityResult? ->
                if (result?.resultCode == Activity.RESULT_OK){
                    Log.e("ImageSelect",""+result?.data?.extras?.get("data").toString())
                }else{
                    Log.e("ImageSelect","Data Kosong")
                }
            }

            camera.setOnClickListener(View.OnClickListener {
                var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                resultContract.launch(intent)
//                Toast.makeText(view.context,"Aplikasi Tidak Suppurt",Toast.LENGTH_SHORT).show()
                }
            )

            galery.setOnClickListener {
                var intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                resultContract.launch(intent)

            }
        }


        override fun onStart() {
            super.onStart()
            val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
            val heigth = (resources.displayMetrics.widthPixels * 0.40).toInt()
            dialog!!.window?.setLayout(width,ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }
}