import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AirportRunwayLengths {

    public AirportRunwayLengths() {
    }

    /*
     * this method returns a list of airports that have runways that are less than
     * or equal to maxLength
     */
    public ArrayList<String> getLowBoundRunwayAirports(int maxLength) {
        ArrayList<String> output = new ArrayList<String>();
        try {
            File file = new File("airport_runway_lengths.csv");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            line = scanner.nextLine();

            while (scanner.hasNextLine()) {
                int runwayLength = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.lastIndexOf("(") - 1));
                if (runwayLength <= maxLength)
                    output.add(line.substring(line.indexOf(" ") + 1, line.indexOf(",")));
                line = scanner.nextLine();
            }
            scanner.close();
            return output;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
