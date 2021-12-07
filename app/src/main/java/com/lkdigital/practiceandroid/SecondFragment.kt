package com.lkdigital.practiceandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.lkdigital.practiceandroid.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondViewModel
    private lateinit var viewModelFactory: SecondViewModelFactory

    //Fragment is our UI controller

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

        viewModelFactory = SecondViewModelFactory(SecondFragmentArgs.fromBundle(requireArguments()).clicks)
//        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        //Now can create viewModel with arguments in constructor
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)

        binding.secondViewModel = viewModel
        binding.lifecycleOwner = this

        //We want to pass arguments to the viewModel so we use ViewModelFactory

        //Get value from first fragment
//        val args = SecondFragmentArgs.fromBundle(requireArguments())
//        binding.secondFragmentTvClicks.text = args.clicks.toString()
        binding.secondFragmentTvClicks.text = viewModel.clicks.toString()

        binding.secondFragmentBtBack.setOnClickListener { goBack() }

        binding.secondFragmentBtClick.setOnClickListener { viewModel.addClick() }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun goBack() {
        findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
    }

}