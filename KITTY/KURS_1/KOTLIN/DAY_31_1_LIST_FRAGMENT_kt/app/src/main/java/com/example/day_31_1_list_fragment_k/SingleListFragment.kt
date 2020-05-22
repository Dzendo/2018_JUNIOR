package com.example.day_31_1_list_fragment_k

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter

import com.example.day_31_1_list_fragment_k.dummy.DummyContent
import com.example.day_31_1_list_fragment_k.dummy.DummyContent.DummyItem

import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
class SingleListFragment : ListFragment() {
    // TODO: Customize parameters
    private var mColumnCount = 1
    private var mListener: OnListFragmentInteractionListener? = null
    // определяем массив типа String
    internal val catNames = arrayOf("Рыжик", "Барсик", "Мурзик", "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка", "Кузя", "Китти", "Масяня", "Симба")


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    // Для связывания данных используются адаптеры
    // ListAdapter, ArrayAdapter, SimpleAdapter, SimpleCursorAdapter и т.д.
    // Подключение следует производить в методе onActivityCreated().
    //fun SingleListFragment() {}

    // TODO: Customize parameter initialization не исполльзуется
    fun newInstance(columnCount: Int): SingleListFragment {
        val fragment = SingleListFragment()
        val args = Bundle()
        args.putInt(ARG_COLUMN_COUNT, columnCount)
        fragment.setArguments(args)
        return fragment
    }

    // вставлено из kitty
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = ArrayAdapter(activity!!,
                android.R.layout.simple_list_item_activated_1, catNames)
        listAdapter = adapter
    }

    // это из шаблона
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments!!.getInt(ARG_COLUMN_COUNT)
        }
    }

    // Стандартная разметка подгружается автоматически,
    // для собственной разметки используйте метод onCreateView()

     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

         return inflater.inflate(R.layout.listfragment!!, null)
        val view = inflater!!.inflate(R.layout.listfragment_list, container, false)

        // Set the adapter Вылетает
        if (view is RecyclerView) {
            val context = view.getContext()
            val recyclerView = view
            if (mColumnCount <= 1) {
                recyclerView.layoutManager = LinearLayoutManager(context)
            } else {
                recyclerView.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            recyclerView.adapter = MyPersonRecyclerViewAdapter(DummyContent.ITEMS, mListener)
        }
        return inflater.inflate(R.layout.listfragment, null)
        //return view;

    }

/*       Вылетает
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnListFragmentInteractionListener")
        }
    }
*/
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem)
    }

    companion object {

        // TODO: Customize parameter argument names
        private val ARG_COLUMN_COUNT = "column-count"
    }

}

//Мы используем метод onActivityCreated(), так как именно здесь можно быть уверенным,
// что все необходимые компоненты фрагмента загрузились
// и фрагмент готов к использованию в составе активности.
// Метод onCreateView() в данном случае использовать не обязательно
