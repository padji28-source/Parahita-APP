package com.example.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.ContactSupport
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Catalog : Screen("catalog", "Products", Icons.Default.Inventory2)
    object Gallery : Screen("gallery", "Gallery", Icons.Default.PhotoLibrary)
    object Contact : Screen("contact", "Contact", Icons.Default.ContactSupport)
}

val BottomNavScreens = listOf(
    Screen.Home,
    Screen.Catalog,
    Screen.Gallery,
    Screen.Contact
)
