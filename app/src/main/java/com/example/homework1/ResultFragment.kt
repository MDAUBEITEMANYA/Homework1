package com.example.homework1

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.homework1.databinding.FragmentMainBinding
import com.example.homework1.databinding.FragmentResultBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val disposableBag = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val api = (requireActivity().application as App).api
        val isDate = arguments?.getBoolean(ARG_KEY) ?: false
        if (isDate) {
           val disposable = api.getDate()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    binding.resultText.text = it.toString()
                }, Throwable::printStackTrace)
            disposableBag.add(disposable)
        }else{
            val disposable = api.getIp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    binding.resultText.text = it.toString()
                }, Throwable::printStackTrace)
            disposableBag.add(disposable)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposableBag.clear()
    }

    companion object {
        private const val ARG_KEY = "isDate"
        fun newInstance(isDate: Boolean) =
            ResultFragment().apply { arguments = bundleOf(ARG_KEY to isDate) }
    }

}