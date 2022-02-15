package com.curso.cronicasdovazio.utils

import androidx.lifecycle.MutableLiveData

fun String.minusOne() = (this.toInt() -1).toString()

fun String.plusOne() = (this.toInt() +1).toString()

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }