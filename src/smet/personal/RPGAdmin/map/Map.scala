package smet.personal.RPGAdmin.map

import scala.collection.mutable.ListBuffer

class Map (val width: Int, val height: Int){
	val tiles = new ListBuffer[Tile]
	
	def setTiles(tiles: ListBuffer[Tile]): Unit = {
		tiles ++= tiles 
	}
	
}