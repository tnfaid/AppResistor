package titik.com.pantaupadi.FungsiDeteksi;

import org.opencv.core.Scalar;

/**
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * jadi ini isinya tentang warna yang digunakan, terdapat minimun dan maksimum nilai HSV.
 * warna diasosiaikan dengan menggunakan warna mereka berdasarkan pengecekan apakah warna tersebut diantara
 * nilai warna minimal dan maksimal HSV scalar.
 *
 *
 * HSV:
 * Scalar(H, S, V);
 * Scalar(0-180, 0-255, 0-255);
 * <p>
 */
public class ColorDefinitionsHsv {

    /**
     * Red wraps around and is therefore defined twice
     */
    public static final Scalar RED1_MIN = new Scalar(0, 65, 100);
    public static final Scalar RED1_MAX = new Scalar(6, 250, 150);

    public static final Scalar ORANGE_MIN = new Scalar(7, 150, 150);
    public static final Scalar ORANGE_MAX = new Scalar(18, 250, 250);

    public static final Scalar YELLOW_MIN = new Scalar(25, 130, 100);
    public static final Scalar YELLOW_MAX = new Scalar(34, 250, 160);
//
//    public static final Scalar GREEN_MIN = new Scalar(35, 60, 60);
//    public static final Scalar GREEN_MAX = new Scalar(75, 250, 150);

    public static final Scalar BLUE_MIN = new Scalar(82, 60, 49);
    public static final Scalar BLUE_MAX = new Scalar(128, 255, 255);

    public static final Scalar VIOLET_MIN = new Scalar(129, 60, 50);
    public static final Scalar VIOLET_MAX = new Scalar(165, 250, 150);

    public static final Scalar  GREEN_MIN0= new Scalar(40,50,50);
    public static final Scalar  GREEN_MAX0= new Scalar(44,255,255);

    public static final Scalar  GREEN_MIN1= new Scalar(48,60,53);
    public static final Scalar  GREEN_MAX1= new Scalar(49,255,255);

//    public static final Scalar GREEN_MIN2 = new Scalar(45,60,53);
//    public static final Scalar GREEN_MAX2 = new Scalar(47,255,255);
//
//    public static final Scalar GREEN_MIN3 = new Scalar(50.5 ,56,35);
//    public static final Scalar GREEN_MAX3 = new Scalar(58, 255,255);

    public static final Scalar GREEN_MIN2 = new Scalar(56, 243, 85);
    public static final Scalar GREEN_MAX2 = new Scalar(57, 248, 90);

    public static final Scalar GREEN_MIN3 = new Scalar(58, 183, 92);
    public static final Scalar GREEN_MAX3 = new Scalar(59, 184, 93);

    public static final Scalar GREEN_MIN4 = new Scalar(61, 162, 83);
    public static final Scalar GREEN_MAX4 = new Scalar(65, 163, 87);

    public static final Scalar GREEN_MIN5 = new Scalar(66, 143, 85);
    public static final Scalar GREEN_MAX5 = new Scalar(74, 145, 87);

    public static final Scalar COBA_MIN = new Scalar(88, 70, 65);
    public static final Scalar COBA_MAX = new Scalar(81, 39, 88);

    /**
     * Red wraps around and is therefore defined twice
     */

//    jadi ini tuh warna HSV
    public static final Scalar RED2_MIN = new Scalar(166, 65, 50);
    public static final Scalar RED2_MAX = new Scalar(180, 250, 150);

    public static final Scalar BLACK_MIN = new Scalar(0, 0, 0);
    public static final Scalar BLACK_MAX = new Scalar(180, 250, 40);

    public static final Scalar BROWN_MIN = new Scalar(0, 31, 41);
    public static final Scalar BROWN_MAX = new Scalar(25, 250, 99);

    public static final Scalar GREY_MIN = new Scalar(0, 0, 41);
    public static final Scalar GREY_MAX = new Scalar(180, 30, 130);

    public static final Scalar WHITE_MIN = new Scalar(0, 0, 150);
    public static final Scalar WHITE_MAX = new Scalar(180, 30, 255);

    public static final Scalar GOLD_MIN = new Scalar(0, 0, 0);     //// TODO:
    public static final Scalar GOLD_MAX = new Scalar(0, 0, 0);

    public static final Scalar SILVER_MIN = new Scalar(0, 0, 0);   //// TODO:
    public static final Scalar SILVER_MAX = new Scalar(0, 0, 0);

