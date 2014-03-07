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
import smet.personal.RPGAdmin.map.TileSet
import scalafx.collections.ObservableBuffer
import smet.personal.RPGAdmin.map.Tile
import smet.personal.RPGAdmin.npc.Monster
import smet.personal.RPGAdmin.map.PlayerMode
import smet.personal.RPGAdmin.map.DMMode

object Main extends JFXApp {
	
	val editor = EditWindow
	val playField = PlayWindow
	val bounds = Screen.primary.bounds

	stage = new JFXApp.PrimaryStage {
		title = "RPGAdmin"
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
	
	playStage show

	val mm = new MonsterManual()
	mm.loadFromFile("")
	
	val tt = new TileSet()
	tt.loadFromFile("")
	
	val monsters = ObservableBuffer[Monster](mm("hoop"), mm("hoop"))
	val tilesList = (0 until 3) flatMap {i =>
		(0 until 3) map {j =>
			tt(i, j, "grass")
		}
	}
	val tiles = ObservableBuffer[Tile](tilesList)
	
	val dm = DMMode()
	val pm = PlayerMode()
	playField.mapViewer.addTileLayer(tiles, pm)
	playField.mapViewer.addNPCLayer(monsters, pm)
	
	editor.mapEditor.addTileLayer(tiles, dm)
	editor.mapEditor.addNPCLayer(monsters, dm)
	
	
}