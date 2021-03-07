package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import org.junit.jupiter.api.Test;

import javax.websocket.EncodeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

class AvizEncoderTest {

    @Test
    void testEncode_whenString_thenEncodeCorrectly() throws EncodeException {
        final AvizEncoder avizEncoder = new AvizEncoder();
        final String message = "joao i was king of portugal he is recognized chiefly for his role in portugals victory in a succession war with castile preserving his countrys independence and establishing the aviz  or joanina dynasty on the portuguese throne";
        final AvizEncodedMessage avizEncodedMessage = new AvizEncodedMessage();
        avizEncodedMessage.setEncodedMessage(message);
        final String encode = avizEncoder.encode(avizEncodedMessage);

        BLUE.printGenericLn(encode);

        assertThat(encode).isEqualTo(
                "wbnb v jnf xvat bs cbeghtny ur vf erpbtavmrq puvrsyl sbe uvf ebyr va cbeghtnyf ivpgbel va n fhpprffvba jne jvgu pnfgvyr cerfreivat uvf pbhagelf vaqrcraqrapr naq rfgnoyvfuvat gur nivm  be wbnavan qlanfgl ba gur cbeghthrfr guebar");
    }
}