package in.karigaronccall.karigaroncall.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IMRAN on 19-09-2015.
 */
public class InReachAreaProvider {
    List<String> areaInReach;
    static InReachAreaProvider singleTonInstance;

    public InReachAreaProvider() {
    }

    static {
        init();
    }

    public static List<String> getAreaInReach() {
        return singleTonInstance.areaInReach;
    }

    private static void init() {
        if (singleTonInstance == null) {
            synchronized (InReachAreaProvider.class) {
                if (singleTonInstance == null) {
                    singleTonInstance = new InReachAreaProvider();
                    singleTonInstance.areaInReach = new ArrayList<>();
                    singleTonInstance.areaInReach.add("baner");
                    singleTonInstance.areaInReach.add("vimannagar");
                }
            }
        }
    }

    public static boolean isInReach(String area) {
        return singleTonInstance.areaInReach.contains(area.toLowerCase());
    }

}
