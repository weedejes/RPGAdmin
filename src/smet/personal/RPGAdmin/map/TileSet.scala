package smet.personal.RPGAdmin.map

import scalafx.scene.image.Image

class TileSet {

	val imgs = scala.collection.mutable.Map[String, Image]()
	
	def loadFromFile(filename: String) = {
		println("Loading")
		val img = new Image("smet/personal/RPGAdmin/data/img/tiles/grass.png")
		
		imgs("grass") = img
	}

	def apply(name: String) = {
		new Tile(imgs(name))
	}
}