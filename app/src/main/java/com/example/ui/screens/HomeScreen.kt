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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import com.example.R

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
            item { ClientsSection() }
            item { FeaturedProductsSection(onNavigateToCatalog = onNavigateToCatalog) }
            item { CtaSection() }
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

data class SlideData(val imageRes: Int, val title: String, val desc: String)

@Composable
fun HeroSection(onNavigateToCatalog: () -> Unit = {}) {
    var currentSlide by androidx.compose.runtime.remember { androidx.compose.runtime.mutableIntStateOf(0) }
    
    androidx.compose.runtime.LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.delay(5000)
            currentSlide = (currentSlide + 1) % 2
        }
    }

    val slides = listOf(
        SlideData(
            imageRes = com.example.R.drawable.parahitaprimasentosa,
            title = "The Real Uniform &\nPromotion",
            desc = "Solusi terbaik untuk kebutuhan seragam kerja dan media promosi perusahaan Anda."
        ),
        SlideData(
            imageRes = com.example.R.drawable.product_1,
            title = "Koleksi Seragam\nTerlengkap",
            desc = "Kualitas jahitan premium dengan pilihan material terbaik demi kenyamanan kerja Anda."
        )
    )

    val slide = slides[currentSlide]

    BoxWithConstraints {
        val isWide = maxWidth > 600.dp
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(if (isWide) 2.5f else 1.2f)
        ) {
            AsyncImage(
                model = slide.imageRes,
                contentDescription = slide.title,
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
                    text = slide.title,
                    style = if (isWide) MaterialTheme.typography.displayLarge.copy(color = Color.White) else MaterialTheme.typography.headlineLarge.copy(color = Color.White, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = slide.desc,
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White.copy(alpha = 0.9f))
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
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

                    Row(
                        modifier = Modifier.padding(end = 12.dp)
                    ) {
                        slides.forEachIndexed { index, _ ->
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .size(8.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(
                                        if (index == currentSlide) Color.White else Color.White.copy(alpha = 0.5f)
                                    )
                                    .clickable { currentSlide = index }
                            )
                        }
                    }
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
                            iconRes = com.example.R.drawable.p1,
                            isHorizontal = false
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        FeatureCard(
                            title = "Kualitas Premium",
                            description = "Material pilihan & jahitan rapi.",
                            iconRes = com.example.R.drawable.p2,
                            isHorizontal = false
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        FeatureCard(
                            title = "Tepat Waktu",
                            description = "Manajemen produksi efisien & akurat.",
                            iconRes = com.example.R.drawable.p3,
                            isHorizontal = false
                        )
                    }
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    FeatureCard(
                        title = "Berpengalaman",
                        description = "Bertahun-tahun menangani klien korporasi dengan standar tinggi.",
                        iconRes = com.example.R.drawable.p1,
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
                                iconRes = com.example.R.drawable.p2,
                                isHorizontal = false
                            )
                        }
                        Box(modifier = Modifier.weight(1f)) {
                            FeatureCard(
                                title = "Tepat Waktu",
                                description = "Manajemen produksi efisien & akurat.",
                                iconRes = com.example.R.drawable.p3,
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
fun FeatureCard(title: String, description: String, iconRes: Int, isHorizontal: Boolean) {
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
                    model = iconRes,
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
                    model = iconRes,
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

data class ProductInfo(val category: String, val title: String, val imageRes: Int, val isNew: Boolean = false)

val sampleProducts = listOf(
    ProductInfo("RETAIL", "Seragam Alfamart", R.drawable.alfa2, isNew = true),
    ProductInfo("ENERGY", "Kemeja Pertamina", R.drawable.pertamina3),
    ProductInfo("HOSPITALITY", "Seragam The Langham", R.drawable.langham1, isNew = true),
    ProductInfo("RETAIL", "Kemeja Dan+Dan", R.drawable.dandan),
    ProductInfo("ENERGY", "Seragam SPBU Shell", R.drawable.shell),
    ProductInfo("CONSTRUCTION", "Pakaian Dinas Waskita", R.drawable.waskita, isNew = true),
    ProductInfo("RETAIL", "Polo Transmart", R.drawable.transmart2)
)

data class ClientInfo(val name: String, val logoRes: Int, val description: String)

val clientList = listOf(
    ClientInfo("PT Pertamina", R.drawable.pertamina3, "Energi & SPBU"),
    ClientInfo("Shell Indonesia", R.drawable.shell, "Energi & Retail"),
    ClientInfo("Alfamart", R.drawable.alfa2, "Retail Minimarket"),
    ClientInfo("Transmart", R.drawable.transmart, "Retail Supermarket"),
    ClientInfo("Waskita Karya", R.drawable.waskita, "Konstruksi & PDL"),
    ClientInfo("The Langham", R.drawable.langham1, "Hospitality Bintang 5"),
    ClientInfo("Dan+Dan", R.drawable.dandan, "Health & Beauty Retail"),
    ClientInfo("MK Kontraktor", R.drawable.mk1, "Manajemen Konstruksi")
)

@Composable
fun ClientsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Klien & Mitra Kami",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 12.dp)
                    .height(4.dp)
                    .width(48.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(SecondaryRed)
            )
            Text(
                text = "Dipercaya oleh berbagai korporasi terkemuka di tanah air",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(clientList) { client ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, BorderSubtle),
                    modifier = Modifier.width(140.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = client.logoRes,
                            contentDescription = client.name,
                            modifier = Modifier
                                .size(72.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = client.name,
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Text(
                            text = client.description,
                            style = MaterialTheme.typography.bodySmall.copy(fontSize = androidx.compose.ui.unit.TextUnit.Unspecified),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

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
                    model = product.imageRes,
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

