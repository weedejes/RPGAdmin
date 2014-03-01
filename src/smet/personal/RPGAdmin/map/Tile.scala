package smet.personal.RPGAdmin.map

import smet.personal.RPGAdmin.gui.StaticImage
import scalafx.scene.image.Image
import scalafx.beans.property.BooleanProperty
import scala.util.Random

class Tile(val image: Image) extends StaticImage {
	val fogged = if (Random.nextBoolean) {
		BooleanProperty(false)
	} else {
		BooleanProperty(true)
	}
}