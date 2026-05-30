package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ui.components.MainTopAppBar
import com.example.ui.theme.BorderSubtle
import com.example.ui.theme.SecondaryRed

@Composable
fun ContactScreen() {
    Scaffold(
        topBar = { MainTopAppBar() }
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
                    Text(text = "Mari Berkolaborasi", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Kami siap membantu mewujudkan standar seragam perusahaan Anda dengan presisi industri dan kualitas premium.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            item { ContactForm() }
            item { DirectContactInfo() }
            item { OfficeAddressAndMap() }
        }
    }
}

@Composable
fun ContactForm() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Konsultasi Desain", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Isi formulir di bawah ini untuk memulai proses produksi seragam Anda.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Nama Lengkap") },
                placeholder = { Text("Contoh: Budi Santoso") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Email Korporat") },
                placeholder = { Text("budi@perusahaan.com") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Nama Perusahaan") },
                placeholder = { Text("PT Maju Bersama") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Pesan atau Spesifikasi") },
                placeholder = { Text("Jelaskan kebutuhan seragam Anda...") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 4
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 14.dp)
            ) {
                Text("Kirim Permintaan", style = MaterialTheme.typography.labelLarge)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.Send, contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
fun DirectContactInfo() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = "KONTAK LANGSUNG", style = MaterialTheme.typography.labelLarge, color = Color.White.copy(alpha = 0.7f))
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(40.dp).clip(RoundedCornerShape(20.dp)).background(Color.White.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Chat, contentDescription = "WhatsApp", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "WhatsApp", style = MaterialTheme.typography.labelSmall, color = Color.White.copy(alpha = 0.6f))
                    Text(text = "+62 812 3456 7890", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(40.dp).clip(RoundedCornerShape(20.dp)).background(Color.White.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Email, contentDescription = "Email", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "Email", style = MaterialTheme.typography.labelSmall, color = Color.White.copy(alpha = 0.6f))
                    Text(text = "info@parahita.id", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun OfficeAddressAndMap() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "KANTOR PUSAT", style = MaterialTheme.typography.labelLarge, color = SecondaryRed)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Gading Serpong, Kav. 12-14,\nTangerang, Banten 15810,\nIndonesia",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Surface(color = Color(0xFFf2f4f6), shape = RoundedCornerShape(50)) {
                    Text("Buka: Sen - Jum", modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp), style = MaterialTheme.typography.labelSmall)
                }
                Surface(color = Color(0xFFf2f4f6), shape = RoundedCornerShape(50)) {
                    Text("08:00 - 17:00", modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp), style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, BorderSubtle, RoundedCornerShape(12.dp))
    ) {
        AsyncImage(
            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuCJo7RRMpdzAlEAVVb0Tv0DobSeVQMwGAfwTfAICtmv8wi6URRVPPGwL9E-hvHhpHPiLVakKNbNisG7fAPK4ko4zluqqzxvLYWamrPvyJxS9E695RAB5a1viofdomZz3dnPQxH80pYNudwHGr-LCHh-8eRAr9ha2pRQtFt1rRpoF_3PT_b_YXISV76e1qoCuPBpBrQG23604nFsJ5Iq-BZGoRH5YEGbHVXdnFf_5Fw02Ify13afaSBkGHKYvPBPOeI6y3Od020lA_A",
            contentDescription = "Map Location",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.4f)) // Grayscale effect fallback
        )
        Row(
            modifier = Modifier.align(Alignment.BottomStart).padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Lihat di Google Maps", style = MaterialTheme.typography.labelLarge, color = Color.White)
        }
    }
}
