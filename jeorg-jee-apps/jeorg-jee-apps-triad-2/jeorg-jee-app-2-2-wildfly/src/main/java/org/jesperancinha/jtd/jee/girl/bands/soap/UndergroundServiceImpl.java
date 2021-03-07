package org.jesperancinha.jtd.jee.girl.bands.soap;

import javax.jws.WebService;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@WebService(name = "underground",
        endpointInterface = "org.jesperancinha.jtd.jee.girl.bands.soap.UndergroundService")
public class UndergroundServiceImpl implements UndergroundService {

    private static final String PIECE_1 =
            "Waters runnin' in the wrong direction\n" + "Got a feelin' it's a mixed up sign\n"
                    + "I can see it in my own reflection\n" + "Summit funnies goin' on inside my mind\n"
                    + "Don't know what it's pushin' me higher\n" + "It's the static from the floor below\n"
                    + "Then its drops and catches like a fire\n" + "It's a sound I, it's a sound I know";

    private static final String PIECE_2 =
            "It's the sound of the underground\n" + "The beat of the drum goes round and round\n" + "In to the overflow\n"
                    + "Where the girls get down to the sound of the radio\n" + "Out to the electric night\n"
                    + "Where the bass line jumps in the backstreet lights\n" + "The beat goes around and round\n"
                    + "It's the sound of the under\n" + "Sound of the underground\n";

    private static final String[] TWO_PIECES = {PIECE_1, PIECE_2};

    private static final String[] bandMembers = {"Cheryl Cole", "Cheryl Cole", "Sarah Harding", "Nicola Roberts",
            "Kimberley Walsh"};

    // Caused by: com.sun.xml.ws.spi.db.DatabindingException: com.sun.xml.bind.v2.runtime.IllegalAnnotationsException:
    // 1 counts of IllegalAnnotationExceptions
    // java.util.List is an interface, and JAXB can't handle interfaces.
    // this problem is related to the following location:
    // at java.util.List
    // public List<String> bandMembers() {
    public String[] bandMembers() {
        BLUE.printGenericTitleLn("JAXB doesn't handle interfaces");
        YELLOW.printGenericLn("    // Caused by: com.sun.xml.ws.spi.db.DatabindingException: com.sun.xml.bind.v2.runtime.IllegalAnnotationsException:\n"
                + "    // 1 counts of IllegalAnnotationExceptions\n"
                + "    // java.util.List is an interface, and JAXB can't handle interfaces.\n"
                + "    // this problem is related to the following location:\n" + "    // at java.util.List\n"
                + "    // public List<String> bandMembers() {");
        return bandMembers;
    }

    public String getSoundOfTheUnderground(int piece) {
        ORANGE.printGenericLn("Make sure the the method and param annotations remain in the interface");
        return FROM + "\n" + TWO_PIECES[piece];
    }
}
