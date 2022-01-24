package com.mistershorr.vaccinations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mistershorr.vaccinations.databinding.ActivityVaccinationDetailBinding

class VaccinationDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_COUNTRY = "country"
    }

    private lateinit var binding: ActivityVaccinationDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaccinationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val countryInfo = intent.getParcelableExtra<VaccinationInfo>(EXTRA_COUNTRY)
        binding.textViewVaxDetailCountry.text = countryInfo?.country
        binding.textViewVaxDetailLatestVax.text =
            countryInfo?.timeline?.toList()?.joinToString {
            it.first + ": " + it.second + "\n"
        }?.replace(", ", "")
    }
}