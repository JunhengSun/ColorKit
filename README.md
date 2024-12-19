# ColorKit: Add Vibrance to Your Program with Colors

Tired of using monotonous RGB colors in your program? **ColorKit** introduces 2 features: **Color Gradients** and **Color Blending**

---

## ✏️ Getting Started

### Create a ColorKit Instance

* Using Decimal RGB Values. The format is `ColorKit(0, 0, 0)`
* Using Hexadecimal (int) RGB Values. The format is `ColorKit(0x??RRGGBB)`. (As long as the last 6 digits represent rgb values)
* Using Hexadecimal (String) RGB Values. The format is `ColorKit("RRGGBB")`

### Basic Operations

* Get Individual RGB Components 
  * 🔴  getR() - Get the red component.
  * 🟢  getG() - Get the green component. 
  * 🔵  getB() - Get the blue component.
* Print ColorKit Directly 
  * The output format will be: `(R, G, B)`
* Extra Utilities: This module provides two additional methods to convert RGB representations:
  * Hexadecimal String to Decimal RGB 
  * Hexadecimal int to Decimal RGB 
  * These formats match their respective constructors.

## 🎨 Color Gradients

When your program needs a smooth and elegant transition between two colors, ColorKit helps you do that.

* ColorGradient is a static method and has 3 ways to pass parameters:
  1. 1st (the basic one)
     * Parameters:
        * A starting ColorKit instance
        * An ending ColorKit instance
        * The number of steps from the starting color to the ending color
     * It returns an array of ColorKit, with the length equal to `step + 2`
  2. 2nd (extension)
     * Parameters:
       * A list of Colorkit instances
       * An integer (as the average step size, meaning the step between each pair of colors is the same)
     * It returns an array of ColorKit, with the length equal to `colors.length + (colors.length - 1) * step`
  3. 3rd (extension)
     * Parameters
       * A list of ColorKit instances
       * An integer array (which means you can customize the step size between each pair of colors, so the length of the integer array is the length of the ColorKit list -1)
     * It returns an array of ColorKit, with the length equal to `sum(steps) + colors.length`

### Example✍️: Gradual Transition from White to Blue

* In this example, I will only use the basic method as an example.
* Example Code: `ColorKit.colorGradient(new ColorKit(255,255,255), new ColorKit(0,0,255), 3)`
* Result Visualization:
* | ![](resources/ColorGradient1.png)    | ![](resources/ColorGradient2.png) | ![](resources/ColorGradient3.png) | ![](resources/ColorGradient4.png) | ![](resources/ColorGradient5.png) |
    | --- |-----------------------------------|-----------------------------------|-----------------------------------|-----------------------------------|
* **❗Note**: For demonstration purposes, the number of steps is set to 3. If you increase the number of steps to 50 or more, the transition becomes much smoother, resulting in an enhanced visual experience.

## 🎨 Color Blending

When using certain rendering tools, such as PApplet, newly generated images may overwrite previously rendered images. colorBlending provides a way to blend colors, allowing you to render overlapping parts with a combined color, making the transitions seamless and less abrupt.

**❕Note**: This module does not handle transparency.

* colorBlending is a static method that takes:
  * Color1: The first color to blend.
  * Color2: The second color to blend.
  * Weight1: The weight of the first color.
  * Weight2: The weight of the second color.
* The method blends two colors by calculating the weighted ratio of each, using the weights provided (weights are of type double).
* It returns a new blended ColorKit instance based on the specified colors and weights.

### Example✍️: 

* | Black and White Blended at 1:1 Ratio                                         | Black and White Blended at 4:1 Ratio                                         |
    |------------------------------------------------------------------------------|------------------------------------------------------------------------------|
  | `ColorKit.colorBlending(new ColorKit(0,0,0),new ColorKit(255,255,255),5,5);` | `ColorKit.colorBlending(new ColorKit(0,0,0),new ColorKit(255,255,255),4,1);` |
  | ![](resources/ColorBlending1.png)                                            | ![](resources/ColorBlending2.png)                                            |