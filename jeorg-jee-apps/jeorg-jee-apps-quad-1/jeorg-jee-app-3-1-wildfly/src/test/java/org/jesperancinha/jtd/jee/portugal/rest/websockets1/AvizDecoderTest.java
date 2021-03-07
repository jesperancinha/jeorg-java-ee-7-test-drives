package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import org.junit.jupiter.api.Test;

import javax.websocket.DecodeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;

class AvizDecoderTest {

    @Test
    void testDecode_whenEncodedMessage_thenDecodeOk() throws DecodeException {
        final var avizDecoder = new AvizDecoder();
        final var decode = avizDecoder.decode(
                "wbnb v jnf xvat bs cbeghtny ur vf erpbtavmrq puvrsyl sbe uvf ebyr va cbeghtnyf ivpgbel va n fhpprffvba jne jvgu pnfgvyr cerfreivat uvf pbhagelf vaqrcraqrapr naq rfgnoyvfuvat gur nivm  be wbnavan qlanfgl ba gur cbeghthrfr guebar");
        printRainbowTitleLn(decode);

        assertThat(decode).isEqualTo(
                "joao i was king of portugal he is recognized chiefly for his role in portugals victory in a succession war with castile preserving his countrys independence and establishing the aviz  or joanina dynasty on the portuguese throne");
    }
}