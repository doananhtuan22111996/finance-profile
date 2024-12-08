package vn.finance.profile.presentation.components.card

import androidx.compose.ui.graphics.Color

/**
 * https://medium.com/deuk/intermediate-android-compose-bank-card-ui-371d14ea7843
 * Understanding Saturation
 * Saturation refers to the intensity or purity of a color. In a highly saturated color, the hue appears vivid and rich. In contrast, a desaturated color looks more washed out or gray.
 * In UI design, playing with saturation can create visual interest and hierarchy, helping certain elements stand out or blend into the background.
 * The HSL Color Model
 * HSL stands for Hue, Saturation, and Lightness. It’s a cylindrical color model that represents colors in a way that’s often more intuitive for humans to understand and manipulate than RGB (Red, Green, Blue).
 * In HSL, Hue determines the type of color, Saturation defines the intensity of that color, and Lightness controls the brightness.
 * Converting to HSL — toHsl()
 * The toHsl() function calculates a color's hue, saturation, and lightness.
 * It starts by finding the maximum and minimum values among the color's red, green, and blue components, which helps determine the hue and saturation.
 * The hue is calculated based on which RGB component (red, green, or blue) is dominant.
 * Saturation is then derived based on the lightness and the difference (delta) between the max and min components.
 * Converting to Color — hslToColor()
 * This method is used to convert HSL (Hue, Saturation, Lightness) values back to a Color object, typically represented in the RGB (Red, Green, Blue) color model.
 * Manipulating Saturation — setSaturation()
 * The purpose of setSaturation() is to change the saturation level of a color while keeping its hue and lightness constant.
 * This method first converts the color from the RGB space to HSL using toHsl(), adjusts the saturation value, and then converts it back to an RGB color using hslToColor().
 */

fun Color.toHsl(): FloatArray {
    val redComponent = red
    val greenComponent = green
    val blueComponent = blue

    val maxComponent = maxOf(redComponent, greenComponent, blueComponent)
    val minComponent = minOf(redComponent, greenComponent, blueComponent)
    val delta = maxComponent - minComponent
    val lightness = (maxComponent + minComponent) / 2

    val hue: Float
    val saturation: Float

    if (maxComponent == minComponent) {
        // Grayscale color, no saturation and hue is undefined
        hue = 0f
        saturation = 0f
    } else {
        // Calculating saturation
        saturation =
            if (lightness > 0.5) delta / (2 - maxComponent - minComponent) else delta / (maxComponent + minComponent)
        // Calculating hue
        hue = when (maxComponent) {
            redComponent -> 60 * ((greenComponent - blueComponent) / delta % 6)
            greenComponent -> 60 * ((blueComponent - redComponent) / delta + 2)
            else -> 60 * ((redComponent - greenComponent) / delta + 4)
        }
    }

    // Returning HSL values, ensuring hue is within 0-360 range
    return floatArrayOf(hue.coerceIn(0f, 360f), saturation, lightness)
}

fun hslToColor(hue: Float, saturation: Float, lightness: Float): Color {
    val chroma = (1 - kotlin.math.abs(2 * lightness - 1)) * saturation
    val secondaryColorComponent = chroma * (1 - kotlin.math.abs((hue / 60) % 2 - 1))
    val matchValue = lightness - chroma / 2

    var red = matchValue
    var green = matchValue
    var blue = matchValue

    when ((hue.toInt() / 60) % 6) {
        0 -> {
            red += chroma; green += secondaryColorComponent
        }

        1 -> {
            red += secondaryColorComponent; green += chroma
        }

        2 -> {
            green += chroma; blue += secondaryColorComponent
        }

        3 -> {
            green += secondaryColorComponent; blue += chroma
        }

        4 -> {
            red += secondaryColorComponent; blue += chroma
        }

        5 -> {
            red += chroma; blue += secondaryColorComponent
        }
    }

    // Creating a color from RGB components
    return Color(red = red, green = green, blue = blue)
}

fun Color.setSaturation(newSaturation: Float): Color {
    val hslValues = this.toHsl()
    // Adjusting the saturation while keeping hue and lightness the same
    return hslToColor(hslValues[0], newSaturation.coerceIn(0f, 1f), hslValues[2])
}