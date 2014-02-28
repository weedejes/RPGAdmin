package smet.personal.RPGAdmin.gui.toolbars.edit

import scalafx.scene.Group
import scalafx.scene.control.Label
import scalafx.scene.control.TabPane
import scalafx.scene.control.Tab

object MapsToolbar extends Group {
	val tabPane = new TabPane {
		tabs = List(
			new Tab {
				text = "Tiles"
				content = new Label("all tiles")
			},
			new Tab {
				text = "Objects"
				content = new Label("all objects")
			}
		)
	}
	children.add(tabPane)

}