package help_requests.collision_find;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private static final BigInteger[] solutions = {new BigInteger("5"), new BigInteger("41"), new BigInteger("213"), new BigInteger("3729"), new BigInteger("26141"), new BigInteger("155961"), new BigInteger("870053"), new BigInteger("15273505"), new BigInteger("36609133"), new BigInteger("1054220105"), new BigInteger("4505811317"), new BigInteger("7773109937"), new BigInteger("523822645181"), new BigInteger("3733152900697"), new BigInteger("24496081740101"), new BigInteger("230079197716545"), new BigInteger("1171915746385933"), new BigInteger("15546621882336873"), new BigInteger("49946760501120533"), new BigInteger("327042765867107025"), new BigInteger("1218330057780268381"), new BigInteger("24224433307378470777"), new BigInteger("477081534948440215525"), new BigInteger("3637191169141921953377"), new BigInteger("3560858123550171518893"), new BigInteger("106493180840990087090569"), new BigInteger("263083800091123852359349"), new BigInteger("1503327743555779780119281"), new BigInteger("54460542267446542982860541"), new BigInteger("567965126131910432301178009"), new BigInteger("1103945056654686306379534981"), new BigInteger("53699798708459365136918073473"), new BigInteger("280115712290190620845433045837"), new BigInteger("2084264102823205166563811737769"), new BigInteger("24755744344946645542049463890773"), new BigInteger("94193751125056678973777798436625"), new BigInteger("343357303883438062577911580263581"), new BigInteger("12010954235406791158135723873258937"), new BigInteger("73017428123155013979641894852045093"), new BigInteger("712448183411711836070427085617589921"), new BigInteger("2535100029095190938440938125628138221"), new BigInteger("60056434216983269293778743925685064649"), new BigInteger("505420718878757425880648929561200919541"), new BigInteger("2415004238838133036727077116448264021809"), new BigInteger("7016422292649645105842207885979602464317"), new BigInteger("184339084915226446979078630532514510971609"), new BigInteger("2057872850599883011597490194565260663673797"), new BigInteger("19367207988871006272624858570664159412818113"), new BigInteger("101996720471308943077282132113785622508877453"), new BigInteger("163124113364857776721285023367706638140050153")};

    public static String findCollision(String hex) {
        int n = hex.length();
        BigInteger diff = new BigInteger(hex, 16).subtract(new BigInteger(hex, 10));
        if (!diff.and(BigInteger.ONE.shiftLeft(n).subtract(BigInteger.ONE)).equals(BigInteger.ZERO)) return null;
        return solutions[n - 1].multiply(diff.shiftRight(n)).toString();
    }

    // returns {gcd(a,b),x,y} which a*x+b*y = gcd(a,b)
    private static void gcd(BigInteger a, BigInteger b, BigInteger[] res) {
        if (a.equals(BigInteger.ZERO)) {
            res[0] = b;
            res[1] = BigInteger.ZERO;
            res[2] = BigInteger.ONE;
            return;
        }
        gcd(b.mod(a), a, res);
        BigInteger c = res[2].subtract(b.divide(a).multiply(res[1]));
        res[2] = res[1];
        res[1] = c;
    }

    //precompute solutions for x*5^n+y*8^n = 1
    public static void main(String[] args) {
        String[] ans = new String[50];
        for (int i = 1; i <= 50; i++) {
            BigInteger a = BigInteger.valueOf(5).pow(i);
            BigInteger b = BigInteger.valueOf(8).pow(i);
            BigInteger[] res = new BigInteger[3];
            gcd(a, b, res);
            if (res[0].signum() < 0) res[1] = res[1].negate();
            if (res[1].signum() < 0) res[1] = res[1].add(b);
            ans[i - 1] = res[1].toString();
        }
        System.out.println(Arrays.stream(ans).map(x -> "new BigInteger(\"" + x + "\")").collect(Collectors.joining(",", "{", "}")));
    }
}
