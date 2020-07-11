import java.io.File;

public class Utils {

       // method to take in two points and return a vector
    public static int[] pointsToVector(int x, int y){
        return new int[]{x, y};
    }

    // method to take in two points and return a vector
    public static void getAllFilesInDirectory(String path) {
        //String path = Paths.get(".").normalize().toAbsolutePath().toString() + "\\imgs";
        File folder = new File(path);
        // grab array of file bytestreams
        // TODO: read about file class
        File[] files = folder.listFiles();
        for(int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
    }
    
}
