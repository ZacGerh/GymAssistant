package com.example.gymassistant

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel(), Observable {

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    @Bindable
    val benchText = MutableLiveData<String>()
    @Bindable
    val ohpText = MutableLiveData<String>()
    @Bindable
    val lateralRaisesText = MutableLiveData<String>()
    @Bindable
    val skullCrushersText = MutableLiveData<String>()
    @Bindable
    val chinUpText = MutableLiveData<String>()
    @Bindable
    val squatText = MutableLiveData<String>()
    @Bindable
    val bentFliesText = MutableLiveData<String>()
    @Bindable
    val bicepCurlText = MutableLiveData<String>()

    val currentRunningTimer: LiveData<String>
        get() = RunningTimer.currentRunTime




}