package jerry.chadwick.jersey.first;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jchadwic on 10/24/14.
 */
@XmlRootElement
public class MyCoachObject {
    public int      id;
    public String   given;
    public String   surname;
    public int      wins;

    public MyCoachObject() {
        id = 0;
        given = null;
        surname = null;
        wins = 0;
    }

    public MyCoachObject(int iIndex, String firstName, String lastName, int numWins) {
        id = iIndex;
        given = firstName;
        surname = lastName;
        wins = numWins;
    }
}
