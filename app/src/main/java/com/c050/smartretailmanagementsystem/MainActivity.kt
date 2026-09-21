package com.c050.smartretailmanagementsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.c050.smartretailmanagementsystem.ui.theme.SmartRetailManagementSystemTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SmartRetailManagementSystemTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    DashboardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {

    val backgroundColor = Color(0xFF07111F)
    val cardColor = Color(0xFF101D2E)
    val accentColor = Color(0xFF22D3EE)
    val secondaryAccent = Color(0xFF3B82F6)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 20.dp)
    ) {

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // Store header
        Text(
            text = "UrbanNest",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Retail Operations",
            color = Color(0xFF94A3B8),
            fontSize = 14.sp
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // AI Assistant
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF10263A)
            ),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    text = "✦  Ask Retail AI",
                    color = accentColor,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Ask about sales, inventory, customers or invoices",
                    color = Color(0xFFCBD5E1),
                    fontSize = 13.sp
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF172A3D),
                    shape = RoundedCornerShape(14.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(
                            horizontal = 14.dp,
                            vertical = 13.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Ask anything...",
                            color = Color(0xFF64748B),
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "🎤",
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Today's sales
        Text(
            text = "TODAY",
            color = Color(0xFF94A3B8),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            ),
            shape = RoundedCornerShape(20.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "₹42,850",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Today's Sales",
                        color = Color(0xFF94A3B8),
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = "↑ 12%",
                    color = Color(0xFF34D399),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Alerts
        Text(
            text = "NEEDS ATTENTION",
            color = Color(0xFF94A3B8),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        AlertCard(
            title = "5 Products Running Low",
            description = "Inventory levels have fallen below the reorder point.",
            accentColor = Color(0xFFF59E0B),
            cardColor = cardColor
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        AlertCard(
            title = "₹14,800 Overdue Payments",
            description = "3 customer invoices are pending collection.",
            accentColor = Color(0xFFFB7185),
            cardColor = cardColor
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Quick actions
        Text(
            text = "QUICK ACTIONS",
            color = Color(0xFF94A3B8),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            QuickAction(
                title = "New Invoice",
                modifier = Modifier.weight(1f),
                accentColor = secondaryAccent
            )

            QuickAction(
                title = "Add Product",
                modifier = Modifier.weight(1f),
                accentColor = accentColor
            )
        }
    }
}

@Composable
fun AlertCard(
    title: String,
    description: String,
    accentColor: Color,
    cardColor: Color
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        shape = RoundedCornerShape(18.dp)
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = "⚠  $title",
                color = accentColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = description,
                color = Color(0xFFCBD5E1),
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun QuickAction(
    title: String,
    modifier: Modifier = Modifier,
    accentColor: Color
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF101D2E)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Text(
            text = "+  $title",
            modifier = Modifier.padding(16.dp),
            color = accentColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    SmartRetailManagementSystemTheme {
        DashboardScreen()
    }
}