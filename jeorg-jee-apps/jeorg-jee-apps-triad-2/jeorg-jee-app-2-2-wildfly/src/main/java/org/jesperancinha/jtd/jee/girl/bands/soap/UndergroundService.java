package org.jesperancinha.jtd.jee.girl.bands.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UndergroundService {

    String FROM = "https://www.azlyrics.com/lyrics/girlsaloud/soundoftheunderground.html";

    @WebResult(name = "members")
    String[] bandMembers();

    @WebResult(name = "lyric")
    @WebMethod(operationName = "underground")
    String getSoundOfTheUnderground(
            @WebParam(mode = WebParam.Mode.IN,
                    name = "pieceNumber")
                    int piece);
}
