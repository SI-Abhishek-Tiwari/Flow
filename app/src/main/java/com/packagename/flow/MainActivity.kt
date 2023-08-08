package com.packagename.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

// first see maincode and implement it here
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch(Dispatchers.Main) {
            val data: Flow<Int> = producer()
            delay(6000)
            data.collect {
                    Log.d("abhi", "$it")
                }

        }

//        GlobalScope.launch(Dispatchers.Main) {
//            val data: Flow<Int> = producer()
//            delay(2500)
//            data.collect {
//                Log.d("abhi-1", "$it")
//            }
//
//        }

//        GlobalScope.launch {
//            delay(2500)                         //here we have delay it to see that our second user if he start late so he get data from scratch or not bcz of flow we get it from scratch
//            data.collect{                          //just like netflix everyuser can start to watch movie from scratch
//                Log.d("abhiflow - 2", "$it ")
//            }
//        }

//        GlobalScope.launch {
//            //here we have to give  val job = GlobalScope.launch in above
//            delay(3500)    // it will give till number 3 from list bcz afetr 3500 it get stop so when corotine stop it get stop
//            job.cancel()          //we dont have any method to cancel flow but when coroutine will get cancel it will automatically stop
//        }


    }

}

//    private fun producer() : Flow<Int> {
//        return flow {
//            val list = listOf<Int>(1,2,3,4,5)
//            list.forEach {
//                delay(1000)
//                emit(it)
//
////            Log.d("abhiflow", "${Thread.currentThread().name}") //here because we are using main thread above in consumer thats y this code also works in main thread
//                //but in main thread on ui portion works not any api so to change thread we use flow on
//
//            }
//        }
//
//    }

//    private fun producer() : Flow<Int> {                 //shared flow is hot it will give data no matter anyone is consuming or not if any consumer start late to collect data he get data from that time he will lost previous data
//       val mutableSharedFlow = MutableSharedFlow<Int>(2)  //bcz of flow we can solve problem it will last 2 value to user who have join late
//        GlobalScope.launch {
//            val list = listOf<Int>(1,2,3,4,5)
//            list.forEach {
//                mutableSharedFlow.emit(it)
//                delay(1000)
//            }
//        }
//
//        return mutableSharedFlow
//
//    }

private fun producer() : Flow<Int> {                 //state flow is same as shared flow only difference is in state flow it keep its last value and give to consumer whenever he come
    val mutableStateFlow = MutableStateFlow(10)  //but in shared flow it doest not contain its last value
    GlobalScope.launch {
        delay(2000)
        mutableStateFlow.emit(20)
        delay(2000)
        mutableStateFlow.emit(30)
    }
    return mutableStateFlow
}

/*
livedata vs state flow
1.Transformation in main thread -> livedate mostly run on main thread it operator like map and filter runs on main thread which is not acceptable in flow we can switch thread only by using flow on
2.opeartor -> In livedata we have limeted operator but in flow we have more operator
3.lifycycle operator -> we have to give lifecycle in livedata so its difficult eg. if we want to apply livedata in repository so we cant access it on repo bcz we dont have lifecycle for it
but in flow we only have to give coroutine which we can do it

 */



