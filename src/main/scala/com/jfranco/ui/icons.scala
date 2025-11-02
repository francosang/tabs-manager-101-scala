package com.jfranco.ui

import tyrian.*
import tyrian.Html.*
import com.jfranco.Action

object icons {

  def closeIcon: Html[Action] =
    import tyrian.SVG.*

    svg(
      xmlns   := "http://www.w3.org/2000/svg",
      fill    := "currentColor",
      viewBox := "0 0 16 16"
    )(
      path(
        d := "M5.28 4.22a.75.75 0 0 0-1.06 1.06L6.94 8l-2.72 2.72a.75.75 0 1 0 1.06 1.06L8 9.06l2.72 2.72a.75.75 0 1 0 1.06-1.06L9.06 8l2.72-2.72a.75.75 0 0 0-1.06-1.06L8 6.94 5.28 4.22Z"
      )
    )

  def iconButton(icon: Html[Action]): Html[Action] =
    div(
      cls := "w-7 h-7 p-1 ml-3 font-light dark:text-white border border-gray-200 rounded-lg toggle-ring-gray-500 focus:outline-none dark:text-gray-400 dark:border-gray-600 hover:bg-gray-300 dark:hover:bg-gray-500 hover:text-white"
    )(
      icon
    )

  def menuIcon: Html[Action] =
    import tyrian.SVG.*

    svg(
      xmlns   := "http://www.w3.org/2000/svg",
      fill    := "currentColor",
      viewBox := "0 0 16 16"
    )(
      path(
        d := "M8 2a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3ZM8 6.5a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3ZM9.5 12.5a1.5 1.5 0 1 0-3 0 1.5 1.5 0 0 0 3 0Z"
      )
    )

  def plusOneIcon: Html[Action] =
    import tyrian.SVG.*
    svg(
      xmlns   := "http://www.w3.org/2000/svg",
      fill    := "currentColor",
      viewBox := "0 0 16 16"
    )(
      path(
        d := "M8.75 3.75a.75.75 0 0 0-1.5 0v3.5h-3.5a.75.75 0 0 0 0 1.5h3.5v3.5a.75.75 0 0 0 1.5 0v-3.5h3.5a.75.75 0 0 0 0-1.5h-3.5v-3.5Z"
      )
    )

  def duplicateIcon: Html[Action] =
    import tyrian.SVG.*
    svg(
      xmlns   := "http://www.w3.org/2000/svg",
      fill    := "currentColor",
      viewBox := "0 0 16 16"
    )(
      path(
        d := "M5.5 3.5A1.5 1.5 0 0 1 7 2h2.879a1.5 1.5 0 0 1 1.06.44l2.122 2.12a1.5 1.5 0 0 1 .439 1.061V9.5A1.5 1.5 0 0 1 12 11V8.621a3 3 0 0 0-.879-2.121L9 4.379A3 3 0 0 0 6.879 3.5H5.5Z"
      ),
      path(
        d := "M4 5a1.5 1.5 0 0 0-1.5 1.5v6A1.5 1.5 0 0 0 4 14h5a1.5 1.5 0 0 0 1.5-1.5V8.621a1.5 1.5 0 0 0-.44-1.06L7.94 5.439A1.5 1.5 0 0 0 6.878 5H4Z"
      )
    )

}
