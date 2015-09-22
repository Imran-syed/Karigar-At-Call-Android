package in.karigaronccall.karigaroncall.models;

/**
 * Created by IMRAN on 21-09-2015.
 */
public class WorkType {

    private int iconID;
    private String workType;
    private String desc;

    public WorkType(int iconID, String workType, String desc) {
        this.iconID = iconID;
        this.workType = workType;
        this.desc = desc;
    }

    public int getIconID() {
        return iconID;
    }

    public String getWorkType() {
        return workType;
    }

    public String getDesc() {
        return desc;
    }
}
