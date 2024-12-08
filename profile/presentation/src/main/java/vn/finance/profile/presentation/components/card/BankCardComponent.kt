package vn.finance.profile.presentation.components.card

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.finance.profile.presentation.EMPTY_STRING
import vn.finance.profile.presentation.R

// Our star of the show: BankCardUi
@Composable
fun BankCardComponent(
    modifier: Modifier = Modifier,
    baseColor: Color = MaterialTheme.colorScheme.primary,
    cardNumber: String = EMPTY_STRING,
    cardHolder: String = EMPTY_STRING,
    expires: String = EMPTY_STRING,
    cvv: String = EMPTY_STRING,
    brand: String = EMPTY_STRING
) {
    // Bank Card Aspect Ratio
    val bankCardAspectRatio = 1.586f // (e.g., width:height = 85.60mm:53.98mm)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(bankCardAspectRatio),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ) {
        Box {
            BankCardBackground(baseColor = baseColor)
            BankCardNumber(cardNumber = cardNumber)
            // Positioned to corner top left
            SpaceWrapper(
                modifier = Modifier.align(Alignment.TopStart),
                space = 32.dp,
                top = true,
                left = true
            ) {
                BankCardLabelAndText(
                    label = stringResource(R.string.card_holder),
                    text = cardHolder
                )
            }
            // Positioned to corner bottom left
            SpaceWrapper(
                modifier = Modifier.align(Alignment.BottomStart),
                space = 32.dp,
                bottom = true,
                left = true
            ) {
                Row {
                    BankCardLabelAndText(label = stringResource(R.string.expires), text = expires)
                    Spacer(modifier = Modifier.width(16.dp))
                    BankCardLabelAndText(label = stringResource(R.string.cvv), text = cvv)
                }
            }
            // Positioned to corner bottom right
            SpaceWrapper(
                modifier = Modifier.align(Alignment.BottomEnd),
                space = 32.dp,
                bottom = true,
                right = true
            ) {
                // Feel free to use an image instead
                Text(
                    text = brand, style = MaterialTheme.typography.displayMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                        letterSpacing = 1.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.W500,
                    )
                )
            }
        }
    }
}

// A splash of color for the background
@Composable
private fun BankCardBackground(baseColor: Color) {
    val colorSaturation75 = baseColor.setSaturation(0.75f)
    val colorSaturation50 = baseColor.setSaturation(0.5f)
    // Drawing Shapes with Canvas
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(baseColor)
    ) {
        // Drawing Circles
        drawCircle(
            color = colorSaturation75,
            center = Offset(x = size.width * 0.2f, y = size.height * 0.6f),
            radius = size.minDimension * 0.85f
        )
        drawCircle(
            color = colorSaturation50,
            center = Offset(x = size.width * 0.1f, y = size.height * 0.3f),
            radius = size.minDimension * 0.75f
        )
    }
}

@Composable
private fun BankCardNumber(cardNumber: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween, // Space out the children evenly
        verticalAlignment = Alignment.CenterVertically // Center the children vertically
    ) {
        // Draw the first three groups of dots
        repeat(3) {
            BankCardDotGroup()
        }
        // Display the last four digits
        Text(
            text = cardNumber.takeLast(4), style =
            MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onSurface,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Bold,
            )
        )
    }
}

@Composable
private fun BankCardDotGroup() {
    val color = MaterialTheme.colorScheme.onSurface
    Canvas(modifier = Modifier.width(48.dp), onDraw = { // You can adjust the width as needed
        val dotRadius = 4.dp.toPx()
        val spaceBetweenDots = 8.dp.toPx()
        for (i in 0 until 4) { // Draw four dots
            drawCircle(
                color = color, radius = dotRadius, center = Offset(
                    x = i * (dotRadius * 2 + spaceBetweenDots) + dotRadius, y = center.y
                )
            )
        }
    })
}

@Composable
private fun BankCardLabelAndText(label: String, text: String) {
    Column(
        modifier = Modifier.wrapContentSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label.uppercase(), style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurface, letterSpacing = 1.sp
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text, style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurface,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.W400
            )
        )
    }
}

@Composable
private fun SpaceWrapper(
    modifier: Modifier = Modifier,
    space: Dp,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false,
    left: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .then(if (top) Modifier.padding(top = space) else Modifier)
            .then(if (right) Modifier.padding(end = space) else Modifier)
            .then(if (bottom) Modifier.padding(bottom = space) else Modifier)
            .then(if (left) Modifier.padding(start = space) else Modifier)
    ) {
        content()
    }
}
