package br.com.wellingtoncosta.coroutines.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job

/**
 * @author Wellington Costa on 03/12/18
 */
open class CoroutineViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext = Main

    protected val jobs = ArrayList<Job>()

    infix fun ArrayList<Job>.add(job: Job) { this.add(job) }

    override fun onCleared() {
        super.onCleared()
        jobs.forEach { if(!it.isCancelled) it.cancel() }
    }

}