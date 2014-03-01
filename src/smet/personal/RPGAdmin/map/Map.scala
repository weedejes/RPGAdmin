package smet.personal.RPGAdmin.map

import scala.collection.mutable.ListBuffer

class Map(val width: Int, val height: Int) {
	private val tiles = Array.ofDim[Tile](width, height)

	val tileSet = new TileSet()
	tileSet.loadFromFile("'")

	(0 until width).foreach { i =>
		(0 until height).foreach { j =>
			setTile(i, j, tileSet("grass"))
		}
	}

	def setTile(x: Int, y: Int, tile: Tile) = {
		tiles(x)(y) = tile
	}

	def getTile(x: Int, y: Int): Tile = {
		tiles(x)(y)
	}

}