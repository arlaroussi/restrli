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
import rli.test.rest.restrli.model.Aliment
import rli.test.rest.restrli.repository.AlimentRepository

@Component
class DataSeeder(private val boxRepository: BoxRepository, private val alimentRepository: AlimentRepository): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        var url: String = "E:/SPRING/restrli/src/main/assets/boxes.json"

        val reader = JsonReader(InputStreamReader(FileInputStream(url)))
        val jsonParser = JsonParser()
        val boxArray: JsonArray = jsonParser.parse(reader).getAsJsonArray()

        var gson = Gson()

        println(boxArray.size())

        var aBox: Box
        var aBox1 : Box
        for (aElem in boxArray) {
            aBox = gson.fromJson(aElem, Box::class.java)
            aBox1 = Box("${aBox.nom}", "${aBox.pieces}".toInt(), "${aBox.prix}".toDouble(), "${aBox.image}")
            boxRepository.save(aBox1)

            for (elem in aBox.aliments!!) {
                println("${elem.nom}" + " " + "${elem.quantite}" + " " + "${aBox.id}")
                var alim = Aliment("${elem.id}".toLong(),"${elem.nom}", "${elem.quantite}", aBox)
                println(alim.nom)
                println(alim.quantite)
                alimentRepository.save(alim)
            }
        }
    }
}

