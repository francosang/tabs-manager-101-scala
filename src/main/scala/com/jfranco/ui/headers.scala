package com.jfranco.ui

import tyrian.*
import tyrian.Html.*
import com.jfranco.ui.icons.*
import com.jfranco.Action
import com.jfranco.ui.windows.windowItem

object headers {

  def header(): Html[Action] =
    div(
      cls := "text-sm font-medium text-center text-gray-500 border-b border-gray-200 bg-white dark:bg-gray-800 dark:text-gray-400 dark:border-gray-700"
    )(
      ul(
        cls := "flex items-center -mb-px w-full"
      )(
        headerItem(windowItem("All windows", selected = true)),
        headerItem(windowItem("Window 1", selected = false)),
        headerItem(windowItem("Window 2", selected = false)),
        headerItem(iconButton(plusOneIcon))
      )
    )

  def headerItem(content: Html[Action]): Html[Action] =
    div(cls := "inline-block")(
      content
    )
}
