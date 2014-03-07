package smet.personal.RPGAdmin.npc

import scalafx.animation.Animation
import smet.personal.RPGAdmin.gui.Drawable
import scalafx.scene.image.Image
import smet.personal.RPGAdmin.gui.StaticImage
import scalafx.beans.property.IntegerProperty
import smet.personal.RPGAdmin.map.PopupEntry
import scalafx.event.Event
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color
import scalafx.scene.effect.ColorAdjust
import scalafx.beans.property.ObjectProperty
import scalafx.beans.Observable
import smet.personal.RPGAdmin.map.DrawMode
import smet.personal.RPGAdmin.map.DMMode
import smet.personal.RPGAdmin.map.PlayerMode

class Monster (x_ : Int, y_ : Int,
				val stats: MonsterStats, val image: Image) extends StaticImage {
	
	val x = IntegerProperty(x_)
	val y = IntegerProperty(y_)
	val currentHP = IntegerProperty(stats.hp)
	
	currentHP.onChange {
		println("CurrentHP: " + currentHP.value)
	}

	def draw(g: GraphicsContext, x: Int, y: Int, dm: DrawMode) = {
		super.draw(g, x, y)
		dm match {
			case _: DMMode => {
				g.stroke = if (currentHP.value > stats.hp / 2) {Color.BLACK} else {Color.RED} 
				g.strokeText(currentHP.value.toString, x + 20, y + 20)
			}
			case _: PlayerMode => {
				if (currentHP.value < stats.hp / 2) {
					g.fill = Color(1,0,0, 0.2)
					g.fillRect(x, y, image.width.value, image.height.value)
				}
			}
		}
	}
	
	def heal(amount: Int) = {
		currentHP.value = currentHP.value + amount
	}
	
	def damage(amount: Int) = {
		currentHP.value = currentHP.value - amount
	}
	
	def popUpEntries = {
		List(
				new PopupEntry("Hurt", { e: Event =>
					println("Hurting")
					damage(1)
				}),
				new PopupEntry("Move", { e: Event =>
					println("Moving")
					x.value = x.value + 1
				}))
	}
	
	
	
}