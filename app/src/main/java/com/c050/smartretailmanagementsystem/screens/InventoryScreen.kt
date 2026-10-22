package com.c050.smartretailmanagementsystem.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF07111F)
private val CardBackground = Color(0xFF101D2E)
private val Cyan = Color(0xFF22D3EE)
private val MutedText = Color(0xFF94A3B8)
private val Warning = Color(0xFFFBBF24)
private val Danger = Color(0xFFFB7185)

private data class Product(
    val name: String,
    val category: String,
    val price: Int,
    val stock: Int,
    val reorderLevel: Int
)

private val sampleProducts = listOf(
    Product("Wireless Keyboard", "Accessories", 1500, 12, 5),
    Product("Wireless Mouse", "Accessories", 750, 4, 10),
    Product("USB-C Cable", "Cables", 350, 0, 8),
    Product("Laptop Stand", "Accessories", 1200, 18, 5),
    Product("USB Hub", "Electronics", 950, 7, 10)
)

@Composable
fun InventoryScreen() {
    val totalProducts = sampleProducts.size
    val lowStock = sampleProducts.count {
        it.stock > 0 && it.stock <= it.reorderLevel
    }
    val outOfStock = sampleProducts.count {
        it.stock == 0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        Text(
            text = "Inventory",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Manage products and stock levels",
            color = MutedText,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SummaryCard(
                title = "Products",
                value = totalProducts.toString(),
                modifier = Modifier.weight(1f),
                valueColor = Cyan
            )

            SummaryCard(
                title = "Low Stock",
                value = lowStock.toString(),
                modifier = Modifier.weight(1f),
                valueColor = Warning
            )

            SummaryCard(
                title = "Out of Stock",
                value = outOfStock.toString(),
                modifier = Modifier.weight(1f),
                valueColor = Danger
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "All Products",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sampleProducts) { product ->
                ProductCard(product)
            }
        }
    }
}

@Composable
private fun SummaryCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    valueColor: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                color = MutedText,
                fontSize = 11.sp
            )

            Text(
                text = value,
                color = valueColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ProductCard(product: Product) {
    val status = when {
        product.stock == 0 -> "Out of stock"
        product.stock <= product.reorderLevel -> "Low stock"
        else -> "In stock"
    }

    val statusColor = when {
        product.stock == 0 -> Danger
        product.stock <= product.reorderLevel -> Warning
        else -> Cyan
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = product.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = product.category,
                    color = MutedText,
                    fontSize = 12.sp
                )

                Text(
                    text = status,
                    color = statusColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "₹${product.price}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                Text(
                    text = "Stock: ${product.stock}",
                    color = MutedText,
                    fontSize = 12.sp
                )
            }
        }
    }
}