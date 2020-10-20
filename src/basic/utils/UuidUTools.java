package basic.utils;

import java.security.SecureRandom;

public class UuidUTools {
    private static final char[] digitsLower = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
    };
    private static final char[] digitsUpper = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F'
    };

    public static String getRandomUuidWithoutDashesLower() {
        SecureRandom ng = UuidUTools.Holder.numberGenerator;
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;  /* clear version        */
        randomBytes[6] |= 0x40;  /* set to version 4     */
        randomBytes[8] &= 0x3f;  /* clear variant        */
        randomBytes[8] |= 0x80;  /* set to IETF variant  */

        byte[] buf = new byte[32];
        for (int i = 0, j = 0; i < 16; ) {
            buf[j++] = (byte) digitsLower[(randomBytes[i] >>> 4) & 15];
            buf[j++] = (byte) digitsLower[randomBytes[i++] & 15];
        }
        return new String(buf, 0);
    }

    public static String getRandomUuidWithoutDashesUpper() {
        SecureRandom ng = UuidUTools.Holder.numberGenerator;
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;  /* clear version        */
        randomBytes[6] |= 0x40;  /* set to version 4     */
        randomBytes[8] &= 0x3f;  /* clear variant        */
        randomBytes[8] |= 0x80;  /* set to IETF variant  */

        byte[] buf = new byte[32];
        for (int i = 0, j = 0; i < 16; ) {
            buf[j++] = (byte) digitsUpper[(randomBytes[i] >>> 4) & 15];
            buf[j++] = (byte) digitsUpper[randomBytes[i++] & 15];
        }
        return new String(buf, 0);
    }

    private static class Holder {
        static final SecureRandom numberGenerator = new SecureRandom();
    }
}


