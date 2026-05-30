package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.components.MainTopAppBar
import com.example.ui.theme.SecondaryRed
import com.example.ui.theme.BorderSubtle

@Composable
fun HomeScreen(onNavigateToCatalog: () -> Unit = {}) {
    Scaffold(
        topBar = { MainTopAppBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            item { HeroSection(onNavigateToCatalog) }
            item { FeaturesSection() }
            item { FeaturedProductsSection(onNavigateToCatalog = onNavigateToCatalog) }
            item { CtaSection() }
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun HeroSection(onNavigateToCatalog: () -> Unit = {}) {
    BoxWithConstraints {
        val isWide = maxWidth > 600.dp
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(if (isWide) 2.5f else 1.2f)
        ) {
            AsyncImage(
                model = "https://lh3.googleusercontent.com/aida/ADBb0ug5Pa5hqDNEiKB6ZQiEb1y1e-CjXx6vfCRQMRzZVoOI5V3ziZiyRBWnLxTc8W_M889sG7M6mK6p-xJizNBMRbbSZi-jH2reyYkYAnKq3ejKVjyszfkxUVetazRemRx199D-Y6MSGxCdZ56j1eYW43noPaQwHMf8bxcarwLMLa5-RiwQzRLGhjqzvPEVdYHhFkhs9toCcpbF9a7F8Fn_jHiYkCuTmiXuDU1ldWpyJiU6bX3_yiiFXkUgNgo",
                contentDescription = "The Real Uniform & Promotion",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
                            )
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(24.dp)
                    .fillMaxWidth(if (isWide) 0.6f else 0.9f)
            ) {
                Text(
                    text = "The Real Uniform &\nPromotion",
                    style = if (isWide) MaterialTheme.typography.displayLarge.copy(color = Color.White) else MaterialTheme.typography.headlineLarge.copy(color = Color.White, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Solusi terbaik untuk kebutuhan seragam kerja dan media promosi perusahaan Anda.",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White.copy(alpha = 0.9f))
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = onNavigateToCatalog,
                    colors = ButtonDefaults.buttonColors(containerColor = SecondaryRed),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp)
                ) {
                    Text("Jelajahi Produk", color = Color.White, style = MaterialTheme.typography.labelLarge)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(18.dp), tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun FeaturesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Mengapa Kami?",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 24.dp)
                    .height(4.dp)
                    .width(48.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(SecondaryRed)
            )
        }

        BoxWithConstraints {
            if (maxWidth > 600.dp) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Box(modifier = Modifier.weight(1f)) {
                        FeatureCard(
                            title = "Berpengalaman",
                            description = "Bertahun-tahun menangani klien korporasi dengan standar tinggi.",
                            iconUrl = "https://lh3.googleusercontent.com/aida/ADBb0uiHdYpAoqcacrTNokQguY82XU_fGWA12FQPdTGnA3xsMz945M8DT03qw7G3oNp3OLdHHblf5El2ckvy4BkZoQILPuYGNVJbCflM7xpWWWkkdL4qryqXeDqyXTnXYpdNz7ydPXsOey6stBdRciqEPL7nCUT_WvSAaQxJwSG4nOTRd_ChmiGzEkngU_4jNd2XtDjHKHRDowexKYZ9dXh_P5B_5WSMBHiLCxPd37MmFIz35kpJcbiky6OmVDg",
                            isHorizontal = false
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        FeatureCard(
                            title = "Kualitas Premium",
                            description = "Material pilihan & jahitan rapi.",
                            iconUrl = "https://lh3.googleusercontent.com/aida/ADBb0uhnk_EBAL04byr3mTgRCpZs8WAOwf5IXG9YcMqt6BFRFV_rmvjg-WfrYONV5LsRQCe5BDEBDE-JMkPwVYLSvAHXEIW3WowHQXvbDY6cTaFnqF1dIp7MWmWpDIS3DpTyJF7T8rBiI5cq7ys6kuvb535pFAkZZw6Yir8bS2Qcxdnn774fbIr3lJkB_tQe3L9pPzQt7l6ao8PSU0o-A2uiZU9UKbY24w2y-kdqL76s7FpN_BLIa8sjln71Mw",
                            isHorizontal = false
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        FeatureCard(
                            title = "Tepat Waktu",
                            description = "Manajemen produksi efisien & akurat.",
                            iconUrl = "https://lh3.googleusercontent.com/aida/ADBb0ugZ42bhZXfhji15qj_02fy1wGfk-SrMrc2gwoLeJA4iM7VMx6ItmGepnnRI9V5xM23fWKjbty7Xpt739rWwJ5eJ0UZ3FPXm1BBaGtCjXhORZHLEjBouQHWqhF6CoYAs8ral8Exf6kbp6WYm94B6BG4hd6gIHmtH8P1f2ST_CxD89UTbMxFStutRyCW2-6IO8SqcRTCt22nQ4Ov4TEDBUV_GWNAFhcT1iM4xET7pvhI7zU7Apn6CtCZ3Ig",
                            isHorizontal = false
                        )
                    }
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    FeatureCard(
                        title = "Berpengalaman",
                        description = "Bertahun-tahun menangani klien korporasi dengan standar tinggi.",
                        iconUrl = "https://lh3.googleusercontent.com/aida/ADBb0uiHdYpAoqcacrTNokQguY82XU_fGWA12FQPdTGnA3xsMz945M8DT03qw7G3oNp3OLdHHblf5El2ckvy4BkZoQILPuYGNVJbCflM7xpWWWkkdL4qryqXeDqyXTnXYpdNz7ydPXsOey6stBdRciqEPL7nCUT_WvSAaQxJwSG4nOTRd_ChmiGzEkngU_4jNd2XtDjHKHRDowexKYZ9dXh_P5B_5WSMBHiLCxPd37MmFIz35kpJcbiky6OmVDg",
                        isHorizontal = true
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            FeatureCard(
                                title = "Kualitas Premium",
                                description = "Material pilihan & jahitan rapi.",
                                iconUrl = "https://lh3.googleusercontent.com/aida/ADBb0uhnk_EBAL04byr3mTgRCpZs8WAOwf5IXG9YcMqt6BFRFV_rmvjg-WfrYONV5LsRQCe5BDEBDE-JMkPwVYLSvAHXEIW3WowHQXvbDY6cTaFnqF1dIp7MWmWpDIS3DpTyJF7T8rBiI5cq7ys6kuvb535pFAkZZw6Yir8bS2Qcxdnn774fbIr3lJkB_tQe3L9pPzQt7l6ao8PSU0o-A2uiZU9UKbY24w2y-kdqL76s7FpN_BLIa8sjln71Mw",
                                isHorizontal = false
                            )
                        }
                        Box(modifier = Modifier.weight(1f)) {
                            FeatureCard(
                                title = "Tepat Waktu",
                                description = "Manajemen produksi efisien & akurat.",
                                iconUrl = "https://lh3.googleusercontent.com/aida/ADBb0ugZ42bhZXfhji15qj_02fy1wGfk-SrMrc2gwoLeJA4iM7VMx6ItmGepnnRI9V5xM23fWKjbty7Xpt739rWwJ5eJ0UZ3FPXm1BBaGtCjXhORZHLEjBouQHWqhF6CoYAs8ral8Exf6kbp6WYm94B6BG4hd6gIHmtH8P1f2ST_CxD89UTbMxFStutRyCW2-6IO8SqcRTCt22nQ4Ov4TEDBUV_GWNAFhcT1iM4xET7pvhI7zU7Apn6CtCZ3Ig",
                                isHorizontal = false
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FeatureCard(title: String, description: String, iconUrl: String, isHorizontal: Boolean) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (isHorizontal) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = iconUrl,
                    contentDescription = title,
                    modifier = Modifier.size(72.dp).clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        } else {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = iconUrl,
                    contentDescription = title,
                    modifier = Modifier.fillMaxWidth().aspectRatio(1.5f).clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
            }
        }
    }
}

data class ProductInfo(val category: String, val title: String, val imageUrl: String, val isNew: Boolean = false)

val sampleProducts = listOf(
    ProductInfo("WORKWEAR", "Kemeja Drill Premium", "https://lh3.googleusercontent.com/aida-public/AB6AXuCswrAQCQdxlnPxkA_IM9tpu-f3lrt8hzChocwCTJ-wazjWF5NiZfSvk1W0p5yiFHoEMVverKkVP69TCvgamMC6jNo2sRC1l13HIOH0goMyfdL8VQukXeSPEu3kQvu9OnEf4K7eHjgjEadsOcJZwJ2_XyYOWjWB-Ytb5DRErGNwoqinqicYD2Kjx3etDMVH3p82buXgyRY9BDxc3PbUw5Syhg49ISpdkyc_bKEHRg0c08r8AH1UVB_HAToNRY11cfR5WdxGYcRv_-8"),
    ProductInfo("PROMOTION", "Polo Shirt Lacoste", "https://lh3.googleusercontent.com/aida-public/AB6AXuDDyE6a7yRcc3s1BrHz8Stx2KufirLWtYi1UeP80GT3iLTUy-e3XS-VVyOFQnL_OpTN4aHjC_lK92bRJU2FkP8QnElKEK5OYslKD2n1R4ROyq9QnaCRf4ssgT0FcF8wz4Pk4qq5PG8ncWOodWcUMs9aOXftybjKZNLGBZ0h1N9Pl15T8em-ubdx0Xa3VurGvAQzUUg_9mn015PEQ-Qe45E13TbGl7MaNmD1RnixQQfZvGgSeiUrVEzUXmXjtFdS9F1EQHsuu_AYEwA", isNew = true),
    ProductInfo("INDUSTRIAL", "Jaket Safety Pro", "https://lh3.googleusercontent.com/aida-public/AB6AXuACNLqNnh8GjSujiA797pOicpz4aydnDsSrVWTBkHXbux2BEU1aXPJSiAh5FEeFXmeSrwsfW1zXEuEacA4aG_K2tuYmPYqvc-QaZtEHwuv4oNdlXZLqb3G7vpuufPeZBryh_OzB8Joq_d3c0cVtm4F4BhSq22ULtz-hY2H3BKMZA_C4E-omQ6CfI1idNN2Lxpp5Ka2NKM4UEW-o1iuNyoEeI0yXwXbufvB5HdcJ2ZK64S8XBzWXXF699OOnxIHnXlCm4nraM6YNiJc")
)

@Composable
fun FeaturedProductsSection(onNavigateToCatalog: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(text = "Produk Unggulan", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
                Text(text = "Inovasi desain seragam terkini", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Text(
                text = "Lihat Semua", 
                style = MaterialTheme.typography.labelLarge, 
                color = SecondaryRed, 
                modifier = Modifier.clickable(onClick = onNavigateToCatalog).padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sampleProducts) { product ->
                ProductCard(product)
            }
        }
    }
}

@Composable
fun ProductCard(product: ProductInfo) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.width(180.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4f / 5f)
                    .background(Color(0xFFeceef0))
            ) {
                AsyncImage(
                    model = product.imageUrl,
                    contentDescription = product.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                if (product.isNew) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(SecondaryRed)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(text = "BARU", style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold), color = Color.White)
                    }
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = product.category, style = MaterialTheme.typography.labelSmall, color = SecondaryRed)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = product.title, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

@Composable
fun CtaSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(32.dp)
    ) {
        BoxWithConstraints {
            val isWide = maxWidth > 600.dp
            if(isWide) {
                Row(
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.SpaceBetween,
                   modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Butuh Penawaran Khusus?", style = MaterialTheme.typography.headlineMedium, color = Color.White)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Konsultasikan kebutuhan seragam perusahaan Anda dengan tim ahli kami secara gratis.", style = MaterialTheme.typography.bodyLarge, color = Color.White.copy(alpha = 0.8f))
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.Chat, contentDescription = null, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Hubungi via WhatsApp", style = MaterialTheme.typography.labelLarge)
                    }
                }
            } else {
                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Butuh Penawaran Khusus?", style = MaterialTheme.typography.headlineMedium, color = Color.White)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "Konsultasikan kebutuhan seragam perusahaan Anda dengan tim ahli kami secara gratis.", style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.8f))
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = MaterialTheme.colorScheme.primary),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(vertical = 16.dp)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.Chat, contentDescription = null, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Hubungi via WhatsApp", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}

