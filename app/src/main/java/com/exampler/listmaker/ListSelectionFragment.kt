package com.exampler.listmaker

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.RuntimeException


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ListSelectionFragment : Fragment() {

    private var listener : OnListItemFragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnListItemFragmentInteractionListener) {
            listener = context
        } else {
            throw  RuntimeException("$context must implement OnListItemFragmentInteractionListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list_selection, container, false)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListItemFragmentInteractionListener {
        fun onListItemClicked(list: TaskList)
    }

    companion object {

        @JvmStatic
        fun newInstance(): ListSelectionFragment {
            return ListSelectionFragment()
        }
    }
}