    /**
     * This color (black) is used for unknown color values
     * when converting from color names to colors
     */
    public static final Scalar UNKNOWN = new Scalar(0, 0, 0);

    /**
     * Calculate the mean value for H, S and V of two Scalars.
     *
     * @param scalar1 The first scalar
     * @param scalar2 The second scalar
     * @return The mean value of scalar1 and scalar2
     */
    private static Scalar meanOfScalars(Scalar scalar1, Scalar scalar2) {
        if (scalar1.val.length != scalar2.val.length)
            System.err.println("scalar1 and scalar2 size mismatch");

        Scalar result = new Scalar(0, 0, 0, 0);

        for (int i = 0; i < scalar1.val.length; i++) {
            result.val[i] = (scalar1.val[i] + scalar2.val[i]) / 2;
        }

        return result;
    }

    /**
     *
     * @param scalar     The scalar to check if it is between the lower and upper bound
     * @param lowerBound The lower bound. Every value of scalar has to be above these values.
     * @param upperBound The upper bound. Every value of scalar has to be below these values.
     * @return true if the scalar is between the bounds, false otherwise
     *
     * cek jika nilai scalar diantara batas terendah dan tertinggi warna
     * sebuah scalar diantara 2 bounds
     * scalar = untuk memeriksa apakah berada di antara batas bawah dan atas
     * lowerBound = Setiap nilai skalar harus di atas nilai-nilai ini.
     * UpperBound = Batas atas. Setiap nilai skalar harus di bawah nilai-nilai ini.
     * jika skalar berada di antara batas maka bernilai true, dan false untuk sebaliknya
     */
    private static boolean isScalarBetweenBounds(Scalar scalar, Scalar lowerBound, Scalar upperBound) {
        if (scalar == null || lowerBound == null || upperBound == null)
            throw new IllegalArgumentException("Scalar harusnya gaboleh null lah");

        if (lowerBound.val.length != upperBound.val.length)
            System.err.println("upper and lower bound size kagak sama");

        if (scalar.val.length != lowerBound.val.length)
            System.err.println("scalar and bounds size sama");

        for (int i = 0; i < scalar.val.length; i++) {
            if (scalar.val[i] < lowerBound.val[i] || scalar.val[i] > upperBound.val[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * konversi warna HSV ke nama warna,
     * nama dari warna ditentukan dari pengecekan warna yang tersedia diantara bounds dari nama warna
     *
     * ColorName.Unknown akan muncul jika tidak ada kecocokan nama warna yang ditemukan
     * method akan menampilkan pesan error jika color definitios overlap
     *
     * @param colorHsv The color in HSV space to convert to a name.
     * @return The name associated with the given color, or ColorName.Unknown.
     *
     *
     */
    public static ColorName getColorName(Scalar colorHsv) {
        if (colorHsv == null)
            throw new IllegalArgumentException("colorHsv must not be null!");

        ColorName name = ColorName.Unknown;

        if (isScalarBetweenBounds(colorHsv, RED1_MIN, RED1_MAX) ||
                isScalarBetweenBounds(colorHsv, RED2_MIN, RED2_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Red + ")!");

            name = ColorName.Red;
        }

//        if (isScalarBetweenBounds(colorHsv, GREEN_MIN0, GREEN_MAX0) ||
//                isScalarBetweenBounds(colorHsv, GREEN_MIN1, GREEN_MAX1) ||
//                     isScalarBetweenBounds(colorHsv, GREEN_MIN2, GREEN_MAX2) ||
//                             isScalarBetweenBounds(colorHsv, GREEN_MIN3, GREEN_MAX3)){
//                    if (name != ColorName.Unknown)
//                        System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green + ")!");
//
//                    name = ColorName. Green;
//        }


        if (isScalarBetweenBounds(colorHsv, ORANGE_MIN, ORANGE_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Orange + ")!");

            name = ColorName.Orange;
        }

        if (isScalarBetweenBounds(colorHsv, YELLOW_MIN, YELLOW_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Yellow + ")!");

            name = ColorName.Yellow;
        }

        if (isScalarBetweenBounds(colorHsv, GREEN_MIN1, GREEN_MAX1)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green1 + ")!");

            name = ColorName.Green1;
        }

        if (isScalarBetweenBounds(colorHsv, GREEN_MIN2, GREEN_MAX2)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green2 + ")!");

            name = ColorName.Green2;
        }

        if (isScalarBetweenBounds(colorHsv, GREEN_MIN3, GREEN_MAX3)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green3 + ")!");

            name = ColorName.Green3;
        }

        if (isScalarBetweenBounds(colorHsv, GREEN_MIN4, GREEN_MAX4)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green4 + ")!");

            name = ColorName.Green4;
        }

        if (isScalarBetweenBounds(colorHsv, GREEN_MIN5, GREEN_MAX5)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green5 + ")!");

            name = ColorName.Green5;
        }


//        if (isScalarBetweenBounds(colorHsv, GREEN_MIN, GREEN_MAX)) {
//            if (name != ColorName.Unknown)
//                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green + ")!");
//
//            name = ColorName.Green;
//        }

