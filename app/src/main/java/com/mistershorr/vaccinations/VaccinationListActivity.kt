package com.mistershorr.vaccinations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mistershorr.vaccinations.databinding.ActivityVaccinationListBinding

class VaccinationListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityVaccinationListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaccinationListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vaccineList = mutableListOf<VaccinationInfo>()
        vaccineList.add(VaccinationInfo("Fake 1",
            sortedMapOf<String, Int>(
                Pair("1/23/22", 100),
                Pair("1/24/22", 105),
                Pair("1/25/22", 110)
            )
        ))
        vaccineList.add(VaccinationInfo("Fake 2",
            sortedMapOf<String, Int>(
                Pair("1/23/22", 50000),
                Pair("1/24/22", 60000),
                Pair("1/25/22", 70000)
            )
        ))

        val adapter = VaccinationAdapter(vaccineList)
        binding.recyclerViewVaccinations.adapter = adapter
        binding.recyclerViewVaccinations.layoutManager = LinearLayoutManager(this)

    }
}