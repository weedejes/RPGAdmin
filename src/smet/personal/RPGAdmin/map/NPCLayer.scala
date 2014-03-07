package smet.personal.RPGAdmin.map

import scalafx.scene.canvas.GraphicsContext
import javafx.collections.ObservableList
import smet.personal.RPGAdmin.npc.Monster
import scalafx.collections.ObservableBuffer
import scalafx.scene.paint.Color
import scala.util.Random
import scalafx.beans.property.IntegerProperty
import scalafx.event.Event

class NPCLayer (val displayCanvas: GraphicsContext,
				val width: Int, val height: Int,
				val npcs: ObservableBuffer[Monster], 
				val mode: DrawMode) extends Layer {
	
	npcs onChange draw
	npcs foreach {npc =>
		npc.x.onChange(draw)
		npc.y.onChange(draw)
		npc.currentHP.onChange(draw)
	}
	
	def draw: Unit = draw(mode)
	
	def draw(dm: DrawMode) = {
		displayCanvas.clearRect(0, 0, 500, 500)
		npcs.foreach {npc =>
			npc.draw(displayCanvas, npc.x.value * width, npc.y.value * height, dm)
		}
	}
	
	def createPopupEntries(mouseX: Int, mouseY: Int) = {
		val (indX, indY) = (mouseX / width, mouseY / height)
		val pp = npcs.filter {npc =>
			npc.x.value == indX && npc.y.value == indY
		}.flatMap { _.popUpEntries }
		pp.toList
	}
	
	draw
}