package jgdledge.coroutines.reactive

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("jgdledge.coroutines.reactive")
		.start()
}
