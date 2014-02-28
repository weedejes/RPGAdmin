package smet.personal.RPGAdmin.gui

import scalafx.scene.image.Image
import scalafx.scene.canvas.Canvas
import scalafx.scene.canvas.GraphicsContext


trait StaticImage extends Drawable {
	val image: Image
	
	def draw(g: GraphicsContext, x: Int, y: Int)  = {
		g.drawImage(image, x, y)
	}
	
}