package com.jfranco.ui

import tyrian.*
import tyrian.Html.*
import com.jfranco.Action
import com.jfranco.ui.icons.closeIcon

object windows {

  def windowItem(label: String, selected: Boolean): Html[Action] =
    val classes =
      if selected then
        "rounded-t-lg text-blue-600 border-blue-600 active dark:text-blue-500 dark:border-blue-500"
      else
        "border-transparent rounded-t-lg hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300"

    div(
      cls := s"flex items-center space-x-2 py-2 pl-2 pr-1 border-b-2 $classes"
    )(
      a(
        href := "#"
      )(label),
      div(
        cls := "w-4 h-4 rounded-lg hover:bg-gray-300 dark:hover:bg-gray-500 hover:text-white"
      )(closeIcon)
    )

}
