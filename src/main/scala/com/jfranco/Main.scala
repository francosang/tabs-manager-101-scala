package com.jfranco

import cats.effect.*
import com.jfranco.browser.{Browser, Tab}
import tyrian.*
import tyrian.Html.{div, p}

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import com.jfranco.ui.headers.*
import com.jfranco.ui.tabs.*

sealed abstract class Action

object Action:
  case object NoOp                             extends Action
  final case class TabsLoaded(tabs: List[Tab]) extends Action

sealed abstract class Model
object Model:
  case object Empty                      extends Model
  final case class Tabs(tabs: List[Tab]) extends Model

@JSExportTopLevel("Main")
object Main extends TyrianIOApp[Action, Model]:

  val browser: Browser = Browser.chromeImpl

  def router: Location => Action = Routing.none(Action.NoOp)

  def init(flags: Map[String, String]): (Model, Cmd[IO, Action]) =
    (
      Model.Tabs(Tab.dummyTabsList),
      Cmd.Run(browser.query())(it => Action.TabsLoaded(it))
    )

  def update(model: Model): Action => (Model, Cmd[IO, Action]) =
    case Action.NoOp             => (model, Cmd.None)
    case Action.TabsLoaded(tabs) => (Model.Tabs(tabs), Cmd.None)

  def view(model: Model): Html[Action] =
    div(
      header(),
      div(
        model match
          case Model.Empty      => List(p("Loading..."))
          case Model.Tabs(tabs) => tabs.map(tabItem)
      )
    )

  def subscriptions(model: Model): Sub[IO, Action] =
    Sub.None
