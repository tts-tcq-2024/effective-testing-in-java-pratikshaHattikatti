public class Alerter {
    static int alertFailureCount = 0;
    private static NetworkAlert networkAlert = new NetworkAlertStub(); // Default to stub

    public static void setNetworkAlert(NetworkAlert alert) {
        networkAlert = alert;
    }

    static void alertInCelcius(float farenheit) {
        float celcius = (farenheit - 32) * 5 / 9;
        int returnCode = networkAlert.sendAlert(celcius);
        if (returnCode != 200) {
            alertFailureCount += 1;
        }
    }

    public static void main(String[] args) {
        alertInCelcius(0);
        alertInCelcius(303.6f);
        assert(alertFailureCount == 0); // Adjust for stub behavior or real implementation
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        System.out.println("All is well (maybe!)\n");
    }
}
