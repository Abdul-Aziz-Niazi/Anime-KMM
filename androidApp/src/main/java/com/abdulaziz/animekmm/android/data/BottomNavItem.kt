package com.abdulaziz.animekmm.android.data

import com.abdulaziz.animekmm.android.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Feed : BottomNavItem("Feed", R.drawable.ramen,"feed")
    object Genre: BottomNavItem("Genre",R.drawable.ic_genre,"genre")
    object About: BottomNavItem("About",R.drawable.ic_info,"about")
}