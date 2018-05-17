import lab2.StateFSM;
import lab2.SwitchFSM;
import lab2.TransTableFSM;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestFSM {
    static class FSMProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("913741GJDFJNDF#", true),
                    Arguments.of("9%#", true),
                    Arguments.of("9*#", true),
//                    Arguments.of("21313ANaSDA#", false),
//                    Arguments.of("111A# ", false),
//                    Arguments.of("111A #", false),
//                    Arguments.of(" ", false),
//                    Arguments.of(null, false),
                    Arguments.of("1#", false),
                    Arguments.of("#11#", false),
                    Arguments.of("55A%#", false),
                    Arguments.of("55A1#", false)
//                    Arguments.of("1*#", true)
//                    Arguments.of("{{{{{{", false)
            );
        }
    }

    private static Stream<String> provideInCorrectString() {
        return Stream.of(
//                "111f2A#",
//                "00ADaS#",
                "1%*#"
        );
    }

    private static Stream<String> provideCorrectString() {
        return Stream.of(
                "4825HFFD#",
                "85747%#",
                "00000*#"
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"000SFF#", "1%#"})
//    @MethodSource("provideCorrectString")
    @CsvFileSource(resources = "CorrectStrings.csv")
    void TestFSMScanInCorrectStrings(String str) {
        assertTrue(new SwitchFSM().scanString(str));
        assertTrue(new TransTableFSM().scanString(str));
        assertTrue(new StateFSM().scanString(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "%#", "00000000FFFF"})
    @CsvFileSource(resources = "WrongStrings.csv")
    @MethodSource("provideInCorrectString")
    void TestFSMScanInNotCorrectStrings(String str) {
        assertFalse(new SwitchFSM().scanString(str));
        assertFalse(new TransTableFSM().scanString(str));
        assertFalse(new StateFSM().scanString(str));
    }

    @ParameterizedTest
    @ArgumentsSource(FSMProvider.class)
    void TestFSMScanWithMyArguments(String str, boolean res) {
        assertEquals(new SwitchFSM().scanString(str), res);
        assertEquals(new TransTableFSM().scanString(str), res);
        assertEquals(new StateFSM().scanString(str), res);
    }
}
