package com.lkdigital.practiceandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.lkdigital.practiceandroid.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    //LiveData then telling fragment to observe that livedata

    //Attach viewModel to fragment
    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FragmentFirstBinding

    //private var clicks = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        //ViewModelProvider will return viewModel if already made
        //No new viewModel is created
        //Cant pass arguments into ViewModels
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        //Using dataBinding to bind data directly to views in XML
        binding.firstViewModel = viewModel
        binding.lifecycleOwner = this

        //Using ViewModelFactory you can create your own custom ViewModels

        //Add observers to observe LiveData
        //LiveData are going to update the UI
        //Only exposing LiveData but cant change
        //If not using dataBinding we have to create observers to observe the live data
//        viewModel.message.observe(viewLifecycleOwner, { myMessage -> binding.tvMessage.text = myMessage })
//        viewModel.clicks.observe(viewLifecycleOwner, { myClicks -> binding.tvClicks.text = "$myClicks total clicks" })

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false)

        binding.btHello.setOnClickListener { viewModel.hello(binding.etName.text.toString()) }
        binding.btGoodbye.setOnClickListener { viewModel.goodbye(binding.etName.text.toString()) }

        binding.btEnd.setOnClickListener { nextFragment() }

        return binding.root
    }

    private fun nextFragment() {
        //If value is null the app would crash
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(viewModel.clicks.value!!))
    }

    //The old way not using live data
//    private fun hello() {
//        val name = binding.etName.text.toString()
//        viewModel.message = "Hello $name"
//
//        viewModel.clicks++
//
//        updateUI()
//    }
//
//    private fun goodbye() {
//        val name = binding.etName.text.toString()
//        viewModel.message = "Goodbye $name"
//
//        viewModel.clicks++
//
//        updateUI()
//    }
//
//    private fun updateUI() {
//        binding.tvMessage.text = viewModel.message
//        binding.tvClicks.text = "${viewModel.clicks} total clicks"
//    }

    //Old versions not using viewModel
//    private fun hello() {
//       val name = binding.etName.text.toString()
//       binding.tvMessage.text = "Hello $name"
//
//        clicks++
//        binding.tvClicks.text = "$clicks total clicks"
//    }
//
//    private fun goodbye() {
//        val name = binding.etName.text.toString()
//        binding.tvMessage.text = "Goodbye $name"
//
//        clicks++
//        binding.tvClicks.text = "$clicks total clicks"
//    }

}