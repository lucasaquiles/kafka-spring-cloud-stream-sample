package com.lucasaquiles.socket

import com.google.gson.Gson
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import reactor.core.publisher.TopicProcessor

data class Event(val sender: Int, val bagId: Int)
data class Location(val event:Event, val lon: Double, val lat: Double)

@Component
class TrackingHandler : WebSocketHandler {

    private val processor = TopicProcessor.share<Event>("shared",1024)

    override fun handle(session: WebSocketSession): Mono<Void> {
        var gson = Gson()

        return session.send(
            processor.map { ev -> session.textMessage("${gson.toJson(ev.copy())}") }
        ).and(
                session.receive()
                        .map { ev ->
                            val parts = ev.payloadAsText

                            var fromJson = gson.fromJson(parts, Event::class.java)

                            Event(sender =  fromJson.sender, bagId = fromJson.bagId)


                        }
                        .log()
                        .doOnNext{ ev -> processor.onNext(ev) }
        )
    }
}
