package smet.personal.RPGAdmin.npc

import scalafx.scene.image.Image

class MonsterManual {
	
	val stats = scala.collection.mutable.Map[String, MonsterStats]()
	val imgs = scala.collection.mutable.Map[String, Image]()
	
	def loadFromFile(filename: String) = {
		println("Loading")
		val img = new Image("file://D:/projects/Scala/RPGAdmin/src/smet/personal/RPGAdmin/data/img/tiles/grass.png")
		
		println(img.width)
		println("____")
		
		stats("hoop") = new MonsterStats(1, 15, 5)
		imgs("hoop") = img
		stats("fern") = new MonsterStats(1, 25, 6)
		imgs("fern") = img
	}

	def createMonster(name: String) = {
		new Monster(stats(name), imgs(name))
	}
}