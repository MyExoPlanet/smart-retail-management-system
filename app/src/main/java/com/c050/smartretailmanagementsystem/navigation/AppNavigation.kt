package com.c050.smartretailmanagementsystem.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.c050.smartretailmanagementsystem.DashboardScreen
import com.c050.smartretailmanagementsystem.screens.InventoryScreen

private val BackgroundColor = Color(0xFF07111F)
private val AccentColor = Color(0xFF22D3EE)

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Scaffold(
        containerColor = BackgroundColor,
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF101D2E),
                contentColor = Color.White
            ) {
                NavigationBarItem(
                    selected = currentRoute == "home",
                    onClick = {
                        navController.navigate("home") {
                            launchSingleTop = true
                            popUpTo("home") {
                                saveState = true
                            }
                            restoreState = true
                        }
                    },
                    icon = {
                        Text("🏠")
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = currentRoute == "inventory",
                    onClick = {
                        navController.navigate("inventory") {
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Text("📦")
                    },
                    label = {
                        Text("Inventory")
                    }
                )

                NavigationBarItem(
                    selected = currentRoute == "sales",
                    onClick = {
                        navController.navigate("sales") {
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Text("🧾")
                    },
                    label = {
                        Text("Sales")
                    }
                )

                NavigationBarItem(
                    selected = currentRoute == "ai",
                    onClick = {
                        navController.navigate("ai") {
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Text("🤖")
                    },
                    label = {
                        Text("AI Assistant")
                    }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") {
                DashboardScreen()
            }

            composable("inventory") {
                InventoryScreen()
            }

            composable("sales") {
                PlaceholderScreen(
                    title = "Sales",
                    description = "Manage sales, invoices, customers, and payments."
                )
            }

            composable("ai") {
                PlaceholderScreen(
                    title = "AI Assistant",
                    description = "Ask questions about your store and discover business insights."
                )
            }
        }
    }
}

@Composable
private fun PlaceholderScreen(
    title: String,
    description: String
) {
    androidx.compose.foundation.layout.Column(
        modifier = Modifier
            .padding(24.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )

        Text(
            text = description,
            color = Color(0xFF94A3B8),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}