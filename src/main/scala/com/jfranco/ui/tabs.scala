package com.jfranco.ui

import com.jfranco.browser.Tab
import tyrian.*
import tyrian.Html.*

import com.jfranco.Action
import com.jfranco.ui.icons.*

object tabs {

  def tabItem(tab: Tab): Html[Action] =
    div(
      cls := "flex items-center border-b bg-white dark:bg-gray-800 dark:border-gray-700 dark:hover:text-white dark:hover:bg-gray-700"
    )(
      // Icon
      img(
        src := tab.favIconUrl.getOrElse(""),
        cls := "w-4 h-4 m-2"
      ),
      // Title
      div(
        cls := "py-2 truncate font-light dark:text-white text-sm w-full"
      )(tab.title.getOrElse("")),
      // Actions aligned to the right
      div(cls := "flex pr-2 space-x-1")(
        // Windows button
        iconButton(menuIcon),
        // Duplicate button
        iconButton(duplicateIcon),
        // Close button
        iconButton(closeIcon)
      )
    )

  def actionTab(label: String): Html[Action] =
    button(
      cls := "w-7 h-7 font-light dark:text-white border border-gray-200 rounded-lg toggle-ring-gray-500 focus:outline-none dark:text-gray-400 dark:border-gray-600 dark:hover:text-white dark:hover:bg-gray-800"
    )(label)

}
