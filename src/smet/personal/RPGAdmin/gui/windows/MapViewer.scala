package smet.personal.RPGAdmin.gui.windows

import scalafx.scene.canvas.Canvas
import smet.personal.RPGAdmin.map.Map
import scalafx.scene.paint.Color

class MapViewer extends Canvas{
	width = 100
	height = 100
	
	graphicsContext2D.fill = Color.BLUE
	graphicsContext2D.fillRect(0, 0, 2*width.value, 2*height.value)
	
	var map: Option[Map] = None
	
	def setMap(map: Map) = {
		this.map = Some(map)
	}
}