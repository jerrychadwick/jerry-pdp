package jerry.chadwick.jersey.first;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jchadwic on 3/24/14.
 */
public class MyResourceObject {
    public int      itemID;
    public String   itemName;
    public String   schoolName;
    public int      numWins;
    public List<Object> winYears;
    public String   itemFullString;

    public MyResourceObject(int iIndex, String initString) {
        int     lItemID;
        String  lItemName;
        String  lSchoolName;
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
        iIntVal = Integer.parseInt(tokens[2]);
        lNumWins = iIntVal.intValue();
        sStringVal = tokens[3];

        delims = "[,]";
        tokens = sStringVal.split(delims);
        for (int i=0; i<lNumWins; i++) {
            lWinYears.add(tokens[i]);
        }
        itemID = lItemID;
        itemName = lItemName;
        schoolName = lSchoolName;
        numWins = lNumWins;
        winYears = lWinYears;

    }
}
