package smet.personal.RPGAdmin.gui.windows

import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import smet.personal.RPGAdmin.map.Layer
import smet.personal.RPGAdmin.map.NPCLayer
import smet.personal.RPGAdmin.npc.MonsterManual
import scalafx.collections.ObservableBuffer
import smet.personal.RPGAdmin.npc.Monster
import scalafx.scene.Group
import scalafx.scene.input.MouseEvent
import scalafx.Includes._
import smet.personal.RPGAdmin.map.TileLayer
import smet.personal.RPGAdmin.map.TileSet
import smet.personal.RPGAdmin.map.Tile
import scalafx.scene.layout.VBox
import scalafx.scene.control.Label
import scala.collection.mutable.ListBuffer
import scalafx.scene.control.Button
import scala.util.Random
import scalafx.scene.control.ContextMenu
import scalafx.scene.control.MenuItem
import scalafx.event.ActionEvent
import scalafx.scene.shape.Path
import scalafx.scene.shape.Circle
import scalafx.scene.shape.Arc
import scalafx.scene.shape.MoveTo
import scalafx.scene.shape.LineTo
import scalafx.scene.shape.ArcTo
import scalafx.animation.Timeline
import scalafx.scene.paint.LinearGradient
import scalafx.scene.paint.CycleMethod
import scalafx.scene.paint.Stop
import scalafx.scene.paint.RadialGradient
import scalafx.event.Event
import smet.personal.RPGAdmin.map.DMMode
import smet.personal.RPGAdmin.map.DrawMode

class MapViewer extends Group {
	

	val layers = new ListBuffer[Layer]()
	val canvas_tiles = new Canvas () {
		width = 3 * 128
		height = 3 * 128
	}

	def addNPCLayer(data: ObservableBuffer[Monster], dm: DrawMode) = {
		val canvas = new Canvas () {
			width = 3 * 128
			height = 3 * 128
		}
		layers += new NPCLayer(canvas.graphicsContext2D, 128, 128, data, dm)
		children.add(canvas)
	}	
	
	def addTileLayer(data: ObservableBuffer[Tile], dm: DrawMode) = {
		val canvas = new Canvas () {
			width = 3 * 128
			height = 3 * 128
		}
		layers += new TileLayer(canvas.graphicsContext2D, 128, 128, data, dm)
		children.add(canvas)
	}
	
	
	onMouseClicked = (e: MouseEvent) => {
		val pps = layers.flatMap {_.createPopupEntries(e.sceneX.toInt, e.sceneY.toInt) }
		
		
		val popup = new Group()
		val path = new Path() {
			elements = List(
				MoveTo(e.sceneX - 50, e.sceneY),
				ArcTo(50, 50, 0, e.sceneX + 50, e.sceneY, true, true),
				LineTo(e.sceneX + 100, e.sceneY),
				ArcTo(-100, -100, 0, e.sceneX - 100, e.sceneY, true, false),
				LineTo(e.sceneX - 50, e.sceneY)
			)
			fill = Color(0.7, 0.7, 0.7, 0.7)
			stroke = Color.TRANSPARENT
		}
		
		popup.children.add(path)
		var x: Int = -80
		pps foreach { pp =>
			val button = new Button(pp.name) {
				onAction = (e: Event) => {
					pp.onClick(e)
					children.remove(popup)
				}
				translateX = e.sceneX + x
				translateY = e.sceneY - 10
				x += 50
			}
			popup.children.add(button)
		}
		
		
		children.add(popup)
		
		
		
	}
	
}