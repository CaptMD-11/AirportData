import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AirportRunwayLengths {

    private int minLength;

    public AirportRunwayLengths(int inputMinLength) {
        minLength = inputMinLength;
    }

    public ArrayList<String> getValidAirports() {
        ArrayList<String> output = new ArrayList<String>();
        try {
            File file = new File("airport_runway_lengths.csv");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            line = scanner.nextLine();

            while (scanner.hasNextLine()) {
                int runwayLength = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.lastIndexOf("(") - 1));
                if (minLength <= runwayLength)
                    output.add(line.substring(line.indexOf(" ") + 1, line.indexOf(",")));
                line = scanner.nextLine();
            }

            return output;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        AirportRunwayLengths obj = new AirportRunwayLengths(6800);
        System.out.println(obj.getValidAirports());
    }
}
