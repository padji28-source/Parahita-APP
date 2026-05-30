package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.components.MainTopAppBar
import com.example.ui.theme.SecondaryRed
import com.example.ui.theme.BorderSubtle

data class CatalogItem(val category: String, val title: String, val desc: String, val imageUrl: String)

val catalogItems = listOf(
    CatalogItem("INDUSTRIAL", "Seragam Tambang", "Material drill berkualitas tinggi dengan fitur tahan panas dan visibilitas tinggi untuk keamanan pekerja lapangan.", "https://lh3.googleusercontent.com/aida/ADBb0ugr-SozJzeThDVPA2vHrSrXlc2DBTsv6jHWoDK67t9X3b56sLt_yIaArMrkR6MqBiFkPk2DTPOX2dP4GKb-kz1UjBA0KHSMgyVDRWX_Qc38yGQya54UAwVKL4ErvA2wpgw6UxjHJ0do24f4QM1LGuoGenP7bzLxBaDKGTzXZEBLN8nIdNJnBVpv_lhQxhxaOhdQsS7BbnZgJ-4dep5Rjh_Ft-CpJIqEbLRzH9jEM8_vegMWaAygNJcygg0"),
    CatalogItem("AUTOMOTIVE", "Seragam Otomotif", "Desain ergonomis yang memudahkan pergerakan teknisi dengan bahan yang menyerap keringat dan tidak mudah sobek.", "https://lh3.googleusercontent.com/aida/ADBb0uidy1DTs1jcAaq54yI3FT9Qf-uDzYeb_c61-KyzWNmHuI7Eh-RZkcQL39SYQZZtAKYdNAST1BVyCBMCLhpcTQFM9b44lpKbn1PcRBaL4UiiAPWoR21YVGL7lYhJgf3HYEYhp1bXwtBYM4NSShzySYord2_1tS3LA4RB_rgdfOm0pja-k7AdVhYdmFx7QdBuknheOnGrd0sPfbXUJ30ImHwFUOPLqllSatvKJkwrFpBfZYZo5hhlHl742so"),
    CatalogItem("HOSPITALITY", "Seragam Waralaba", "Tampilan bersih dan rapi untuk staf frontliner. Pilihan bahan katun premium yang nyaman digunakan sepanjang hari.", "https://lh3.googleusercontent.com/aida/ADBb0uj27mr1ggZ7htrMERCVoBV7qHeoMpunQEJCEfef5ED7lSLl5rY9nV6PDlReOio206MeAfvvtGALF1mVf7N8eVLdSB68xV5xC2A-Tl6XXNlvdBF0elLlf9dJFJIM9BgHaWekgIq9fdtBxXLzsJauVlnrs2394Rj_MxHpC4i6jaAZiuhi9rZvP7KqzgCg0123V1Dr4ITqx49dhl4WY_wWqAjvU5d2XHf0zjWRKurlARvy92ZzKxp8BWd0pfE")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Parahita") },
                actions = {
                    IconButton(onClick = {}) { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Column {
                    Text(text = "Katalog Seragam", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Kualitas industri profesional untuk berbagai kebutuhan korporat Anda.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val categories = listOf("Semua", "Tambang", "Otomotif", "Waralaba", "Medis")
                    items(categories) { category ->
                        val isSelected = category == "Semua"
                        Surface(
                            shape = RoundedCornerShape(percent = 50),
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                            border = if (!isSelected) BorderStroke(1.dp, BorderSubtle) else null,
                            onClick = {}
                        ) {
                            Text(
                                text = category,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
            items(catalogItems) { item ->
                CatalogCard(item)
            }
        }
    }
}

@Composable
fun CatalogCard(item: CatalogItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Color(0xFFeceef0))
            ) {
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = item.category, style = MaterialTheme.typography.labelSmall, color = SecondaryRed)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.title, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.desc, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary, contentColor = Color.White),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(vertical = 12.dp)
                ) {
                    Text("Detail", style = MaterialTheme.typography.labelLarge)
                }
            }
        }
    }
}
