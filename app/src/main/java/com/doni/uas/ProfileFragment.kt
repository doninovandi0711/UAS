package com.doni.uas

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_profile.*
import org.w3c.dom.Text
import java.nio.file.Files.list
import java.util.Collections.list


class ProfileFragment : Fragment() {
    // mengambil secara global
    lateinit var image: ImageView
    lateinit var title: TextView
    lateinit var subtitle: TextView
    lateinit var list: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        title = root.findViewById(R.id.title)
        subtitle = root.findViewById(R.id.subtitle)
        image = root.findViewById(R.id.image)
        list = root.findViewById(R.id.list)

        title.text = "Doni Novandi"
        subtitle.text = "Belajar Android Kotlin"
        list.adapter = linkAdapter

        return root
    }




    // Profile
    private val linkAdapter by lazy {
        val items = listOf<LinkModel>(
            LinkModel("WhatsApp", R.drawable.wa, "https://api.whatsapp.com/send?phone=082287626488"),
            LinkModel("Instagram", R.drawable.ig, "https://www.instagram.com//"),
            LinkModel("Github", R.drawable.web, "https://inforlajar.blogspot.com/")
        )

        LinkAdapter(items, object : LinkAdapter.AdapterListener {
            override fun onClick(linktree: LinkModel) {
                Log.e("onClick", linktree.url)
                openUrl(linktree.url)
            }

        })
    }

    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}