package smet.personal.RPGAdmin.map

sealed trait DrawMode

case class DMMode extends DrawMode
case class PlayerMode extends DrawMode