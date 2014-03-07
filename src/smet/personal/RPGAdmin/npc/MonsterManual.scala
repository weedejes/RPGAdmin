package smet.personal.RPGAdmin.npc

import scalafx.scene.image.Image
import scala.util.Random

class MonsterManual {
	
	val stats = scala.collection.mutable.Map[String, MonsterStats]()
	val imgs = scala.collection.mutable.Map[String, Image]()
	
	def loadFromFile(filename: String) = {
		println("Loading")
		val img = new Image("smet/personal/RPGAdmin/data/img/monsters/hoop.png")
		
		stats("hoop") = new MonsterStats(1, 15, 5)
		imgs("hoop") = img
		stats("fern") = new MonsterStats(1, 25, 6)
		imgs("fern") = img
	}

	def apply(name: String) = {
		new Monster(Random.nextInt(3), Random.nextInt(3), stats(name), imgs(name))
	}
}