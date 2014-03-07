package smet.personal.RPGAdmin.map

import scalafx.scene.canvas.GraphicsContext
import javafx.collections.ObservableList
import smet.personal.RPGAdmin.npc.Monster
import scalafx.collections.ObservableBuffer
import scalafx.scene.paint.Color
import scala.util.Random
import scalafx.beans.property.IntegerProperty
import scalafx.event.Event

class TileLayer (val displayCanvas: GraphicsContext,
				val width: Int, val height: Int,
				val data: ObservableBuffer[Tile], 
				val dm: DrawMode) extends Layer {
	
	data onChange draw
	data.foreach {_.fogged.onChange( draw)}
	
	def draw:Unit = draw(dm)
	def draw(dm: DrawMode) = {
		data.foreach { tile => 
			tile.draw(displayCanvas, tile.x * width, tile.y * height, dm)
		}
	}
	
	def createPopupEntries(mouseX: Int, mouseY: Int) = {
		val (indX, indY) = (mouseX / width, mouseY / height)
		val pp = data.filter {tile =>
			tile.x == indX && tile.y == indY
		}.flatMap { _.popUpEntries }
		pp.toList
	}
	
	draw
}