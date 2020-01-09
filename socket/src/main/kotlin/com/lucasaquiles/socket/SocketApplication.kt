package com.lucasaquiles.socket

import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SocketApplication

fun main(args: Array<String>) {

	val app = SpringApplication(SocketApplication::class.java)
	app.webApplicationType = WebApplicationType.REACTIVE
	app.run(*args)
}
