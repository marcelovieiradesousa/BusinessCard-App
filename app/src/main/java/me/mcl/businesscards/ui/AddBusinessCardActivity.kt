package me.mcl.businesscards.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import me.mcl.businesscards.App
import me.mcl.businesscards.R
import me.mcl.businesscards.data.BusinessCard
import me.mcl.businesscards.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBusinessCardBinding
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnExit.setOnClickListener {
            val intent = Intent(
                this,
                MainActivity::class.java
            )
            startActivity(intent)
        }
        binding.btnConfirm.setOnClickListener {
            val businessCard =
                BusinessCard(
                    nome = binding.tilName.editText?.text.toString(),
                    empresa = binding.tilFirma.editText?.text.toString(),
                    telefone = binding.tilPhone.editText?.text.toString(),
                    email = binding.tilEmail.editText?.text.toString(),
                    fundoPersonalizado = binding.tilColor.editText?.text.toString()
                )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}