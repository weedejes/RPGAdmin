package smet.personal.RPGAdmin.gui.windows

import scalafx.scene.layout.BorderPane
import scalafx.scene.canvas.Canvas
import scalafx.scene.Group
import scalafx.scene.control.Label
import scalafx.scene.layout.HBox
import scalafx.scene.control.Button
import scalafx.scene.control.TextField
import scalafx.scene.layout.VBox
import scalafx.scene.input.MouseEvent
import scalafx.event._
import scalafx.event.EventHandler
import scalafx.Includes._
import scalafx.scene.control.ToggleButton
import javafx.scene.Node
import scalafx.beans.property.StringProperty
import scalafx.scene.control.ToggleGroup
import scalafx.scene.control.Toggle

object EditWindow extends BorderPane {

	// Map Editor
	val mapEditor = new MapViewer()
	val textEditor = new TextField
	
	

	val addTile = new Button("Add tile")

	// Toolbar Selection
	val editPlayToggleButton = new ToggleButton("Edit")
	val editMode = new StringProperty
	editMode.value = "play"
	editMode <== when(editPlayToggleButton.selected) then "play" otherwise "edit"

	val mapSelectionButton = new ToggleButton("Maps")
	mapSelectionButton.selected = true
	val effectSelectionButton = new ToggleButton("Effects")
	val musicSelectionButton = new ToggleButton("Music")
	val toggleGroup = new ToggleGroup {
		toggles = List(mapSelectionButton, effectSelectionButton, musicSelectionButton) 
	}
	val selectedToolbar = new StringProperty
	selectedToolbar.value = "maps"
	toggleGroup.selectedToggle.onChange {
		selectedToolbar <== toggleGroup.selectedToggle.get.asInstanceOf[javafx.scene.control.ToggleButton].text
	}

	val selectionToolbar = new VBox
	selectionToolbar.children.addAll(
		editPlayToggleButton,
		mapSelectionButton,
		effectSelectionButton,
		musicSelectionButton)

	// Toolbar editor
	val toolbarEditors = scala.collection.mutable.Map[String, Group]()


	toolbarEditors("music") = smet.personal.RPGAdmin.gui.toolbars.edit.MusicToolbarEditor 
	toolbarEditors("maps") = smet.personal.RPGAdmin.gui.toolbars.edit.MapsToolbarEditor
	toolbarEditors("effects") = smet.personal.RPGAdmin.gui.toolbars.edit.EffectsToolbarEditor

	// Toolbars
	val toolbars = scala.collection.mutable.Map[String, Group]()
	toolbars("music_edit") = smet.personal.RPGAdmin.gui.toolbars.edit.MusicToolbar
	toolbars("maps_edit") = smet.personal.RPGAdmin.gui.toolbars.edit.MapsToolbar
	toolbars("effects_edit") = smet.personal.RPGAdmin.gui.toolbars.edit.EffectsToolbar

	toolbars("music_play") = smet.personal.RPGAdmin.toolbars.play.MusicToolbar
	toolbars("maps_play") = smet.personal.RPGAdmin.toolbars.play.MapsToolbar
	toolbars("effects_play") = smet.personal.RPGAdmin.toolbars.play.EffectsToolbar

	def updateToolbar = {
		bottom = toolbars(selectedToolbar.value.toLowerCase + "_" + editMode.value.toLowerCase)
		if (editMode.value == "edit") {
			left = toolbarEditors(selectedToolbar.value.toLowerCase())
		} else {
			left = new Group
		}
	}
	editMode.onChange {
		updateToolbar
	}
	selectedToolbar.onChange {
		updateToolbar
	}
	updateToolbar

	// Set different regions
	center = mapEditor
	right = selectionToolbar
}