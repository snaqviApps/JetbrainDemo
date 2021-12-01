package org.com.testing.with.jetbrainsdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//class ArticleAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    val value = MainViewModel()            // get Data
    var articleList = listOf<Article>()
        //    var articleList = String()
        set(value) {
            field = value
            notifyDataSetChanged()      // last resort
        }

    //    override fun getItemCount() = articleList.size
    override fun getItemCount() = articleList.size


    //    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = articleList[position]

        holder.title.text = item.title;
        holder.content.text = item.content

//        holder.image.setImageResource(R.drawable.ic_baseline_4g_plus_mobiledata_24)
//        holder.image.let {
//            val imgUrl = item.imageURL.toUri().buildUpon().scheme("https").build()
//            Picasso
//                .get()
//                .load(imgUrl)
//                .into(holder.image)
//        }
    }

    //    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater.inflate(R.layout.card_view_item, parent, false) as TextView
        val view = layoutInflater.inflate(R.layout.card_view_item, parent, false)

//        return TextItemViewHolder(view)
        return ArticleViewHolder(view)
    }

    class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.mTextViewTitle)
        val content: TextView = itemView.findViewById(R.id.mTextViewContent)
        var image: ImageView = itemView.findViewById(R.id.mImageViewCardViewItem)
    }
}
