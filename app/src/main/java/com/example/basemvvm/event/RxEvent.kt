package com.example.basemvvm.event
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

object RxEvent {
    private val publisher = PublishSubject.create<Any>()

    fun send(event: Any) {
        publisher.onNext(event)
    }

    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}