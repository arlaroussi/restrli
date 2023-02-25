package rli.test.rest.restrli.seeders

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import rli.test.rest.restrli.model.Box
import rli.test.rest.restrli.repository.BoxRepository
import java.io.FileInputStream
import java.io.InputStreamReader
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import org.springframework.stereotype.Component

@Component
class DataSeeder(private val boxRepository: BoxRepository): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        var url: String = "E:/SPRING/restrli/src/main/assets/boxes.json"

        val reader = JsonReader(InputStreamReader(FileInputStream(url)))
        val jsonParser = JsonParser()
        val boxArray: JsonArray = jsonParser.parse(reader).getAsJsonArray()

        var gson = Gson()

        println(boxArray.size())

        var listeBox: ArrayList<Box>? = null

        for (aElem in boxArray) {
            val aBox: Box = gson.fromJson(aElem, Box::class.java)
            boxRepository.save(aBox)
        }
    }
}
