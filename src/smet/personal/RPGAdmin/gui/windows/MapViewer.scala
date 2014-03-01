package smet.personal.RPGAdmin.gui.windows

import scalafx.scene.canvas.Canvas
import smet.personal.RPGAdmin.map.Map
import scalafx.scene.paint.Color

class MapViewer extends Canvas{
	width = 3*128
	height = 3*128 
	
	var map: Option[Map] = None
	
	def setMap(map: Map) = {
		this.map = Some(map)
		(0 until map.width) foreach {i =>
			(0 until map.height) foreach {j =>
				if (map.getTile(i, j).fogged.value) {
					map.getTile(i, j).draw(graphicsContext2D, i * 128, j * 128)
				} else{
					graphicsContext2D.fill = Color.BLACK
					graphicsContext2D.fillRect(i * 128, j * 128, 128, 128)
				}
			}
		}
	}
}