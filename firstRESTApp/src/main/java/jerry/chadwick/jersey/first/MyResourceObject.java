package jerry.chadwick.jersey.first;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jchadwic on 3/24/14.
 */
@XmlRootElement
public class MyResourceObject {
    public int      itemID;
    public String   itemName;
    public String   schoolName;
    public String   coach;  // will be hypermedia link to object
    public int      numWins;
    public List<Object> winYears;
    public String   itemFullString;

    public MyResourceObject() {
        itemID = 0;
        itemName = "NO NAME";
        schoolName = "NO SCHOOL";
        numWins = 0;
        winYears = null;
        itemFullString = "NO FULL LIST";
    }

    public MyResourceObject(int iIndex, String initString) {
        int     lItemID;
        String  lItemName;
        String  lSchoolName;
        String  strCoach; // link
        int     lNumWins;
        List<Object> lWinYears = new ArrayList<Object>();

        Integer iIntVal = new Integer(0);
        String sStringVal = new String();

        String lInitString = initString;
        itemFullString = initString;

        String delims = "[|]";
        String[] tokens = lInitString.split(delims);
        lItemID = iIndex;
        lItemName = new String(tokens[0]);
        lSchoolName = new String(tokens[1]);
        strCoach = new String(tokens[2]);
        iIntVal = Integer.parseInt(tokens[3]);
        lNumWins = iIntVal.intValue();
        sStringVal = tokens[4];

        delims = "[,]";
        tokens = sStringVal.split(delims);
        for (int i=0; i<lNumWins; i++) {
            lWinYears.add(tokens[i]);
        }
        itemID = lItemID;
        itemName = lItemName;
        schoolName = lSchoolName;
        coach = strCoach;
        numWins = lNumWins;
        winYears = lWinYears;

    }
}
