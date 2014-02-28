package smet.personal.RPGAdmin.gui.windows

import scalafx.application.JFXApp
import scalafx.application.JFXApp
import scalafx.scene._
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.stage._
import scalafx.scene.paint._
import scalafx.scene.input.MouseEvent
import scalafx.event._
import scalafx.event.EventHandler
import scalafx.Includes._
import scala.collection.immutable.Seq
import scalafx.animation.Timeline
import scalafx.scene.shape.Rectangle
import scalafx.scene.canvas.Canvas
import scala.collection.immutable.Nil
import scala.util.Random
import scalafx.geometry.Rectangle2D
import smet.personal.RPGAdmin.npc.MonsterManual

object Main extends JFXApp {
	val m = new MonsterManual()
	m.loadFromFile("'")
	val monster = m.createMonster("hoop")
	val editor = EditWindow
	val playField = PlayWindow
	val bounds = Screen.primary.bounds

	stage = new JFXApp.PrimaryStage {
		title = "Sliding Blocks"
		scene = new Scene(400, 400) {
			root = editor
		}
	}

	val playStage = new Stage() {
		//initStyle(StageStyle.UNDECORATED)
		scene = new Scene(400,400) {
			root = playField
		}
	}
	
	monster.draw(playField.mapViewer.graphicsContext2D, 0, 0) 

	editor.editPlayToggleButton.onAction = (e: Event) => {
		if (editor.editPlayToggleButton.selected.value) {
			editor.editPlayToggleButton.text = "Play"
			playStage show
		} else {
			editor.editPlayToggleButton.text = "Edit"
			playStage close
		}

	}
	
	val colors = List(Color.BEIGE, Color.GOLD, Color.DARKCYAN)
	playField.mapViewer.graphicsContext2D.fill = colors(Random.nextInt(colors.length))

}