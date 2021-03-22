package pl.softwaret.kpdf.view.usecase.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_publication_item.view.*
import pl.softwaret.core.model.repository.entity.publication.Publication
import pl.softwaret.kpdf.R

class PublicationsAdapter(
    private var dataSet: List<Publication>
) : RecyclerView.Adapter<PublicationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_publication_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun setNewData(dataSet: List<Publication>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: Publication) {
            itemView.name.text = item.name
            itemView.author.text = item.authorLogin
            itemView.description.text = item.description
        }
    }
}