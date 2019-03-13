package algorithm.medium10;



import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/11/23.
 */
public class Solution820 {
    public  boolean isSubstring(String str,String subStr){
        int index1 = str.length() - 1;
        int index2 = subStr.length() - 1;
        int flag = 0;
        while ((index1 >= 0) && (index2 >= 0)){
            if(str.charAt(index1) != subStr.charAt(index2)){
                flag = 1;
                break;
            }else {
                index1--;
                index2--;
            }
        }

        if(flag == 0){
            return  true;
        }else {
            return  false;
        }
    }

    public  int compute(String[] words ,int[] arr, List<Integer> list){
        if(list.size() == 0){
            return 0;
        }

        int count = 0;
        for(int i = 0; i < list.size(); i++){
            int v = (int)(words[list.get(i)].charAt(0) - 'a');
            if(arr[v] < 2){
                count += words[list.get(i)].length();
                count++;
            }
            if(arr[v] == words.length && list.size() == words.length){
                count = words[list.get(i)].length();
                count++;
                break;
            }
        }
        for(int j = 0;j < 26; j++){
            arr[j] = 0;
        }

        return  count;
    }


    //Accepted ----38ms
    /*
        dp algorithm
        tim complextiy O(n*maxLength)
     */
    public  int minimumLengthEncoding(String[] words) {
        int maxLenght = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > maxLenght) {
                maxLenght = words[i].length();
            }
        }

        int sum = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            String temp = words[i].substring(words[i].length() -1);
            if(!set.contains(temp)){
                set.add(temp);
            }
        }

        int distance = 1;
        while (distance < maxLenght) {
            for (int i = 0; i < words.length; i++) {
                int index = words[i].length() - 1 - distance;
                if (index >= 0) {
                   String str1 =words[i].substring(index + 1, words[i].length());
                    String str2 = words[i].substring(index,words[i].length());
                    if (set.contains(str1)) {
                        set.remove(str1);
                        set.add(str2);
                    }else {
                        if(!set.contains(str2)){
                            set.add(str2);
                        }
                    }
                }
            }
            distance++;
        }

        for (String str : set) {
            sum += str.length() + 1;
        }

        return sum;
    }


    //Accepted ----238ms
    /*
        time complexity O(n^2)
     */
    public  int minimumLengthEncoding1(String[] words){
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int[] arr = new int[words.length];
        for(int i = words.length - 1; i >= 0; i--){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] == 0){
                    if(isSubstring(words[i], words[j])){
                        arr[j] = 1;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < words.length; i++){
            if(arr[i] == 0){
                sum += words[i].length();
                sum++;
            }
        }

        return  sum;
    }

    @Test
    public  void  test(){
//        String[] words = {"time","me","bell"};
//       String[] words = {"time","time","time","time"};
        String[] words = {"mokgggq","pjdislx","bfrbsfs","hgwqzz","bnwxc","pzhmyo","wbfton",
                "evdro","uwxuzmn","mdwfn","rinmw","cwvvrea","aqyxlev","ipypqev","cbdhb",
                "ynqok","lieciy","sqhmdh","pcotcq","vyeqmey","gvpbu","kvhaag","qkaqq","mwtmzzs",
                "gtywt","cnowp","ibfdgvp","jybmx","gseqh","yaohcp","jgarzaz","lgxogb","cjjiev",
                "tjfbf","qwtlx","hehmv","oergh","ovehsf","zifrfb","tbykq","oasqrsw","hjmzil","fuylmzc",
                "zokxci","wbyspc","cqwsb","oftqr","wvgtmrq","ymfyjm","odrnphc","mnoms","frhelt",
                "gokypg","yoafppu","mmquko","klnvy","atcfwzv","yjmluf","hckdblw","wreortt","osuidhr",
                "vmvopqa","snilp","lpygwbe","esqpirj","lacnfr","dnyehuz","qfvuo","jvnlky","gdnzemt",
                "isewa","hvmfts","nuxsog","cckcw","bmxtsb","ozlilc","wmhku","uhoni","ckkbb","uwrakdx",
                "kciqov","xrpjq","lqvbs","fyrglkp","xfbgq","vrojsdw","wwivh","frgontv","fgghrms",
                "psxdbxb","ezapa","lvihja","oydcdih","ztefj","khpoypx","llwgyuq","heepqf","lneold","lxcyjrt","yrnzmvm","kwcluhu","qoqbzzu","cuwmp","qiejx","fnqceo","myizd","thggnqx","ixwbbve","gjwruu","alpglnk","zrhmh","evkojps","gvwol","pystdn","yhcjrd","qtyhucx","cwmbh","vrlmw","bwkntib","isyyx","bptejfp","gctufb","lewtr","llkwsi","rokvhw","jwagu","axchu","llshkne","lnrwco","ylnkjsu","ukdaxm","byfnel","deecwis","xwjjf","xwsyfi","bvnen","supbi","dzara","qtnyslh","zflzqu","rfbsz","yiwbok","kpvpmey","aosdked","gjogz","pwaww","qpqhoz","avlxwv","aakku","ykpjq","biejhfz","ngnmk","gucufvo","zonyhu","pwbnko","dianhi","svdulhs","seaqz","tupyev","rfsde","qgvwnz","ijjpsx","vwwizu","cegwsql","snsrb","kzarfp","xsvwq","zdend","hnnib","ghtfd","pgdlfx","iyrfnl","xhnpif","axinxpx","cttjnl","gmkji","ewbecn","fqpvci","iazmng","ehfmc","wsmjtm","vsxto","cguyk","mncgl","brafj","jvpivd","ljburu","pgxbvd","ewxxx","trmshp","spfdgn","oczwdxj","wvnared","ktzmiu","kdqww","saeuudb","mwzel","sbihma","jemgzpm","oogsc","lvhtgm","thuis","ljkdo","ewgvbu","emuxgt","kgxyfdi","tzwmlof","canbgua","nwqeqwg","ikmorv","uzanjn","npmjwyl","hwkdfld","bbmil","kgfro","qamev","nuvhoh","pklbp","yzfplx","bcifen","gimid","xiiqj","pvvcocj","skshvmq","nlhsqt","zqttm","xuskbm","jejdbjq","xecjgs","udenjcp","tsrekhp","iisxmwb","gmtovot","kqcfsdo","efpsvqi","ylhxyv","tvamwgp","kidlop","amwsk","xeplp","tkuhek","qaweb","orrzhb","ogiylt","muvbpg","ooiebj","gtkqk","uurhse","cmwmgh","yiaogkj","famrlgt","nslern","hsdfss","asujt","hbdmg","qokzr","razeq","vwfrnu","hbgkrf","betedj","wctub","dpfrrv","zengra","elphsd","lkvhwx","xutmp","huqpltl","qaatefx","zarfa","dliudeh","ggniy","cvarq","rjjkqs","xkzztf","vjmoxa","cigku","cvmlpfj","vxmmb","kqxfn","nuwohcs","sezwzhd","xpglr","ypmuob","flqmt","ergssgv","ourdw","sexon","kwhdu","vdhdes","inellc","urjhgcj","vipnsis","rwtfs","nrahj","jnnxk","emesdw","iyiqq","luuadax","ueyurq","vzbcshx","flywfhd","kphagyo","tygzn","alauzs","oupnjbr","rpqsl","xpqbqkg","tusht","llxhgx","bdmhnbz","kwzxtaa","mhtoir","heyanop","bvjrov","udznmet","kxrdmr","vmldb","qtriy","qfmbt","ppxgclr","jywhzz","rdntkwp","hlejhf","pvqjag","zcnudmz","wcyuaqz","tudmp","kluqos","slygy","zkixjqg","socvj","igvxwq","oyugfh","jscjg","qmigl","yazwe","shzapa","zqgmc","rmfrfz","tdgquiz","ducbvxz","uiddcnw","aapdunz","bagnif","dbjyal","qgbram","bivve","vxrtcs","szwigrl","zmuteys","zagudtp","lrjmobu","ozbgh","hvoxaw","xmjna","lqlkqqq","oclufg","ovbokv","oezekn","hcfgcen","aablpvt","ejvzn","tzncr","lhedw","wiqgdb","gctgu","zczgt","vufnci","jlwsm","dcrqe","ghuev","exqdhff","kvecua","relofjm","jjznnjd","imbklr","sjusb","tqhvlej","jcczqnz","vyfzx","audyo","ckysmmi","oanjmb","fhtnb","rzqagl","wxlxmj","nyfel","wruftl","uuhbsje","oobjkmy","litiwj","dxscotz","znvixpd","nsxso","ieati","iaodgc","dgyvzr","rvfccm","cchxt","raiqi","owzwnr","rkosimq","dyrscbo","ppjtey","ebnuom","bifrbq","teclf","ztbbyr","omrehv","wtrvc","dllgjc","guxeicj","udmxbe","zrvravk","dnric","sbnxmxv","ckzah","qzbrlq","gtmjvoq","xarml","jeqco","hnodvno","fomdpk","coqoudc","eochkh","hdghbb","jiiyrvp","vsdydi","owctgdz","hqafd","zhjktay","yqcfv","ajququ","gftptr","amllxns","sisfbef","tdjwhz","wrvkr","hqxuo","bhrjk","igjldkr","ujqwaj","ufksq","kmfai","zsjiot","civroa","eqpoiu","hjpnw","snxdde","vxkro","lvyddk","rfskh","zcnjtk","hsszo","uxnnj","yghbnl","cunqr","pkbwwy","ozjxbzt","sxqxmz","arkjqwp","buwcygp","eqthat","lqrofq","wwfmh","xjddhyu","nluzkk","sofgqaw","yrwhfg","pkhiq","kpupg","eonip","ptkfqlu","togolji","exrnx","keofq","jltdju","jcnjdjo","qbrzz","znymyrb","cjjma","dqyhp","tcmmlpj","qictc","jgswqyq","jcrib","myajs","dsqicw","llszo","kxjsos","xxstde","vavnq","rjelsx","lermaxm","gqaaeu","neovumn","azaeg","lztlxhi","pqbaj","wjujyo","hldxxb","ocklr","lgvnou","egjrf","scigsem","orrjki","ncugkks","dfpui","zbmwda","gqlxi","xawccav","rtels","bewrq","xvhkn","pyzdzju","voizx","cxuxll","kyyyg","qdngpff","dvtivnb","lsurzr","xyxcev","ojbhjhu","qxenhl","lgzcsib","xwomf","yevuml","anfpjp","hsqxxna","wknpn","hpeffdv","yjqvvyz","eoctiv","wannxu","slxnf","ijadma","uaxypn","xafpljk","nysxmyv","nfhvjfd","nykvxrp","nvpvf","dxupo","pvyqjdx","wyzudq","vgwpkyj","qlhbvp","hvhpmh","djwukq","rdnmazf","gnnryn","mllysxq","iapvpe","zcpayi","amuakk","slwgc","pbqffyw","emlurpa","kecswbq","pfbzg","opjexe","savxot","finntqj","tnzroga","jktlrsn","beyir","txsvlt","qjkbxr","qomtajo","ytvkqbz","dxantfq","zsstb","sonmv","rxplgr","ltmnnl","najvi","ucdrotu","smeccv","iqyssw","ytkgn","ccrzv","iepvgw","zbnyyh","mupzq","ztghi","ztyaen","efnzco","ugsyq","puokxgl","ceqotz","yytwzik","gxsbdne","vgcjgyu","sfidsno","cqkvw","rscfgmv","zpoblc","oslpwhv","tsvsa","xdrty","dcbejb","twxul","fozhwha","hkehs","mclhfm","kfxfpx","oplmpq","cmfzuu","rmbyhmf","rcivkmz","mgabniw","hghapx","wmoxvuk","kupmpud","snspozp","zveqzy","omxxlfq","gaill","lpazav","kxywrju","lcgtepu","zbmlcl","lpzhv","pszeto","vzmbso","kbokpl","uoqmat","fdkwjg","kytvxew","gzzreyo","wxdyynx","twchm","lsxbxma","tzbva","fnazkc","qmvpa","mxoiz","nmxzmn","ufimada","dvrow","tqxxsd","xucms","loraesj","mbqdp","mkcnovs","pmvip","uksrfu","ngxcbel","acbgch","jynevd","pewhh","rtuymc","jxqvb","ylrdr","nfbnsxo","blcyz","twndeik","dnfku","yrckw","ozzqt","bxftit","ooidimg","mpvgc","otobnvo","fbczc","paybdj","yedrbz","qwlijd","uyamzc","cehtizz","xejofd","hlvqt","iracei","ppjlp","jymqay","vbdtxw","svhdn","srylnl","arpbta","yiasrg","chmlmof","oaoagf","ntiwo","heuvqrv","ygudcn","ujoxgw","vcxysn","xxvbcz","gubka","lcteegl","mfjqu","jmrll","xmpefxb","fxhlx","qgtcw","itldt","xbhhno","wjlkr","mkoumfo","clccuxo","ksflxgu","cviwbab","ggxcbmm","aosxdgi","ucaqtvm","tzkquj","dcdjfl","vykusrg","ayxfjy","vejuy","bnqxwd","fnrbwd","uvkjmu","rgneg","wcqrldl","lokksi","evoqgp","xzpvts","xbjudib","zdpttvp","tbvbi","pzvfn","giicqi","cyjsrd","vvyvdn","trvxk","xkwzirg","smzaoc","jvpncjy","carcxzy","azmnrz","tkffh","kalra","emoowz","qfjcz","tbcpi","unmas","fxdhi","wegea","vjnbmu","hbxxa","updrj","kanisyn","qzqfa","rbyfleo","gvpud","vvrnda","ntgcz","niiqd","okmqocr","hlmuoir","cllmy","pvgcyui","klubnzd","henjf","ucmilyk","bdzvhvy","zifmo","cidvxii","unfcw","uzsgfv","rvimhmz","rrneanz","tmtptt","wwdzgb","kxlofp","muvdf","ojlkit","xjioe","hdmrl","uotxsd","wblmhvw","kyatg","lueyjj","edcqlhh","yigtdu","mkqvux","ognxpmw","obdpmbo","doguzpy","pmeuq","egkwgm","zmjps","blxurlk","tcdsvz","cpttk","oones","zulotp","bbjmmft","qkchbbb","ddoyf","qwykri","rtdhc","xzeopey","dwwzu","absoj","pyhxrz","xkzppy","hukvxis","mrlzdcn","rowai","jehovhy","ctrho","icfhdp","mjgmdju","hxujna","bzmfac","hpnpfvb","zhnnuzl","exfpqk","uusye","abklkm","hpwybsm","pttzcdz","mmkao","uxkqle","mllnhh","gqggto","mgntzzx","xtdef","xdhgjq","bkvcqzj","grvdv","agjof","nxxonak","ssdwci","wjkcwl","bvgwiaw","aehhhox","miyxnt","ztjbho","npuynrk","qnjch","urwuyw","hjclv","qhbvvt","enyzud","pfeyzwd","fozvoz","zisyj","hzdbri","wyylyi","fjvwf","svfmn","edhcu","eprzr","vbhsezf","isudgte","qszip","ilqnce","rmrjlw","opaweid","juzdv","ehtiv","yzcosn","rimplj","yhdre","onklj","xyrzj","fpkebll","hvjyjkb","koczlof","iovlifd","uqvvw","xyfueng","twynd","ktmkxzq","qcvwd","uxnjdh","exzkjjx","vefasx","ufgtg","cmllk","whqpy","uiqka","lxnwzw","jblxgd","dxvuvf","llxqaz","qzxqeq","smfiri","qwalddg","qqkianf","oshgkag","qalgka","sedaqv","logbadp","hmklzj","qdqcqj","cdwcudk","sqgvhsh","llloqjx","binnlcs","fjaow","uirnxyz","zffqat","akdzyhn","pmcwu","elnge","uyelt","uzsod","qwfarib","lowtshb","wgzaiwm","xzcppu","azfoudu","zvargi","mhospi","bfqemy","krhnt","dolixge","ofpqew","xjslrou","djjueg","nbjtp","zahjb","vdbxeg","vooqz","hflenpk","xpyxqmq","wkkdtd","cfcgj","unrprg","keszevs","cequp","hsjio","ayprq","alpzyk","erikrmm","ftxfgde","lopqyg","oxlqbi","tiiht","itanzk","vpduf","uxbgkqt","vztwrdf","bcqleo","zbrteyu","mzhvxw","esnlm","uctdwz","dmhnw","dhoqk","ulsokg","ecceh","lfkyscl","turgt","jctmib","psrlmq","gdwpniq","hahedwt","ajbigo","qtfmiv","dtzij","oceesy","hothyg","vfadpdf","hppiu","pjgiee","isxxbpp","dwnoh","cgnill","zufyk","mpoeo","pqyxc","ehpyix","aulgyr","dtdvk","snlmd","uswfmev","jhypcm","nreeygx","sjbuqp","uajrx","bvgci","cktys","mioopek","tojhyqu","hihlal","lhviecc","kczwrkd","belivo","gcxlt","vtqorps","fdvnwku","kllox","xgnyfqr","xwvfqa","hshmm","lugfp","ugcxki","yiyylah","imjcspq","lpsts","ifvkz","veheym","yxbrib","wyhpjhn","izwaqvn","kjpdj","chcnl","tbxld","rskqzjm","fisxhi","dwepxp","cfxjbl","mjqpe","renbc","lnqdq","psyhms","unqmse","mlivyuw","ajzrmjt","fmmsrx","ggvwrg","evnhtbx","ednufjc","goows","olofgl","wpfrr","wuvype","fwjto","vnazt","ujrhkec","noxme","pbkaz","larkdu","ebuxauc","vkjqer","ldelp","sojxqfg","wbvbut","qgsooz","ixtgd","qioslp","pqgua","mfnvz","fkinlrh","qtenoc","syenus","fkplm","qvlies","unolnf","bftvtl","ifzbp","zckbjz","rwokr","iqipnz","nyrsnty","klneq","rtizom","nzxvaf","kwsknn","delmgu","lvrtoi","xgpcn","zovahx","kqykd","zllzd","ciskyi","qmkow","zwbwgni","qixaqyp","bbpdxz","gpyddcr","emwcbkv","qymwpuk","gzfwr","bqtsjm","zzjuarn","tuczqbf","focyyew","aajkpt","doxpudb","iihqftz","iplmetd","awzllw","mjafnh","gzqmt","bcbqbek","wkpda","hdhnced","vescmqn","tvsof","ontvba","ywmawy","yzucwi","fqziiur","pmydwpt","dliolrc","jnsou","tvswwhb","yogoial","vayef","fwvhh","wwlck","mrzrjcx","xzqxcif","irynybr","gzyqisa","lnflfzy","xmepwne","unyjrem","zgblsf","rtmomdy","eshld","xmwikj","fnupbcw","fcipz","uciehpe","kmtnut","ectqzea","swrit","frrchku","swcgsu","shkxvt","zjjcx","gtcez","xblhk","gubhe","pnaoos","yypewih","cbzbk","jjxbq","nzqycdl","mrjjfyk","itkzfhc","uambd","gictm","atwntt","cenrao","hzmlgfv","cyamfon","pldrrnv","ebtzqx","jonga","ktgmiy","qiqseiz","npitnk","fzwuen","mvxhb","obidnqw","plola","pijaf","jistxtn","dcxxk","ruxbphm","qzaneb","ioyqmy","wayuno","wbvmck","pmcxo","qtada","kbxnj","knhmjtl","kiqxiro","jcpsi","cyhvmo","hsomp","tkxxf","mneqtp","ntrcat","wgvgmr","varaytv","pbida","yqolnz","chxwvp","vchgf","hohypb","zohgdc","xspsy","hxaefb","zaomwg","ghpniya","vvsmcwk","ycnxjh","hyrkc","zmlyxmy","nxwrij","vgnda","scpzuwu","ibnbzhk","tmavs","bvdhfbl","cjudij","udgqjbs","svyrq","kmhthi","prapa","xlibves","dqddqmx","tqcipdw","uqgrhl","fczoo","pptncy","vvaylkt","xjznf","zdjori","atuzhd","qmttkmb","rsfkvw","rqxscu","rxrwc","zvptpuc","ahdvce","ftaidk","apahhfj","iskrwxa","ellsp","lwjvg","rcbsw","dtbmi","ejwti","hdyzyf","gbmdm","gmrzr","jbgje","hnuapiv","yogxasw","kjuxrxi","ejjzwq","qthpshr","ufqqa","drswm","sqcdrm","zharf","duefy","pfrsnfs","ywygkk","debqn","ttsbv","jqoqn","dtwopta","psgxiz","gpuiy","rtghkgu","qcmhksu","lcoseb","vzewq","gxiux","ryqht","nrljfdm","dztatif","lkehf","rmrox","rnntci","zhliree","rlfpo","dpdup","qhjspn","hpsqhi","wbnub","pwgkle","bldsutn","nhugm","llxvj","nkulvoy","aihuf","lqflwp","lekamz","fdnfln","fjtplf","zinbih","jvqovhr","ehmlp","qaprv","mdnfd","xjgon","nqsdbj","odrjtab","qzsjq","ripgmer","ljgsxt","sciqi","yaqykph","rfunhjy","abygu","ibldxl","fhsgodn","lnneny","clcemc","pviqaqg","ywpchy","baksyet","tnfmw","dkpvx","bykxod","qwzrn","kmrfrv","asxodt","yuismpd","cxfcrc","kbkioi","ivspipn","vmjcb","kpnotnf","jncttso","mvoexeu","gxgkb","ihpszdp","ihuzlsb","ztyzdp","gsvmymx","ldhfbb","wmjymr","gbcjub","ltxge","picika","qhjywi","ctxwfma","awnzi","cgdwc","gyfpuzr","taqohj","bdmeo","zwrsref","fhixq","drvryni","lmgsd","rihhz","twwhyy","bhzob","mwypg","nrmyzv","pmfvmst","mizvjy","tdsfg","weoma","ckrzl","zvcgqz","pjnuw","nqrde","qcnem","grhis","nqozqd","gefinct","ipmzvrp","rgiqruj","eoqdeva","dimxz","ixrhlpt","bfwkm","ufwjp","aoszp","ahpyp","hghcyv","rqlti","pcpnpo","efxyxdm","atgcrj","okadwcw","igavnan","bfxqc","tdvdr","zretcfp","siymap","tugzn","wulwhre","lmfqz","ixjsxwc","gsozyoj","bdolsf","korwx","fvlpk","kuebj","ublpu","ciglmvs","siwqcdx","xclnxlf","vdycdl","utsoyxq","ugjnsxj","hppqtce","ciijifs","mxbyw","ptwill","rbahig","twafrt","qgppawc","terobw","qcjpv","aauvybv","wjfbvx","hrmfd","ibtwu","bnrgqm","lrloxuk","rzippvx","cbjekyh","cggdym","czynzdj","qurxnfa","mclrra","byxfrrp","vcryit","umkva","zulxwp","sfvjsyl","lvosyl","mfjfprv","pudrmc","liineqn","jqrfff","apgrfu","xusxh","vbbla","unvsvm","zhaax","ztcnucd","iuhnod","meeglt","lyvaoq","pqjhuq","afsjig","mrnffa","vngwa","fveunc","vmvnx","wxdxosn","hfwybx","fmwna","qnbxae","rrmyoax","rnjhywy","vstnd","ewnllhr","wsvxenk","cbivijf","nysamc","zoyfna","uotmde","zkkrpmp","ttficz","rdnds","uveompq","emtbwb","drhwsf","bmkafp","yedpcow","untvymx","yyejqta","kcjakg","tdwmu","gecjncx","cxezgec","xonnszm","mecgvq","kdagva","ucewe","chsmeb","kscci","gzoia","ovdojr","mwgbxe","gibxxlt","mfgpo","jkhob","hwquiz","wvhfaia","sxhikny","dghcawc","phayky","shchy","mklvgh","yabxat","rkmrfs","pfhgrw","wtlxebg","mevefcq","uvhvgo","nldxkdz","dwybxh","ycmlybh","aqvod","tsvfhw","uhvuc","wcsxe","afyzus","jhfyk","vghpfv","nprfou","vsxmc","hiiiewc","uehpmz","jzffnr","twbuhn","ahrbzqv","rvmffb","vrmynfc","upnuka","jghpuse","dwrbkhv","nveuii","nefmnf","aowjzzo","yfcprb","ojihgh","jfnit","ovkpf","bhyqx","enyrhm","ljqxp","pzpfjr","qligbi","udoqp","naxqyjp","jriibb","iccscme","rhnwh","xfajbc","gopeq","kurqqru","qyzpd","twfaem","nopsy","yqcpwa","xzhoc","rwval","zqhyid","mnmaobk","bzsxfa","kmgqo","quxchux","mimqbx","djuok","injzi","nekayg","oiyytj","vgwdob","epmbtws","whwkeph","ddfwxo","nlobf","adrqb","lzzownl","iuhka","upfjos","kjiua","xjgud","qqqnwqc","bgvooqf","qjurybc","ufsnhxp","fjpkb","pztffxh","qeqcgg","tfills","rkmbus","wpsmuk","moqeh","nyiayg","bejhle","gszvfjw","fnskvxi","nhxyzxi","trwseu","jdnptzx","fiotq","xspgs","ddnyc","yhxjxus","hkwrzd","rmvsyi","eqbjf","gymahyo","vuxso","ekagz","vozvpu","euzcdla","qvernpp","seejev","tetez","eosct","fxuicyl","mwyzg","qeujko","gpnizxr","azxslf","faepd","nsvcr","rxcty","kmtnoe","tuwoxf","xewnebm","qlegtb","qxlust","qnlje","ptdlpvq","tjmwt","nddiu","qanqplx","kxckhbq","lvtyy","cqwdax","irvigyr","mpdqgvy","qbvysre","ezluyj","qshkht","fjxyezs","lquxor","rxtgdy","ezlzb","addqjj","fucytk","mmbjy","gtkjcnz","fourguz","ffhtah","yhyxwcm","svmofbn","gvzve","cizjcea","vkdtt","hdivkwt","utnjaf","svvrkeh","qyxpd","qlinqj","xvesol","bykuhwp","mjodd","trurbet","ahzxm","hkxhvo","bhccyxf","elobjqo","igdxmj","twkdf","gmogg","lzmljtj","jhgrq","ndiye","sgaaavr","mxxvrkm","vyvvi","pcafw","cverpds","bvpjmw","pcqzlg","fmwhf","ctviwh","tgmjzsd","uvtwwy","pbxhcmg","tbiwyru","efzimj","dcujj","lxbndb","ysbhy","lqwnjdz","ontmb","dfsxzto","ubwbyv","htjmvu","ahzxszy","ivttau","cfimiy","fkjfmw","gscep","bwdjojj","knwosp","gznvty","izgfoyl","zayof","jqjpk","vosohad","xjqtry","zdgvx","cbgvmn","iskhag","qdzxb","lfivyh","ltpzk","wexodoi","zheod","wtamnc","lnjhy","bwozgnh","dvdpsy","puayd","sogsxu","fzylgp","kotukif","pwfjx","vnecbvd","zgojjum","byuzv","lxwfio","enqpgs","lguax","ztfnyqt","bbbbrq","bfqcd","poalx","amyfb","rmuyan","anqopg","rovev","pafiqmd","uxjiaaz","kyskun","kdyzd","dnvyel","ljwmn","nosgpxo","wplvwil","orcwe","xhyuj","ogueh","taovv","zodzsc","rdiut","fiyny","qmwccp","oqgpqv","ipsmwz","rvnanf","vhjcem","hevsn","sxdsmg","zxerju","qqmvrn","jpqzy","yenlp","nmitc","bakwo","ixmrhxx","faypb","bbzsmgw","opulvn","qnugsr","kpidsbl","dukzjpq","bbybu","wjausnl","jmzkjv","uygdm","sejdzga","fxkyhn","xwgvw","oxxzvlr","kowjho","ipwkmjc","fjrxk","rrzkdgs","bxghaq","gbhoqa","xnaprd","vrjus","prpqp","zayukll","ieaarp","xfcozp","yofdlo","vquhofn","prlictl","akseu","fqlybv","crpvuzw","bsvzr","mwdcfdr","dhcmcu","hiocm","xivqrr","yvcmo","svwsfr","uwopkxy","ougre","yfpmzlw","ycsbch","wlrdnre","jrdhn","ssjkca","tndje","nzebm","ozyobeo","puerg","aaeqauo","gswil","iwcxgji","tauimn","kbpdwlk","vltzl","watqld","ghqrm","pkravau","mjfbxv","bzifdx","ufszjkr","xodqa","vopisyg","ppytrz","ioqlech","ixvtpg","sgpeoa","avsvj","iwobycm","ycnvobh","lnexix","fgogr","atdwdil","vcsbk","iopjwyx","moxoyua","vncee","cfqiwxh","ttbkbh","xearpw","jzfsl","shpxr","wyrrbm","imrjybd","adufra","msedvi","hgfyd","yofpdh","zjwycb","dcleww","ruacjb","yjwelwi","dagoiud","vavunu","xlxbcmc","urqksfd","tngbww","kwjhnl","gekdht","jlkzfgv","lexqhx","cnmynkc","ebenz","rwdopf","wnetkj","mcfbo","gtevzv","odvil","shkifu","aovbq","vibnyno","tcmlmkz","rfpgk","gohtjwc","mwmfeq","wzxmz","jyufim","bniivjc","mozrlzt","rcwje","nykfvh","ezglkh","nqkpvj","tyqwypw","udzlzyz","iixxey","dlyaq","ugksuyk","sxaco","tkpokn","ykglu","uwzorpp","fhuxz","dqfyv","xnlgoe","bpohjte","smlty","vhght","nmreqxa","reouy","abqju","ramtsu","ektbvhz","ercmpc","opchcx","ajhrj","hkvalb","ucngyjf","zoltae","ryjhfiv","lgjscrc","mnbkms","odbjs","ywbvys","jjcvh","vzkojje","ttohufl","gvnoaj","jkyhavl","czsbrxu","lhhrdn","nhmuatv","eityul","aabelb","limct","oooxwis","tmvxpv","xbeiqh","fcwcc","qjhdcq","wbyplq","zftnk","epcdy","kptee","qipzud","viytsl","bzhwvj","pmkpud","aqpunv","jsxetb","gxeljex","iaebpo","dihzj","zftby","vkzra","hejaidb","djvtqt","vazqo","iugtsp","lxvtoin","kwyxpwj","ehpnrp","iivjvkn","vdhwfj","afyavpl","yoiht","colenpr","iohrx","khuljuj","iwtjh","gnqncp","vdhwm","yhxfw","rsrig","qpgym","gbalr","gqhdmz","cxsimhf","muonsb","swfwyyi","ihnnk","hrzoc","uixhtym","rjjtpn","efzgwq","rubgndx","rffpmk","rllab","cyrfk","ssvoz","ttzhop","zhywy","utzix","oklvooj","kdslj","qjohyod","ulnqss","dppso","xhyjlff","elazc","qdimsq","ozzaprn","pusmfw","vqopa","fguvxwd","luerv","ylgvs","qixlgz","btwyq","exxthjr","gmcmk","vdovgma","uxaqwjn","rzdlo","yjknn","yrxygac","vocejbl","wnfki","aabtp","aohxnt","evgftbl","ppsraw","xwjin","bryhke","mhwlj","rnnfh","vfmsxq","znxzwm","yilmhgj","gqdvp","lnuln","ltjtpt","fhrhkcw","dvsalfh","soytv","kexst","sjblwo","wiblqa",
                "hzikex","cqjlf"};



        long startTime = System.currentTimeMillis();
        int result = minimumLengthEncoding(words);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}