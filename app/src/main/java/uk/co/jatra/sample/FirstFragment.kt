package uk.co.jatra.sample

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val viewModel: SampleViewModel by viewModels()
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: SampleAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.data = it
        }

        recyclerview = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = SampleAdapter(requireContext())
        viewManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = adapter
        recyclerview.layoutManager = viewManager
    }

    class SampleAdapter(val context: Context): RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {
        var data: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
            return SampleViewHolder(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false) as TextView)
        }
        override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
            holder.view.text = data[position]
        }
        override fun getItemCount(): Int {
            return data.size
        }

        data class SampleViewHolder(val view: TextView): RecyclerView.ViewHolder(view)
    }
}