package rli.test.rest.restrli

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import rli.test.rest.restrli.model.Box
import java.io.FileInputStream
import java.io.InputStreamReader

@SpringBootApplication
class RestrliApplication

fun main(args: Array<String>) {
	runApplication<RestrliApplication>(*args)
}
