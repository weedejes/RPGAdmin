package smet.personal.RPGAdmin.gui

import scalafx.scene.image.Image
import scalafx.scene.canvas.Canvas
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color


trait StaticImage extends Drawable {
	val image: Image
	
	def draw(g: GraphicsContext, x: Int, y: Int)  = {
		g.clearRect(x, y, image.width.value, image.height.value)
		g.drawImage(image, x, y)
	}
	
}