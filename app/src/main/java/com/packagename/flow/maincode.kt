//package com.packagename.flow
//
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.MutableSharedFlow
//import kotlinx.coroutines.launch
//
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val data: Flow<Int> = producer()
//        GlobalScope.launch(Dispatchers.Main) {
//
//            data
//                .collect {
//                    Log.d("abhi", "$it")
//                }
//
////            getNotes()
////                .map {
////                    FormattedNote(it.isActive,it.title.uppercase(),it.description)  //here we use map to change our data form as we want in ui
////                }
////                .filter {   //it will check if is active is true then it should proceed
////                    it.isActive
////                }
////                .collect{
////                    Log.d("abhiflow", "$it ")
////                }
//
////            buffer is also used when producer produce the data but consumer is taking the time at that time buffer hold some last data and will give to consumer
//
////            data
//
////                .map {    // it is non teminal operator it used to map our object to differrnt form
////                    it * 2
////                    Log.d("abhiflow", "${Thread.currentThread().name}")
////                }
////                .filter {  //it is non teminal operator it is boolean it check condition map and filter dhoule be in line
////                    Log.d("abhiflow", "${Thread.currentThread().name}")
////                    it < 8
////                }
////                .flowOn(Dispatchers.IO)  //but in main thread on ui portion works not any api so to change thread we use flowOn in flow
////                .onStart {
////                    emit(-1)
////                    Log.d("abhiflow", "Flow Started")
////                }
////                .onCompletion {
////                    emit(6)
////                    Log.d("abhiflow", "completed")
////
////                }
////                .onEach {
////                    Log.d("abhiflow", "About to emit $it")
////                }
//
//
////                .collect{
////                    Log.d("abhiflow ", "$it")
////                }
////
//
//
//        }
//
////        GlobalScope.launch {
////            delay(2500)                         //here we have delay it to see that our second user if he start late so he get data from scratch or not bcz of flow we get it from scratch
////            data.collect{                          //just like netflix everyuser can start to watch movie from scratch
////                Log.d("abhiflow - 2", "$it ")
////            }
////        }
//
////        GlobalScope.launch {
////            //here we have to give  val job = GlobalScope.launch in above
////            delay(3500)    // it will give till number 3 from list bcz afetr 3500 it get stop so when corotine stop it get stop
////            job.cancel()          //we dont have any method to cancel flow but when coroutine will get cancel it will automatically stop
////        }
//
//
//    }
//
//}
//
////    private fun producer() : Flow<Int> {
////        return flow {
////            val list = listOf<Int>(1,2,3,4,5)
////            list.forEach {
////                delay(1000)
////                emit(it)
////
//////            Log.d("abhiflow", "${Thread.currentThread().name}") //here because we are using main thread above in consumer thats y this code also works in main thread
////                //but in main thread on ui portion works not any api so to change thread we use flowon concept
////
////            }
////        }
////
////    }
//
//private fun producer() : Flow<Int> {
//    val mutableSharedFlow = MutableSharedFlow<Int>()
//    GlobalScope.launch {
//        val list = listOf<Int>(1,2,3,4,5)
//        list.forEach {
//            mutableSharedFlow.emit(it)
//        }
//    }
//
//    return mutableSharedFlow
//
//}
