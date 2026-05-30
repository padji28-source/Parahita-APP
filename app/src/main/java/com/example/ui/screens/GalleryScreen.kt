package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.components.MainTopAppBar
import com.example.ui.theme.SecondaryRed

@Composable
fun GalleryScreen() {
    Scaffold(
        topBar = { MainTopAppBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            item { GalleryHero() }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StatItem("KAPASITAS BULANAN", "50,000+ Unit")
                    StatItem("STANDAR KUALITAS", "ISO 9001:2015")
                }
            }
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Alur Produksi Kami", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Setiap tahap dipantau secara ketat untuk memastikan daya tahan dan kenyamanan maksimal.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            item {
                GalleryProcessCard("Tahap 01", "Precision Cutting", "Pemotongan kain menggunakan mesin CNC otomatis untuk akurasi pola milimeter.", "https://lh3.googleusercontent.com/aida-public/AB6AXuDWddoDtr0SWILsliICMb8hWyD1a7blbwEH7DOnmOLOPLcwQ9RhIxPGS-GygtfM15u0sfCrgcJeGB8_gE8wJC-U_a6XtfuRLvjpiNCaf9qlqnshBnI86GhWDe_uZAJQONvzZ-KKmhfiAIlr1Ur0EtMzPDbvrfU3HR5ObaFmPxJydfc3gqHBVaNBeQ7vzkj8HNBJTu0Gsnst3kd_WF8lBNUPCU2wdZmG3aayWyCQkiOgw59-2QdQfVnglCBo2N9bTWo5qdtOSG6Trv0")
            }
            item {
                GalleryProcessCard("Expert Sewing", "Expert Sewing", "Jahitan kuat dan presisi.", "https://lh3.googleusercontent.com/aida-public/AB6AXuAHuh0blMT9XCVYG--t9P25BprT-N3aSFfeDo4oKJdLjbFTTkpqCx8bAo8zZCOtf5y_EFGoQQ3tIVgxwF4IGfl_F7fYrVPlP_W45A0LUznh-u5LatHDAF9kie2OTs0POsVgRv-kEIqcs7MDlXaV52lhHhQmQBwDDGEO_98nfI0nnfzAnjFlOlsim92aF2v8RIP9_xWvNQ_-5reGZqt8RFkvijfo22-6p-Ur5EgPJ7JH6Vl7rBuYg1xDky8xuBRMmZL-_wo4pkH5Qmc")
            }
            item {
                GalleryProcessCard("Step Final", "Finishing & Packaging", "Setiap produk melalui proses uap panas dan pengemasan steril sebelum dikirim.", "https://lh3.googleusercontent.com/aida-public/AB6AXuBlR29oBZjzLv6v19Oy0aKNIAbv6c3wyF3uVacnX9QhhZsQkdv2a0yQLey_V4TOcQsD2r3uej8Kh33rtOoqNtiYLBDOL7gzPmsYhb_gsmMAZaYQf1oEsfpYZgdJcg53AR9BBbOQ9DdlregkwcbcGOISLJ9PBm_yrEpJtD88EcM15TUhvEUgiMysu8gaRYbF-BQHMhzZuJwPEb_ByuK8dnxl6sNaBu185DQijPa1Tz6b4j1_5KTwiBMqg7wz8R2zCxfZA4w32Nx5S2g")
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun GalleryHero() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {
        AsyncImage(
            model = "https://lh3.googleusercontent.com/aida/ADBb0ujgKz1tCzJxBqG75cbSNt9NyKjidURON77Er0HUquUn8pTWuYSQU8RVRdO-N4sStuxVAnzVRcx7lz0BD_BBwjbN5rnnOYvjkaYAD-oxQImc2Wr6g7ylyINBvAD6wF8udikHvVF-FrxERsmwMuyY9ALNqgkIXDfGWpu5w7LRk3B8EZbUfVIbPPltk2vtqesdzy18GRYsPmYo523Ep5TabNRdRIOPv9Hw2km8qx81R68wnu2vGYQwMQQ__g0",
            contentDescription = "Production Hero",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, MaterialTheme.colorScheme.primary.copy(alpha = 0.8f))
                )
            )
        )
        Column(
            modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
        ) {
            Text("EXCELLENCE IN CRAFT", style = MaterialTheme.typography.labelSmall, color = SecondaryRed)
            Text("Galeri Produksi", style = MaterialTheme.typography.displayLarge, color = Color.White)
            Text("Melihat lebih dekat presisi dan dedikasi di balik setiap jahitan seragam Parahita.", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.8f))
        }
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = value, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
    }
}

@Composable
fun GalleryProcessCard(tag: String, title: String, desc: String, imgUrl: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(180.dp)) {
            AsyncImage(
                model = imgUrl,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, MaterialTheme.colorScheme.primary.copy(alpha = 0.9f))
                    )
                )
            )
            Column(modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)) {
                Text(text = tag, style = MaterialTheme.typography.labelSmall, color = Color.White.copy(alpha = 0.7f))
                Text(text = title, style = MaterialTheme.typography.headlineMedium, color = Color.White)
                Text(text = desc, style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.8f))
            }
        }
    }
}
