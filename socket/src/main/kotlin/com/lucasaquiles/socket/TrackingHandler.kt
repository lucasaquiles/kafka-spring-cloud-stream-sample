package com.lucasaquiles.socket

import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import reactor.core.publisher.TopicProcessor

data class Event(val sender: Int, val bagId: Int)

@Component
class TrackingHandler : WebSocketHandler {

    private val processor = TopicProcessor.share<Event>("shared",1024)

    override fun handle(session: WebSocketSession): Mono<Void> {

        return session.send(
            processor.map { ev -> session.textMessage("${ev.sender}: ${ev.bagId}") }
        ).and(
                session.receive()
                        .map { ev ->
                            val parts = ev.payloadAsText.split(":")
                            Event(sender = parts[0].toInt(), bagId = parts[1].toInt())
                        }
                        .log()
                        .doOnNext{ ev -> processor.onNext(ev) }
        )
    }
}
