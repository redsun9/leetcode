package leetcode.leetcode23xx.leetcode2301;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    private static final int ALPHABET_SIZE = 2;
    private static final int minN = 6, maxN = 8, minM = 3, maxM = 5;
    private static final int numberOfTests = 10_000, debugStep = 1_000;

    @Test
    void test1() {
        String s = "abaabb", pat = "bbaaa";
        char[][] mappings = {{'b', 'a' }, {'a', 'b' }};
        assertTrue(new Solution().matchReplacement(s, pat, mappings));
        assertTrue(new Solution2().matchReplacement(s, pat, mappings));
        assertTrue(new Solution3().matchReplacement(s, pat, mappings));
        assertTrue(new Solution4().matchReplacement(s, pat, mappings));
    }

    @Test
    void test2() {
        String s = "666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666166666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666616666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666661666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666166666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666616666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666661";
        String pat = "6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666";
        char[][] mappings = {{'6', 'a' }, {'6', 'b' }, {'6', 'c' }, {'6', 'd' }, {'6', 'e' }, {'6', 'f' }, {'6', 'g' }, {'6', 'h' }, {'6', 'i' }, {'6', 'j' }, {'6', 'k' }, {'6', 'l' }, {'6', 'm' }, {'6', 'n' }, {'6', 'o' }, {'6', 'p' }, {'6', 'q' }, {'6', 'r' }, {'6', 's' }, {'6', 't' }, {'6', 'u' }, {'6', 'v' }, {'6', 'w' }, {'6', 'x' }, {'6', 'y' }, {'6', 'z' }, {'6', '0' }, {'6', '2' }, {'6', '3' }, {'6', '4' }, {'6', '5' }, {'6', '7' }, {'6', '8' }, {'6', '9' }, {'1', 'a' }, {'1', 'b' }, {'1', 'c' }, {'1', 'd' }, {'1', 'e' }, {'1', 'f' }, {'1', 'g' }, {'1', 'h' }, {'1', 'i' }, {'1', 'j' }, {'1', 'k' }, {'1', 'l' }, {'1', 'm' }, {'1', 'n' }, {'1', 'o' }, {'1', 'p' }, {'1', 'q' }, {'1', 'r' }, {'1', 's' }, {'1', 't' }, {'1', 'u' }, {'1', 'v' }, {'1', 'w' }, {'1', 'x' }, {'1', 'y' }, {'1', 'z' }, {'1', '0' }, {'1', '2' }, {'1', '3' }, {'1', '4' }, {'1', '5' }, {'1', '7' }, {'1', '8' }, {'1', '9' }};
        assertFalse(new Solution().matchReplacement(s, pat, mappings));
        assertFalse(new Solution2().matchReplacement(s, pat, mappings));
        assertFalse(new Solution3().matchReplacement(s, pat, mappings));
        assertFalse(new Solution4().matchReplacement(s, pat, mappings));
    }

    @Test
    void test3() {
        String s = "d5u6z7nz3ihkdpt9ngwax2v5cogxtksze78yh3rb2tsltklh9fbx1qlohqsp1rgrmedlhd2l1wfufy1dpenjn7q0x70fao8i00omdcpu54st1bg3fjnxv8t1opq7ntupl9t275xa0zpca27sosijhohga1y75i5s499ep6xcx1il02hz86ydrvik6ligqonkwmnrxfvhy7j5h7g86z0csmwl0mcch4ycuf026xtksijk1ii9q9kcl9m4x21cen59g4ajp1yy9rj6gx3dfxaywmb0tx1hii9uikl0czpg0jzhm2sz9hlr3qhvyfpbuxrbzavil54q18002chftu65fpj5avyamjqek4t753d1how7m6ckhlcerymyxhvgjs2q84zpmkfw6l5eco58zco2jj5cp7rq4560lp0rol1xjp92jp0ecocg86fq8g0px5cgkmswtz0qpb1fb6nwf6jzpqd8mpn3bqnyml81zvy6gxx64zlpkpt1tveegoaszufslpw0jmpjc2u97v4p186rwoywci8p5ksbzfv7elsoty3hghxex00b36d1t1sxlfs7arq69qhn3mqmy1s0b039inlhbhoecypwqg5fjo336xst0em9yilc973obl2mkvj47d4jpap6i6obt7mzfkzpgf3epy0slknxsupv4gah0blu8645lsd85lf2css3tpe2quesq7iggakp9l5g4ik2lb5nhj3opeqonlkk6e04b6pdzsmlj93iiv5e0due7bfo0gauro3vh7xcaq09urb2pdq4x27c4uu99cdt6qsw5ziwzz0dt3prc657g3z84ka34dq15wtqrwv7vt2getkae6pmaasxo9jhaxosjjk0e8vreblmy0lx24gg68kh32yrytfeedad750oqlk8burhlzf0t0pdl2lwglqesun7cyrop6otloxiubwjofsrwm3aixkb6fos1k9e22k5d6kr3b4lt9rubsrbd5zvgw8ugj59piqs994vo5owimrhujczx9dhln12fnf1jv37zodzf3i6kz7sh9a02qalrfgy8e8iswoudupj62zggl3uor6dr2u7qym6qkwaqq758qm6g1c9ol400t0kg0vorh120zpuvez4gau6go3vge5tbke2bblspmr4h6yc7mp7hkybf35mh5qgdauof0azwubeg25nvcaahbsg4tekidehhyauqj6wfnyq9a7m69tt1ejkkplyh16qegugp7it0xhqmupi5kviwakyjqox3sqqvzahlh3n9gxierxot9ywspw7lofslbufpu2lfwjit8vh8bynz9qa5tux2z0pjv43lwlazemgjglcgpayvr2cgu456vdw0m7xtfx1whdg1xuz942tjep9hbfyyf5otqr7njlp2dgf1zwqo1rrud5mm3ovk2vqodbvyokgopgd1za4qyokuambm7nxz6i2qcdkmpmt6dh4egtn4ce0byo9vztrda1oje2n1iig515o3z3gw9xkyuy09768jzz6pzjlb9ummkrp4pa285vy5p1ko3wari9ejp0e16i0cqtds5pcog32f5q8repgt1vpkxj0v5yo4dai5joxs5dv2y17c02jc1q85ur3orojzafns0n1zxopscfbt5rw4ugfhgfketyqb0zop84xxpnnccz7up0jqdz2470akdb5wp74uiazwey3rert2e09x8imr7qegzluy9c9kgt77pfbt6p6qmh13ugvfvwh8ty73q2ww493y352mxg98jz03m936l3ba7i39ihgkugwdhgck17p52w62sf1x3c2jm3svlnxvp7xzi8jn9tp0mxqwul4u4e6n2msr00g1vqrx9pggerfqgrg6p8ahj5opkynj6og9i8rp98b3fsq6h79zcy9vwmzgr1f4vumjavf43e573ouofx70umdn29vacz19iogzro1ee3o3eg9i8fketr0owobmsbhgp35kptqikpgnmdcyu9ky2lv8ywlfignsvdqcb7ilsr2y0iwq070lit915oa8f1r0jj24sskcgbsmck2xxy29potdpwy59vciv4pl4yz9g8gcs79llvu7f4p92pevjsycxssf25u0anp9k112z7xv7jtj9irtrrxkdqyy195d01j24g6rmudhe8cvlckvj0u8si2eam7pbmcburqz43vsh903v9xoygc5ae1usm88fqvfjhckeot831438u54r0dty8klnhgmhbg1dq5gso4gak62q30ao7t0mt66zzpdg9pkttpv0teevc2ubdbacgzu87zfksnsl7cmbi806te5kurkqinemhpys8ykkg9030t4k83wrrqi36ivg2x3aykzulpllcxlkp6n0g0smtnycwc58gdg2qyge1yt9y1d20g0ri14ti0rw77eroo7w5thprrewma6cxgr5bj21omu8p248y0rip0blvftvo99yi30pfxx0sldklor8cx52att19hobo2x30snwa8bsu9jdzk6jluo7qe3mds5w5nxw4nq1cgp72cqzup2s6n4is1hd3k031sfi6d7hw1r1x1rsbrmvw6r4b2f8t74pw3ibtu4jvlr293jkrh1wabypikv3o1vzbvn9js74sukgt304ydcbtcbl2auv273c0zppllp4xdzrls8y9zxzqlzi2azzw2ln3xinhb1ngrqx0yn56z0jqdl3efatysnapgyixz7kli6lg1mrr2amr9mwxund9jaylh42qjvhxo6ybux94dntf52i16bbtejdxxzw2aq4us6qh9jau8sbfyux9huv0orikyfbyhpubcy15wvlqzu13686gnpq79avg9tvhbgrp8so914q9w1cqci3xqvwgiglp4azyjr7o3c7cfqub0w3uxasjmhn6ezsl4s0pdjzbp1y9h9p1ah6r4860xxysxz5fivq7hnrw7weauizvci1xoofuh7pjh0nlc9ybsxdmksth31uni5t4va2379whr0112brtlnknnxd8rykzxg14iohxmg7n7xu6fmonky9jzw0e5ocidebabgda2qzpwfvkpucyzvmxrowr062ske4s3ac5i0n2cln2ksl76s58jt1dtc2l3oeetpiaxsdkwufl6qc3jh2tgaem921rchtbltk4u2s8exwp4ttc9lxgia4ksxxr0ga26f7nojs0wnkuo7ieer4c93q3kgimqx9tuuup90fbjlzhvfj9gxm7mx1b6gfg1zv9fs0x528ygdkrw1c552ioaubozv0cmzhcjq90pvd52hm6pwvuob889drlnjyx3lfbxeoyuyu9eehwxzdm3rdsds4wveca8nbqm66g09i1xlervnk737s3nh6r16kkgkbb2q1y06gztl2y08hf0izme6hq12fmctyjmtsl2iozac5xhfa5okhdrto53sny96zirhuf93zje7a34al6rkgqlnfmrfqrux80e6soy8md8ooayk0ix7uygetwfv5cdo4xmkroranpznf74tcut419f5jbse2aq82vw31mps91onj8aahatsq1g174lyp2q5i58tr7x70wsd9fylz1whc90vp0ui53205ocremll7slfrivjp3ojgr26cv3yooa8ckxwz050jvp6wgg4i0wtueqbkobdix2uu1l6cbtyhvfrfroqaz1nfh3soznng3vb1zw35xff1rrpgfr5zn7pj8waaxfhk8vye2a4ke50bdg11nsj1vaywic7o9c0orgizy0wr4jx44sur486ixyyvd5ej85p60xvnuzhiyjqzf86uz6eebhvaukbk0vbhmne0d65djqeoleywwexy5fc81xlqohc3a91uh0kuvf8fdw48f2n7o11jyf5hz47xo7snigpe5yeqsjm5ksbl8lchkfpvmzcumrmat7qhoai1sg65xnrpnnl9sqloce9lig25kfht3b3qd3c4ah0z7jtttid8hx8u6m1mcmxdmx2nc37go0g0kd8b7f2z50vkg3rb3s9slk0t2f4lyl4hmc1kyjptk2zib18sf6dx8iuqkjojwg7dqorqojqtw3gli8ryns3uq0ono59mizbc3ugsifdos2dx59j8dyv8zs8k2ticxif3mobtgrgh995mgfmb0wjoz06dqpw1xevx1rz3tuuag3sx7hhf2e4y7xyiquc707beyvi69zmp5zfhdsoi1vpuqb83xrum10hkssljodsvvz";
        String pat = "bt277wmvco0bwtyfyxxqxa6zv0zjr4zfjefyvhaio30emqj2ydg7s86r47s7ebyqwq62x0vnklwhsoqy14fu964d682mjeeosz5697zxyjv0qho0vngoaejzgea9en4k8br1igh73le8phvcrcbtt9mhhl1ogt9v33t8ns3fxf0xxv33q2fzax68p5527q1nbici2nhn7pq68mdu6sfcp0rohe8gpt31rk61yqmif1skov8hp17iowx6synmqx0q9xydumiynx7job5pxiuj004ovpybgybvzvaj2u63rwqp5dwpc2no0nypeix0r3hz1a5d4airwzkjt7qfzphe8oa577znq4h7dtm5eesqgrf0rzawhxjasn6yvwnwr4zxnl21l2cg3t0afurcpo1y7oyyxhtpc79m49eobapmhaihou5xv2a22r7he5b16q1ggi4p3kqga55onixnuiae4y8mkfz87ejz7kca6zqijiuvb3dt84u2n5gp5wrcqobgfzhbje8hcr0v0dby34pf01yuh47se5pcky4o2e774emf5ebjjfqa2xorb284g4uir60hacx4ufz54t79j7j9ykcvgqfi3clg0pfi29kl78bmqmzafzrwtl0x4jqwfs07pwzifx9qdn1odoaj0xljyvlcmp54pz8py8xfxe1zp9kykmo9cjol1j8pjitzd5i8ewn1wit41re8frg9o7zfk3uojs1y8stjqpi5i9gt8oelkpy10r829hkb7agw1yrynwhldw2putt0ff4lb9nkmhtfrt53p67fg1vxvsdn76avh5ghnlxdwffjyo40bs88aag3a9lpgo76wsojyi1rv3i6sfjtek7i5embn1oy24bahwwp3s8rrkmb52ek5s4ardpa8bztt6q6hruo46hojula4m0myw04h1l7zflp9yyof3arq0uhltyapil2jm4w2onqjplu6x4zvf7cmhkim1yosrduzw59h9zohp2v6eqcsj92hrouac3ry6sqi3ugswi30ddd646jo9u2ff7k9vp1cn5fhy5ydzvby9xqf3a8afbesqi3zvrn3bvbsn5kdupyotnb4qjeg5ap6fvlbhkn8xncxhtlvcbj7cet0nhq9ll7iz6qq6a1uv80aj692lm9li1cmwf18d7909po7uvtzljczttvflkixylvw0zeuvmnezrxbt3urdnhxyzcujrsx1zamhm42vrslhd7666quiyij8vtb8h8ty4b0hz957lpxm7vrhpstg4gdqgtur6vu89ypzw9r1ad7zycbdt9wzwe62uvrzhqva74v2kx6sdcr93sdlngphgqc284edsf4r65i181e48cptrll9zeyf611z8oiqmokfxx79dxuw7te5w2inebug2l74dpxzamys4me1g3p9cyhkb4trd3y1lx90p50pwzh1mkcbww81c0s5lv3cmaw0j93a44qfkegulpeeyaaa28ffnnna9u18pbkcu39u5o4j9jdsfltzsgk2a4rqn6fhk3628hbun8sxkuxb41frv2b3wtjlfbuuooqhprxj5gu7v4fzb4w1h4xx1n80v7y97lygw8bdgffsz0pz80cz3d639qip4wq13i1g0f2s9vo8fxdlm9w68onzedow9mslkffz7ronqa34dg7g4gtcwc6q7arz33a28t24si625y3yrr9m6jdyaicjwr5ir4ublelxryz69gixf9wohej3yde52gsvm162f4rl8mxx3zg02r6xeogdxidc84q01i8icws8yexniilnxt78db6uh61wo9pdvtvl3tgwolfh5iawt5qnl1jnqo4tfbf0y107qm6dmtytwpdrq2qxq0hvtcwywd2520no5mtdmnq9vlb98y2yr8obaspdbcie9jep348v62fsakefvthtzva6xeokgdkz9rhu3d7k6duysdj89i8qrkqioikqzj42uxvi80zpf4ddwwe9lxwdzii8c2me0hvmml83bh1245svecl2inhn9hbfavp9zz9n7vs3oy5t7uvt70u6v9iy70y4ck4pnw9f2vbynsgpnw6ea927e5xb69my0u5tfe75joeaqbaui91e66ow7pmaio8nb4ew4umr3sxuyv6vufyv7z4go0ck013v3gsaigpthx1xr7ywkom9lf8nc0enhstgs1q7kh5vyrhnmu5x3xatb4c3lozh60pw9wvsozxe6zvpjuh75lolwl47sbm74c92t0ibp81cuci2nqcr3j08e3n9txfcxhrrdjc0llrmhfnib2go4e0io4kudkdko8q0sq1uxvxnowdptyzoufd5xnb775z2d0g8y8jsbuypcd9vda406vm7qo0fb67miz8ybmltmvhp65zfs9ntxh0901le6yjgupv63ttuyo6srnhril9zjdben8ggd06zqpkly8y3dsp2pp9mmd26ssixttx290k5qnpchuel5ablzk1m1x2xod571jy6vyytom91kgav41ciygqm9ppdfvruzqv797rxo6tesldx81r7hy1ymtmozqkw3chgamypfhul6q9vfjkq4dg86qchi6a7pvjlzn9tvoke636g9vhnkelvmygrktiy1nr600crgzptd8hfon4q00bl4izj3usk9ro8pq8h7sxo7bnf2qkibl121nznpznt1z0w1vbic8tufybf9nwh19f698imbgzaortgt8elxveme2lcygm3a1f889ah8txrtjbsthvuborfsldll5boivkoq4n9xc8c80ci50ic0bea84zvsyo97kgbpypdharis1l9ju6ek2jm0bla9hz2bmxzamf8tpt3d737owcx6jhsbgi2mkz1e4471pxfb86zg1mlyh45jbbjyk4lxzx7t0uej22ecd2q2pxercpars4wj";
        char[][] mappings = {{'6', 'r'}, {'6', 'q'}, {'c', 'm'}, {'p', '2'}, {'x', '0'}, {'9', 'b'}, {'h', 'm'}, {'v', 'c'}, {'1', 'y'}, {'p', 'x'}, {'s', 'u'}, {'q', '6'}, {'x', 'c'}, {'g', '4'}, {'w', '8'}, {'j', '3'}, {'u', '7'}, {'y', '9'}, {'n', '5'}, {'x', 'd'}, {'2', 'o'}, {'g', 'f'}, {'s', 'j'}, {'7', 'y'}, {'e', 'p'}, {'v', '6'}, {'g', 'b'}, {'4', 'b'}, {'a', 'i'}, {'7', 'n'}, {'5', '8'}, {'0', 't'}, {'a', 't'}, {'y', 'v'}, {'3', 'c'}, {'t', 'h'}, {'z', 'w'}, {'q', 'p'}, {'m', 'x'}, {'o', 'z'}, {'7', 'q'}, {'c', '8'}, {'q', 'n'}, {'m', '6'}, {'i', 'l'}, {'y', 'a'}, {'u', 'z'}, {'8', 'l'}, {'n', 'v'}, {'7', 's'}, {'p', 'i'}, {'9', 'k'}, {'m', 't'}, {'f', 'p'}, {'r', '5'}, {'l', 'c'}, {'i', 'o'}, {'w', 'x'}, {'3', 'a'}, {'k', 'h'}, {'p', '5'}, {'p', 'o'}, {'r', 'd'}, {'q', 'r'}, {'i', 'x'}, {'9', 'l'}, {'s', 'f'}, {'1', 'j'}, {'h', '1'}, {'g', 'd'}, {'w', 'h'}, {'w', '1'}, {'a', '9'}, {'p', 'g'}, {'b', 'j'}, {'a', 'e'}, {'7', 'j'}, {'d', 'c'}, {'3', 'd'}, {'t', '1'}, {'t', 'k'}, {'1', '7'}, {'8', '6'}, {'i', 'q'}, {'h', 'f'}, {'8', 'k'}, {'9', '0'}, {'s', 'n'}, {'d', '0'}, {'b', 'p'}, {'m', '0'}, {'o', '9'}, {'d', 'z'}};
        assertFalse(new Solution().matchReplacement(s, pat, mappings));
        assertFalse(new Solution2().matchReplacement(s, pat, mappings));
        assertFalse(new Solution3().matchReplacement(s, pat, mappings));
        assertFalse(new Solution4().matchReplacement(s, pat, mappings));
    }

    @Test
    void testCorrectness2() throws InterruptedException {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generateTestData,
                testData -> solution.matchReplacement(testData.s, testData.sub, testData.mappings),
                testData -> solution2.matchReplacement(testData.s, testData.sub, testData.mappings),
                numberOfTests,
                1,
                debugStep
        ));
    }

    @Test
    void testCorrectness3() throws InterruptedException {
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generateTestData,
                testData -> solution.matchReplacement(testData.s, testData.sub, testData.mappings),
                testData -> solution3.matchReplacement(testData.s, testData.sub, testData.mappings),
                numberOfTests,
                1,
                debugStep
        ));
    }

    @Test
    void testCorrectness4() throws InterruptedException {
        Solution solution = new Solution();
        Solution4 solution4 = new Solution4();
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generateTestData,
                testData -> solution.matchReplacement(testData.s, testData.sub, testData.mappings),
                testData -> solution4.matchReplacement(testData.s, testData.sub, testData.mappings),
                numberOfTests,
                1,
                debugStep
        ));
    }

    @Test
    @Disabled
    void testIncorrectness() throws InterruptedException {
        Solution solution = new Solution();
        WrongSolutionFromDiscuss wrongSolution = new WrongSolutionFromDiscuss();

        assertFalse(StressTester.exactStressTest(
                SolutionTest::generateTestData,
                testData -> solution.matchReplacement(testData.s, testData.sub, testData.mappings),
                testData -> wrongSolution.matchReplacement(testData.s, testData.sub, testData.mappings),
                numberOfTests,
                1,
                debugStep
        ));
    }

    @Test
    @Disabled
    void testIncorrectness2() throws InterruptedException {
        Solution solution = new Solution();
        WrongSolutionFromDiscuss2 wrongSolution = new WrongSolutionFromDiscuss2();

        assertFalse(StressTester.exactStressTest(
                SolutionTest::generateTestData,
                testData -> solution.matchReplacement(testData.s, testData.sub, testData.mappings),
                testData -> wrongSolution.matchReplacement(testData.s, testData.sub, testData.mappings),
                numberOfTests,
                1,
                debugStep
        ));
    }

    static TestData generateTestData(long seed) {
        Random random = new Random(seed);
        int n = random.nextInt(maxN - minN + 1) + minN;
        int m = random.nextInt(maxM - minM + 1) + minM;
        return generateTestData(random, n, m);
    }

    static TestData generateTestData(Random random, int n, int m) {
        char[] a = new char[n];
        char[] b = new char[m];
        for (int i = 0; i < n; i++) a[i] = idx(random.nextInt(ALPHABET_SIZE));
        for (int i = 0; i < m; i++) b[i] = idx(random.nextInt(ALPHABET_SIZE));
        boolean[][] map = new boolean[ALPHABET_SIZE][ALPHABET_SIZE];
        int cnt = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++)
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                if (i == j) continue;
                map[i][j] = random.nextBoolean();
                if (map[i][j]) cnt++;
            }
        char[][] mappings = new char[cnt][2];
        for (int i = 0; i < ALPHABET_SIZE; i++)
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                if (i == j) continue;
                if (map[i][j]) {
                    mappings[--cnt][0] = idx(i);
                    mappings[cnt][1] = idx(j);
                }
            }
        return new TestData(new String(a), new String(b), mappings);
    }

    record TestData(String s, String sub, char[][] mappings) {
        public String toString() {
            return s + " " + sub + " " + Arrays.deepToString(mappings);
        }
    }

    private static char idx(int c) {
        if (c < 26) return (char) ('a' + c);
        if (c < 52) return (char) ('A' + c - 26);
        return (char) ('0' + c - 52);
    }
}