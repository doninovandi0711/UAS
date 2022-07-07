package com.doni.uas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_t_v_show.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TVShowFragment : Fragment() {
    var tvshowes: List<TVShow>? = null
    private lateinit var tvshowAdapter: TVShowAdapter

    companion object {
        fun newInstance() = TVShowFragment()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { return inflater.inflate(R.layout.fragment_t_v_show, container, false) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_tvshow_list.layoutManager = LinearLayoutManager(activity)
        rv_tvshow_list.setHasFixedSize(true)
        getMovieData { tvshowes: List<TVShow> ->
            rv_tvshow_list.adapter = TVShowAdapter(tvshowes, object :TVShowAdapter.OnAdapterListener {

                override fun onClick(result: TVShow) {
                    val intent = Intent(activity, DetailTVShowActivity::class.java)
                    intent.putExtra(DetailTVShowActivity.EXTRA_DATA, result)
                    startActivity(intent)
                }
            })
        }
    }
    private fun setupRecyclerView(){
        tvshowAdapter = TVShowAdapter(arrayListOf(),
            object : TVShowAdapter.OnAdapterListener {
                override fun onClick(result: TVShow) {
                    val intent = Intent(activity,
                        DetailTVShowActivity::class.java)
                    intent.putExtra(DetailTVShowActivity.EXTRA_DATA,
                        result)
                    startActivity(intent)
                }
            })
        rv_tvshow_list.apply {
            layoutManager =
                LinearLayoutManager(context)
            adapter = tvshowAdapter
        }
    }

    private fun getMovieData(callback: (List<TVShow>) -> Unit){
        val apiService = TVShowApiService.getInstance().create(TVShowApiInterface::class.java)
        apiService.getTVShowList().enqueue(object : Callback<TVShowResponse> {
            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TVShowResponse>, response: Response<TVShowResponse>) {
                tvshowes = response.body()!!.tvshowes
                return callback(response.body()!!.tvshowes)
            }

        })
    }
}