package com.example.interneepk

object DataSource {
    private lateinit var dataList: ArrayList<RvModel>
    fun getData(): ArrayList<RvModel> {
        dataList = ArrayList<RvModel>()
        dataList.add(RvModel(R.drawable.a, "Frontend Development"))
        dataList.add(RvModel(R.drawable.b, "Backend Development"))
        dataList.add(RvModel(R.drawable.c, "Chatbot Development"))
        dataList.add(RvModel(R.drawable.d, "Machine Learning"))
        dataList.add(RvModel(R.drawable.e, "Data Science"))
        dataList.add(RvModel(R.drawable.f, "Graphic Design"))
        dataList.add(RvModel(R.drawable.g, "Mobile App Development"))
        dataList.add(RvModel(R.drawable.h, "Video Animation"))
        dataList.add(RvModel(R.drawable.i, "Social Media Marketing"))

        return dataList
    }
}