        if (isScalarBetweenBounds(colorHsv, BLUE_MIN, BLUE_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Blue + ")!");

            name = ColorName.Blue;
        }

        if (isScalarBetweenBounds(colorHsv, VIOLET_MIN, VIOLET_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Violet + ")!");

            name = ColorName.Violet;
        }

        if (isScalarBetweenBounds(colorHsv, BROWN_MIN, BROWN_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Brown + ")!");

            name = ColorName.Brown;
        }

        if (isScalarBetweenBounds(colorHsv, BLACK_MIN, BLACK_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Black + ")!");

            name = ColorName.Black;
        }

        if (isScalarBetweenBounds(colorHsv, GREY_MIN, GREY_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Grey + ")!");

            name = ColorName.Grey;
        }

        if (isScalarBetweenBounds(colorHsv, WHITE_MIN, WHITE_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.White + ")!");

            name = ColorName.White;
        }

        if (isScalarBetweenBounds(colorHsv, GREEN_MIN0, GREEN_MAX0)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Green0 + ")!");

            name = ColorName.Green0;
        }


        if (isScalarBetweenBounds(colorHsv, COBA_MIN, COBA_MAX)) {
            if (name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Coba + ")!");

            name = ColorName.Coba;
        }

        /*
        if(isScalarBetweenBounds(colorHsv, GOLD_MIN, GOLD_MAX)){
            if(name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Gold + ")!");

            name = ColorName.Gold;
        }

        if(isScalarBetweenBounds(colorHsv, SILVER_MIN, SILVER_MAX)){
            if(name != ColorName.Unknown)
                System.err.println("overlapping colorHsv name definitions (" + name + " and " + ColorName.Silver + ")!");

            name = ColorName.Silver;
        }
        */


        return name;
    }

    /**
     *
     * Kembali ke warna HSV yang merepresentasikan nama waran
     * Warna merepresentasikan sebuah nama yang sudah dihitung dengan nilai rata- rata
     * yang berasal dari lower dan upper bound dari definisi warna itu sendiri
     *
     * Returns the color UNKNOWN (black) for unknown colors.
     *
     * @param name The color name to convert to a HSV color
     * @return The HSV color representing the given name, or the color UNKNOWN.
     */
    public static Scalar getColorFromName(ColorName name) {
        switch (name) {
            case Black:
                return meanOfScalars(BLACK_MAX, BLACK_MIN);
            case Brown:
                return meanOfScalars(BROWN_MAX, BROWN_MIN);
            case Red:
                return meanOfScalars(RED1_MAX, RED1_MIN);
            case Orange:
                return meanOfScalars(ORANGE_MAX, ORANGE_MIN);
            case Yellow:
                return meanOfScalars(YELLOW_MAX, YELLOW_MIN);
//            case Green:
//                return meanOfScalars(GREEN_MAX, GREEN_MIN);
            case Blue:
                return meanOfScalars(BLUE_MAX, BLUE_MIN);
            case Violet:
                return meanOfScalars(VIOLET_MAX, VIOLET_MIN);
            case Grey:
                return meanOfScalars(GREY_MAX, GREY_MIN);
            case White:
                return meanOfScalars(WHITE_MAX, BLACK_MIN);
            case Green0:
                return meanOfScalars(GREEN_MAX0, GREEN_MIN0);
            case Green1:
                return meanOfScalars(GREEN_MAX1, GREEN_MIN1);
            case Green2:
                return meanOfScalars(GREEN_MAX2, GREEN_MIN2);
            case Green3:
                return meanOfScalars(GREEN_MAX3, GREEN_MIN3);

            /*
            case Gold:
                return meanOfScalars(GOLD_MAX, GOLD_MIN);
            case Silver:
                return meanOfScalars(SILVER_MAX, SILVER_MIN);
            */

            case Unknown:
            default:
                return UNKNOWN;
        }
    }
}
