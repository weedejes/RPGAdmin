package smet.personal.RPGAdmin.gui

import scalafx.scene.canvas.GraphicsContext

trait Drawable {
	def draw(g: GraphicsContext, x: Int, y: Int)
}