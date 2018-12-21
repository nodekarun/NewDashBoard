package co.winds.newdashbord

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter_home.view.*
import android.widget.AbsListView



class MainActivity : AppCompatActivity() {

    private lateinit var mContext:Context
    private lateinit var list: ArrayList<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        list = ArrayList()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        list.add(Model(R.drawable.ic_person_black_24dp, "Pay"))
        list.add(Model(R.drawable.ic_person_black_24dp, "Karun"))
        list.add(Model(R.drawable.ic_person_black_24dp, "Ram"))
        list.add(Model(R.drawable.ic_person_black_24dp, "Shaym"))

        list.add(Model(R.drawable.ic_person_black_24dp, "Mohan"))
        list.add(Model(R.drawable.ic_person_black_24dp, "Kon"))
        list.add(Model(R.drawable.ic_person_black_24dp, "REW"))


        recyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false)
        recyclerView.adapter = ListAdapter(list)
        circleIndicator!!.attachTo(recyclerView)
        circleIndicator!!.count=2


    }


    private inner class ListAdapter(val list:ArrayList<Model>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_home, parent, false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItem(list[position])
        }

        override fun getItemCount(): Int {
            return list.size
        }

        internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

              fun bindItem(mdel:Model){
                itemView.tv_title
            }
        }
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_nearyby -> {
              //  message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
               // message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
