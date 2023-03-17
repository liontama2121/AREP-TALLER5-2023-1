package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.*;

public class SparkWebServer {
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        get("/h", (req, res) -> "ESTO FUNCIONA");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "key/ecikeystore.p12";
    }
    static String getPwdKeyStore() {
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return"eci123456";
    }
}