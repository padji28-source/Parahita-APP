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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.components.MainTopAppBar
import com.example.ui.theme.SecondaryRed
import com.example.ui.theme.BorderSubtle
import com.example.R

data class CatalogItem(val category: String, val title: String, val desc: String, val imageRes: Int)

val catalogItems = listOf(
    CatalogItem("RETAIL", "Kemeja Dan+Dan", "Seragam kasual dan dinamis untuk kru Dan+Dan, fleksibel untuk mobilitas tinggi.", R.drawable.dandan),
    CatalogItem("RETAIL", "Polo Shirt Dan+Dan", "Polo shirt nyaman untuk aktivitas outlet Dan+Dan.", R.drawable.dandan2),
    CatalogItem("RETAIL", "Seragam Alfamart", "Seragam pramuniaga Alfamart, nyaman dan menyerap keringat.", R.drawable.alfa2),
    CatalogItem("RETAIL", "Kemeja Transmart", "Kemeja karyawan area retail The Transmart.", R.drawable.transmart),
    CatalogItem("RETAIL", "Polo Transmart", "Seragam polo untuk karyawan harian Transmart.", R.drawable.transmart2),
    CatalogItem("HOSPITALITY", "Seragam The Langham", "Seragam elegan eksklusif untuk staf hotel The Langham.", R.drawable.langham1),
    CatalogItem("HOSPITALITY", "Blazer The Langham", "Blazer untuk manajemen level bintang 5 di The Langham.", R.drawable.langham2),
    CatalogItem("HOSPITALITY", "Kemeja Front Office", "Kemeja formal dengan standar pelayanan The Langham.", R.drawable.langham3),
    CatalogItem("ENERGY", "Seragam SPBU Shell", "Seragam operasional material anti-statis standar HSE.", R.drawable.shell),
    CatalogItem("ENERGY", "Kemeja SPBU", "Kemeja lengkap dengan visibilitas ekstra untuk SHELL.", R.drawable.shell1_new),
    CatalogItem("ENERGY", "Kemeja Supervisor Shell", "Seragam supervisor lapangan dengan detail tangguh.", R.drawable.shell2),
    CatalogItem("ENERGY", "Kemeja Pertamina", "Kemeja SPBU Pertamina dengan fitur nyaman berdurabilitas tinggi.", R.drawable.pertamina3),
    CatalogItem("CONSTRUCTION", "Pakaian Dinas Waskita", "Pakaian lapangan (PDL) Waskita tangguh ekstra aman.", R.drawable.waskita),
    CatalogItem("CONSTRUCTION", "Seragam Proyek", "Seragam teknisi bangunan Waskita fungsional tinggi.", R.drawable.waskita2),
    CatalogItem("CONSTRUCTION", "Kemeja MK", "Seragam pengawas konstruksi untuk manajemen proyek MK.", R.drawable.mk1)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen() {
    var selectedCategory by androidx.compose.runtime.mutableStateOf("Semua")
    val filteredItems = if (selectedCategory == "Semua") catalogItems else catalogItems.filter { it.category == selectedCategory }
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
                    val categories = listOf("Semua", "RETAIL", "HOSPITALITY", "ENERGY", "CONSTRUCTION", "BEAUTY RETAIL")
                    items(categories) { category ->
                        val isSelected = category == selectedCategory
                        Surface(
                            shape = RoundedCornerShape(percent = 50),
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                            border = if (!isSelected) BorderStroke(1.dp, BorderSubtle) else null,
                            onClick = { selectedCategory = category }
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
            items(filteredItems) { item ->
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
                    model = item.imageRes,
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
