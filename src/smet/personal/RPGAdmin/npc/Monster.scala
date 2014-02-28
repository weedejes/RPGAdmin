package smet.personal.RPGAdmin.npc

import scalafx.animation.Animation
import smet.personal.RPGAdmin.gui.Drawable
import scalafx.scene.image.Image
import smet.personal.RPGAdmin.gui.StaticImage

class Monster (val stats: MonsterStats, val image: Image) extends StaticImage {
	var currentHP = stats.hp
	
	def heal(amount: Int) = {
		currentHP += amount
	}
	
	def damage(amount: Int) = {
		currentHP -= amount
	}
	
}