package smet.personal.RPGAdmin.map

import scalafx.event.Event

case class PopupEntry(val name: String, val onClick: Event => Unit) {

}