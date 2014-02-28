package smet.personal.RPGAdmin.effect

class Spellbook {

	def createSpell(name: String): Spell = {
		new Spell(name, 5)
	}
}