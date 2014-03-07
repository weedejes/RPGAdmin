package smet.personal.RPGAdmin.map

import scalafx.scene.canvas.GraphicsContext
import scalafx.collections.ObservableBuffer

trait Layer {
	val displayCanvas: GraphicsContext
	def createPopupEntries(mouseX: Int, mouseY: Int): List[PopupEntry]
	
	def draw(dm: DrawMode): Unit
}