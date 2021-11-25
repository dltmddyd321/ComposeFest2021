package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.toUpperCase
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    //Add Test
    @Test
    fun rallyTopAppBarTest() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }
        //Thread.sleep(5000)
        //composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")
        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.toUpperCase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            ).assertExists()

//        composeTestRule
//            .onNodeWithContentDescription(RallyScreen.Accounts.name.toUpperCase())
//            .assertIsSelected()
    }
}