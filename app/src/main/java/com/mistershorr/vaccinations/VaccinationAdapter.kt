package com.mistershorr.vaccinations

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class VaccinationAdapter(var dataSet: List<VaccinationInfo>) :
    RecyclerView.Adapter<VaccinationAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCountry: TextView
        val textViewLatestVax: TextView
        val layout : ConstraintLayout


        init {
            textViewCountry = view.findViewById(R.id.textView_vaxItem_country)
            textViewLatestVax = view.findViewById(R.id.textView_vaxItem_latestVax)
            layout = view.findViewById(R.id.layout_vaxItem)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_vax, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val countryInfo = dataSet[position]
        viewHolder.textViewCountry.text = countryInfo.country
        viewHolder.textViewLatestVax.text =
            countryInfo.timeline[countryInfo.timeline.lastKey()].toString()
        viewHolder.layout.setOnClickListener {
            // Toast.makeText(it.context, "Hi, you clicked on ${hero.name}", Toast.LENGTH_SHORT).show()
            // get the context from something in the viewholder
            val context = viewHolder.layout.context
            // make the intent with context we got
            val vaxDetailIntent = Intent(context, VaccinationDetailActivity::class.java).apply {
                // pass the whole hero object into the intent because it is parcelable
                putExtra(VaccinationDetailActivity.EXTRA_COUNTRY, countryInfo)
            }
            context.startActivity(vaxDetailIntent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
