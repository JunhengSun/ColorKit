public class ColorKit {
    // rgb attributes
    private final int r;
    private final int g;
    private final int b;

    /**
     * Initializes a ColorKit instance using decimal RGB values.
     */
    public ColorKit(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Initializes a ColorKit instance using a hexadecimal RGB value.
     * The hexadecimal value should be in the format `0x??RRGGBB`. As long as the last 6 digits are rgb.
     */
    public ColorKit(int hexRGB) {
        int[] rgb = hexToDecimal(hexRGB);
        this.r = rgb[0];
        this.g = rgb[1];
        this.b = rgb[2];
    }

    /**
     * Initializes a ColorKit instance using a string representation of the RGB color.
     * The string should be in the format "RRGGBB".
     */
    public ColorKit(String strRGB) {
        int[] rgb = strToDecimal(strRGB);
        this.r = rgb[0];
        this.g = rgb[1];
        this.b = rgb[2];
    }

    /**
     * Converts a hexadecimal RGB string into an array of decimal RGB values.
     */
    public static int[] strToDecimal(String str) {
        int[] rgb = new int[3];
        rgb[0] = Integer.parseInt(str.substring(0,2),16);
        rgb[1] = Integer.parseInt(str.substring(2,4),16);
        rgb[2] = Integer.parseInt(str.substring(4,6),16);
        return rgb;
    }

    /**
     * Converts a hexadecimal integer RGB value into an array of decimal RGB values.
     */
    public static int[] hexToDecimal(int hex) {
        int[] rgb = new int[3];
        rgb[0] = (hex >> 16) & 0xFF;
        rgb[1] = (hex >> 8) & 0xFF;
        rgb[2] = hex & 0xFF;
        return rgb;
    }

    /**
     * Gets the red component of the color.
     */
    public int getR() {
        return this.r;
    }

    /**
     * Gets the green component of the color.
     */
    public int getG() {
        return this.g;
    }

    /**
     * Gets the blue component of the color.
     */
    public int getB() {
        return this.b;
    }

    private static int getColorComponent(int start, int end, int step, int index) {
        return (int)Math.round(start + (end - start) * index / (step-1.0));
    }


    /**
     * Returns a string representation of the ColorKit instance.
     * The format is "(R,G,B)"
     */
    @Override
    public String toString() {
        return "(" + r + "," + g + "," + b + ")";
    }

    /**
     * Blends two colors based on their respective weights.
     * This method provides a strong blending operation, where the resulting color is a weighted average of the two input colors.
     * Note: Transparency is not handled in this module.
     */
    public static ColorKit colorBlending(ColorKit color1, ColorKit color2, double C1, double C2) {
        double ratio = C1 / (C1 + C2);
        int r = (int)Math.round(color1.getR() * ratio + color2.getR() * (1-ratio));
        int g = (int)Math.round(color1.getG() * ratio + color2.getG() * (1-ratio));
        int b = (int)Math.round(color1.getB() * ratio + color2.getB() * (1-ratio));
        return new ColorKit(r, g, b);
    }

    /**
     * Generates a gradient between two colors over a specified number of steps.
     * The gradient is a smooth transition of colors from the starting color to the ending color.
     */
    public static ColorKit[] colorGradient(ColorKit startColor, ColorKit endColor, int step) {
        ColorKit[] colors = new ColorKit[step];
        // fill the first and last element
        colors[0] = startColor;
        colors[step-1] = endColor;
        // get rgb info from starting and ending colors
        int startR = startColor.getR();
        int startG = startColor.getG();
        int startB = startColor.getB();
        int endR = endColor.getR();
        int endG = endColor.getG();
        int endB = endColor.getB();
        int r;
        int g;
        int b;
        // get gradient color
        for (int i = 1; i < step-1; i++) {
            r = getColorComponent(startR, endR, step, i);
            g = getColorComponent(startG, endG, step, i);
            b = getColorComponent(startB, endB, step, i);
            colors[i] = (new ColorKit(r, g, b));
        }
        return colors;
    }
}
