package smet.personal.RPGAdmin.gui.windows

import scalafx.scene.layout.Pane
import scalafx.scene.Group
import scalafx.scene.control.Label
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import javafx.collections.ListChangeListener
import smet.personal.RPGAdmin.map.Map

object PlayWindow extends Group {

	val mapViewer = new MapViewer()
	
	children.add(mapViewer)

}