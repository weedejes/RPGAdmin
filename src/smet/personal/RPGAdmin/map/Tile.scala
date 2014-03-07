package smet.personal.RPGAdmin.map

import smet.personal.RPGAdmin.gui.StaticImage
import scalafx.scene.image.Image
import scalafx.beans.property.BooleanProperty
import scala.util.Random
import scalafx.Includes._
import scalafx.event.Event
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

class Tile(val x: Int, val y: Int, val image: Image) extends StaticImage {
	
	val fogged = BooleanProperty(false)

	def draw(g: GraphicsContext, x: Int, y: Int, dm: DrawMode) {
		dm match {
			case _: DMMode => {
				super.draw(g, x, y)
				if (fogged.value) {
					g.fill = Color(0,0,0, 0.5)
					g.fillRect(x, y, image.width.value, image.width.value)
				}
			}
			case _: PlayerMode => {
				if (fogged.value) {
					g.fill = Color.BLACK
					g.fillRect(x, y, image.width.value, image.width.value)
				} else {
					super.draw(g, x, y)
				}
			}
		}
		
	}
	
	
	
	def popUpEntries = {
		List(
			new PopupEntry("Fog", { e: Event =>
				println("Flipping fog")
				fogged.value = !fogged.value
			}))
	}
	
}