package ca.six.mvi.ui.rv


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import java.util.ArrayList


abstract class OneAdapter<T> : RecyclerView.Adapter<RvViewHolder> {
    var layoutResId: Int = 0
    var data: List<T>? = null

    constructor(layoutResId: Int) {
        this.layoutResId = layoutResId
        data = ArrayList()
    }

    constructor(layoutResId: Int, data: List<T>) {
        this.layoutResId = layoutResId
        this.data = data
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        //        System.out.println("szw onCreateViewHolder()");
        return RvViewHolder.createViewHolder(parent, layoutResId)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        //        System.out.println("szw onBindViewHolder( "+position+" )");
        if (data != null && data!!.size > position) {
            apply(holder, data!![position], position)
        }
    }


    protected abstract fun apply(vh: RvViewHolder, t: T, position: Int)

}
