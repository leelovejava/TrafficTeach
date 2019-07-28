<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1541639886140" ID="ID_173308664" MODIFIED="1542072722679" TEXT="Spark">
<node CREATED="1541639949776" FOLDED="true" ID="ID_831337030" MODIFIED="1542249190394" POSITION="right" TEXT="SparkCore">
<node CREATED="1541639957331" FOLDED="true" ID="ID_327920778" MODIFIED="1542072722426" TEXT="Spark">
<node CREATED="1541639962700" ID="ID_1596597568" MODIFIED="1541639982857" TEXT="Spark&#x57fa;&#x4e8e;&#x5185;&#x5b58;&#x7684;&#x8ba1;&#x7b97;&#x6846;&#x67b6;"/>
<node CREATED="1541639986594" FOLDED="true" ID="ID_1922901042" MODIFIED="1542072722421" TEXT="&#x4e0e;MR&#x7684;&#x533a;&#x522b;&#xff1f;">
<node CREATED="1541639991571" ID="ID_946932420" MODIFIED="1541640005563" TEXT="1.Spark&#x57fa;&#x4e8e;&#x5185;&#x5b58;&#x8fed;&#x4ee3;&#x8ba1;&#x7b97;&#xff0c;MR&#x662f;&#x57fa;&#x4e8e;&#x78c1;&#x76d8;&#x8fed;&#x4ee3;&#x8ba1;&#x7b97;"/>
<node CREATED="1541640006199" ID="ID_1516281874" MODIFIED="1541640014357" TEXT="2.Spark&#x4e2d;&#x6709;DAG&#x6709;&#x5411;&#x65e0;&#x73af;&#x56fe;"/>
<node CREATED="1541640021538" ID="ID_1694146644" MODIFIED="1541640125972" TEXT="3.MR&#x4e2d;&#x53ea;&#x6709;map &#x548c;reduce&#xff0c;&#x76f8;&#x5f53;&#x4e8e;Spark&#x4e2d;&#x4e24;&#x4e2a;&#x7b97;&#x5b50;&#x3010;map ,reduceByKey&#x3011; ,Spark&#x4e2d;&#x6709;&#x5404;&#x79cd;&#x7b97;&#x5b50;&#x5e94;&#x5bf9;&#x4e0d;&#x540c;&#x573a;&#x666f;"/>
</node>
</node>
<node CREATED="1541640153910" FOLDED="true" ID="ID_1093882473" MODIFIED="1542072722426" TEXT="Spark &#x6280;&#x672f;&#x6808;">
<node CREATED="1541640159297" ID="ID_1756040027" MODIFIED="1541640167031" TEXT="HDFS,MR,Yarn,Hive.."/>
<node CREATED="1541640167508" ID="ID_217316674" MODIFIED="1541640174866" TEXT="SparkCore"/>
<node CREATED="1541640178774" ID="ID_1059992569" MODIFIED="1541640181608" TEXT="SparkSQL"/>
<node CREATED="1541640181778" ID="ID_51375987" MODIFIED="1541640186546" TEXT="SparkStreaming"/>
</node>
<node CREATED="1541640137828" FOLDED="true" ID="ID_736340792" MODIFIED="1542072722426" TEXT="Spark &#x8fd0;&#x884c;&#x6a21;&#x5f0f;">
<node CREATED="1541640208941" ID="ID_244650307" MODIFIED="1541640249684" TEXT="local&#xff1a;&#x591a;&#x7528;&#x4e8e;&#x672c;&#x5730;&#x6d4b;&#x8bd5;&#xff0c;&#x4e00;&#x822c;&#x5728;Eclipse,IDEA&#x4e2d;&#x8fd0;&#x884c;&#x4f7f;&#x7528;local&#x6a21;&#x5f0f;"/>
<node CREATED="1541640250667" ID="ID_1276311107" MODIFIED="1541640345519" TEXT="Standalone:Spark&#x81ea;&#x5e26;&#x7684;&#x8d44;&#x6e90;&#x8c03;&#x5ea6;&#x6846;&#x67b6;&#xff0c;&#x652f;&#x6301;&#x5206;&#x5e03;&#x5f0f;&#x642d;&#x5efa;"/>
<node CREATED="1541640280829" ID="ID_163897507" MODIFIED="1541640302188" TEXT="Yarn : Hadoop&#x751f;&#x6001;&#x5708;&#x4e2d;&#x8d44;&#x6e90;&#x8c03;&#x5ea6;&#x6846;&#x67b6;&#xff0c;Spark&#x53ef;&#x4ee5;&#x57fa;&#x4e8e;Yarn&#x8fd0;&#x884c;"/>
<node CREATED="1541640303181" ID="ID_1980718415" MODIFIED="1541640313496" TEXT="Mesos:&#x8d44;&#x6e90;&#x8c03;&#x5ea6;&#x6846;&#x67b6;"/>
</node>
<node CREATED="1541640362542" FOLDED="true" ID="ID_1386736077" MODIFIED="1542072722426" TEXT="Spark &#x6838;&#x5fc3;RDD">
<node CREATED="1541640371572" ID="ID_850467102" MODIFIED="1541640382011" TEXT="RDD:&#x5f39;&#x6027;&#x5206;&#x5e03;&#x5f0f;&#x6570;&#x636e;&#x96c6;"/>
<node CREATED="1541640585671" ID="ID_1490116431" MODIFIED="1541640608834" TEXT="RDD&#x5185;&#x5176;&#x5b9e;&#x662f;&#x4e0d;&#x5b58;&#x6570;&#x636e;&#x7684;&#x3002;partition&#x4e5f;&#x662f;&#x4e0d;&#x5b58;&#x6570;&#x636e;&#x7684;&#x3002;"/>
<node CREATED="1541640382478" FOLDED="true" ID="ID_1360113290" MODIFIED="1542072722421" TEXT="RDD&#x7684;&#x4e94;&#x5927;&#x7279;&#x6027;">
<node CREATED="1541640386991" ID="ID_1708722096" MODIFIED="1541640398200" TEXT="1.RDD&#x662f;&#x7531;partition&#x7ec4;&#x6210;"/>
<node CREATED="1541640399272" ID="ID_150693251" MODIFIED="1541640415414" TEXT="2.&#x7b97;&#x5b50;&#xff08;&#x51fd;&#x6570;&#xff09;&#x4f5c;&#x7528;&#x5728;partition&#x4e0a;&#x7684;"/>
<node CREATED="1541640416779" ID="ID_772045563" MODIFIED="1541640421926" TEXT="3.RDD&#x4e4b;&#x95f4;&#x6709;&#x4f9d;&#x8d56;&#x5173;&#x7cfb;"/>
<node CREATED="1541640422087" ID="ID_403380446" MODIFIED="1541640434403" TEXT="4.&#x5206;&#x533a;&#x5668;&#x662f;&#x4f5c;&#x7528;&#x5728;K,V&#x683c;&#x5f0f;&#x7684;RDD&#x4e0a;"/>
<node CREATED="1541640434845" ID="ID_1843627337" MODIFIED="1541640455327" TEXT="5.partition&#x5bf9;&#x5916;&#x63d0;&#x4f9b;&#x6700;&#x4f73;&#x8ba1;&#x7b97;&#x4f4d;&#x7f6e;&#xff0c;&#x5229;&#x4e8e;&#x6570;&#x636e;&#x5904;&#x7406;&#x7684;&#x672c;&#x5730;&#x5316;"/>
</node>
<node CREATED="1541640457611" FOLDED="true" ID="ID_1045750108" MODIFIED="1542072722421" TEXT="&#x6ce8;&#x610f;&#xff1a;">
<node CREATED="1541640461121" ID="ID_1433119931" MODIFIED="1541640516295" TEXT="1.textFile &#x8bfb;&#x53d6;HDFS&#x6587;&#x4ef6;&#x7684;&#x65b9;&#x6cd5;&#x5e95;&#x5c42;&#x8c03;&#x7528;&#x7684;&#x662f;MR&#x8bfb;&#x53d6;HDFS&#x6587;&#x4ef6;&#x7684;&#x65b9;&#x6cd5;&#xff0c;&#x9996;&#x5148;split,&#x6bcf;&#x4e2a;split&#x5bf9;&#x5e94;&#x4e00;&#x4e2a;block,&#x6bcf;&#x4e2a;split&#x5bf9;&#x5e94;&#x4e00;&#x4e2a;partition"/>
<node CREATED="1541640517743" FOLDED="true" ID="ID_1084469354" MODIFIED="1542072722297" TEXT="2.&#x4ec0;&#x4e48;&#x662f;K,V&#x683c;&#x5f0f;&#x7684;RDD?">
<node CREATED="1541640527287" ID="ID_1315373681" MODIFIED="1541640537604" TEXT="RDD&#x4e2d;&#x7684;&#x6570;&#x636e;&#x662f;&#x4e00;&#x4e2a;&#x4e2a;&#x7684;&#x4e8c;&#x5143;&#x7ec4;"/>
</node>
<node CREATED="1541640538950" FOLDED="true" ID="ID_1074185300" MODIFIED="1542072722297" TEXT="3.&#x54ea;&#x91cc;&#x4f53;&#x73b0;&#x4e86;RDD&#x7684;&#x5f39;&#x6027;&#xff08;&#x5bb9;&#x9519;&#xff09;">
<node CREATED="1541640549291" ID="ID_146961993" MODIFIED="1541640557213" TEXT="1.RDD&#x7684;&#x5206;&#x533a;&#x53ef;&#x591a;&#x53ef;&#x5c11;"/>
<node CREATED="1541640557390" ID="ID_1356747374" MODIFIED="1541640562802" TEXT="2.RDD&#x4e4b;&#x95f4;&#x6709;&#x4f9d;&#x8d56;&#x5173;&#x7cfb;"/>
</node>
<node CREATED="1541640563992" FOLDED="true" ID="ID_446261347" MODIFIED="1542072722298" TEXT="4.&#x54ea;&#x91cc;&#x4f53;&#x73b0;&#x4e86;RDD&#x7684;&#x5206;&#x5e03;&#x5f0f;&#xff1f;">
<node CREATED="1541640573513" ID="ID_207685937" MODIFIED="1541640582037" TEXT="RDD&#x7684;partition&#x662f;&#x5206;&#x5e03;&#x5728;&#x591a;&#x4e2a;&#x8282;&#x70b9;&#x4e0a;&#x7684;"/>
</node>
</node>
</node>
<node CREATED="1541640322348" FOLDED="true" ID="ID_70504740" MODIFIED="1542072722427" TEXT="Spark &#x4ee3;&#x7801;&#x6d41;&#x7a0b;">
<node CREATED="1541640356839" ID="ID_1404850054" MODIFIED="1541640667540" TEXT="1.val conf = new SparkConf().setAppName...setMaster.."/>
<node CREATED="1541640653465" ID="ID_765861574" MODIFIED="1541640679030" TEXT="2.val sc = new SparkContext(conf)"/>
<node CREATED="1541640680082" ID="ID_939523334" MODIFIED="1541640688130" TEXT="3.&#x7531;sc&#x5f97;&#x5230;RDD"/>
<node CREATED="1541640688313" ID="ID_1814295023" MODIFIED="1541640701102" TEXT="4.&#x5bf9;RDD&#x4f7f;&#x7528;transformation&#x7c7b;&#x7b97;&#x5b50;&#x8fdb;&#x884c;&#x8f6c;&#x6362;"/>
<node CREATED="1541640702987" ID="ID_4867474" MODIFIED="1541640730483" TEXT="5.&#x5bf9;RDD&#x4f7f;&#x7528;Action&#x7b97;&#x5b50;&#x89e6;&#x53d1;Transformations&#x7c7b;&#x7b97;&#x5b50;&#x6267;&#x884c;"/>
<node CREATED="1541640731026" ID="ID_219227093" MODIFIED="1541640736315" TEXT="6.sc.stop()"/>
</node>
<node CREATED="1541640777382" FOLDED="true" ID="ID_1278475220" MODIFIED="1542157298952" TEXT="&#x7b97;&#x5b50;">
<node CREATED="1541640781085" FOLDED="true" ID="ID_1258158616" MODIFIED="1542157295487" TEXT="&#x8f6c;&#x6362;&#x7b97;&#x5b50;&#xff1a;Transformation&#xff0c;&#x61d2;&#x6267;&#x884c;&#xff0c;&#x9700;&#x8981;Action&#x89e6;&#x53d1;&#x6267;&#x884c;">
<node CREATED="1541640814993" ID="ID_1252267010" MODIFIED="1541640832899" TEXT="filter"/>
<node CREATED="1541640833082" ID="ID_1029852177" MODIFIED="1541640834022" TEXT="map"/>
<node CREATED="1541640834213" ID="ID_276837314" MODIFIED="1541640837140" TEXT="flatMap"/>
<node CREATED="1541640837311" ID="ID_447923128" MODIFIED="1541640840503" TEXT="mapToPair"/>
<node CREATED="1541640841587" ID="ID_944846884" MODIFIED="1541640844306" TEXT="sample"/>
<node CREATED="1541640844486" ID="ID_453564243" MODIFIED="1541640848745" TEXT="sortBy"/>
<node CREATED="1541640848917" ID="ID_1103092396" MODIFIED="1541640855332" TEXT="sortByKey"/>
<node CREATED="1541640855499" ID="ID_101482214" MODIFIED="1541640860015" TEXT="reduceByKey"/>
<node CREATED="1541640860187" ID="ID_1874875989" MODIFIED="1541666441009" TEXT="join"/>
<node CREATED="1541985862531" ID="ID_872250813" MODIFIED="1541985866920" TEXT="leftOuterJoin"/>
<node CREATED="1541985867097" ID="ID_1997220565" MODIFIED="1541985871034" TEXT="rightOuterJoin"/>
<node CREATED="1541985871216" ID="ID_2943373" MODIFIED="1541985875049" TEXT="fullOuterJoin"/>
<node CREATED="1541985877959" ID="ID_1409605229" MODIFIED="1541985879605" TEXT="union"/>
<node CREATED="1541985887868" ID="ID_1340279196" MODIFIED="1541985895913" TEXT="intersection"/>
<node CREATED="1541985897584" ID="ID_1596651787" MODIFIED="1541985901073" TEXT="subtract"/>
<node CREATED="1541985908304" ID="ID_136149767" MODIFIED="1541985915293" TEXT="mapPartitions"/>
<node CREATED="1541985916039" FOLDED="true" ID="ID_956024525" MODIFIED="1542072722315" TEXT="distinct ">
<node CREATED="1541985976346" ID="ID_1625129330" MODIFIED="1541985982901" TEXT="map + reduceByKey+map"/>
</node>
<node CREATED="1541985985261" FOLDED="true" ID="ID_79238379" MODIFIED="1542072722316" TEXT="cogroup">
<node CREATED="1541985990961" ID="ID_1212984955" MODIFIED="1541986023208" TEXT="(K,V) (K,W)=&gt;(K,([V],[W]))"/>
</node>
<node CREATED="1542072737660" ID="ID_993091292" MODIFIED="1542072744065" TEXT="mapPartitionsWithIndex"/>
<node CREATED="1542072732295" FOLDED="true" ID="ID_569234576" MODIFIED="1542072872772" TEXT="repartition">
<node CREATED="1542072754732" ID="ID_1472166506" MODIFIED="1542072766973" TEXT="&#x53ef;&#x4ee5;&#x589e;&#x591a;&#x5206;&#x533a;&#xff0c;&#x53ef;&#x4ee5;&#x51cf;&#x5c11;&#x5206;&#x533a;&#xff0c;&#x6709;shuffle"/>
<node CREATED="1542072767160" ID="ID_1046061663" MODIFIED="1542072781265" TEXT="repartition = coalesce(num,shuffle=true)"/>
</node>
<node CREATED="1542072747286" FOLDED="true" ID="ID_55303646" MODIFIED="1542072873299" TEXT="coalesce">
<node CREATED="1542072786363" ID="ID_91352733" MODIFIED="1542072805212" TEXT="&#x53ef;&#x4ee5;&#x589e;&#x591a;&#x5206;&#x533a;&#xff0c;&#x4e5f;&#x53ef;&#x4ee5;&#x51cf;&#x5c11;&#x5206;&#x533a;&#xff0c;&#x9ed8;&#x8ba4;&#x6ca1;&#x6709;shuffle"/>
<node CREATED="1542072805824" ID="ID_1702238532" MODIFIED="1542072828317" TEXT="&#x82e5;RDD&#x7531;&#x5c11;&#x7684;&#x5206;&#x533a;&#x5206;&#x5230;&#x591a;&#x7684;&#x5206;&#x533a;&#x65f6;&#xff0c;&#x4e0d;&#x8ba9;&#x4ea7;&#x751f;shuffle&#xff0c; &#x4e0d;&#x8d77;&#x4f5c;&#x7528;"/>
</node>
<node CREATED="1542072831704" ID="ID_1413137519" MODIFIED="1542072838590" TEXT="zip"/>
<node CREATED="1542072838772" ID="ID_144422910" MODIFIED="1542072843321" TEXT="zipWithIndex"/>
<node CREATED="1542072843499" ID="ID_603592261" MODIFIED="1542072847297" TEXT="groupByKey"/>
</node>
<node CREATED="1541640786947" FOLDED="true" ID="ID_199910301" MODIFIED="1542157298056" TEXT="&#x884c;&#x52a8;&#x7b97;&#x5b50;">
<node CREATED="1541640916039" ID="ID_1031644520" MODIFIED="1541640916521" TEXT="Action,&#x89e6;&#x53d1;transformation&#x7c7b;&#x7b97;&#x5b50;&#x6267;&#x884c;&#xff0c;&#x4e00;&#x4e2a;application&#x4e2d;&#x6709;&#x4e00;&#x4e2a;action&#x7b97;&#x5b50;&#x5c31;&#x6709;&#x4e00;&#x4e2a;job"/>
<node CREATED="1541640917398" FOLDED="true" ID="ID_634937269" MODIFIED="1542157296712" TEXT="Action&#x7b97;&#x5b50;">
<node CREATED="1541640926905" ID="ID_1784033103" MODIFIED="1541640930534" TEXT="foreach"/>
<node CREATED="1541640930727" FOLDED="true" ID="ID_364174616" MODIFIED="1542072722322" TEXT="count">
<node CREATED="1541640959465" ID="ID_1882891873" MODIFIED="1541640972482" TEXT="&#x7ed3;&#x679c;&#x4f1a;&#x62ff;&#x5230;Driver&#x7aef;"/>
</node>
<node CREATED="1541640932841" FOLDED="true" ID="ID_233705944" MODIFIED="1542072722322" TEXT="collect">
<node CREATED="1541640980444" ID="ID_577598332" MODIFIED="1541640988230" TEXT="&#x5c06;&#x7ed3;&#x679c;&#x62ff;&#x56de;Driver&#x7aef;"/>
</node>
<node CREATED="1541640934875" ID="ID_697320970" MODIFIED="1541640938951" TEXT="first"/>
<node CREATED="1541640939122" ID="ID_139627358" MODIFIED="1541640942385" TEXT="take(num)"/>
<node CREATED="1541640943062" ID="ID_1621891009" MODIFIED="1541986043061" TEXT="foreachPartition"/>
<node CREATED="1542072860441" ID="ID_1465960367" MODIFIED="1542072861746" TEXT="reduce"/>
<node CREATED="1542072861933" ID="ID_1668529571" MODIFIED="1542072864996" TEXT="countByKey"/>
<node CREATED="1542072865174" ID="ID_742954774" MODIFIED="1542072869317" TEXT="countByValue"/>
</node>
</node>
<node CREATED="1541640790177" FOLDED="true" ID="ID_1234601295" MODIFIED="1542072722422" TEXT="&#x6301;&#x4e45;&#x5316;&#x7b97;&#x5b50;">
<node CREATED="1541641454792" FOLDED="true" ID="ID_879652578" MODIFIED="1542072722343" TEXT="cache">
<node CREATED="1541641459161" ID="ID_1026078245" MODIFIED="1541641469134" TEXT="&#x9ed8;&#x8ba4;&#x5c06;&#x6570;&#x636e;&#x5b58;&#x50a8;&#x5728;&#x5185;&#x5b58;&#x4e2d;"/>
<node CREATED="1541642034884" ID="ID_404737020" MODIFIED="1541642083119" TEXT="cache() =  persist() = persist(StorageLevel.MEMORY_ONLY)"/>
</node>
<node CREATED="1541641978258" FOLDED="true" ID="ID_794530823" MODIFIED="1542072722344" TEXT="persist">
<node CREATED="1541641990520" ID="ID_1517916262" MODIFIED="1541642000843" TEXT="&#x53ef;&#x4ee5;&#x624b;&#x52a8;&#x6307;&#x5b9a;&#x6301;&#x4e45;&#x5316;&#x7ea7;&#x522b;"/>
<node CREATED="1541644822304" ID="ID_1432526622" MODIFIED="1541644828512" TEXT="MEMORY_ONLY"/>
<node CREATED="1541644837085" ID="ID_1275674247" MODIFIED="1541644843316" TEXT="MEMORY_ONLY_SER"/>
<node CREATED="1541644843798" ID="ID_1167022717" MODIFIED="1541644851678" TEXT="MEMORY_AND_DISK"/>
<node CREATED="1541644856831" ID="ID_1901916708" MODIFIED="1541644862907" TEXT="MEMORY_AND_DISK_SER"/>
<node CREATED="1541644873357" ID="ID_295149386" MODIFIED="1541644881896" TEXT="&quot;_2&quot; &#x662f;&#x7531;&#x526f;&#x672c;"/>
<node CREATED="1541644882068" ID="ID_128562008" MODIFIED="1541644895833" TEXT="&#x5c3d;&#x91cf;&#x5c11;&#x4f7f;&#x7528;DISK_ONLY&#x7ea7;&#x522b;"/>
</node>
<node CREATED="1541645087640" FOLDED="true" ID="ID_793418255" MODIFIED="1542072722344" TEXT="checkpoint">
<node CREATED="1541645091761" ID="ID_1978893733" MODIFIED="1541645193122" TEXT="&#x5c06;&#x6570;&#x636e;&#x76f4;&#x63a5;&#x6301;&#x4e45;&#x5316;&#x5230;&#x6307;&#x5b9a;&#x7684;&#x76ee;&#x5f55;&#xff0c;&#x5f53;lineage &#x8ba1;&#x7b97;&#x975e;&#x5e38;&#x590d;&#x6742;&#xff0c;&#x53ef;&#x4ee5;&#x5c1d;&#x8bd5;&#x4f7f;&#x7528;checkpoint ,checkpoint&#x8fd8;&#x53ef;&#x4ee5;&#x5207;&#x65ad;RDD&#x7684;&#x4f9d;&#x8d56;&#x5173;&#x7cfb;"/>
<node CREATED="1541645773883" ID="ID_511858689" MODIFIED="1541645799312" TEXT="&#x7279;&#x6b8a;&#x573a;&#x666f;&#x4f7f;&#x7528;checkpoint,&#x5bf9;RDD&#x4f7f;&#x7528;checkpoint&#x8981;&#x614e;&#x7528;"/>
<node CREATED="1541645824791" ID="ID_275901030" MODIFIED="1541645855222" TEXT="checkpoint&#x8981;&#x6307;&#x5b9a;&#x76ee;&#x5f55;&#xff0c;&#x53ef;&#x4ee5;&#x5c06;&#x6570;&#x636e;&#x6301;&#x4e45;&#x5316;&#x5230;&#x6307;&#x5b9a;&#x7684;&#x76ee;&#x5f55;&#x4e2d;&#xff0c;&#x5f53;application&#x6267;&#x884c;&#x5b8c;&#x6210;&#x4e4b;&#x540e;&#xff0c;&#x8fd9;&#x4e2a;&#x76ee;&#x5f55;&#x4e2d;&#x7684;&#x6570;&#x636e;&#x4e0d;&#x4f1a;&#x88ab;&#x6e05;&#x9664;"/>
<node CREATED="1541645890146" FOLDED="true" ID="ID_1287309638" MODIFIED="1542072722344" TEXT="checkpoint&#x7684;&#x6267;&#x884c;&#x6d41;&#x7a0b;">
<node CREATED="1541645898535" ID="ID_1289360698" MODIFIED="1541645931901" TEXT="1.&#x5f53;sparkjob&#x6267;&#x884c;&#x5b8c;&#x6210;&#x4e4b;&#x540e;&#xff0c;Spark &#x4f1a;&#x4ece;&#x540e;&#x5f80;&#x524d;&#x56de;&#x6eaf;&#xff0c;&#x627e;&#x5230;checkpointRDD&#x505a;&#x6807;&#x8bb0;"/>
<node CREATED="1541645932077" ID="ID_864244904" MODIFIED="1541645968897" TEXT="2.&#x56de;&#x6eaf;&#x5b8c;&#x6210;&#x4e4b;&#x540e;,Spark&#x6846;&#x67b6;&#x4f1a;&#x91cd;&#x65b0;&#x542f;&#x52a8;&#x4e00;&#x4e2a;job,&#x8ba1;&#x7b97;&#x6807;&#x8bb0;&#x7684;RDD&#x7684;&#x6570;&#x636e;&#xff0c;&#x653e;&#x5165;&#x6307;&#x5b9a;&#x7684;checkpoint&#x76ee;&#x5f55;&#x4e2d;"/>
<node CREATED="1541645977948" ID="ID_1108357458" MODIFIED="1541646028397" TEXT="3.&#x6570;&#x636e;&#x8ba1;&#x7b97;&#x5b8c;&#x6210;&#xff0c;&#x653e;&#x5165;&#x76ee;&#x5f55;&#x4e4b;&#x540e;&#xff0c;&#x4f1a;&#x5207;&#x65ad;RDD&#x7684;&#x4f9d;&#x8d56;&#x5173;&#x7cfb;&#xff0c;&#x5f53;SparkApplication&#x6267;&#x884c;&#x5b8c;&#x6210;&#x4e4b;&#x540e;&#xff0c;&#x6570;&#x636e;&#x76ee;&#x5f55;&#x4e2d;&#x7684;&#x6570;&#x636e;&#x4e0d;&#x4f1a;&#x88ab;&#x6e05;&#x9664;"/>
<node CREATED="1541646029555" ID="ID_98473920" MODIFIED="1541646087608" TEXT="&#x4f18;&#x5316;&#xff1a;&#x5bf9;&#x54ea;&#x4e2a;RDD&#x8fdb;&#x884c;checkpoint&#xff0c;&#x6700;&#x597d;&#x5148;cache&#x4e0b;&#xff0c;&#x8fd9;&#x6837;&#x56de;&#x6eaf;&#x5b8c;&#x6210;&#x540e;&#x518d;&#x8ba1;&#x7b97;&#x8fd9;&#x4e2a;CheckpointRDD&#x6570;&#x636e;&#x7684;&#x65f6;&#x5019;&#x53ef;&#x4ee5;&#x76f4;&#x63a5;&#x5728;&#x5185;&#x5b58;&#x4e2d;&#x62ff;&#x5230;&#x653e;&#x6307;&#x5b9a;&#x7684;&#x76ee;&#x5f55;&#x4e2d;"/>
</node>
</node>
<node CREATED="1541644909179" FOLDED="true" ID="ID_1089636099" MODIFIED="1542072722344" TEXT="cache&#x548c;persist&#x7684;&#x6ce8;&#x610f;">
<node CREATED="1541644920312" ID="ID_1962112723" MODIFIED="1541644962207" TEXT="1.cache,persist,checkpoint &#x90fd;&#x662f;&#x61d2;&#x6267;&#x884c;&#xff0c;&#x6700;&#x5c0f;&#x6301;&#x4e45;&#x5316;&#x5355;&#x4f4d;&#x662f;partition"/>
<node CREATED="1541644962769" ID="ID_1930826072" MODIFIED="1541644987225" TEXT="2.cache&#x548c;persist&#x4e4b;&#x540e;&#x53ef;&#x4ee5;&#x76f4;&#x63a5;&#x8d4b;&#x503c;&#x7ed9;&#x4e00;&#x4e2a;&#x503c;&#xff0c;&#x4e0b;&#x6b21;&#x76f4;&#x63a5;&#x4f7f;&#x7528;&#x8fd9;&#x4e2a;&#x503c;&#xff0c;&#x5c31;&#x662f;&#x4f7f;&#x7528;&#x7684;&#x6301;&#x4e45;&#x5316;&#x7684;&#x6570;&#x636e;"/>
<node CREATED="1541644995330" ID="ID_1006128284" MODIFIED="1541645056558" TEXT="3.&#x5982;&#x679c;&#x91c7;&#x7528;&#x7b2c;&#x4e8c;&#x79cd;&#x65b9;&#x5f0f;&#xff0c;&#x540e;&#x9762;&#x4e0d;&#x80fd;&#x7d27;&#x8ddf;action&#x7b97;&#x5b50;"/>
<node CREATED="1541645105514" ID="ID_780211739" MODIFIED="1541645124094" TEXT="4.cache&#x548c;persist&#x7684;&#x6570;&#x636e;&#xff0c;&#x5f53;application&#x6267;&#x884c;&#x5b8c;&#x6210;&#x4e4b;&#x540e;&#x4f1a;&#x81ea;&#x52a8;&#x6e05;&#x9664;"/>
</node>
</node>
</node>
<node CREATED="1541657418614" FOLDED="true" ID="ID_983650891" MODIFIED="1542072722427" TEXT="&#x521b;&#x5efa;RDD&#x65b9;&#x5f0f;">
<node CREATED="1541657427436" ID="ID_1840977425" MODIFIED="1541657430955" TEXT="textFile..."/>
<node CREATED="1541657431122" ID="ID_886145976" MODIFIED="1541657434002" TEXT="parallelize"/>
<node CREATED="1541657434173" ID="ID_440626784" MODIFIED="1541657438556" TEXT="makeRDD"/>
</node>
<node CREATED="1541658703955" FOLDED="true" ID="ID_42275152" MODIFIED="1542072722427" TEXT="Spark &#x96c6;&#x7fa4;&#x642d;&#x5efa;">
<node CREATED="1541658708146" FOLDED="true" ID="ID_1245694895" MODIFIED="1542072722422" TEXT="Standalone&#x96c6;&#x7fa4;&#x642d;&#x5efa;">
<node CREATED="1541984744149" ID="ID_731389955" MODIFIED="1541984752327" TEXT="1.&#x4e0a;&#x4f20;&#x89e3;&#x538b;&#x5305;"/>
<node CREATED="1541984752502" ID="ID_1517011650" MODIFIED="1541984762803" TEXT="2.&#x914d;&#x7f6e;slaves &#x6587;&#x4ef6;&#xff0c;&#x914d;&#x7f6e;worker&#x4fe1;&#x606f;"/>
<node CREATED="1541984763813" FOLDED="true" ID="ID_205612953" MODIFIED="1542072722357" TEXT="3.&#x914d;&#x7f6e;spark-env.sh &#x6587;&#x4ef6;">
<node CREATED="1541984776006" ID="ID_1492814821" MODIFIED="1541984846258" TEXT="SPARK_MASTER_HOST=node1"/>
<node CREATED="1541984793121" ID="ID_1975706217" MODIFIED="1541984805955" TEXT="SPARK_MASTER_PORT=7077"/>
<node CREATED="1541984807150" ID="ID_337622108" MODIFIED="1541984815494" TEXT="SPARK_WORKER_CORES=2"/>
<node CREATED="1541984816763" ID="ID_1127104135" MODIFIED="1541984828689" TEXT="SPARK_WORKER_MEMORY=3g"/>
</node>
<node CREATED="1541984867446" ID="ID_1159862601" MODIFIED="1541984880352" TEXT="4.&#x5206;&#x53d1;&#x5230;worker&#x8282;&#x70b9;"/>
<node CREATED="1541984880528" ID="ID_51363652" MODIFIED="1541984899017" TEXT="5.&#x5728;Master&#x8282;&#x70b9; ../sbin/start-all.sh &#x542f;&#x52a8;&#x96c6;&#x7fa4;"/>
</node>
<node CREATED="1541658719603" FOLDED="true" ID="ID_556701835" MODIFIED="1542072722423" TEXT="&#x642d;&#x5efa;&#x4e00;&#x4e2a;&#x5ba2;&#x6237;&#x7aef;">
<node CREATED="1541984944786" ID="ID_723430850" MODIFIED="1541984970649" TEXT="&#x539f;&#x5c01;&#x4e0d;&#x52a8;&#x5c06;&#x5b89;&#x88c5;&#x5305;&#x53d1;&#x9001;&#x5230;&#x4e00;&#x53f0;&#x65b0;&#x7684;&#x8282;&#x70b9;&#xff0c;&#x5728;&#x8fd9;&#x5929;&#x8282;&#x70b9;&#x4e0a;&#x63d0;&#x4ea4;&#x4efb;&#x52a1;&#x3002;"/>
</node>
<node CREATED="1541658726263" FOLDED="true" ID="ID_860683065" MODIFIED="1542072722423" TEXT="&#x57fa;&#x4e8e;yarn&#x63d0;&#x4ea4;&#x4efb;&#x52a1;">
<node CREATED="1541984977956" FOLDED="true" ID="ID_14535388" MODIFIED="1542072722357" TEXT="&#x5728;&#x63d0;&#x4ea4;&#x4efb;&#x52a1;&#x8282;&#x70b9;&#x4e0a;../conf/spark-env.sh &#x4e2d;&#x914d;&#x7f6e; ">
<node CREATED="1541985005341" ID="ID_1487997700" MODIFIED="1541985027587" TEXT="HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop"/>
</node>
</node>
</node>
<node CREATED="1541984914798" FOLDED="true" ID="ID_776819412" MODIFIED="1542072722427" TEXT="Spark PI &#x4efb;&#x52a1;&#x63d0;&#x4ea4;">
<node CREATED="1541984922378" ID="ID_1824157190" MODIFIED="1541984940024" TEXT="./spark-submit --master spark://node1:7077 --class ...jar ..."/>
</node>
<node CREATED="1541985063302" FOLDED="true" ID="ID_942605251" MODIFIED="1542072722427" TEXT="Spark &#x4efb;&#x52a1;&#x63d0;&#x4ea4;">
<node CREATED="1541985069047" FOLDED="true" ID="ID_114698390" MODIFIED="1542072722423" TEXT="standalone ">
<node CREATED="1541985092455" FOLDED="true" ID="ID_1815869163" MODIFIED="1541985843389" TEXT="client">
<node CREATED="1541985104667" FOLDED="true" ID="ID_1119864116" MODIFIED="1542072722362" TEXT="&#x547d;&#x4ee4;">
<node CREATED="1541985111522" ID="ID_1534162610" MODIFIED="1541985129775" TEXT="./spark-submit --master spark://node:port --class ...jar "/>
<node CREATED="1541985129972" ID="ID_1520972850" MODIFIED="1541985146379" TEXT="./spark-submit --master spark://node:port --deploy-mode client --class ..jar "/>
</node>
<node CREATED="1541985150067" FOLDED="true" ID="ID_1066180869" MODIFIED="1542072722362" TEXT="&#x8fc7;&#x7a0b;">
<node CREATED="1541985153833" ID="ID_423936030" MODIFIED="1541985170798" TEXT="1.&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x63d0;&#x4ea4;Spark application &#xff0c;Driver&#x9996;&#x5148;&#x4f1a;&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x542f;&#x52a8;"/>
<node CREATED="1541985170971" ID="ID_361520934" MODIFIED="1541985202787" TEXT="2.&#x5ba2;&#x6237;&#x7aef;&#x5411;Maste&#x7533;&#x8bf7;&#x8d44;&#x6e90;&#xff0c;Master &#x4f1a;&#x627e;&#x5230;&#x6ee1;&#x8db3;&#x8d44;&#x6e90;&#x7684;worker&#x8282;&#x70b9;&#xff0c;&#x542f;&#x52a8;Executor"/>
<node CREATED="1541985209901" ID="ID_1785649724" MODIFIED="1541985238800" TEXT="3.Exeuctor&#x542f;&#x52a8;&#x4e4b;&#x540e;&#xff0c;&#x4f1a;&#x53cd;&#x5411;&#x6ce8;&#x518c;&#x7ed9;Driver,Driver&#x53d1;&#x9001;task,&#x76d1;&#x63a7;task &#xff0c;&#x56de;&#x6536;&#x7ed3;&#x679c;"/>
</node>
<node CREATED="1541985275806" FOLDED="true" ID="ID_732373831" MODIFIED="1542072722362" TEXT="&#x6ce8;&#x610f;">
<node CREATED="1541985287808" ID="ID_1851644247" MODIFIED="1541985326583" TEXT="client &#x6a21;&#x5f0f;&#x9002;&#x7528;&#x4e8e;&#x7a0b;&#x5e8f;&#x6d4b;&#x8bd5;&#xff0c;&#x4e0d;&#x9002;&#x7528;&#x4e8e;&#x751f;&#x4ea7;&#x73af;&#x5883;&#xff0c;&#x5f53;&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x63d0;&#x4ea4;&#x591a;&#x4e2a;application&#x65f6;&#xff0c;&#x6709;&#x7f51;&#x5361;&#x6d41;&#x91cf;&#x6fc0;&#x589e;&#x7684;&#x95ee;&#x9898;&#x3002;&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x53ef;&#x4ee5;&#x770b;&#x5230;task&#x7684;&#x6267;&#x884c;&#x548c;&#x7ed3;&#x679c;"/>
</node>
</node>
<node CREATED="1541985095370" FOLDED="true" ID="ID_178776036" MODIFIED="1541985842522" TEXT="cluster">
<node CREATED="1541985330874" FOLDED="true" ID="ID_613747449" MODIFIED="1542072722362" TEXT="&#x547d;&#x4ee4;">
<node CREATED="1541985333212" ID="ID_1547546027" MODIFIED="1541985358417" TEXT="./spark-submit --master spark://node:port --deploy-mode cluster --class jar .."/>
</node>
<node CREATED="1541985361607" FOLDED="true" ID="ID_1257946273" MODIFIED="1542072722363" TEXT="&#x8fc7;&#x7a0b;">
<node CREATED="1541985364933" ID="ID_734828925" MODIFIED="1541985411964" TEXT="1.&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x63d0;&#x4ea4;spark application&#xff0c;&#x9996;&#x5148;&#x5ba2;&#x6237;&#x7aef;&#x4f1a;&#x5411;Mater&#x7533;&#x8bf7;&#x542f;&#x52a8;Driver&#xff0c;Master&#x968f;&#x673a;&#x627e;&#x5230;&#x4e00;&#x53f0;&#x6ee1;&#x8db3;&#x8d44;&#x6e90;&#x7684;Worker&#x542f;&#x52a8;Driver"/>
<node CREATED="1541985400884" ID="ID_545214774" MODIFIED="1541985450411" TEXT="2.Driver &#x5411;Master &#x7533;&#x8bf7;&#x8d44;&#x6e90;&#xff0c;Master &#x627e;&#x5230;&#x6ee1;&#x8db3;&#x8d44;&#x6e90;&#x7684;&#x8282;&#x70b9;&#x542f;&#x52a8;Executor&#xff0c;Executor&#x542f;&#x52a8;&#x4e4b;&#x540e;&#x4f1a;&#x53cd;&#x5411;&#x6ce8;&#x518c;&#x7ed9;Driver "/>
<node CREATED="1541985450581" ID="ID_239011407" MODIFIED="1541985465880" TEXT="3.Driver &#x53d1;&#x9001;task ,&#x76d1;&#x63a7;task ,&#x56de;&#x6536;&#x7ed3;&#x679c;"/>
</node>
<node CREATED="1541985275806" FOLDED="true" ID="ID_211727373" MODIFIED="1542072722363" TEXT="&#x6ce8;&#x610f;">
<node CREATED="1541985287808" ID="ID_1981131169" MODIFIED="1541985504936" TEXT="cluster &#x6a21;&#x5f0f;&#x9002;&#x7528;&#x4e8e;&#x751f;&#x4ea7;&#x73af;&#x5883;&#xff0c;&#x5f53;&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x63d0;&#x4ea4;&#x591a;&#x4e2a;application&#x65f6;&#xff0c;&#x5c06;&#x7f51;&#x5361;&#x6d41;&#x91cf;&#x6fc0;&#x589e;&#x7684;&#x95ee;&#x9898;&#x5206;&#x6563;&#x5230;&#x96c6;&#x7fa4;&#x4e2d;&#x3002;&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x53ef;&#x4ee5;&#x770b;&#x4e0d;&#x5230;task&#x7684;&#x6267;&#x884c;&#x548c;&#x7ed3;&#x679c;&#xff0c;&#x8981;&#x53bb;webui&#x4e2d;&#x67e5;&#x770b;"/>
</node>
</node>
</node>
<node CREATED="1541985074021" FOLDED="true" ID="ID_1968110728" MODIFIED="1542072722423" TEXT="yarn">
<node CREATED="1541985092455" FOLDED="true" ID="ID_75657293" MODIFIED="1541985850475" TEXT="client">
<node CREATED="1541985514903" FOLDED="true" ID="ID_611848996" MODIFIED="1541985844443" TEXT="&#x547d;&#x4ee4;">
<node CREATED="1541985518745" ID="ID_1146104022" MODIFIED="1541985530729" TEXT="./spark-submit --master yarn --class ...jar ..."/>
<node CREATED="1541985530892" ID="ID_854389731" MODIFIED="1541985541664" TEXT="./spark-submit --master yarn-client --class ..jar .."/>
<node CREATED="1541985541907" ID="ID_307073264" MODIFIED="1541985557691" TEXT="./spark-submit --master yarn --deploy-mode client --class ..jar ..."/>
</node>
<node CREATED="1541985560322" FOLDED="true" ID="ID_1999430531" MODIFIED="1541985845026" TEXT="&#x8fc7;&#x7a0b;">
<node CREATED="1541985564576" ID="ID_442204022" MODIFIED="1541985589561" TEXT="1.&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x63d0;&#x4ea4;Application&#xff0c; &#x9996;&#x5148;Driver&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x542f;&#x52a8;"/>
<node CREATED="1541985590134" ID="ID_1353705319" MODIFIED="1541985628585" TEXT="2.&#x5ba2;&#x6237;&#x7aef;&#x5411;RS&#x7533;&#x8bf7;&#x542f;&#x52a8;AM&#xff0c;RS&#x6536;&#x5230;&#x8bf7;&#x6c42;&#x4e4b;&#x540e;&#xff0c;&#x968f;&#x673a;&#x5728;&#x4e00;&#x53f0;NM&#x4e2d;&#x542f;&#x52a8;AM"/>
<node CREATED="1541985628751" ID="ID_1572848433" MODIFIED="1541985643196" TEXT="3.AM&#x542f;&#x52a8;&#x4e4b;&#x540e;&#xff0c;&#x4f1a;&#x5411;RS&#x7533;&#x8bf7;&#x8d44;&#x6e90;&#xff0c;&#x7528;&#x4e8e;&#x542f;&#x52a8;Executor"/>
<node CREATED="1541985643377" ID="ID_1154952981" MODIFIED="1541985661424" TEXT="4.RS&#x8fd4;&#x56de;&#x4e00;&#x6279;NM,AM&#x8fde;&#x63a5;&#x8fd9;&#x4e9b;NM&#x542f;&#x52a8;Executor"/>
<node CREATED="1541985661832" ID="ID_774717918" MODIFIED="1541985672975" TEXT="5.Executor&#x542f;&#x52a8;&#x4e4b;&#x540e;&#xff0c;&#x4f1a;&#x53cd;&#x5411;&#x6ce8;&#x518c;&#x7ed9;Driver"/>
<node CREATED="1541985673152" ID="ID_1146974142" MODIFIED="1541985684893" TEXT="6.Driver&#x53d1;&#x9001;task &#xff0c;&#x76d1;&#x63a7;task&#xff0c;&#x56de;&#x6536;&#x7ed3;&#x679c;"/>
</node>
<node CREATED="1541985275806" FOLDED="true" ID="ID_102547022" MODIFIED="1541985846483" TEXT="&#x6ce8;&#x610f;">
<node CREATED="1541985287808" ID="ID_750216051" MODIFIED="1541985326583" TEXT="client &#x6a21;&#x5f0f;&#x9002;&#x7528;&#x4e8e;&#x7a0b;&#x5e8f;&#x6d4b;&#x8bd5;&#xff0c;&#x4e0d;&#x9002;&#x7528;&#x4e8e;&#x751f;&#x4ea7;&#x73af;&#x5883;&#xff0c;&#x5f53;&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x63d0;&#x4ea4;&#x591a;&#x4e2a;application&#x65f6;&#xff0c;&#x6709;&#x7f51;&#x5361;&#x6d41;&#x91cf;&#x6fc0;&#x589e;&#x7684;&#x95ee;&#x9898;&#x3002;&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x53ef;&#x4ee5;&#x770b;&#x5230;task&#x7684;&#x6267;&#x884c;&#x548c;&#x7ed3;&#x679c;"/>
</node>
</node>
<node CREATED="1541985095370" FOLDED="true" ID="ID_840473096" MODIFIED="1541985849875" TEXT="cluster">
<node CREATED="1541985695758" FOLDED="true" ID="ID_1818994604" MODIFIED="1541985849322" TEXT="&#x547d;&#x4ee4;">
<node CREATED="1541985697927" ID="ID_901745418" MODIFIED="1541985713021" TEXT="./spark-submit --master yarn-cluster --class ..jar .."/>
<node CREATED="1541985713198" ID="ID_318419292" MODIFIED="1541985729402" TEXT="./spark-submit --master yarn --deploy-mode cluster --class .jar "/>
</node>
<node CREATED="1541985731322" FOLDED="true" ID="ID_1418816099" MODIFIED="1541985847963" TEXT="&#x8fc7;&#x7a0b;">
<node CREATED="1541985564576" ID="ID_572683154" MODIFIED="1541985753671" TEXT="1.&#x5728;&#x5ba2;&#x6237;&#x7aef;&#x63d0;&#x4ea4;Application&#xff0c;&#x5ba2;&#x6237;&#x7aef;&#x9996;&#x5148;&#x5411;RS&#x7533;&#x8bf7;&#x542f;&#x52a8;AM&#xff0c;RS&#x6536;&#x5230;&#x8bf7;&#x6c42;&#x4e4b;&#x540e;&#xff0c;&#x968f;&#x673a;&#x5728;&#x4e00;&#x53f0;NM&#x4e2d;&#x542f;&#x52a8;AM"/>
<node CREATED="1541985628751" ID="ID_50043661" MODIFIED="1541985768054" TEXT="2.AM&#x542f;&#x52a8;&#x4e4b;&#x540e;&#xff08;Driver&#xff09;&#xff0c;&#x4f1a;&#x5411;RS&#x7533;&#x8bf7;&#x8d44;&#x6e90;&#xff0c;&#x7528;&#x4e8e;&#x542f;&#x52a8;Executor"/>
<node CREATED="1541985643377" ID="ID_1015633083" MODIFIED="1541985775408" TEXT="3.RS&#x8fd4;&#x56de;&#x4e00;&#x6279;NM,AM&#x8fde;&#x63a5;&#x8fd9;&#x4e9b;NM&#x542f;&#x52a8;Executor"/>
<node CREATED="1541985661832" ID="ID_1320000258" MODIFIED="1541985790153" TEXT="4.Executor&#x542f;&#x52a8;&#x4e4b;&#x540e;&#xff0c;&#x4f1a;&#x53cd;&#x5411;&#x6ce8;&#x518c;&#x7ed9;AM(Driver)"/>
<node CREATED="1541985673152" ID="ID_1458163676" MODIFIED="1541985801110" TEXT="5.AM(Driver)&#x53d1;&#x9001;task &#xff0c;&#x76d1;&#x63a7;task&#xff0c;&#x56de;&#x6536;&#x7ed3;&#x679c;"/>
</node>
</node>
</node>
</node>
<node CREATED="1542071019753" FOLDED="true" ID="ID_593568026" MODIFIED="1542072722428" TEXT="&#x672f;&#x8bed;">
<node CREATED="1542071029386" FOLDED="true" ID="ID_473489677" MODIFIED="1542072722423" TEXT="&#x8d44;&#x6e90;&#x5c42;&#x9762;">
<node CREATED="1542071065164" ID="ID_229459034" MODIFIED="1542071083756" TEXT="Master-&gt;Worker-&gt;Executor-&gt;ThreadPool"/>
</node>
<node CREATED="1542071058047" FOLDED="true" ID="ID_459154434" MODIFIED="1542072722423" TEXT="&#x4efb;&#x52a1;&#x5c42;&#x9762;">
<node CREATED="1542071089290" ID="ID_1212886336" MODIFIED="1542071108832" TEXT="Application-&gt;job-&gt;stage-&gt;tasks"/>
</node>
</node>
<node CREATED="1542071134042" FOLDED="true" ID="ID_1893029448" MODIFIED="1542072722428" TEXT="RDD&#x7684;&#x5bbd;&#x7a84;&#x4f9d;&#x8d56;">
<node CREATED="1542071139888" FOLDED="true" ID="ID_637207723" MODIFIED="1542072722424" TEXT="&#x5bbd;&#x4f9d;&#x8d56;&#xff08;shuffle&#xff09;">
<node CREATED="1542071148155" ID="ID_410019608" MODIFIED="1542071164399" TEXT="&#x7236;RDD&#x4e0e;&#x5b50;RDD partitiion&#x4e4b;&#x95f4;&#x7684;&#x5173;&#x7cfb;&#x662f;&#x4e00;&#x5bf9;&#x591a;"/>
</node>
<node CREATED="1542071143723" FOLDED="true" ID="ID_1326105459" MODIFIED="1542072722424" TEXT="&#x7a84;&#x4f9d;&#x8d56;">
<node CREATED="1542071172584" ID="ID_1654031180" MODIFIED="1542071186854" TEXT="&#x7236;RDD&#x4e0e;&#x5b50;RDD partition&#x4e4b;&#x95f4;&#x7684;&#x5173;&#x7cfb;&#x662f;&#x4e00;&#x5bf9;&#x4e00;"/>
<node CREATED="1542071187679" ID="ID_567040884" MODIFIED="1542071193520" TEXT="&#x7236;RDD&#x4e0e;&#x5b50;RDD partition&#x4e4b;&#x95f4;&#x7684;&#x5173;&#x7cfb;&#x662f;&#x591a;&#x5bf9;&#x4e00;"/>
</node>
</node>
<node CREATED="1542071203193" FOLDED="true" ID="ID_1996837294" MODIFIED="1542072722428" TEXT="Stage">
<node CREATED="1542071207426" ID="ID_1127218498" MODIFIED="1542071215820" TEXT="&#x7531;&#x4e00;&#x7ec4;&#x5e76;&#x884c;&#x7684;task&#x7ec4;&#x6210;"/>
<node CREATED="1542071269701" ID="ID_767515210" MODIFIED="1542071285216" TEXT="RDD&#x4e0d;&#x5b58;&#x6570;&#x636e;&#xff0c;Partition&#x4e2d;&#x5b58;&#x7684;&#x662f;&#x903b;&#x8f91;"/>
<node CREATED="1542071467927" ID="ID_1782289880" MODIFIED="1542071487076" TEXT="RDD&#x4e4b;&#x95f4;&#x6709;&#x5bbd;&#x4f9d;&#x8d56;&#x4f1a;&#x5212;&#x5206;stage"/>
<node CREATED="1542071251971" ID="ID_776171331" MODIFIED="1542071267893" TEXT="Spark&#x8ba1;&#x7b97;&#x6a21;&#x5f0f;pipeline&#x7ba1;&#x9053;&#x8ba1;&#x7b97;&#x6a21;&#x5f0f;"/>
<node CREATED="1542071338173" FOLDED="true" ID="ID_1378374640" MODIFIED="1542072722424" TEXT="&#x7ba1;&#x9053;&#x4e2d;&#x7684;&#x6570;&#x636e;&#x4f55;&#x65f6;&#x843d;&#x5730;&#xff1f;">
<node CREATED="1542071345594" ID="ID_187000699" MODIFIED="1542071350707" TEXT="1.shuffle write&#x65f6;"/>
<node CREATED="1542071350970" ID="ID_382810681" MODIFIED="1542071357824" TEXT="2.&#x5bf9;RDD&#x8fdb;&#x884c;&#x6301;&#x4e45;&#x5316;&#x65f6;"/>
</node>
<node CREATED="1542071359510" ID="ID_1872901135" MODIFIED="1542071386162" TEXT="stage&#x7684;&#x5e76;&#x884c;&#x5ea6;&#x7531;stage&#x4e2d;finalRDD partition &#x4e2a;&#x6570;&#x51b3;&#x5b9a;"/>
<node CREATED="1542071390243" FOLDED="true" ID="ID_322707225" MODIFIED="1542072722424" TEXT="&#x5982;&#x4f55;&#x63d0;&#x9ad8;stage&#x7684;&#x5e76;&#x884c;&#x5ea6;&#xff1f;">
<node CREATED="1542071398012" ID="ID_1852516891" MODIFIED="1542071404760" TEXT="&#x589e;&#x5927;RDDpartition&#x7684;&#x4e2a;&#x6570;"/>
<node CREATED="1542071404987" ID="ID_1810456817" MODIFIED="1542071411480" TEXT="reduceByKey"/>
<node CREATED="1542071411648" ID="ID_87931625" MODIFIED="1542071413200" TEXT="distinct"/>
<node CREATED="1542071413381" ID="ID_569315256" MODIFIED="1542071414986" TEXT="join"/>
<node CREATED="1542071415168" ID="ID_753054570" MODIFIED="1542071417892" TEXT="repartition"/>
</node>
</node>
<node CREATED="1542071590505" FOLDED="true" ID="ID_341813647" MODIFIED="1542072722428" TEXT="Spark&#x7684;&#x8d44;&#x6e90;&#x8c03;&#x5ea6;&#x548c;&#x4efb;&#x52a1;&#x8c03;&#x5ea6;">
<node CREATED="1542071650016" FOLDED="true" ID="ID_960830185" MODIFIED="1542072722424" TEXT="&#x8d44;&#x6e90;&#x8c03;&#x5ea6;">
<node CREATED="1542071660992" ID="ID_584801744" MODIFIED="1542071676986" TEXT="1.&#x96c6;&#x7fa4;&#x542f;&#x52a8;&#xff0c;Worker&#x5411;Master&#x6c47;&#x62a5;&#x8d44;&#x6e90;&#xff0c;Master&#x638c;&#x63e1;&#x96c6;&#x7fa4;&#x8d44;&#x6e90;"/>
<node CREATED="1542071677237" ID="ID_1320718885" MODIFIED="1542071704298" TEXT="2.&#x5f53;&#x4ee3;&#x7801;new SparkContext&#x65f6;&#xff0c;&#x4f1a;&#x521b;&#x5efa;DAGScheduler&#x548c;TaskScheduler"/>
<node CREATED="1542071706322" ID="ID_1592327340" MODIFIED="1542071757407" TEXT="3.TaskScheduler &#x5411;Master&#x7533;&#x8bf7;&#x8d44;&#x6e90;"/>
<node CREATED="1542071757705" ID="ID_73235848" MODIFIED="1542071768020" TEXT="4.Master &#x627e;&#x5230;&#x6ee1;&#x8db3;&#x8d44;&#x6e90;&#x7684;&#x8282;&#x70b9;&#xff0c;&#x542f;&#x52a8;Executor"/>
<node CREATED="1542071768176" ID="ID_988522960" MODIFIED="1542071794644" TEXT="5.Exeuctor&#x542f;&#x52a8;&#x4e4b;&#x540e;&#x53cd;&#x5411;&#x6ce8;&#x518c;&#x7ed9;Driver,Driver&#x638c;&#x63e1;&#x4e86;&#x4e00;&#x6279;&#x8ba1;&#x7b97;&#x8d44;&#x6e90;"/>
</node>
<node CREATED="1542071656151" FOLDED="true" ID="ID_1873071971" MODIFIED="1542072722424" TEXT="&#x4efb;&#x52a1;&#x8c03;&#x5ea6;">
<node CREATED="1542071796671" ID="ID_414099401" MODIFIED="1542071820904" TEXT="6.action&#x7b97;&#x5b50;&#x89e6;&#x53d1;job,job&#x4e2d;RDD&#x4e4b;&#x95f4;&#x7684;&#x4f9d;&#x8d56;&#x5173;&#x7cfb;&#x5f62;&#x6210;DAG&#x6709;&#x5411;&#x65e0;&#x73af;&#x56fe;"/>
<node CREATED="1542071821105" ID="ID_1057530228" MODIFIED="1542071860256" TEXT="7.DAGScheduler &#x6309;&#x7167;RDD&#x4e4b;&#x95f4;&#x7684;&#x5bbd;&#x7a84;&#x4f9d;&#x8d56;&#x5173;&#x7cfb;&#xff0c;&#x5207;&#x5272;&#x6bcf;&#x4e2a;job&#xff0c;&#x5212;&#x5206;stage&#xff0c;&#x5c06;stage&#x4ee5;TaskSet&#x5f62;&#x5f0f;&#x63d0;&#x4ea4;&#x7ed9;TaskScheduler"/>
<node CREATED="1542071860453" ID="ID_493654154" MODIFIED="1542071893052" TEXT="8.TaskScheduler&#x904d;&#x5386;TaskSet,&#x62ff;&#x5230;&#x4e00;&#x4e2a;&#x4e2a;&#x7684;Task&#xff0c;&#x53d1;&#x9001;&#x5230;Executor&#x4e2d;&#x7684;&#x7ebf;&#x7a0b;&#x6c60;&#x4e2d;&#x6267;&#x884c;"/>
<node CREATED="1542071896118" ID="ID_1078136961" MODIFIED="1542071906541" TEXT="9.TaskScheduler&#x76d1;&#x63a7;task&#xff0c;&#x56de;&#x6536;&#x7ed3;&#x679c;"/>
</node>
<node CREATED="1542071658283" FOLDED="true" ID="ID_422084857" MODIFIED="1542072722425" TEXT="&#x603b;&#x7ed3;">
<node CREATED="1542071910869" ID="ID_1071931448" MODIFIED="1542071982656" TEXT="1.Task&#x5982;&#x679c;&#x53d1;&#x9001;&#x5931;&#x8d25;&#xff0c;&#x6709;TaskScheduler&#x91cd;&#x8bd5;&#xff0c;&#x5982;&#x679c;&#x91cd;&#x8bd5;3&#x6b21;&#x4e4b;&#x540e;&#xff0c;&#x4f9d;&#x7136;&#x5931;&#x8d25;&#xff0c;&#x90a3;&#x4e48;&#x7531;DAGScheduler&#x91cd;&#x8bd5;stage&#xff0c;&#x91cd;&#x8bd5;4&#x6b21;&#x4e4b;&#x540e;&#xff0c;&#x5982;&#x679c;&#x5931;&#x8d25;&#xff0c;&#x90a3;&#x4e48;stage&#x6240;&#x5728;&#x7684;job&#x5c31;&#x5931;&#x8d25;&#x4e86;&#xff0c;job&#x5931;&#x8d25;&#xff0c;application&#x5c31;&#x5931;&#x8d25;&#x4e86;"/>
<node CREATED="1542071983859" ID="ID_988618952" MODIFIED="1542072049230" TEXT="2.TaskScheduler&#x4e0d;&#x4ec5;&#x53ef;&#x4ee5;&#x91cd;&#x8bd5;&#x6267;&#x884c;&#x5931;&#x8d25;&#x7684;task&#xff0c;&#x8fd8;&#x53ef;&#x4ee5;&#x91cd;&#x8bd5;&#x6267;&#x884c;&#x7f13;&#x6162;&#x7684;task&#xff0c;&#x8fd9;&#x5c31;&#x662f;spark&#x4e2d;&#x7684;&#x63a8;&#x6d4b;&#x6267;&#x884c;&#x673a;&#x5236;&#xff0c;&#x9ed8;&#x8ba4;&#x662f;&#x5173;&#x95ed;&#x7684;&#xff0c;&#x5bf9;&#x4e8e;ETL&#x7684;&#x4e1a;&#x52a1;&#xff0c;&#x8981;&#x5173;&#x95ed;&#x63a8;&#x6d4b;&#x6267;&#x884c;&#x3002;"/>
<node CREATED="1542072049515" FOLDED="true" ID="ID_1700103077" MODIFIED="1542072722371" TEXT="3.&#x5982;&#x679c;&#x5728;task&#x6267;&#x884c;&#x8fc7;&#x7a0b;&#x4e2d;&#xff0c;&#x53d1;&#x73b0;&#x67d0;&#x4e9b;task&#x6267;&#x884c;&#x975e;&#x5e38;&#x7f13;&#x6162;&#x3002;">
<node CREATED="1542072090733" ID="ID_1841920028" MODIFIED="1542072096943" TEXT="1.&#x662f;&#x5426;&#x6709;&#x6570;&#x636e;&#x503e;&#x659c;"/>
<node CREATED="1542072097200" ID="ID_1561617190" MODIFIED="1542072104904" TEXT="2.&#x662f;&#x5426;&#x5f00;&#x542f;&#x7684;&#x63a8;&#x6d4b;&#x6267;&#x884c;"/>
</node>
</node>
</node>
<node CREATED="1542072497571" FOLDED="true" ID="ID_1233320927" MODIFIED="1542072722428" TEXT="&#x7c97;&#x7c92;&#x5ea6;&#x8d44;&#x6e90;&#x7533;&#x8bf7;&#x548c;&#x7ec6;&#x7c92;&#x5ea6;&#x8d44;&#x6e90;&#x7533;&#x8bf7;">
<node CREATED="1542072510170" FOLDED="true" ID="ID_578533505" MODIFIED="1542072722425" TEXT="&#x7c97;&#x7c92;&#x5ea6;&#x8d44;&#x6e90;&#x7533;&#x8bf7;">
<node CREATED="1542072518153" ID="ID_887803711" MODIFIED="1542072639965" TEXT="&#x5f53;application&#x6267;&#x884c;&#x4e4b;&#x524d;&#x9996;&#x5148;&#x5c06;&#x6240;&#x6709;&#x7684;&#x8d44;&#x6e90;&#x7533;&#x8bf7;&#x5b8c;&#x6bd5;&#xff0c;&#x5982;&#x679c;&#x7533;&#x8bf7;&#x4e0d;&#x5230;&#x4e00;&#x76f4;&#x7b49;&#x5f85;&#xff0c;&#x5982;&#x679c;&#x7533;&#x8bf7;&#x7684;&#x5230;&#xff0c;&#x6267;&#x884c;application&#xff0c;task&#x6267;&#x884c;&#x8fc7;&#x540e;&#x624d;&#x80fd;&#x4e2d;&#x5c31;&#x4e0d;&#x9700;&#x8981;&#x81ea;&#x5df1;&#x7533;&#x8bf7;&#x8d44;&#x6e90;&#x3002;task&#x6267;&#x884c;&#x5feb;&#xff0c;application&#x6267;&#x884c;&#x5feb;&#xff0c;&#x6240;&#x6709;&#x7684;task&#x6267;&#x884c;&#x5b8c;&#x6bd5;&#x4e4b;&#x540e;&#xff0c;&#x8d44;&#x6e90;&#x624d;&#x4f1a;&#x88ab;&#x91ca;&#x653e;"/>
<node CREATED="1542072569865" ID="ID_1699699317" MODIFIED="1542072577729" TEXT="&#x4f18;&#x70b9;&#xff1a;application&#x6267;&#x884c;&#x5feb;"/>
<node CREATED="1542072577941" ID="ID_1324277024" MODIFIED="1542072586772" TEXT="&#x7f3a;&#x70b9;&#xff1a;&#x96c6;&#x7fa4;&#x8d44;&#x6e90;&#x4e0d;&#x80fd;&#x5145;&#x5206;&#x5229;&#x7528;&#x2018;"/>
</node>
<node CREATED="1542072513397" FOLDED="true" ID="ID_1028926667" MODIFIED="1542072722425" TEXT="&#x7ec6;&#x7c92;&#x5ea6;&#x8d44;&#x6e90;&#x7533;&#x8bf7;">
<node CREATED="1542072589309" ID="ID_1329981638" MODIFIED="1542072652805" TEXT="&#x5f53;application&#x6267;&#x884c;&#x4e4b;&#x524d;&#xff0c;&#x4e0d;&#x4f1a;&#x5c06;&#x6240;&#x6709;&#x7684;&#x8d44;&#x6e90;&#x7533;&#x8bf7;&#x5b8c;&#x6bd5;&#xff0c;task&#x6267;&#x884c;&#x65f6;&#xff0c;&#x81ea;&#x5df1;&#x7533;&#x8bf7;&#x8d44;&#x6e90;&#xff0c;&#x81ea;&#x5df1;&#x91ca;&#x653e;&#x8d44;&#x6e90;&#xff0c;task&#x6267;&#x884c;&#x76f8;&#x5bf9;&#x6162;"/>
<node CREATED="1542072653642" ID="ID_1343221326" MODIFIED="1542072661006" TEXT="&#x4f18;&#x70b9;&#xff1a;&#x96c6;&#x7fa4;&#x8d44;&#x6e90;&#x53ef;&#x4ee5;&#x5145;&#x5206;&#x5229;&#x7528;"/>
<node CREATED="1542072661199" ID="ID_1905833350" MODIFIED="1542072672248" TEXT="&#x7f3a;&#x70b9;&#xff1a;application&#x6267;&#x884c;&#x76f8;&#x5bf9;&#x6162;"/>
</node>
</node>
<node CREATED="1542072683105" FOLDED="true" ID="ID_1082005568" MODIFIED="1542157926935" TEXT="PV&amp;UV">
<node CREATED="1542157725275" ID="ID_945226925" MODIFIED="1542157730944" TEXT="PV:page View"/>
<node CREATED="1542157731360" ID="ID_823383686" MODIFIED="1542157737886" TEXT="UV:unique vistor"/>
</node>
<node CREATED="1542072700016" FOLDED="true" ID="ID_857142875" MODIFIED="1542157313648" TEXT="SparkSubmit &#x53c2;&#x6570;">
<node CREATED="1542076925354" ID="ID_683750607" MODIFIED="1542076936323" TEXT="--master"/>
<node CREATED="1542076936501" ID="ID_674916870" MODIFIED="1542076941220" TEXT="--deploy-mode "/>
<node CREATED="1542076942703" ID="ID_1001878669" MODIFIED="1542076946445" TEXT="--conf"/>
<node CREATED="1542076953413" ID="ID_1682999757" MODIFIED="1542076956506" TEXT="--name"/>
<node CREATED="1542076956754" ID="ID_720703176" MODIFIED="1542076965139" TEXT="--jars"/>
<node CREATED="1542077007511" ID="ID_1536564845" MODIFIED="1542077012722" TEXT="--driver-class-path"/>
<node CREATED="1542076965591" ID="ID_1731724157" MODIFIED="1542076972295" TEXT="--files"/>
<node CREATED="1542076972820" ID="ID_392928897" MODIFIED="1542076977363" TEXT="--driver-cores"/>
<node CREATED="1542076977931" ID="ID_1466082803" MODIFIED="1542076984067" TEXT="--driver-memory"/>
<node CREATED="1542076984605" ID="ID_130292816" MODIFIED="1542076991256" TEXT="--executor-cores"/>
<node CREATED="1542076992723" ID="ID_1965184899" MODIFIED="1542076997298" TEXT="--executor-memory"/>
<node CREATED="1542076997907" ID="ID_1760068180" MODIFIED="1542077002642" TEXT="--total-executor-cores"/>
<node CREATED="1542077018246" ID="ID_1424326432" MODIFIED="1542077024352" TEXT="--num-executors"/>
</node>
<node CREATED="1542077039250" FOLDED="true" ID="ID_1623523136" MODIFIED="1542157928616" TEXT="&#x6e90;&#x7801;&#x5206;&#x6790;">
<node CREATED="1542077047577" ID="ID_317713590" MODIFIED="1542077050483" TEXT="Master&#x542f;&#x52a8;"/>
<node CREATED="1542077051330" ID="ID_798042505" MODIFIED="1542077053775" TEXT="Worker&#x542f;&#x52a8;"/>
<node CREATED="1542157350200" FOLDED="true" ID="ID_1526750435" MODIFIED="1542157924399" TEXT="Spark Submit &#x63d0;&#x4ea4;&#x4efb;&#x52a1; ">
<node CREATED="1542157412542" ID="ID_312744887" MODIFIED="1542157415220" TEXT="Driver&#x542f;&#x52a8;"/>
<node CREATED="1542157415412" ID="ID_1280972461" MODIFIED="1542157429879" TEXT="Driver&#x5411;Master&#x6ce8;&#x518c;Application"/>
</node>
<node CREATED="1542157410470" FOLDED="true" ID="ID_775046671" MODIFIED="1542157923055" TEXT="Spark &#x8d44;&#x6e90;&#x8c03;&#x5ea6;">
<node CREATED="1542157453870" ID="ID_1761335633" MODIFIED="1542157475694" TEXT="1.Executor&#x5728;&#x96c6;&#x7fa4;&#x4e2d;&#x662f;&#x5206;&#x6563;&#x542f;&#x52a8;&#x7684;&#xff0c;&#x5229;&#x4e8e;&#x6570;&#x636e;&#x5904;&#x7406;&#x7684;&#x672c;&#x5730;&#x5316;"/>
<node CREATED="1542157476155" ID="ID_1998269685" MODIFIED="1542157527324" TEXT="2.&#x5982;&#x679c;&#x63d0;&#x4ea4;&#x4efb;&#x52a1;&#x4ec0;&#x4e48;&#x90fd;&#x4e0d;&#x6307;&#x5b9a;&#xff0c;&#x96c6;&#x7fa4;&#x4e2d;&#x6bcf;&#x53f0;Worker&#x4e3a;&#x5f53;&#x524d;&#x7684;application &#x542f;&#x52a8;&#x4e00;&#x4e2a;Executor&#xff0c;&#x8fd9;&#x4e2a;Executor&#x4f1a;&#x4f7f;&#x7528;&#x5f53;&#x524d;&#x8282;&#x70b9;&#x7684;&#x6240;&#x6709;core&#x548c;1G&#x5185;&#x5b58;"/>
<node CREATED="1542157528133" ID="ID_1066392889" MODIFIED="1542157574280" TEXT="3.&#x5982;&#x679c;&#x60f3;&#x8981;&#x5728;&#x4e00;&#x53f0;Worker&#x4e0a;&#x542f;&#x52a8;&#x591a;&#x4e2a;Executor&#xff0c;&#x8981;&#x6307;&#x5b9a;--executor-cores"/>
<node CREATED="1542157580093" ID="ID_1540958229" MODIFIED="1542157620663" TEXT="4.&#x63d0;&#x4ea4;&#x4efb;&#x52a1;&#x6307;&#x5b9a; --total-executor-cores &#x4f1a;&#x4e3a;&#x5f53;&#x524d;application&#x7533;&#x8bf7;&#x6307;&#x5b9a;core&#x4e2a;&#x6570;&#x7684;&#x8d44;&#x6e90;"/>
<node CREATED="1542157620819" ID="ID_190876786" MODIFIED="1542157639243" TEXT="5.&#x542f;&#x52a8;Executor&#x4e0d;&#x4ec5;&#x548c;core&#x6709;&#x5173;&#x8fd8;&#x548c;&#x5185;&#x5b58;&#x6709;&#x5173; --executor-memory"/>
</node>
<node CREATED="1542157443770" ID="ID_1302133489" MODIFIED="1542157665747" TEXT="Spark &#x4efb;&#x52a1;&#x8c03;&#x5ea6;">
<node CREATED="1542157674436" ID="ID_1242089930" MODIFIED="1542157680551" TEXT="&#x4ece;&#x4e00;&#x4e2a;action&#x7b97;&#x5b50;&#x5f00;&#x59cb;"/>
</node>
</node>
<node CREATED="1542157720111" FOLDED="true" ID="ID_1279345358" MODIFIED="1542157925671" TEXT="&#x4e8c;&#x6b21;&#x6392;&#x5e8f;">
<node CREATED="1542157755950" ID="ID_1545655731" MODIFIED="1542157768362" TEXT="Spark&#x4e2d;&#x5927;&#x4e8e;&#x4e24;&#x5217;&#x7684;&#x6392;&#x5e8f;&#x90fd;&#x53eb;&#x4e8c;&#x6b21;&#x6392;&#x5e8f;"/>
<node CREATED="1542157768899" ID="ID_73050515" MODIFIED="1542157803330" TEXT="&#x5c01;&#x88c5;&#x5bf9;&#x8c61;&#xff0c;&#x5b9e;&#x73b0;&#x5bf9;&#x8c61;&#x7684;&#x6392;&#x5e8f;&#xff0c;&#x5bf9;&#x8c61;&#x4e2d;&#x7684;&#x5c5e;&#x6027;&#x5c31;&#x662f;&#x8981;&#x6392;&#x5e8f;&#x7684;&#x5217;"/>
</node>
<node CREATED="1542157747151" FOLDED="true" ID="ID_323392967" MODIFIED="1542157929328" TEXT="&#x5206;&#x7ec4;&#x53d6;topN">
<node CREATED="1542157841513" ID="ID_1281908124" MODIFIED="1542157869336" TEXT="&#x539f;&#x751f;&#x7684;&#x96c6;&#x5408;&#x6392;&#x5e8f;">
<node CREATED="1542157877527" ID="ID_202621819" MODIFIED="1542157882822" TEXT="&#x6709;OOM&#x98ce;&#x9669;"/>
</node>
<node CREATED="1542157869514" ID="ID_611924811" MODIFIED="1542157873829" TEXT="&#x5b9a;&#x957f;&#x6570;&#x7ec4;"/>
</node>
<node CREATED="1542157931162" FOLDED="true" ID="ID_623859430" MODIFIED="1542245066436" TEXT="&#x5e7f;&#x64ad;&#x53d8;&#x91cf;">
<node CREATED="1542175588043" ID="ID_1713029951" MODIFIED="1542175629666" TEXT="&#x5f53;Executor&#x7aef;&#x4f7f;&#x7528;&#x5230;Driver&#x7aef;&#x7684;&#x53d8;&#x91cf;&#x65f6;&#xff0c;&#x5982;&#x679c;&#x4e0d;&#x4f7f;&#x7528;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x90a3;&#x4e48;&#x5728;&#x6bcf;&#x4e2a;Executor&#x4e2d;&#x6709;&#x591a;&#x5c11;task&#xff0c;&#x5c31;&#x4f1a;&#x6709;&#x591a;&#x5c11;&#x53d8;&#x91cf;&#x526f;&#x672c;"/>
<node CREATED="1542175630361" ID="ID_1017889140" MODIFIED="1542175668646" TEXT="&#x5982;&#x679c;&#x4f7f;&#x7528;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#xff0c;&#x5728;&#x6bcf;&#x4e2a;Executor&#x4e2d;&#x53ea;&#x6709;&#x4e00;&#x4efd;Driver&#x7aef;&#x7684;&#x53d8;&#x91cf;&#x526f;&#x672c;&#xff0c;&#x53ef;&#x4ee5;&#x5927;&#x5927;&#x8282;&#x7701;Executor&#x7aef;&#x5185;&#x5b58;"/>
<node CREATED="1542175685037" ID="ID_1753043150" MODIFIED="1542175687147" TEXT="&#x6ce8;&#x610f;&#x70b9;&#xff1a;">
<node CREATED="1542175688313" ID="ID_465751817" MODIFIED="1542175694204" TEXT="&#x4e0d;&#x80fd;&#x5c06;RDD&#x5e7f;&#x64ad;&#x51fa;&#x53bb;"/>
<node CREATED="1542175694402" ID="ID_1876471640" MODIFIED="1542175724745" TEXT="&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x53ea;&#x80fd;&#x5728;Driver&#x7aef;&#x5b9a;&#x4e49;&#xff0c;&#x5728;Executor&#x7aef;&#x4f7f;&#x7528;&#xff0c;Executor&#x7aef;&#x4e0d;&#x80fd;&#x6539;&#x53d8;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x7684;&#x503c;"/>
</node>
</node>
<node CREATED="1542157936585" FOLDED="true" ID="ID_1481746843" MODIFIED="1542245065748" TEXT="&#x7d2f;&#x52a0;&#x5668;">
<node CREATED="1542175670553" ID="ID_1943371256" MODIFIED="1542175681584" TEXT="&#x76f8;&#x5f53;&#x4e8e;&#x96c6;&#x7fa4;&#x4e2d;&#x7684;&#x7edf;&#x7b79;&#x53d8;&#x91cf;"/>
<node CREATED="1542175683713" ID="ID_99104336" MODIFIED="1542175775649" TEXT="&#x6ce8;&#x610f;&#xff1a;&#x7d2f;&#x8ba1;&#x5668;&#x53ea;&#x80fd;&#x5728;Driver&#x7aef;&#x5b9a;&#x4e49;&#xff0c;&#x5728;Executor&#x7aef;&#x4f7f;&#x7528;&#xff0c;1.6&#x7248;&#x672c;&#x4e0d;&#x80fd;&#x5728;Executor&#x4e2d;accumulator.value()&#x83b7;&#x53d6;&#x7d2f;&#x52a0;&#x5668;&#x7684;&#x503c;"/>
</node>
<node CREATED="1542175561942" FOLDED="true" ID="ID_888274815" MODIFIED="1542245064852" TEXT="Spark WEBUI">
<node CREATED="1542175784500" ID="ID_663844765" MODIFIED="1542175787900" TEXT="Spark-shell ">
<node CREATED="1542175788700" ID="ID_1080088504" MODIFIED="1542175802370" TEXT="Spark-Scala &#x7684;REPL"/>
<node CREATED="1542175804191" ID="ID_303855635" MODIFIED="1542175824852" TEXT="&#x4e0a;&#x4f20;&#x6587;&#x4ef6;&#xff0c;Spark&#x8bfb;&#x53d6;HDFS&#x4e2d;&#x6587;&#x4ef6;"/>
</node>
<node CREATED="1542175921941" ID="ID_440205279" MODIFIED="1542175958355" TEXT="&#x70b9;&#x51fb;job -&gt; stage-&gt;task "/>
<node CREATED="1542175970813" ID="ID_1642738569" MODIFIED="1542176025648" TEXT="Jobs ,Stages,Storage,Envionment,Executor,SQL,Streaming"/>
</node>
<node CREATED="1542175939959" FOLDED="true" ID="ID_1874989603" MODIFIED="1542244600188" TEXT="&#x7aef;&#x53e3;">
<node CREATED="1542176029404" ID="ID_1059774990" MODIFIED="1542176051945" TEXT="50070"/>
<node CREATED="1542176052142" ID="ID_1001524464" MODIFIED="1542176055507" TEXT="9000"/>
<node CREATED="1542176055975" ID="ID_1200045541" MODIFIED="1542176057992" TEXT="8020"/>
<node CREATED="1542176058558" ID="ID_58976146" MODIFIED="1542176061260" TEXT="8088"/>
<node CREATED="1542176062077" ID="ID_1290251639" MODIFIED="1542176065377" TEXT="2181"/>
<node CREATED="1542176066928" ID="ID_1371198270" MODIFIED="1542176072199" TEXT="6379"/>
<node CREATED="1542176118258" ID="ID_413929462" MODIFIED="1542176120414" TEXT="60010"/>
<node CREATED="1542176073599" ID="ID_1090887045" MODIFIED="1542176079006" TEXT="9083"/>
<node CREATED="1542176124305" ID="ID_1853217007" MODIFIED="1542176125597" TEXT="9092"/>
<node CREATED="1542176043887" ID="ID_1572892652" MODIFIED="1542176099391" TEXT="7077"/>
<node CREATED="1542176099863" ID="ID_125870527" MODIFIED="1542176101291" TEXT="8080"/>
<node CREATED="1542176103175" ID="ID_1981126177" MODIFIED="1542176106937" TEXT="8081"/>
<node CREATED="1542176107458" ID="ID_1546332586" MODIFIED="1542176112408" TEXT="18080"/>
</node>
<node CREATED="1542175569935" FOLDED="true" ID="ID_226726299" MODIFIED="1542245063436" TEXT="Spark History-Server">
<node CREATED="1542176164194" ID="ID_176061688" MODIFIED="1542244613710" TEXT="1.&#x5728;&#x5ba2;&#x6237;&#x7aef; spark/conf/spark-defaults.conf &#x914d;&#x7f6e;">
<node CREATED="1542176320371" MODIFIED="1542176320371" TEXT="spark.eventLog.enabled           true"/>
<node CREATED="1542176320372" MODIFIED="1542176320372" TEXT="spark.eventLog.dir               hdfs://node1:9000/spark/log"/>
<node CREATED="1542176320373" ID="ID_338354511" MODIFIED="1542176320373" TEXT="spark.history.fs.logDirectory    hdfs://node1:9000/spark/log"/>
<node CREATED="1542176320374" ID="ID_1344638166" MODIFIED="1542176320374" TEXT="spark.eventLog.compress  true"/>
</node>
<node CREATED="1542176332132" ID="ID_1123546104" MODIFIED="1542176355925" TEXT="2.&#x5728;&#x5ba2;&#x6237;&#x7aef;spark/sbin/start-history-server.sh &#x542f;&#x52a8;&#x5386;&#x53f2;&#x65e5;&#x5fd7;&#x670d;&#x52a1;&#x5668;"/>
<node CREATED="1542176356116" ID="ID_605666669" MODIFIED="1542176365369" TEXT="3.&#x8bbf;&#x95ee;&#xff1a; node4:18080"/>
</node>
<node CREATED="1542176377454" FOLDED="true" ID="ID_1050453842" MODIFIED="1542245067734" TEXT="Master-HA">
<node CREATED="1542176461863" ID="ID_1478728709" MODIFIED="1542244720510" TEXT="&#x5f53;&#x63d0;&#x4ea4;&#x4efb;&#x52a1;&#x542f;&#x52a8;Driver&#x3001;&#x5411;Master&#x6ce8;&#x518c;Application&#x3001;&#x7533;&#x8bf7;Application&#x7684;&#x8d44;&#x6e90; &#x90fd;&#x8981;&#x8fde;&#x63a5;Master&#xff0c;&#x5982;&#x679c;Master &#x4e0d;&#x662f;Alive &#xff0c;&#x5c31;&#x4f1a;&#x5931;&#x8d25;"/>
<node CREATED="1542244736298" FOLDED="true" ID="ID_342059691" MODIFIED="1542245062325" TEXT="Master &#x9ad8;&#x53ef;&#x7528;">
<node CREATED="1542244744924" ID="ID_835356282" MODIFIED="1542244750551" TEXT="&#x672c;&#x5730;&#x6587;&#x4ef6;&#x7cfb;&#x7edf;"/>
<node CREATED="1542244752785" ID="ID_1684615175" MODIFIED="1542244755696" TEXT="zookeeper">
<node CREATED="1542244756514" ID="ID_1445930843" MODIFIED="1542244759953" TEXT="&#x7ba1;&#x7406;&#x539f;&#x6570;&#x636e;"/>
<node CREATED="1542244760128" ID="ID_447644385" MODIFIED="1542244764964" TEXT="&#x81ea;&#x52a8;&#x9009;&#x4e3e;"/>
<node CREATED="1542244767751" ID="ID_573163511" MODIFIED="1542244770590" TEXT="&#x642d;&#x5efa;">
<node CREATED="1542244771227" ID="ID_381169483" MODIFIED="1542244797621" TEXT="1.&#x5728;Master-Alive&#x4e2d; ../conf/spark-env.sh &#x4e2d; &#x914d;&#x7f6e;">
<node CREATED="1542244833897" ID="ID_867380652" MODIFIED="1542244833897" TEXT="export SPARK_DAEMON_JAVA_OPTS=&quot;"/>
<node CREATED="1542244833900" MODIFIED="1542244833900" TEXT="-Dspark.deploy.recoveryMode=ZOOKEEPER"/>
<node CREATED="1542244833901" ID="ID_90570711" MODIFIED="1542244833901" TEXT="-Dspark.deploy.zookeeper.url=node3:2181,node4:2181,node5:2181"/>
<node CREATED="1542244833902" ID="ID_152024172" MODIFIED="1542244833902" TEXT="-Dspark.deploy.zookeeper.dir=/sparkmaster0821&quot;"/>
</node>
<node CREATED="1542244853542" ID="ID_52772845" MODIFIED="1542244881520" TEXT="2.&#x627e;&#x4e00;&#x53f0;Master-Standby &#x914d;&#x7f6e; ../conf/spark-env.sh ">
<node CREATED="1542244881828" ID="ID_199382173" MODIFIED="1542244891395" TEXT="SPARK_MASTER_HOST=node2"/>
</node>
<node CREATED="1542244892986" ID="ID_1534222309" MODIFIED="1542244909194" TEXT="3.&#x542f;&#x52a8;zookeeper"/>
<node CREATED="1542244909484" ID="ID_987565327" MODIFIED="1542244936724" TEXT="4.&#x5728;Master-Alive&#x4e2d;&#x542f;&#x52a8; &#x96c6;&#x7fa4; ./start-all.sh"/>
<node CREATED="1542244937001" ID="ID_1764290436" MODIFIED="1542244956099" TEXT="5.&#x5728;Master-standby &#x542f;&#x52a8;&#x5907;&#x7528;Master ./start-master.sh"/>
<node CREATED="1542244957383" ID="ID_1353520387" MODIFIED="1542244963352" TEXT="6.&#x6d4b;&#x8bd5;&#x5207;&#x6362;">
<node CREATED="1542245007810" ID="ID_1627479518" MODIFIED="1542245019553" TEXT="&#x5207;&#x6362;&#x8fc7;&#x7a0b;&#x4e2d;&#x4e0d;&#x5f71;&#x54cd;&#x6b63;&#x5728;&#x6267;&#x884c;&#x7684;&#x4efb;&#x52a1;"/>
<node CREATED="1542245019724" ID="ID_1516616219" MODIFIED="1542245056711" TEXT="&#x5207;&#x6362;&#x8fc7;&#x7a0b;&#x4e2d; &#x5f71;&#x54cd;&#x6b63;&#x5728;&#x7533;&#x8bf7;&#x8d44;&#x6e90;&#x7684;&#x4efb;&#x52a1;&#xff0c;&#x4f1a;&#x6309;&#x7167;&#x9ad8;&#x53ef;&#x7528;&#x9009;&#x4e3e;&#x8282;&#x70b9;&#x540e;&#x6267;&#x884c;"/>
</node>
</node>
</node>
<node CREATED="1542244975412" ID="ID_12844607" MODIFIED="1542244984496" TEXT="&#x9ad8;&#x53ef;&#x7528;Master &#x63d0;&#x4ea4;&#x4efb;&#x52a1; ">
<node CREATED="1542244984497" ID="ID_474753379" MODIFIED="1542244999060" TEXT="./spark-submit --master spark://node1:7077,node2:7077 --class ..jar .."/>
</node>
</node>
</node>
<node CREATED="1542245068763" FOLDED="true" ID="ID_1269257201" MODIFIED="1542246761902" TEXT="Spark Shuffle">
<node CREATED="1542245073754" ID="ID_98306632" MODIFIED="1542245146432" TEXT="&#x4e24;&#x79cd;shuffleManager,&#x5728;Spark 1.2&#x4e4b;&#x540e;&#x5f15;&#x5165;&#x7684;SortShuffleManager&#xff0c;1.6&#x9ed8;&#x8ba4;&#x4f7f;&#x7528;&#x7684;&#x662f;SortShuffleManager,2.0+HashShuffleManager &#x88ab;&#x4e22;&#x5f03;"/>
<node CREATED="1542245088494" FOLDED="true" ID="ID_1427330481" MODIFIED="1542245747206" TEXT="HashShuffleManager">
<node CREATED="1542245151663" ID="ID_956525906" MODIFIED="1542245154502" TEXT="&#x666e;&#x901a;&#x673a;&#x5236;">
<node CREATED="1542245172162" ID="ID_269138952" MODIFIED="1542245179537" TEXT="&#x4ea7;&#x751f;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x4e2a;&#x6570;">
<node CREATED="1542245181982" ID="ID_1783729594" MODIFIED="1542245185428" TEXT="M*R"/>
</node>
<node CREATED="1542245199453" ID="ID_656587641" MODIFIED="1542245203831" TEXT="&#x6d41;&#x7a0b;">
<node CREATED="1542245204530" ID="ID_510435241" MODIFIED="1542245258188" TEXT="1.map task&#x5904;&#x7406;&#x5b8c;&#x6570;&#x636e;&#x4e4b;&#x540e;&#x5199;&#x5f80;buffer&#x7f13;&#x5b58;&#x533a;&#xff0c;&#x9ed8;&#x8ba4;&#x5927;&#x5c0f;&#x4e3a;32k,&#x5199;&#x5f80;buffer&#x7f13;&#x51b2;&#x533a;&#x7684;&#x4e2a;&#x6570;&#x4e0e;reduce task&#x4e2a;&#x6570;&#x4e00;&#x81f4;"/>
<node CREATED="1542245238051" ID="ID_491479185" MODIFIED="1542245284543" TEXT="2. &#x7f13;&#x51b2;&#x533a;&#x6ee1;32k &#x6ea2;&#x5199;&#x78c1;&#x76d8;&#xff0c;&#x6bcf;&#x4e2a;buffer&#x7f13;&#x5b58;&#x533a;&#x5bf9;&#x5e94;&#x4e00;&#x4e2a;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;"/>
<node CREATED="1542245284705" ID="ID_464826589" MODIFIED="1542245290783" TEXT="3.reduce &#x7aef;&#x62c9;&#x53d6;&#x6570;&#x636e;"/>
</node>
<node CREATED="1542245292553" ID="ID_732237810" MODIFIED="1542245300481" TEXT="&#x95ee;&#x9898;&#xff1a;&#x4ea7;&#x751f;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x591a;">
<node CREATED="1542245300481" ID="ID_1781670684" MODIFIED="1542245310274" TEXT="shuffle write&#x5bf9;&#x8c61;&#x591a;"/>
<node CREATED="1542245310447" ID="ID_583503791" MODIFIED="1542245320934" TEXT="shuffle read &#x5bf9;&#x8c61;&#x591a;"/>
<node CREATED="1542245321101" ID="ID_1010707586" MODIFIED="1542245383111" TEXT="&#x8282;&#x70b9;&#x4e4b;&#x95f4;&#x62c9;&#x53d6;&#x6570;&#x636e;&#x7684;&#x8fde;&#x63a5;&#x591a;&#xff0c;&#x9047;&#x5230;&#x7f51;&#x7edc;&#x8fde;&#x63a5;&#x4e0d;&#x7a33;&#x5b9a;&#x5bfc;&#x81f4;&#x62c9;&#x53d6;&#x6570;&#x636e;&#x5931;&#x8d25;&#x7684;&#x6982;&#x7387;&#x5927;&#xff0c;&#x4f1a;&#x52a0;&#x5927;&#x6570;&#x636e;&#x5904;&#x7406;&#x7684;&#x65f6;&#x95f4;"/>
</node>
</node>
<node CREATED="1542245154675" ID="ID_1008095923" MODIFIED="1542245159233" TEXT="&#x4f18;&#x5316;&#x673a;&#x5236;">
<node CREATED="1542245172162" ID="ID_1468718945" MODIFIED="1542245179537" TEXT="&#x4ea7;&#x751f;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x4e2a;&#x6570;">
<node CREATED="1542245181982" ID="ID_1238516526" MODIFIED="1542245189794" TEXT="C*R"/>
</node>
<node CREATED="1542245199453" ID="ID_1052002523" MODIFIED="1542245203831" TEXT="&#x6d41;&#x7a0b;">
<node CREATED="1542245204530" ID="ID_764930419" MODIFIED="1542245258188" TEXT="1.map task&#x5904;&#x7406;&#x5b8c;&#x6570;&#x636e;&#x4e4b;&#x540e;&#x5199;&#x5f80;buffer&#x7f13;&#x5b58;&#x533a;&#xff0c;&#x9ed8;&#x8ba4;&#x5927;&#x5c0f;&#x4e3a;32k,&#x5199;&#x5f80;buffer&#x7f13;&#x51b2;&#x533a;&#x7684;&#x4e2a;&#x6570;&#x4e0e;reduce task&#x4e2a;&#x6570;&#x4e00;&#x81f4;"/>
<node CREATED="1542245404841" ID="ID_388362456" MODIFIED="1542245420622" TEXT="2.&#x540c;&#x4e00;&#x4e2a;core&#x4e2d;&#x7684;task &#x516c;&#x7528;&#x4e00;&#x4efd;buffer &#x7f13;&#x5b58;&#x533a;"/>
<node CREATED="1542245238051" ID="ID_411355888" MODIFIED="1542245424845" TEXT="3. &#x7f13;&#x51b2;&#x533a;&#x6ee1;32k &#x6ea2;&#x5199;&#x78c1;&#x76d8;&#xff0c;&#x6bcf;&#x4e2a;buffer&#x7f13;&#x5b58;&#x533a;&#x5bf9;&#x5e94;&#x4e00;&#x4e2a;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;"/>
<node CREATED="1542245284705" ID="ID_558258253" MODIFIED="1542245426607" TEXT="4.reduce &#x7aef;&#x62c9;&#x53d6;&#x6570;&#x636e;"/>
</node>
<node CREATED="1542245433299" ID="ID_689874756" MODIFIED="1542245468517" TEXT="&#x76f8;&#x5bf9;&#x4e8e;&#x666e;&#x901a;&#x60c5;&#x51b5;&#xff0c;shuffle&#x6587;&#x4ef6;&#x5927;&#x5927;&#x51cf;&#x5c11;&#xff0c;&#x5f53;reduce task &#x4e2a;&#x6570;&#x591a;&#xff0c;&#x6216;&#x8005;core&#x7684;&#x4e2a;&#x6570;&#x591a;&#x7684;&#x65f6;&#x5019;&#xff0c;&#x4ea7;&#x751f;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x7684;&#x4e2a;&#x6570;&#x8fd8;&#x662f;&#x6bd4;&#x8f83;&#x5927;"/>
</node>
</node>
<node CREATED="1542245092676" FOLDED="true" ID="ID_1597415218" MODIFIED="1542245745486" TEXT="SortShuffleManager">
<node CREATED="1542245161150" FOLDED="true" ID="ID_837360786" MODIFIED="1542245744638" TEXT="&#x666e;&#x901a;&#x673a;&#x5236;">
<node CREATED="1542245172162" ID="ID_1724509748" MODIFIED="1542245179537" TEXT="&#x4ea7;&#x751f;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x4e2a;&#x6570;">
<node CREATED="1542245181982" ID="ID_270064804" MODIFIED="1542245196000" TEXT="2*M"/>
</node>
<node CREATED="1542245473759" ID="ID_796585843" MODIFIED="1542245477723" TEXT="&#x8fc7;&#x7a0b;">
<node CREATED="1542245478491" ID="ID_1092406114" MODIFIED="1542245528131" TEXT="1.map task &#x5904;&#x7406;&#x5b8c;&#x6570;&#x636e;&#x5148;&#x5199;&#x5f80;5M&#x5185;&#x5b58;&#x6570;&#x636e;&#x7ed3;&#x6784;&#xff0c;&#x9ed8;&#x8ba4;&#x6709;&#x4f30;&#x7b97;&#x673a;&#x5236;&#xff0c;&#x5f53;&#x4f30;&#x8ba1;&#x5185;&#x5b58;&#x4e0d;&#x591f;&#x65f6;&#xff0c;&#x4f1a;&#x81ea;&#x52a8;&#x7533;&#x8bf7;&#x5185;&#x5b58;&#xff0c;&#x7533;&#x8bf7;&#xff1a;2*&#x4f30;&#x7b97;-&#x5f53;&#x524d;"/>
<node CREATED="1542245528697" ID="ID_1334401248" MODIFIED="1542245570500" TEXT="2.&#x5982;&#x679c;&#x5185;&#x5b58;&#x80fd;&#x7533;&#x8bf7;&#x5230;&#xff0c;&#x7ee7;&#x7eed;&#x5199;&#x5f80;&#x5185;&#x5b58;&#x4e2d;&#xff0c;&#x5982;&#x679c;&#x7533;&#x8bf7;&#x4e0d;&#x5230;&#xff0c;&#x6ea2;&#x5199;&#x78c1;&#x76d8;&#xff0c;&#x6ea2;&#x5199;&#x65f6;&#x6709;&#x6392;&#x5e8f;&#xff0c;&#x6bcf;&#x6279;&#x6b21;&#x662f;1w&#x6761;&#x6ea2;&#x5199;"/>
<node CREATED="1542245570761" ID="ID_197969505" MODIFIED="1542245594720" TEXT="3.&#x591a;&#x6b21;&#x6ea2;&#x5199;&#x7684;&#x6587;&#x4ef6;&#x5408;&#x5e76;&#x6210;&#x4e24;&#x4e2a;&#x6587;&#x4ef6;&#xff0c;&#x4e00;&#x4e2a;&#x662f;&#x7d22;&#x5f15;&#x6587;&#x4ef6;&#xff0c;&#x4e00;&#x4e2a;&#x662f;&#x6570;&#x636e;&#x6587;&#x4ef6;"/>
<node CREATED="1542245596070" ID="ID_589066453" MODIFIED="1542245602732" TEXT="4.reduce task&#x62c9;&#x53d6;&#x6570;&#x636e;"/>
</node>
</node>
<node CREATED="1542245164945" ID="ID_1075932399" MODIFIED="1542245168393" TEXT="bypass&#x673a;&#x5236;">
<node CREATED="1542245172162" ID="ID_1474114579" MODIFIED="1542245179537" TEXT="&#x4ea7;&#x751f;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x4e2a;&#x6570;">
<node CREATED="1542245181982" ID="ID_822042469" MODIFIED="1542245196000" TEXT="2*M"/>
</node>
<node CREATED="1542245605218" ID="ID_1072417450" MODIFIED="1542245607215" TEXT="&#x8fc7;&#x7a0b;">
<node CREATED="1542245607998" ID="ID_978097553" MODIFIED="1542245620232" TEXT="&#x4e0e;&#x666e;&#x901a;&#x673a;&#x5236;&#x76f8;&#x6bd4;&#xff0c;&#x6ea2;&#x5199;&#x78c1;&#x76d8;&#x6ca1;&#x6709;&#x6392;&#x5e8f;"/>
</node>
<node CREATED="1542245622013" ID="ID_1874223083" MODIFIED="1542245623956" TEXT="&#x6761;&#x4ef6;">
<node CREATED="1542245624693" ID="ID_493404443" MODIFIED="1542245665961" TEXT="1.spark &#x7b97;&#x5b50;&#x6ca1;&#x6709;map&#x7aef;&#x7684; combine&#x805a;&#x5408;&#x65f6;&#xff0c;&#x53ef;&#x4ee5;&#x4f7f;&#x7528;bypass&#x673a;&#x5236;&#xff0c;&#x5982;&#x679c;&#x6709;map&#x7aef;combine &#x60f3;&#x4f7f;&#x7528;bypas &#x4e5f;&#x4e0d;&#x80fd;&#x4f7f;&#x7528;"/>
<node CREATED="1542245671016" ID="ID_1739681496" MODIFIED="1542245725868" TEXT="2.&#x5f00;&#x542f;bypass&#x673a;&#x5236;&#x7684;&#x6761;&#x4ef6;&#xff1a;spark.shuffle.sort.bypassMergeThreshold=200&#xff0c;&#x5f53;reduce task&#x5c0f;&#x4e8e;&#x8fd9;&#x4e2a;&#x53c2;&#x6570;&#x65f6;&#xff0c;&#x9ed8;&#x8ba4;&#x5c31;&#x662f;&#x5f00;&#x542f;bypass&#x673a;&#x5236;"/>
</node>
</node>
</node>
</node>
<node CREATED="1542245750421" FOLDED="true" ID="ID_54176719" MODIFIED="1542246760718" TEXT="Shuffle&#x6587;&#x4ef6;&#x7684;&#x5bfb;&#x5740;">
<node CREATED="1542245757735" ID="ID_861906370" MODIFIED="1542245763774" TEXT="&#x5bf9;&#x8c61;">
<node CREATED="1542245766932" ID="ID_768152286" MODIFIED="1542245771883" TEXT="MapOutputTracker">
<node CREATED="1542245780955" ID="ID_519482132" MODIFIED="1542245806715" TEXT="MapOutputTrackerMaster -Driver"/>
<node CREATED="1542245793709" ID="ID_1095927173" MODIFIED="1542245801555" TEXT="MapOutputTrackerWorker - Executor"/>
</node>
<node CREATED="1542245772065" ID="ID_975138714" MODIFIED="1542245779987" TEXT="BlockManager">
<node CREATED="1542245811665" ID="ID_1873241959" MODIFIED="1542245823476" TEXT="BlockManagerMaster -Driver">
<node CREATED="1542245836204" ID="ID_1623960139" MODIFIED="1542245842640" TEXT="DiskStore">
<node CREATED="1542245863716" ID="ID_1055110167" MODIFIED="1542245867313" TEXT="&#x7ba1;&#x7406;&#x78c1;&#x76d8;&#x6570;&#x636e;"/>
</node>
<node CREATED="1542245842822" ID="ID_653511481" MODIFIED="1542245847176" TEXT="MemoryStore">
<node CREATED="1542245868862" ID="ID_27915883" MODIFIED="1542245871103" TEXT="&#x7ba1;&#x7406;&#x5185;&#x5b58;&#x6570;&#x636e;"/>
</node>
<node CREATED="1542245848792" ID="ID_1738506657" MODIFIED="1542245861629" TEXT="BlockTransferService">
<node CREATED="1542245872614" ID="ID_674713545" MODIFIED="1542245875479" TEXT="&#x8d1f;&#x8d23;&#x62c9;&#x53d6;&#x6570;&#x636e;"/>
</node>
</node>
<node CREATED="1542245823668" ID="ID_312978416" MODIFIED="1542245834236" TEXT="BlockManagerSlaves -Executor">
<node CREATED="1542245836204" ID="ID_1243227333" MODIFIED="1542245842640" TEXT="DiskStore">
<node CREATED="1542245863716" ID="ID_740240076" MODIFIED="1542245867313" TEXT="&#x7ba1;&#x7406;&#x78c1;&#x76d8;&#x6570;&#x636e;"/>
</node>
<node CREATED="1542245842822" ID="ID_790086169" MODIFIED="1542245847176" TEXT="MemoryStore">
<node CREATED="1542245868862" ID="ID_167418836" MODIFIED="1542245871103" TEXT="&#x7ba1;&#x7406;&#x5185;&#x5b58;&#x6570;&#x636e;"/>
</node>
<node CREATED="1542245848792" ID="ID_1002263603" MODIFIED="1542245861629" TEXT="BlockTransferService">
<node CREATED="1542245872614" ID="ID_1171731784" MODIFIED="1542245875479" TEXT="&#x8d1f;&#x8d23;&#x62c9;&#x53d6;&#x6570;&#x636e;"/>
</node>
</node>
</node>
</node>
<node CREATED="1542245763952" ID="ID_93945233" MODIFIED="1542245765171" TEXT="&#x8fc7;&#x7a0b;">
<node CREATED="1542245884529" ID="ID_1790798012" MODIFIED="1542245951760" TEXT="1.map task &#x5904;&#x7406;&#x5b8c;&#x6570;&#x636e;&#xff0c;&#x5c06;&#x6570;&#x636e;&#x7ed3;&#x679c;&#x548c;&#x843d;&#x5730;&#x7684;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x7684;&#x4f4d;&#x7f6e;&#x4fe1;&#x606f;&#x5c01;&#x88c5;&#x5230;MapStatus&#x5bf9;&#x8c61;&#x4e2d;&#xff0c;&#x901a;&#x8fc7;Worker&#x4e2d;&#x7684;MapOUtputTrackerWorker&#x6c47;&#x62a5;&#x7ed9;Driver&#x4e2d;&#x7684;MapOutputTrackerMaster ,Driver&#x638c;&#x63e1;&#x7684;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x7684;&#x4f4d;&#x7f6e;&#x4fe1;&#x606f;"/>
<node CREATED="1542245951936" ID="ID_1661062268" MODIFIED="1542245972261" TEXT="2.reduce task&#x62c9;&#x53d6;&#x6570;&#x636e;&#xff0c;&#x9996;&#x5148;&#x5411;Driver&#x8981;&#x78c1;&#x76d8;&#x5c0f;&#x6587;&#x4ef6;&#x7684;&#x4f4d;&#x7f6e;&#xff0c;Driver&#x8fd4;&#x56de;"/>
<node CREATED="1542245972428" ID="ID_1140389075" MODIFIED="1542245998247" TEXT="3.reduce &#x7aef;&#x8fde;&#x63a5;&#x6570;&#x636e;&#x6240;&#x5728;&#x7684;&#x8282;&#x70b9;&#xff0c;&#x7531;BlockTransferService &#x62c9;&#x53d6;&#x6570;&#x636e;"/>
<node CREATED="1542245998414" ID="ID_562787712" MODIFIED="1542246023161" TEXT="4.BlockTransferService&#x9ed8;&#x8ba4;&#x542f;&#x52a8;5&#x4e2a;&#x7ebf;&#x7a0b;&#x62c9;&#x53d6;&#x6570;&#x636e;&#xff0c;&#x9ed8;&#x8ba4;&#x6700;&#x591a;&#x4e00;&#x6b21;&#x62c9;&#x53d6;48M"/>
<node CREATED="1542246023332" ID="ID_93168875" MODIFIED="1542246042325" TEXT="5.&#x62c9;&#x53d6;&#x6765;&#x7684;&#x6570;&#x636e;&#x653e;&#x5728;&#x4e86;Executor&#x4e2d;shuffle&#x805a;&#x5408;&#x5185;&#x5b58;&#x4e2d;"/>
</node>
<node CREATED="1542246046787" ID="ID_1167140399" MODIFIED="1542246056040" TEXT="reduce OOM&#x95ee;&#x9898;&#xff1f;">
<node CREATED="1542246056714" ID="ID_1939876152" MODIFIED="1542246061591" TEXT="1.&#x51cf;&#x5c11;&#x62c9;&#x53d6;&#x6570;&#x636e;&#x91cf;"/>
<node CREATED="1542246061758" ID="ID_220043494" MODIFIED="1542246068613" TEXT="2.&#x589e;&#x5927;Executor&#x7aef;&#x7684;&#x6574;&#x4f53;&#x5185;&#x5b58;"/>
<node CREATED="1542246068785" ID="ID_584558457" MODIFIED="1542246086989" TEXT="3.&#x589e;&#x5927;Executor shuffle &#x805a;&#x5408;&#x5185;&#x5b58;&#x6bd4;&#x4f8b;"/>
</node>
</node>
<node CREATED="1542246089272" FOLDED="true" ID="ID_547545288" MODIFIED="1542246759790" TEXT="Spark &#x5185;&#x5b58;&#x7ba1;&#x7406;">
<node CREATED="1542246094530" ID="ID_427599343" MODIFIED="1542246158711" TEXT="&#x4e24;&#x79cd;&#x5185;&#x5b58;&#x7ba1;&#x7406;&#xff0c;&#x9759;&#x6001;&#x5185;&#x5b58;&#x7ba1;&#x7406;&#x548c;&#x7edf;&#x4e00;&#x5185;&#x5b58;&#x7ba1;&#x7406;&#xff0c;Spark 1.6&#x5f15;&#x5165;&#x7684;&#x7edf;&#x4e00;&#x5185;&#x5b58;&#x7ba1;&#x7406;&#xff0c;&#x9ed8;&#x8ba4;1.6&#xff08;&#x5305;&#x542b;1.6&#xff09;&#x4ee5;&#x4e0a;&#x4f7f;&#x7528;&#x7684;&#x662f;&#x7edf;&#x4e00;&#x5185;&#x5b58;&#x7ba1;&#x7406;"/>
<node CREATED="1542246175511" ID="ID_1572534829" MODIFIED="1542246190969" TEXT="&#x4f7f;&#x7528;&#x54ea;&#x79cd;&#x5185;&#x5b58;&#x7ba1;&#x7406; &#x9009;&#x62e9;&#x53c2;&#x6570;">
<node CREATED="1542246565759" ID="ID_798341639" MODIFIED="1542246628223" TEXT="spark.memory.useLegacyMode false  &#x7edf;&#x4e00;"/>
</node>
<node CREATED="1542246199417" ID="ID_1459299881" MODIFIED="1542246202983" TEXT="&#x9759;&#x6001;&#x5185;&#x5b58;&#x7ba1;&#x7406;">
<node CREATED="1542246209108" ID="ID_1542436325" MODIFIED="1542246210551" TEXT="0.2">
<node CREATED="1542246217473" ID="ID_1798889990" MODIFIED="1542246219503" TEXT="task&#x8fd0;&#x884c;"/>
</node>
<node CREATED="1542246210733" ID="ID_1932563884" MODIFIED="1542246541709" TEXT="0.2 ---- spark.shuffle.memoryFraction 0.2">
<node CREATED="1542246221126" ID="ID_340323199" MODIFIED="1542246235483" TEXT="0.2:&#x9884;&#x7559;&#x5185;&#x5b58;"/>
<node CREATED="1542246223241" ID="ID_1694399586" MODIFIED="1542246244641" TEXT="0.8&#xff1a;shuffle&#x805a;&#x5408;&#x5185;&#x5b58;"/>
</node>
<node CREATED="1542246212283" ID="ID_1581794353" MODIFIED="1542246515506" TEXT="0.6----spark.storage.memoryFraction 0.6">
<node CREATED="1542246246514" ID="ID_1805359665" MODIFIED="1542246266071" TEXT="0.1:&#x9884;&#x7559;&#x5185;&#x5b58;"/>
<node CREATED="1542246247609" ID="ID_1620530306" MODIFIED="1542246249072" TEXT="0.9">
<node CREATED="1542246249960" ID="ID_1101076907" MODIFIED="1542246530864" TEXT="0.2&#xff1a;&#x53cd;&#x5e8f;&#x5217;&#x5316; ---- spark.storage.unrollFraction 0.2"/>
<node CREATED="1542246253239" ID="ID_1014760602" MODIFIED="1542246283332" TEXT="0.8&#xff1a;RDD&#x7684;&#x7f13;&#x5b58;&#x548c;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;"/>
</node>
</node>
</node>
<node CREATED="1542246203161" ID="ID_1499556987" MODIFIED="1542246206435" TEXT="&#x7edf;&#x4e00;&#x5185;&#x5b58;&#x7ba1;&#x7406;">
<node CREATED="1542246357205" ID="ID_1446585256" MODIFIED="1542246362324" TEXT="300M&#x57fa;&#x7840;&#x5185;&#x5b58;"/>
<node CREATED="1542246362836" FOLDED="true" ID="ID_1693157911" MODIFIED="1542246744622" TEXT="&#xff08;&#x603b;-300M&#xff09;">
<node CREATED="1542246367899" ID="ID_1201603373" MODIFIED="1542246415499" TEXT="0.4&#xff08;1.6&#x7248;&#x672c; - 0.25&#xff09;">
<node CREATED="1542246426820" ID="ID_368369562" MODIFIED="1542246433589" TEXT="task &#x6267;&#x884c;"/>
</node>
<node CREATED="1542246371263" ID="ID_688531765" MODIFIED="1542246485113" TEXT="0.6&#xff08;1.6&#x7248;&#x672c; - 0.75&#xff09;----spark.memory.fraction 0.6">
<node CREATED="1542246435207" ID="ID_1342443507" MODIFIED="1542246449714" TEXT="0.5&#xff1a;shuffle&#x805a;&#x5408;&#x5185;&#x5b58;"/>
<node CREATED="1542246437357" ID="ID_1606391852" MODIFIED="1542246497721" TEXT="0.5&#xff1a;RDD&#x7f13;&#x5b58;&#x548c;&#x5e7f;&#x64ad;&#x53d8;&#x91cf; --spark.memory.storageFraction&#x9;0.5"/>
</node>
</node>
</node>
</node>
<node CREATED="1542246637088" FOLDED="true" ID="ID_1141168423" MODIFIED="1542246758846" TEXT="Shuffle&#x8c03;&#x4f18;">
<node CREATED="1542246647839" ID="ID_1321878660" MODIFIED="1542246652413" TEXT="spark.shuffle.file.buffer  32k"/>
<node CREATED="1542246655892" ID="ID_593718301" MODIFIED="1542246658897" TEXT="spark.reducer.maxSizeInFlight 48M"/>
<node CREATED="1542246665225" ID="ID_1355604962" MODIFIED="1542246673676" TEXT=" spark.shuffle.io.maxRetries  3"/>
<node CREATED="1542246679142" ID="ID_245288447" MODIFIED="1542246682224" TEXT="spark.shuffle.io.retryWait 5s"/>
<node CREATED="1542246687674" ID="ID_1429391597" MODIFIED="1542246696727" TEXT="spark.shuffle.memoryFraction 0.2 --&#x9759;&#x6001; &#x7edf;&#x4e00;&#xff1f;"/>
<node CREATED="1542246703781" ID="ID_1287291072" MODIFIED="1542246711442" TEXT="spark.shuffle.manager hash|sort 2.0+&#x6ca1;&#x6709;"/>
<node CREATED="1542246716062" ID="ID_1271356389" MODIFIED="1542246738096" TEXT="spark.shuffle.sort.bypassMergeThreshold --sortShuffleManager"/>
<node CREATED="1542246727422" ID="ID_614174213" MODIFIED="1542246734514" TEXT="spark.shuffle.consolidateFiles --hashShuffleManager"/>
<node CREATED="1542246751576" ID="ID_634727013" MODIFIED="1542246756788" TEXT="&#x5728;&#x63d0;&#x4ea4;&#x4efb;&#x52a1;&#x65f6;&#x914d;&#x7f6e;"/>
</node>
</node>
<node CREATED="1542249184639" FOLDED="true" ID="ID_597116503" MODIFIED="1542763513446" POSITION="right" TEXT="SparkSQL">
<node CREATED="1542261949400" FOLDED="true" ID="ID_63953715" MODIFIED="1542330882554" TEXT="SparkSQL ">
<node CREATED="1542261957560" ID="ID_936211995" MODIFIED="1542261967756" TEXT="&#x652f;&#x6301;&#x4f7f;&#x7528;SQL &#x67e5;&#x8be2;&#x5206;&#x5e03;&#x5f0f;&#x7684;&#x6570;&#x636e;"/>
<node CREATED="1542261970418" ID="ID_1139361786" MODIFIED="1542261986580" TEXT="Hive&#x4e2d; &#x5199;&#x7684;hql &#xff0c;&#x5e95;&#x5c42;&#x89e3;&#x6790;&#x6210;MRjob "/>
<node CREATED="1542261990982" ID="ID_1971485348" MODIFIED="1542262042232" TEXT="SparkSQL &#x53d1;&#x5c55;&#x8fc7;&#x7a0b; :Hive -&gt; Shark-&gt;SparkSQL"/>
</node>
<node CREATED="1542262044570" FOLDED="true" ID="ID_681488902" MODIFIED="1542330884386" TEXT="Shark&#x4e0e;SparkSQL">
<node CREATED="1542262058693" ID="ID_735278873" MODIFIED="1542262077511" TEXT="1.Shark &#x4e2d;&#x8bed;&#x6cd5;&#x652f;&#x6301;Hive&#x4e2d;&#x7684;&#x8bed;&#x6cd5;"/>
<node CREATED="1542262077701" ID="ID_1885858598" MODIFIED="1542262110748" TEXT="2.SparkSQL&#x7684;&#x51fa;&#x73b0;&#x5b8c;&#x5168;&#x4f7f;Spark&#x8131;&#x79bb;Hive&#xff0c;&#x89e3;&#x8026;&#xff0c;&#x4e0d;&#x5728;&#x4f9d;&#x8d56;&#x4e8e;Hive&#x7684;&#x89e3;&#x6790;&#x4f18;&#x5316;"/>
<node CREATED="1542262111195" ID="ID_1651655579" MODIFIED="1542262127729" TEXT="3.SparkSQL&#x517c;&#x5bb9;&#x6240;&#x6709;Hive&#x548c;Shark&#x7684;&#x8bed;&#x6cd5;"/>
<node CREATED="1542262128126" ID="ID_13151300" MODIFIED="1542262149599" TEXT="4.SparkSQL&#x652f;&#x6301;&#x67e5;&#x8be2;&#x539f;&#x751f;&#x7684;RDD,&#x8fd8;&#x53ef;&#x4ee5;&#x5c06;&#x7ed3;&#x679c;&#x62ff;&#x56de;&#x5f53;&#x505a;RDD&#x4f7f;&#x7528;"/>
</node>
<node CREATED="1542262153348" FOLDED="true" ID="ID_310440978" MODIFIED="1542330907809" TEXT="Spark on hive--SparkSQL">
<node CREATED="1542262168646" ID="ID_319921581" MODIFIED="1542262202215" TEXT="Spark&#xff1a;&#x89e3;&#x6790;&#x4f18;&#x5316;&#xff0c;&#x6267;&#x884c;&#x5f15;&#x64ce;"/>
<node CREATED="1542262203315" ID="ID_1628583909" MODIFIED="1542262208211" TEXT="Hive&#xff1a;&#x53ea;&#x662f;&#x5b58;&#x50a8;"/>
</node>
<node CREATED="1542262160989" FOLDED="true" ID="ID_1223562493" MODIFIED="1542330920131" TEXT="hive on  Spark--Shark">
<node CREATED="1542262210427" ID="ID_603670885" MODIFIED="1542262218303" TEXT="Spark&#xff1a;&#x6267;&#x884c;&#x5f15;&#x64ce;"/>
<node CREATED="1542262219271" ID="ID_994657095" MODIFIED="1542262234818" TEXT="Hive:&#x89e3;&#x6790;&#x4f18;&#x5316;&#xff0c;&#x5b58;&#x50a8;"/>
</node>
<node CREATED="1542262237117" FOLDED="true" ID="ID_55625947" MODIFIED="1542330880682" TEXT="DataFrame">
<node CREATED="1542262240751" ID="ID_1099198045" MODIFIED="1542262281859" TEXT="SparkCore&#x5e95;&#x5c42;&#x64cd;&#x4f5c;&#x7684;&#x662f;RDD,SparkSQL&#x5e95;&#x5c42;&#x64cd;&#x4f5c;&#x7684;&#x5c31;&#x662f;DataFrame"/>
<node CREATED="1542262282485" ID="ID_726644118" MODIFIED="1542262304157" TEXT="DataFrame&#x66f4;&#x50cf;&#x4e00;&#x5f20;&#x4e8c;&#x7ef4;&#x8868;&#x683c;&#xff0c;&#x6709;&#x6570;&#x636e;&#xff0c;&#x4e5f;&#x6709;&#x5217;&#x7684;Schema&#x4fe1;&#x606f;"/>
<node CREATED="1542262305652" ID="ID_1078259115" MODIFIED="1542262363757" TEXT="&#x60f3;&#x8981;&#x4f7f;&#x7528;sql&#x67e5;&#x8be2;&#x5206;&#x5e03;&#x5f0f;&#x6570;&#x636e;&#xff0c;&#x5fc5;&#x987b;&#x521b;&#x5efa;&#x51fa;&#x6765;DataFrame&#xff0c;&#x6709;&#x4e86;DataFrame&#x5c31;&#x53ef;&#x4ee5;&#x6ce8;&#x518c;&#x89c6;&#x56fe;&#xff0c;&#x4f7f;&#x7528;sql&#x67e5;&#x8be2;"/>
<node CREATED="1542262364164" ID="ID_35529405" MODIFIED="1542262403468" TEXT="&#x60f3;&#x8981;&#x521b;&#x5efa;DataFrame &#x5728;Spark1.6&#x4e2d;&#x9700;&#x8981;&#x521b;&#x5efa;SQLContext&#xff0c;&#x5728;Spark2.0+&#x9700;&#x8981;&#x521b;&#x5efa;SparkSession"/>
</node>
<node CREATED="1542262413408" ID="ID_156438672" MODIFIED="1542262446615" TEXT="&#x8c13;&#x8bcd;&#x4e0b;&#x63a8;&#xff0c;SparkSQL&#x4f18;&#x5316;job&#xff0c;&#x4f7f;&#x7528;&#x5230;&#x4e86;&#x8c13;&#x8bcd;&#x4e0b;&#x63a8;"/>
<node CREATED="1542253059132" FOLDED="true" ID="ID_1784190206" MODIFIED="1542331099138" TEXT="SparkSQL1.6&#x548c;SparkSQL2.0+ &#x533a;&#x522b;">
<node CREATED="1542253095806" ID="ID_1234757105" MODIFIED="1542253134370" TEXT="1.Spark 1.6&#x4e2d; &#x8981;&#x521b;&#x5efa;SQLContext(SparkContext),Spark2.0+ &#x4f7f;&#x7528;&#x7684;SparkSession"/>
<node CREATED="1542253136261" ID="ID_499240361" MODIFIED="1542253227029" TEXT="2.&#x5f97;&#x5230;DataFrame&#x540e;&#x6ce8;&#x518c;&#x4e34;&#x65f6;&#x8868;&#x4e0d;&#x4e00;&#x6837;&#xff1a;spark1.6&#x3010;df.registerTempTable&#x3011;spark2.0+&#x3010;df.createOrReplaceTempView&#x6216;&#x8005;df.createOrReplaceGlobalTempView&#x3011;"/>
<node CREATED="1542253233849" ID="ID_1625166486" MODIFIED="1542331096828" TEXT="3.Spark1.6+&#x5f15;&#x5165;DataSet&#xff0c;DataSet&#x4e0e;RDD&#x7684;&#x533a;&#x522b;&#xff1f;">
<node CREATED="1542264421068" ID="ID_1010284662" MODIFIED="1542264448096" TEXT="1.DataSet &#x5185;&#x90e8;&#x5e8f;&#x5217;&#x5316;&#x673a;&#x5236;&#x4e0e;RDD&#x4e0d;&#x540c;&#xff0c;&#x53ef;&#x4ee5;&#x4e0d;&#x7528;&#x53cd;&#x5e8f;&#x5217;&#x6210;&#x5bf9;&#x8c61;&#x8c03;&#x7528;&#x5bf9;&#x8c61;&#x7684;&#x65b9;&#x6cd5;"/>
<node CREATED="1542264448508" ID="ID_743787803" MODIFIED="1542264526162" TEXT="2.DataSet&#x662f;&#x5f3a;&#x7c7b;&#x578b;&#x7684;&#xff0c;&#x9ed8;&#x8ba4;&#x5217;&#x540d;&#x662f;&#x201c;value&#x201d;,&#x64cd;&#x4f5c;&#x4e0a;&#x7684;&#x65b9;&#x6cd5;&#x6bd4;RDD&#x7684;&#x591a;&#xff0c;RDD&#x4e2d;&#x6709;&#x7684;&#x7b97;&#x5b50; &#x5728;DataSet&#x4e2d;&#x90fd;&#x6709;"/>
</node>
</node>
<node CREATED="1542253285427" FOLDED="true" ID="ID_1286916871" MODIFIED="1542332210012" TEXT="&#x521b;&#x5efa;DataFrame&#x7684;&#x65b9;&#x5f0f;">
<node CREATED="1542253295186" FOLDED="true" ID="ID_1838593473" MODIFIED="1542331490436" TEXT="&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x7684;&#x6587;&#x4ef6;">
<node CREATED="1542253306195" ID="ID_565343963" MODIFIED="1542253380883" TEXT="1.&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x6587;&#x4ef6;&#xff0c;json&#x4e2d;&#x7684;&#x5c5e;&#x6027;&#x540d;&#x81ea;&#x52a8;&#x6210;&#x4e3a;&#x5217;&#xff0c;&#x5217;&#x7684;&#x7c7b;&#x578b;&#x4f1a;&#x81ea;&#x52a8;&#x63a8;&#x65ad;"/>
<node CREATED="1542253381504" ID="ID_1624337045" MODIFIED="1542253394694" TEXT="2.&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x7684;&#x6587;&#x4ef6;&#xff0c;&#x5217;&#x4f1a;&#x6309;&#x7167;Ascii &#x6392;&#x5e8f;"/>
<node CREATED="1542253463978" ID="ID_1366000980" MODIFIED="1542331352244" TEXT="3.&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x6587;&#x4ef6;&#x4e24;&#x79cd;&#x65b9;&#x5f0f;">
<node CREATED="1542253473605" ID="ID_243670942" MODIFIED="1542253490910" TEXT="sparksession.read().json(...)"/>
<node CREATED="1542253491342" ID="ID_460435165" MODIFIED="1542253508311" TEXT="sparkSession.read().format(&quot;json&quot;).load(...)"/>
</node>
<node CREATED="1542253572947" ID="ID_1434039795" MODIFIED="1542253593049" TEXT="4.df.show(num) &#x9ed8;&#x8ba4;&#x663e;&#x793a;&#x524d;20&#x884c;&#x6570;&#x636e; "/>
<node CREATED="1542253593548" ID="ID_1898479429" MODIFIED="1542253620471" TEXT="5.&#x521b;&#x5efa;&#x4e34;&#x65f6;&#x8868;&#x7684;&#x4e24;&#x79cd;&#x65b9;&#x5f0f;&#x548c;&#x533a;&#x522b;&#xff1a;createOrReplaceTempView  | createGlobalTempView &#xff0c;&#x533a;&#x522b;&#xff1a;createGlobalTempView &#x53ef;&#x4ee5;&#x8de8;seesion"/>
<node CREATED="1542253923080" ID="ID_485997065" MODIFIED="1542253945708" TEXT="6.&#x8bfb;&#x53d6;&#x5d4c;&#x5957;&#x683c;&#x5f0f;&#x7684;json&#x6570;&#x636e;&#xff0c;&#x4f7f;&#x7528;&#x5217;&#x540d;.&#x5c5e;&#x6027;&#x5373;&#x53ef;"/>
<node CREATED="1542262767579" ID="ID_1366224532" MODIFIED="1542331387781" TEXT="7.DataFrame&#x7ed3;&#x679c;&#x8fd8;&#x53ef;&#x4ee5;&#x62ff;&#x56de;&#x8f6c;&#x6362;&#x6210;RDD&#x4f7f;&#x7528;"/>
<node CREATED="1542262872009" ID="ID_110942489" MODIFIED="1542262896465" TEXT="8.&#x8bfb;&#x53d6;jsonArray&#x683c;&#x5f0f;&#x7684;&#x6570;&#x636e; explod() &#x51fd;&#x6570;&#xff0c;&#x5bfc;&#x5165;&#x9690;&#x5f0f;&#x8f6c;&#x6362;"/>
</node>
<node CREATED="1542262921701" FOLDED="true" ID="ID_1670040279" MODIFIED="1542331224114" TEXT="&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x7684;RDD/DataSet">
<node CREATED="1542264561434" ID="ID_1508295827" MODIFIED="1542264591115" TEXT="Spark1.6&#x4e2d;&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x7684;RDD,Spark2.0+&#x53ea;&#x6709;&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x7684;DataSet"/>
</node>
<node CREATED="1542266382784" FOLDED="true" ID="ID_605458921" MODIFIED="1542332208778" TEXT="&#x8bfb;&#x53d6;RDD&#x521b;&#x5efa;DataFrame">
<node CREATED="1542266401897" ID="ID_568901261" MODIFIED="1542331612917" TEXT="1.&#x53cd;&#x5c04;&#x7684;&#x65b9;&#x5f0f;">
<node CREATED="1542266412547" ID="ID_223186895" MODIFIED="1542266450696" TEXT="1.&#x5c06;RDD&#x8f6c;&#x6362;&#x6210;&#x81ea;&#x5b9a;&#x4e49;&#x7c7b;&#x578b;&#x7684;RDD"/>
<node CREATED="1542266436990" ID="ID_77449853" MODIFIED="1542266452763" TEXT="2.rdd.toDF()"/>
<node CREATED="1542266549134" ID="ID_418320534" MODIFIED="1542266575191" TEXT="Spark 1.6&#x4e2d;java&#xff1a;sqlContext.createDataFrame(personRDD, Person.class);"/>
</node>
<node CREATED="1542266580715" ID="ID_58557252" MODIFIED="1542331665964" TEXT="2.&#x52a8;&#x6001;&#x521b;&#x5efa;Schema">
<node CREATED="1542266861194" ID="ID_975459693" MODIFIED="1542266869232" TEXT="1.&#x521b;&#x5efa;Row&#x7c7b;&#x578b;&#x7684;RDD"/>
<node CREATED="1542266869884" ID="ID_1761103262" MODIFIED="1542266899377" TEXT="2.&#x4f7f;&#x7528; spark.createDataFrame(rowRDD,structType) &#x6620;&#x5c04;&#x6210;DataFrame"/>
<node CREATED="1542267203801" ID="ID_53211010" MODIFIED="1542267204585" TEXT="&#x6ce8;&#x610f;&#xff1a;&#x52a8;&#x6001;&#x521b;&#x5efa;&#x7684;ROW&#x4e2d;&#x6570;&#x636e;&#x7684;&#x987a;&#x5e8f;&#x8981;&#x4e0e;&#x521b;&#x5efa;Schema&#x7684;&#x987a;&#x5e8f;&#x4e00;&#x81f4;&#x3002;"/>
</node>
</node>
<node CREATED="1542267264576" FOLDED="true" ID="ID_1914253282" MODIFIED="1542332207402" TEXT="&#x8bfb;&#x53d6;parquet&#x683c;&#x5f0f;&#x6570;&#x636e;&#x52a0;&#x8f7d;DataFrame">
<node CREATED="1542267655875" ID="ID_1120203155" MODIFIED="1542267663742" TEXT="&#x4e0e;&#x8bfb;&#x53d6;json&#x683c;&#x5f0f;&#x7684;&#x6570;&#x636e;&#x4e00;&#x6837;"/>
</node>
<node CREATED="1542267666223" FOLDED="true" ID="ID_763903986" MODIFIED="1542332206794" TEXT="&#x8bfb;&#x53d6;Mysql&#x4e2d;&#x7684;&#x6570;&#x636e;&#x52a0;&#x8f7d;&#x6210;DataFrame">
<node CREATED="1542331880387" ID="ID_658727385" MODIFIED="1542331899646" TEXT="spark.read.format(&quot;jdbc&quot;).options(map).load() | &#x5206;&#x522b;.option...."/>
<node CREATED="1542331902673" ID="ID_1259240127" MODIFIED="1542331917234" TEXT="spark.read.jdbc(&quot;jdbc:mysql://192.168.179.4:3306/spark&quot;,&quot;person&quot;,properties)"/>
<node CREATED="1542331922141" ID="ID_311257280" MODIFIED="1542331971578" TEXT="&#x4ee5;&#x4e0a;&#x4e24;&#x7c7b;&#xff0c;&#x90fd;&#x652f;&#x6301; &#x5c06; table&#x6362;&#x6210; &#x590d;&#x6742;&#x7684;&#x8bed;&#x53e5;&#xff0c;&#x4f46;&#x662f;&#x5fc5;&#x987b; &#x201c;(&#x590d;&#x6742;&#x8bed;&#x53e5;) T&#x201d; &#x7ed9;&#x522b;&#x540d;&#x65b9;&#x5f0f;&#x4f7f;&#x7528;"/>
</node>
<node CREATED="1542271289163" FOLDED="true" ID="ID_608014818" MODIFIED="1542332207939" TEXT="&#x8bfb;&#x53d6;Hive&#x4e2d;&#x7684;&#x6570;&#x636e;&#x52a0;&#x8f7d;DataFrame">
<node CREATED="1542272969602" ID="ID_1517367087" MODIFIED="1542273027689" TEXT="Spark1.6&#x8981;&#x4f7f;&#x7528;HiveContext &#x64cd;&#x4f5c;Hive&#x6570;&#x636e;"/>
<node CREATED="1542273027868" ID="ID_673191105" MODIFIED="1542273082558" TEXT="Spark2.0+&#x4ee5;&#x4e0a;&#xff0c;SparkSession &#x5c06;SQLContext&#x548c;HiveContext &#x76f8;&#x5f53;&#x4e8e;&#x5c01;&#x88c5;&#xff0c;&#x4f46;&#x662f;&#x8981;&#x8bfb;&#x53d6;Hive&#x4e2d;&#x7684;&#x6570;&#x636e;&#x8981;&#x5f00;&#x542f;Hive&#x652f;&#x6301; enableHiveSupport()"/>
</node>
</node>
<node CREATED="1542267354912" FOLDED="true" ID="ID_1154741322" MODIFIED="1542332216171" TEXT="&#x4fdd;&#x5b58;DataFrame ">
<node CREATED="1542267370313" FOLDED="true" ID="ID_1750740088" MODIFIED="1542270304243" TEXT="&#x5c06;DataFrame&#x4fdd;&#x5b58;&#x6210;parquet&#x6587;&#x4ef6;">
<node CREATED="1542267450474" ID="ID_1132612471" MODIFIED="1542267450474" TEXT="df1.write.mode(SaveMode.Append).format(&quot;parquet&quot;).save(&quot;./data/parquet&quot;)"/>
</node>
<node CREATED="1542268628433" ID="ID_1126622942" MODIFIED="1542268640764" TEXT="&#x5c06;DataFrame&#x4fdd;&#x5b58;&#x5230;MySql&#x8868;&#x4e2d;"/>
<node CREATED="1542271601575" ID="ID_486023121" MODIFIED="1542271614075" TEXT="&#x5c06;DataFrame&#x4fdd;&#x5b58;&#x5230;Hive&#x8868;&#x4e2d;"/>
</node>
<node CREATED="1542271300927" FOLDED="true" ID="ID_385158222" MODIFIED="1542332139019" TEXT="&#x914d;&#x7f6e; Spark on Hive">
<node CREATED="1542332001190" FOLDED="true" ID="ID_969614245" MODIFIED="1542332137426" TEXT="1.&#x5728;&#x5ba2;&#x6237;&#x7aef; ../conf/&#x4e2d;&#x521b;&#x5efa;hive-site.xml&#xff0c;&#x8ba9;SparkSQL&#x627e;&#x5230;Hive&#x539f;&#x6570;&#x636e;">
<node CREATED="1542332051694" MODIFIED="1542332051694" TEXT="&lt;configuration&gt;"/>
<node CREATED="1542332051696" MODIFIED="1542332051696" TEXT="&lt;property&gt;"/>
<node CREATED="1542332051697" ID="ID_794500057" MODIFIED="1542332051697" TEXT="&lt;name&gt;hive.metastore.uris&lt;/name&gt;"/>
<node CREATED="1542332051698" MODIFIED="1542332051698" TEXT="&lt;value&gt;thrift://node1:9083&lt;/value&gt;"/>
<node CREATED="1542332051699" MODIFIED="1542332051699" TEXT="&lt;/property&gt;"/>
<node CREATED="1542332051700" ID="ID_1140130846" MODIFIED="1542332051700" TEXT="&lt;/configuration&gt;"/>
</node>
<node CREATED="1542332055091" ID="ID_1713606034" MODIFIED="1542332104683" TEXT="2.&#x5728;Hive&#x7684;&#x670d;&#x52a1;&#x7aef;&#x542f;&#x52a8;metaStore &#x670d;&#x52a1; &#xff1a; hive --service metastore &amp;"/>
<node CREATED="1542332106545" ID="ID_1153480673" MODIFIED="1542332118037" TEXT="3.&#x4f7f;&#x7528;spark-shell &#x6d4b;&#x8bd5; &#x901f;&#x5ea6;"/>
</node>
<node CREATED="1542274240340" ID="ID_1037754405" MODIFIED="1542274243433" TEXT="UDF">
<node CREATED="1542274280905" ID="ID_762309179" MODIFIED="1542332236614" TEXT="user defined function&#xff0c;&#x7528;&#x6237;&#x81ea;&#x5b9a;&#x4e49;&#x51fd;&#x6570;"/>
<node CREATED="1542332224457" ID="ID_1958868411" MODIFIED="1542332347565" TEXT="java:sqlContext.udf().register(&quot;StrLen&quot;, new UDF1&lt;String,Integer&gt;())  &#x4f20;&#x51e0;&#x4e2a;&#x53c2;&#x6570;&#xff0c;&#x8981;&#x5b9e;&#x73b0;&#x5bf9;&#x5e94;&#x7684;UDFXX&#x63a5;&#x53e3;&#xff0c;&#x6700;&#x591a;&#x652f;&#x6301;22&#x4e2a;"/>
</node>
<node CREATED="1542274251460" ID="ID_1306830767" MODIFIED="1542274254485" TEXT="UDAF">
<node CREATED="1542274294219" ID="ID_274749491" MODIFIED="1542332401568" TEXT="user defined aggregate function&#xff0c;&#x7528;&#x6237;&#x81ea;&#x5b9a;&#x4e49;&#x805a;&#x5408;&#x51fd;&#x6570;"/>
<node CREATED="1542332405541" ID="ID_460338544" MODIFIED="1542332457316" TEXT="count,avg,sum,min,max.. &#x7279;&#x70b9;&#xff1a;&#x591a;&#x5bf9;&#x4e00;&#xff0c;select name ,count(*) from table group by name"/>
<node CREATED="1542332497359" ID="ID_1050529405" MODIFIED="1542336243430" TEXT="&#x662f;&#x805a;&#x5408;&#x51fd;&#x6570;&#xff0c;&#x8981;&#x7ee7;&#x627f; UserDefinedAggregateFunction() &#x5b9e;&#x73b0;8&#x4e2a;&#x65b9;&#x6cd5;&#xff0c;&#x6700;&#x91cd;&#x8981;&#x4e09;&#x4e2a;&#x65b9;&#x6cd5;">
<node CREATED="1542336231396" ID="ID_1475937163" MODIFIED="1542336235864" TEXT="initialize"/>
<node CREATED="1542336239347" ID="ID_663801127" MODIFIED="1542336239347" TEXT="update"/>
<node CREATED="1542336242626" ID="ID_1196598537" MODIFIED="1542336242626" TEXT="merge"/>
</node>
</node>
<node CREATED="1542274254666" ID="ID_758319083" MODIFIED="1542274259126" TEXT="&#x5f00;&#x7a97;&#x51fd;&#x6570;">
<node CREATED="1542336252011" ID="ID_1342264186" MODIFIED="1542348282089" TEXT="over &#x5f00;&#x7a97;&#x51fd;&#x6570;"/>
<node CREATED="1542348282770" ID="ID_377200425" MODIFIED="1542348303607" TEXT="row_number() over(partition by xxx order by xx desc ) as rank "/>
<node CREATED="1542348303790" ID="ID_1454255413" MODIFIED="1542348316098" TEXT="rank &#x5728;&#x6bcf;&#x4e2a;&#x5206;&#x7ec4;&#x5185;&#x4ece;1&#x5f00;&#x59cb;"/>
</node>
</node>
<node CREATED="1542348322309" ID="ID_1147814403" MODIFIED="1542762309475" POSITION="right" TEXT="SparkStreaming">
<node CREATED="1542762263584" ID="ID_41358853" MODIFIED="1542762307334" TEXT="Spark&#x4e2d;&#x6d41;&#x5f0f;&#x5904;&#x7406;&#x6a21;&#x5757;&#xff0c;SparkStreaming&#x662f;7*24&#x5c0f;&#x65f6;&#x4e0d;&#x95f4;&#x65ad;&#x8fd0;&#x884c;&#xff0c;&#x5e95;&#x5c42;&#x64cd;&#x4f5c;&#x7684;&#x662f;DStream,DStream&#x5e95;&#x5c42;&#x662f;RDD"/>
<node CREATED="1542762284843" FOLDED="true" ID="ID_1114344305" MODIFIED="1542763829268" TEXT="SparkStreaming&#x4e0e;Strom&#x7684;&#x533a;&#x522b;">
<node CREATED="1542762323950" ID="ID_872579207" MODIFIED="1542762346734" TEXT="1.SparkStreaming&#x662f;&#x5fae;&#x6279;&#x5904;&#x7406;&#xff0c;Strom&#x662f;&#x7eaf;&#x5b9e;&#x65f6;&#x5904;&#x7406;&#x6570;&#x636e;&#xff0c;SparkStreaming&#x7684;&#x541e;&#x5410;&#x91cf;&#x5927;&#x3002;"/>
<node CREATED="1542762347205" ID="ID_832284572" MODIFIED="1542762407574" TEXT="2.SparkStreaming&#x64c5;&#x957f;&#x5904;&#x7406;&#x590d;&#x6742;&#x7684;&#x4e1a;&#x52a1;&#xff0c;Storm&#x64c5;&#x957f;&#x5904;&#x7406;&#x7b80;&#x5355;&#x7684;&#x6c47;&#x603b;&#x578b;&#x4e1a;&#x52a1;&#x3002;"/>
<node CREATED="1542762373023" ID="ID_1893696915" MODIFIED="1542762400868" TEXT="3.Storm&#x7684;&#x4e8b;&#x52a1;&#x76f8;&#x5bf9;&#x4e8e;SparkStreaming&#x5b8c;&#x5584;&#xff0c;SparkStreaming&#x73b0;&#x5728;&#x4e5f;&#x6bd4;&#x8f83;&#x5b8c;&#x5584;&#x3002;"/>
<node CREATED="1542762408898" ID="ID_1702290524" MODIFIED="1542762435148" TEXT="4.Storm&#x652f;&#x6301;&#x52a8;&#x6001;&#x7684;&#x8d44;&#x6e90;&#x8c03;&#x5ea6;&#xff0c;Spark1.2&#x4e4b;&#x540e;&#x4e5f;&#x662f;&#x652f;&#x6301;&#x52a8;&#x6001;&#x8d44;&#x6e90;&#x8c03;&#x5ea6;"/>
</node>
<node CREATED="1542762688202" FOLDED="true" ID="ID_321433132" MODIFIED="1542763828764" TEXT="SparkStreaming&#x8bfb;&#x53d6;&#x6570;&#x636e;&#x6d41;&#x7a0b;">
<node CREATED="1542762701770" ID="ID_834936013" MODIFIED="1542762764378" TEXT="1.SparkStremaming&#x542f;&#x52a8;&#x4e4b;&#xff0c;&#x9996;&#x5148;&#x4f1a;&#x542f;&#x52a8;&#x4e00;&#x4e2a;job&#x63a5;&#x6536;&#x6570;&#x636e;&#xff0c;&#x6bcf;&#x9694;batchInterval &#x5c06;&#x6570;&#x636e;&#x5c01;&#x88c5;&#x5230;&#x4e00;&#x4e2a;batch&#x4e2d;&#xff0c;&#x8fd9;&#x4e2a;batch&#x53c8;&#x88ab;&#x5c01;&#x88c5;&#x5230;RDD&#x4e2d;&#xff0c;RDD&#x53c8;&#x88ab;&#x5c01;&#x88c5;&#x5230;&#x4e00;&#x4e2a;DStream&#x4e2d;"/>
<node CREATED="1542762764770" ID="ID_824626351" MODIFIED="1542762826082" TEXT="2.SparkStreaming&#x5bf9;&#x751f;&#x6210;&#x7684;DStream&#x8fdb;&#x884c;&#x5904;&#x7406;&#xff0c;DStream&#x6709;&#x81ea;&#x5df1;&#x7684;Transformation&#x7c7b;&#x7b97;&#x5b50;&#xff0c;&#x61d2;&#x6267;&#x884c;&#xff0c;&#x9700;&#x8981;DStream&#x7684;OutputOperator&#x7c7b;&#x7b97;&#x5b50;&#x89e6;&#x53d1;&#x6267;&#x884c;"/>
<node CREATED="1542762832520" ID="ID_306500909" MODIFIED="1542762868448" TEXT="3.&#x5982;&#x679c;batchInterval = 5s &#xff0c;&#x5904;&#x7406;&#x4e00;&#x6279;&#x6b21;&#x6570;&#x636e;&#x7684;&#x65f6;&#x95f4;&#x5c0f;&#x4e8e;5s,&#x96c6;&#x7fa4;&#x8d44;&#x6e90;&#x4e0d;&#x80fd;&#x5145;&#x5206;&#x5229;&#x7528;"/>
<node CREATED="1542762869484" ID="ID_15261879" MODIFIED="1542762890246" TEXT="4.&#x5982;&#x679c;batchInterval = 5s &#xff0c;&#x5904;&#x7406;&#x4e00;&#x6279;&#x6b21;&#x6570;&#x636e;&#x7684;&#x65f6;&#x95f4;&#x5927;&#x4e8e;5s,&#x4efb;&#x52a1;&#x6709;&#x5806;&#x79ef;"/>
</node>
<node CREATED="1542762437837" FOLDED="true" ID="ID_1629322290" MODIFIED="1542763827092" TEXT="SparkStreaming&#x8bfb;&#x53d6;Socket&#x6570;&#x636e;">
<node CREATED="1542762455096" ID="ID_356266910" MODIFIED="1542762465527" TEXT="nc -lk 9999"/>
<node CREATED="1542762465728" ID="ID_1852939815" MODIFIED="1542762473170" TEXT="local[2]"/>
<node CREATED="1542762473367" ID="ID_88863935" MODIFIED="1542762509668" TEXT="&#x521b;&#x5efa;StreamingContext&#x7684;&#x4e24;&#x79cd;&#x65b9;&#x5f0f; val ssc = new StreamingContext(SparkConf/SparkContext,Durations.Seconds(5))"/>
<node CREATED="1542762512029" ID="ID_1717384510" MODIFIED="1542762526862" TEXT="&#x5982;&#x4f55;&#x8c03;&#x8282;batchInterval &#x8981;&#x7ed3;&#x5408;webui&#x8c03;&#x8282;"/>
<node CREATED="1542762527343" ID="ID_1019376724" MODIFIED="1542762545106" TEXT="StreamingContext&#x542f;&#x52a8;&#x4e4b;&#x540e;&#xff0c;&#x4e0d;&#x80fd;&#x6dfb;&#x52a0;&#x65b0;&#x7684;&#x903b;&#x8f91;"/>
<node CREATED="1542762545273" ID="ID_1389966626" MODIFIED="1542762631466" TEXT="StreamingContext.stop(&#x9ed8;&#x8ba4; true) &#x5c06;StreamingContext&#x5173;&#x95ed;&#x65f6;&#xff0c;&#x5c06;SparkContext&#x4e5f;&#x5173;&#x95ed;,&#x5982;&#x679c;&#x8bbe;&#x7f6e;&#x6210;false&#xff0c;&#x5173;&#x95ed;StreamingContext&#x65f6;&#xff0c;&#x4e0d;&#x56de;&#x6536;SparkContext"/>
<node CREATED="1542762655072" ID="ID_1044006164" MODIFIED="1542762683460" TEXT="StreamingContext.stop()&#x4e4b;&#x540e;&#xff0c;&#x4e0d;&#x80fd;&#x91cd;&#x65b0;&#x8c03;&#x7528;start&#x65b9;&#x6cd5;&#x542f;&#x52a8;&#x3002;"/>
</node>
<node CREATED="1542762928214" FOLDED="true" ID="ID_995040004" MODIFIED="1542763825982" TEXT="SparkStreaming&#x7b97;&#x5b50;">
<node CREATED="1542762935277" ID="ID_1719301606" MODIFIED="1542762938686" TEXT="Transformation">
<node CREATED="1542762951148" ID="ID_912179447" MODIFIED="1542762960033" TEXT="flatMap."/>
<node CREATED="1542762960580" ID="ID_1991726601" MODIFIED="1542762961548" TEXT="map.."/>
<node CREATED="1542762961748" ID="ID_538923232" MODIFIED="1542762964453" TEXT="fiter.."/>
<node CREATED="1542762965499" ID="ID_809560962" MODIFIED="1542762966266" TEXT="..."/>
<node CREATED="1542762974041" ID="ID_1038021176" MODIFIED="1542763084234" TEXT="updateStateByKey">
<node CREATED="1542763084971" ID="ID_1424005067" MODIFIED="1542763105765" TEXT="&#x6839;&#x636e;key&#x66f4;&#x65b0;&#x81ea;&#x4ece;SparkStreaming&#x542f;&#x52a8;&#x4ee5;&#x6765;&#x6240;&#x6709;key&#x7684;&#x72b6;&#x6001;"/>
<node CREATED="1542763106202" ID="ID_458371845" MODIFIED="1542763123104" TEXT="&#x9700;&#x8981;&#x8bbe;&#x7f6e;checkpoint">
<node CREATED="1542763124430" ID="ID_593260136" MODIFIED="1542763153030" TEXT="&#x5982;&#x679c;batchInterval &#x5927;&#x4e8e;10s,batchInterval&#x66f4;&#x65b0;&#x4e00;&#x6b21;"/>
<node CREATED="1542763153196" ID="ID_761636853" MODIFIED="1542763167469" TEXT="&#x5982;&#x679c;batchInterval &#x5c0f;&#x4e8e;10s,10s&#x66f4;&#x65b0;&#x4e00;&#x6b21;"/>
</node>
</node>
<node CREATED="1542763174751" ID="ID_1672737774" MODIFIED="1542763366546" TEXT="reduceByKeyAndWindow">
<node CREATED="1542763191625" ID="ID_1800607694" MODIFIED="1542763276584" TEXT="reduceByKeyAndWindow(xxx,&#x7a97;&#x53e3;&#x957f;&#x5ea6;&#xff0c;&#x6ed1;&#x52a8;&#x95f4;&#x9694;)&#xff1a;&#x6bcf;&#x9694;&#x201c;&#x6ed1;&#x52a8;&#x95f4;&#x9694;&#x201d;&#x65f6;&#x95f4;&#xff0c;&#x5c06;&#x6700;&#x8fd1;&#x7684;&#x201c;&#x7a97;&#x53e3;&#x957f;&#x5ea6;&#x201d;&#x65f6;&#x95f4;&#x5185;&#x7684;&#x6570;&#x636e;&#xff0c;&#x505a;&#x4e00;&#x6b21;&#x5904;&#x7406;"/>
<node CREATED="1542763220705" ID="ID_547889514" MODIFIED="1542763239501" TEXT="&#x7a97;&#x53e3;&#x957f;&#x5ea6;&#x548c;&#x6ed1;&#x52a8;&#x95f4;&#x9694;&#x5fc5;&#x987b;&#x662f;batchInterval &#x7684;&#x6574;&#x6570;&#x500d;"/>
<node CREATED="1542763240085" ID="ID_1204864734" MODIFIED="1542763308460" TEXT="&#x666e;&#x901a;&#x673a;&#x5236;&#xff1a;&#x7a97;&#x53e3;&#x5185;&#x7684;&#x6bcf;&#x4e2a;&#x6279;&#x6b21;&#x90fd;&#x4f1a;&#x91cd;&#x65b0;&#x8ba1;&#x7b97;"/>
<node CREATED="1542763308885" ID="ID_333490926" MODIFIED="1542763346459" TEXT="&#x4f18;&#x5316;&#x673a;&#x5236;&#xff1a;&#x8981;&#x8bbe;&#x7f6e;checkpoint,&#x5c06;&#x4e0a;&#x6b21;&#x7a97;&#x53e3;&#x957f;&#x5ea6;&#x5185;&#x7684;&#x7ed3;&#x679c;&#x4fdd;&#x5b58;&#xff0c;&#x52a0;&#x4e0a;&#x65b0;&#x8fdb;&#x6765;&#x7684;&#x6279;&#x6b21;&#xff0c;&#x51cf;&#x53bb;&#x51fa;&#x53bb;&#x7684;&#x6279;&#x6b21;"/>
</node>
<node CREATED="1542763373523" ID="ID_1943234740" MODIFIED="1542763378576" TEXT="window">
<node CREATED="1542763380599" ID="ID_1031456905" MODIFIED="1542763392979" TEXT="window(&#x7a97;&#x53e3;&#x957f;&#x5ea6;&#xff0c;&#x6ed1;&#x52a8;&#x95f4;&#x9694;)"/>
</node>
<node CREATED="1542763395040" ID="ID_592018699" MODIFIED="1542763399989" TEXT="transform">
<node CREATED="1542763405077" ID="ID_1994494085" MODIFIED="1542763429013" TEXT="&#x53ef;&#x4ee5;&#x62ff;&#x5230;DStream&#x4e2d;&#x7684;RDD,&#x5bf9;RDD&#x8fdb;&#x884c;&#x8f6c;&#x6362;&#xff0c;&#x4f46;&#x662f;&#x8981;&#x8fd4;&#x56de;&#x4e00;&#x4e2a;RDD"/>
<node CREATED="1542763429191" ID="ID_1131142788" MODIFIED="1542763449066" TEXT="transform&#x4ee3;&#x7801;&#x5185;&#xff0c;&#x62ff;&#x5230;&#x7684;RDD&#x7684;&#x4ee3;&#x7801;&#x5916;&#xff0c;&#x662f;&#x5728;Driver&#x7aef;&#x6267;&#x884c;&#xff0c;&#x53ef;&#x4ee5;&#x901a;&#x8fc7;&#x8fd9;&#x4e2a;&#x7279;&#x70b9;&#xff0c;&#x505a;&#x5230;&#x52a8;&#x6001;&#x6539;&#x53d8;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;"/>
</node>
</node>
<node CREATED="1542762938854" ID="ID_841522309" MODIFIED="1542762947925" TEXT="OutputOperator">
<node CREATED="1542762979124" ID="ID_250450761" MODIFIED="1542763065176" TEXT="foreachRDD">
<node CREATED="1542762986544" ID="ID_273979392" MODIFIED="1542763015828" TEXT="&#x53ef;&#x4ee5;&#x62ff;&#x5230;DStream&#x4e2d;&#x7684;RDD&#xff0c;&#x5bf9;RDD&#x8fdb;&#x884c;&#x8f6c;&#x6362;&#xff0c;&#x4f46;&#x662f;&#x4e00;&#x5b9a;&#x8981;&#x5bf9;&#x62ff;&#x5230;&#x7684;RDD&#x4f7f;&#x7528;Action&#x89e6;&#x53d1;"/>
<node CREATED="1542763016768" ID="ID_434914259" MODIFIED="1542763059061" TEXT="foreachRDD&#x4ee3;&#x7801;&#x5185;&#xff0c;&#x62ff;&#x5230;&#x7684;RDD&#x7684;&#x4ee3;&#x7801;&#x5916;&#xff0c;&#x662f;&#x5728;Driver&#x7aef;&#x6267;&#x884c;&#xff0c;&#x53ef;&#x4ee5;&#x901a;&#x8fc7;&#x8fd9;&#x4e2a;&#x7279;&#x70b9;&#xff0c;&#x505a;&#x5230;&#x52a8;&#x6001;&#x6539;&#x53d8;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;"/>
</node>
<node CREATED="1542763067279" ID="ID_36491609" MODIFIED="1542763072796" TEXT="print(xx)"/>
<node CREATED="1542763458378" ID="ID_1999585392" MODIFIED="1542763466842" TEXT="saveAsTextFile.."/>
<node CREATED="1542763467025" ID="ID_102847261" MODIFIED="1542763474584" TEXT="saveAsHadoopFile"/>
<node CREATED="1542763474760" ID="ID_1782357678" MODIFIED="1542763482460" TEXT="saveAsObjectFile.."/>
</node>
</node>
<node CREATED="1542763488192" FOLDED="true" ID="ID_1286576151" MODIFIED="1542763824997" TEXT="Dirver HA">
<node CREATED="1542763521985" ID="ID_1505597274" MODIFIED="1542763554822" TEXT="SparkStreaming Driver&#x8981;&#x4e00;&#x76f4;&#x542f;&#x52a8;&#xff0c;&#x5982;&#x679c;&#x6302;&#x6389;Apliication&#x5c31;&#x6302;&#x6389;"/>
<node CREATED="1542763555014" ID="ID_1509307788" MODIFIED="1542763561572" TEXT="&#x5b9e;&#x73b0;Driver HA">
<node CREATED="1542763562294" ID="ID_1028433284" MODIFIED="1542763578459" TEXT="1.&#x63d0;&#x4ea4;&#x4efb;&#x52a1;&#x65f6;&#x6267;&#x884c; --supervise "/>
<node CREATED="1542763585961" ID="ID_1365838224" MODIFIED="1542763639320" TEXT="2.&#x4ee3;&#x7801;&#x4e2d; StreamingContext.getOrCreate(&quot;checkpint&#x76ee;&#x5f55;&quot;,&#x201c;&#x521b;&#x5efa;StreamingContext&#x7684;&#x65b9;&#x6cd5;&#x201d;)"/>
</node>
<node CREATED="1542763668729" ID="ID_1024656574" MODIFIED="1542763672440" TEXT="checkpoint&#x5b58;&#x50a8;">
<node CREATED="1542763673014" ID="ID_113825650" MODIFIED="1542763678027" TEXT="1.DStream&#x7684;&#x914d;&#x7f6e;"/>
<node CREATED="1542763678196" ID="ID_1422055241" MODIFIED="1542763681063" TEXT="2.DStream&#x903b;&#x8f91;"/>
<node CREATED="1542763681240" ID="ID_845440306" MODIFIED="1542763689395" TEXT="3.&#x6279;&#x6b21;&#x6267;&#x884c;&#x8fdb;&#x5ea6;"/>
<node CREATED="1542763689552" ID="ID_1298950694" MODIFIED="1542763711720" TEXT="4.offset -- kafka"/>
</node>
<node CREATED="1542763729039" ID="ID_786053108" MODIFIED="1542763770690" TEXT="Driver HA &#x4e3b;&#x8981;&#x7528;&#x5230; &#x5f53;&#x505c;&#x6b62;SparkStreaming &#x65f6;&#xff0c;&#x518d;&#x6b21;&#x542f;&#x52a8;&#x65f6;&#xff0c;SparkStreaming&#x53ef;&#x4ee5;&#x63a5;&#x7740;&#x4e0a;&#x6b21;&#x6d88;&#x8d39;&#x7684;&#x6570;&#x636e;&#x7ee7;&#x7eed;&#x6d88;&#x8d39;"/>
</node>
<node CREATED="1542763820196" FOLDED="true" ID="ID_395170436" MODIFIED="1542848779376" TEXT="kafka">
<node CREATED="1542767097930" FOLDED="true" ID="ID_876705755" MODIFIED="1542848778280" TEXT="&#x6982;&#x5ff5;">
<node CREATED="1542767109622" ID="ID_1899941662" MODIFIED="1542767136615" TEXT="kafka &#x662f;&#x5206;&#x5e03;&#x5f0f;&#x6d88;&#x606f;&#x7cfb;&#x7edf;&#xff0c;&#x9ed8;&#x8ba4;&#x6d88;&#x606f;&#x662f;&#x5b58;&#x50a8;&#x78c1;&#x76d8;&#xff0c;&#x9ed8;&#x8ba4;&#x4fdd;&#x5b58;7&#x5929;&#x3002;"/>
<node CREATED="1542767140487" ID="ID_287036489" MODIFIED="1542767147499" TEXT="producer ">
<node CREATED="1542767148123" ID="ID_1925966913" MODIFIED="1542767197069" TEXT="&#x6d88;&#x606f;&#x751f;&#x4ea7;&#x8005;&#xff0c;&#x4e24;&#x79cd;&#x673a;&#x5236;&#xff0c;1.&#x8f6e;&#x8be2;&#xff0c;2.key&#x7684;hash &#x3002;&#x5982;&#x679c;key &#x662f;null ,&#x5c31;&#x662f;&#x8f6e;&#x8be2;&#xff0c;&#x5982;&#x679c;key &#x975e;null&#xff0c;&#x6309;&#x7167;key &#x7684;hash"/>
</node>
<node CREATED="1542767203340" ID="ID_524184135" MODIFIED="1542767210077" TEXT="broker">
<node CREATED="1542767210546" ID="ID_1961668712" MODIFIED="1542767258572" TEXT="&#x7ec4;&#x6210;kafka&#x96c6;&#x7fa4;&#x7684;&#x8282;&#x70b9;&#xff0c;broker&#x4e4b;&#x95f4;&#x6ca1;&#x6709;&#x4e3b;&#x4ece;&#x5173;&#x7cfb;&#xff0c;&#x4f9d;&#x8d56;zookeeper&#x534f;&#x8c03;&#x3002;broker&#x8d1f;&#x8d23;&#x6d88;&#x606f;&#x7684;&#x8bfb;&#x5199;&#x548c;&#x5b58;&#x50a8;&#x3002;&#x6bcf;&#x4e2a;broker&#x53ef;&#x4ee5;&#x7ba1;&#x7406;&#x591a;&#x4e2a;partition"/>
</node>
<node CREATED="1542767261077" ID="ID_1065205512" MODIFIED="1542767265271" TEXT="topic ">
<node CREATED="1542767266148" ID="ID_508291467" MODIFIED="1542767276586" TEXT="&#x4e00;&#x7c7b;&#x6d88;&#x606f;/&#x6d88;&#x606f;&#x961f;&#x5217;&#x3002;"/>
<node CREATED="1542767277459" ID="ID_333516440" MODIFIED="1542767463598" TEXT="&#x6bcf;&#x4e2a;topic&#x662f;&#x7531;&#x591a;&#x4e2a;partition &#x7ec4;&#x6210;&#xff0c;&#x4e3a;&#x4e86;&#x63d0;&#x9ad8;&#x5e76;&#x884c;&#x5ea6;&#x3002;&#x7531;&#x51e0;&#x4e2a;&#x7ec4;&#x6210;&#xff1f;&#x53ef;&#x4ee5;&#x521b;&#x5efa;&#x6307;&#x5b9a;&#x3002;"/>
</node>
<node CREATED="1542767317347" ID="ID_867634525" MODIFIED="1542767320040" TEXT="partition">
<node CREATED="1542767321268" ID="ID_1075633145" MODIFIED="1542767340954" TEXT="&#x7ec4;&#x6210;topic&#x7684;&#x5355;&#x5143;&#xff0c;&#x76f4;&#x63a5;&#x63a5;&#x89e6;&#x78c1;&#x76d8;&#xff0c;&#x6d88;&#x606f;&#x662f;append&#x5230;&#x6bcf;&#x4e2a;partition&#x4e0a;&#x7684;"/>
<node CREATED="1542767341117" ID="ID_1554642954" MODIFIED="1542767363200" TEXT="&#x6bcf;&#x4e2a;partition&#x5185;&#x90e8;&#x6d88;&#x606f;&#x662f;&#x5f3a;&#x6709;&#x5e8f;&#x7684;&#x3002;FIFO."/>
<node CREATED="1542767363381" ID="ID_374258548" MODIFIED="1542767384182" TEXT="&#x6bcf;&#x4e2a;partition&#x6709;&#x526f;&#x672c;&#xff0c;&#x51e0;&#x4e2a;&#x526f;&#x672c;&#xff1f;&#x521b;&#x5efa;topic&#x65f6;&#xff0c;&#x53ef;&#x4ee5;&#x6307;&#x5b9a;"/>
</node>
<node CREATED="1542767398952" ID="ID_665520076" MODIFIED="1542767401580" TEXT="consumer">
<node CREATED="1542767402369" ID="ID_1525741331" MODIFIED="1542767419408" TEXT="&#x6bcf;&#x4e2a;consumer&#x90fd;&#x6709;&#x81ea;&#x5df1;&#x7684;&#x6d88;&#x8d39;&#x8005;&#x7ec4;"/>
<node CREATED="1542767419799" ID="ID_431872245" MODIFIED="1542767437616" TEXT="&#x6bcf;&#x4e2a;&#x6d88;&#x8d39;&#x8005;&#x7ec4;&#x5728;&#x6d88;&#x8d39;&#x540c;&#x4e00;&#x4e2a;topic&#x65f6;&#xff0c;&#x8fd9;&#x4e2a;topic&#x4e2d;&#x6570;&#x636e;&#x53ea;&#x80fd;&#x88ab;&#x6d88;&#x8d39;&#x4e00;&#x6b21;"/>
<node CREATED="1542767437793" ID="ID_1588034528" MODIFIED="1542767453352" TEXT="&#x4e0d;&#x540c;&#x7684;&#x6d88;&#x8d39;&#x8005;&#x7ec4;&#x6d88;&#x8d39;&#x540c;&#x4e00;&#x4e2a;topic&#x4e92;&#x4e0d;&#x5f71;&#x54cd;"/>
<node CREATED="1542767481997" ID="ID_798092759" MODIFIED="1542767516827" TEXT="kafka 0.8 &#x4e4b;&#x524d; consumer &#x81ea;&#x5df1;&#x5728;zookeeper&#x4e2d;&#x7ef4;&#x62a4;&#x6d88;&#x8d39;&#x8005;offset"/>
<node CREATED="1542767518689" ID="ID_1907477639" MODIFIED="1542767552841" TEXT="kafka 0.8&#x4e4b;&#x540e;&#xff0c;consumer&#x7684;offset&#x662f;&#x901a;&#x8fc7;kafka &#x96c6;&#x7fa4;&#x6765;&#x7ef4;&#x62a4;&#x7684;"/>
</node>
<node CREATED="1542767476415" ID="ID_1513616316" MODIFIED="1542767583173" TEXT="zookeeper">
<node CREATED="1542767479773" ID="ID_1465670775" MODIFIED="1542767577512" TEXT="&#x5b58;&#x50a8;&#x539f;&#x6570;&#x636e;&#xff0c;broker&#xff0c;topic,partition.."/>
<node CREATED="1542767584781" ID="ID_807197180" MODIFIED="1542767600721" TEXT="kafka 0.8&#x4e4b;&#x524d;&#x8fd8;&#x53ef;&#x4ee5;&#x5b58;&#x50a8;&#x6d88;&#x8d39;&#x8005;offset"/>
</node>
</node>
<node CREATED="1542848569141" FOLDED="true" ID="ID_1738939294" MODIFIED="1542848777248" TEXT="&#x547d;&#x4ee4;">
<node CREATED="1542848586316" ID="ID_633005317" MODIFIED="1542848589121" TEXT="&#x521b;&#x5efa;topic">
<node CREATED="1542848645543" MODIFIED="1542848645543" TEXT="./kafka-topics.sh --zookeeper node3:2181,node4:2181,node5:2181  --create --topic topic2017 --partitions 3 --replication-factor 3"/>
</node>
<node CREATED="1542848589303" ID="ID_1518600782" MODIFIED="1542848597245" TEXT="&#x67e5;&#x770b;&#x5f53;&#x524d;&#x96c6;&#x7fa4;&#x4e2d;topic">
<node CREATED="1542848673638" MODIFIED="1542848673638" TEXT="./kafka-topics.sh  --list --zookeeper node3:2181,node4:2181,node5:2181"/>
</node>
<node CREATED="1542848597666" ID="ID_1306041955" MODIFIED="1542848604063" TEXT="&#x63a7;&#x5236;&#x53f0;&#x5f53;&#x505a;&#x751f;&#x4ea7;&#x8005;">
<node CREATED="1542848650936" ID="ID_629754235" MODIFIED="1542848656253" TEXT="./kafka-console-producer.sh  --topic  topic2017  --broker-list node1:9092,node2:9092,node3:9092"/>
</node>
<node CREATED="1542848604230" ID="ID_766602356" MODIFIED="1542848611229" TEXT="&#x63a7;&#x5236;&#x53f0;&#x5f53;&#x505a;&#x6d88;&#x8d39;&#x8005;">
<node CREATED="1542848667461" MODIFIED="1542848667461" TEXT="./kafka-console-consumer.sh --zookeeper node3:2181,node4:2181,node5:2181 --topic topic2017"/>
</node>
<node CREATED="1542848617193" ID="ID_1652509540" MODIFIED="1542848626260" TEXT="&#x67e5;&#x770b;topic&#x7684;&#x8be6;&#x7ec6;&#x4fe1;&#x606f;">
<node CREATED="1542848678153" MODIFIED="1542848678153" TEXT="./kafka-topics.sh --describe --zookeeper node3:2181,node4:2181,node5:2181  --topic topic2017"/>
</node>
<node CREATED="1542848612024" ID="ID_1840305961" MODIFIED="1542848616050" TEXT="&#x5220;&#x9664;topic">
<node CREATED="1542848681246" ID="ID_1561755596" MODIFIED="1542848693656" TEXT="./kafka-topics.sh --zookeeper node3:2181,node4:2181,node5:2181 --delete --topic t1205"/>
<node CREATED="1542848694556" ID="ID_1523352898" MODIFIED="1542848708182" TEXT="&#x5220;&#x9664;&#x5b58;&#x50a8;&#x4f4d;&#x7f6e;&#x7684;&#x5f53;&#x524d;topic&#x4fe1;&#x606f;"/>
<node CREATED="1542848708353" ID="ID_241562756" MODIFIED="1542848719333" TEXT="zookeeper&#x4e2d;&#x5220;&#x9664;&#x539f;&#x6570;&#x636e;&#x4fe1;&#x606f;"/>
</node>
</node>
<node CREATED="1542848741796" ID="ID_1981170152" MODIFIED="1542848751043" TEXT="Leader &#x5747;&#x8861;&#x673a;&#x5236;"/>
</node>
<node CREATED="1542780502476" ID="ID_887141712" MODIFIED="1542850480139" TEXT="SparkStreaming+kafka&#x6574;&#x5408;">
<node CREATED="1542848781168" ID="ID_51521209" MODIFIED="1542850780304" TEXT="Receiver&#x6a21;&#x5f0f;">
<node CREATED="1542848795184" ID="ID_89352083" MODIFIED="1542849089136" TEXT="Spark 2.0+ &#x53bb;&#x6389;&#xff0c;&#x4e0d;&#x7528;"/>
<node CREATED="1542848805721" ID="ID_115177263" MODIFIED="1542848843287" TEXT="SparkStreaming &#x9700;&#x8981;&#x542f;&#x52a8;task &#x63a5;&#x6536;&#x6570;&#x636e;&#xff0c;&#x63a5;&#x6536;&#x6765;&#x7684;&#x6570;&#x636e;&#x5b58;&#x653e;&#x7ea7;&#x522b; MEMORY_AND_DISK_SER_2"/>
<node CREATED="1542848844138" ID="ID_538506097" MODIFIED="1542848896724" TEXT="&#x6d41;&#x7a0b;&#xff1a;&#x63a5;&#x6536;&#x6570;&#x636e;-&gt;&#x5907;&#x4efd;-&gt;&#x66f4;&#x65b0;offset-&gt;&#x6c47;&#x62a5;&#x6570;&#x636e;&#x4f4d;&#x7f6e;-&gt;&#x53d1;&#x9001;task&#x5904;&#x7406;&#x6570;&#x636e;"/>
<node CREATED="1542848897414" ID="ID_1839183730" MODIFIED="1542848949986" TEXT="&#x5f53;Driver&#x6302;&#x6389;&#x65f6;&#xff0c;&#x6709;&#x4e22;&#x5931;&#x6570;&#x636e;&#x7684;&#x95ee;&#x9898;&#xff0c;&#x5f00;&#x542f;WAL(Write Ahead Log) &#x9884;&#x5199;&#x65e5;&#x5fd7;&#x673a;&#x5236; &#x5c06;&#x6570;&#x636e;&#x5b58;&#x50a8;&#x5728;&#x6307;&#x5b9a;&#x7684;checkpoint&#x4e2d;&#x9632;&#x6b62;&#x4e22;&#x5931;&#x6570;&#x636e;"/>
<node CREATED="1542848962363" ID="ID_1604326604" MODIFIED="1542848991928" TEXT="&#x5f00;&#x542f;WAL &#x8981;&#x8bbe;&#x7f6e;Checkpoint ,&#x53ef;&#x4ee5;&#x5c06;&#x63a5;&#x6536;&#x6765;&#x6570;&#x636e;&#x7684;&#x5b58;&#x50a8;&#x7ea7;&#x522b;&#x964d;&#x7ea7; &#xff1a; MEMORY_AND_DISK_SER"/>
<node CREATED="1542848951768" ID="ID_95572150" MODIFIED="1542849006331" TEXT="&#x5f00;&#x542f;WAL&#x673a;&#x5236;&#x6709;&#x65b0;&#x7684;&#x95ee;&#x9898;:&#x5904;&#x7406;&#x6570;&#x636e;&#x7684;&#x5ef6;&#x8fdf;&#x5927;"/>
<node CREATED="1542849009602" ID="ID_355324935" MODIFIED="1542849038964" TEXT="Receiver &#x6a21;&#x5f0f;&#x4e0d;&#x652f;&#x6301;&#x4ece;&#x6bcf;&#x6279;&#x6b21;&#x4e2d;&#x83b7;&#x53d6;offset&#xff0c;&#x5185;&#x90e8;&#x81ea;&#x5df1;&#x901a;&#x8fc7;zookeeper&#x6765;&#x7ef4;&#x62a4;&#x6d88;&#x8d39;&#x8005;offset"/>
<node CREATED="1542849042059" ID="ID_707748047" MODIFIED="1542849078353" TEXT="Recevier &#x6a21;&#x5f0f;&#x5e95;&#x5c42;&#x91c7;&#x53d6;&#x6d88;&#x8d39;kafka &#x7684;Hight consumer api &#x5b9e;&#x73b0;&#xff0c;&#x4e0d;&#x5173;&#x5fc3;offset&#xff0c;&#x53ea;&#x8981;&#x6570;&#x636e;"/>
<node CREATED="1542849111210" ID="ID_1396041125" MODIFIED="1542849167405" TEXT="Receiver &#x6a21;&#x5f0f;&#x7684;&#x5e76;&#x884c;&#x5ea6; &#xff1a;spark.streaming.blockInterval = 200ms ,&#x9ed8;&#x8ba4;&#x5728;batchInterval &#x5185;&#x6bcf;&#x9694;200ms &#x751f;&#x6210;&#x4e00;&#x4e2a;block&#xff0c;&#x6bcf;&#x4e2a;block&#x5bf9;&#x5e94;RDD&#x7684;&#x4e00;&#x4e2a;partition"/>
<node CREATED="1542849168143" ID="ID_462125503" MODIFIED="1542849192084" TEXT="&#x5982;&#x4f55;&#x63d0;&#x9ad8;&#x5e76;&#x884c;&#x5ea6;&#xff1f;&#x964d;&#x4f4e; spark.streaming.blockInterval &#x6700;&#x4f4e;&#x4e0d;&#x80fd;&#x4f4e;&#x4e8e;50ms"/>
</node>
<node CREATED="1542848786455" ID="ID_178582753" MODIFIED="1542850474965" TEXT="Direct&#x6a21;&#x5f0f;">
<node CREATED="1542849099785" ID="ID_1624808704" MODIFIED="1542849224779" TEXT="&#x76f8;&#x5bf9;&#x4e8e;Receiver&#x6a21;&#x5f0f; &#x7b80;&#x5316;&#x4e86;&#x5e76;&#x884c;&#x5ea6;&#xff0c;&#x5e76;&#x884c;&#x5ea6;&#x4e0e;&#x8bfb;&#x53d6;&#x7684;topic&#x7684;partition&#x4e2a;&#x6570;&#x4e00;&#x81f4;"/>
<node CREATED="1542849226512" ID="ID_1324354500" MODIFIED="1542849254329" TEXT="Direct&#x6bcf;&#x6279;&#x6b21;&#x6570;&#x636e;&#x90fd;&#x662f;&#x76f4;&#x63a5;&#x62c9;&#x53d6;&#x5904;&#x7406;&#xff0c;&#x4e0d;&#x9700;&#x8981;&#x5c06;&#x6570;&#x636e;&#x5b58;&#x50a8;&#x5728;Executor&#x5185;&#x5b58;&#x6216;&#x8005;&#x78c1;&#x76d8;&#x4e2d;"/>
<node CREATED="1542849256221" ID="ID_1061521331" MODIFIED="1542849293120" TEXT="Direct &#x4f7f;&#x7528;Spark&#x6765;&#x7ba1;&#x7406;&#x6d88;&#x8d39;&#x8005;offset&#xff0c;&#x9ed8;&#x8ba4;&#x5b58;&#x50a8;&#x5728;&#x5185;&#x5b58;&#x4e2d;&#xff0c;&#x5982;&#x679c;&#x8bbe;&#x7f6e;checkpoint&#x5728;checkpint&#x4e2d;&#x4e5f;&#x6709;&#x4e00;&#x4efd;"/>
<node CREATED="1542849325779" ID="ID_1297962034" MODIFIED="1542849390390" TEXT="Spark 1.6&#x4e2d;&#x8bfb;&#x53d6;kafka 0.8.2&#x91c7;&#x7528;&#x7684;&#x662f; Simple consumer api &#xff0c;&#x53ef;&#x4ee5;&#x4ece;&#x6bcf;&#x6279;&#x6b21;&#x4e2d;&#x83b7;&#x53d6;&#x6d88;&#x8d39;&#x8005;offset&#xff0c;&#x53ef;&#x4ee5;&#x505a;&#x5230;&#x81ea;&#x5df1;&#x7ef4;&#x62a4;"/>
<node CREATED="1542850374141" ID="ID_1313153979" MODIFIED="1542850427598" TEXT="Spark1.6Direct &#x6a21;&#x5f0f;&#x7ef4;&#x62a4;&#x6d88;&#x8d39;&#x8005;offset&#xff0c;1.&#x4f7f;&#x7528;checkpoint 2.&#x4f7f;&#x7528;&#x624b;&#x52a8;&#x7ef4;&#x62a4;"/>
</node>
<node CREATED="1542849523922" ID="ID_453491827" MODIFIED="1542850447643" TEXT="Spark2.0+ SparkStreaming&#x8bfb;&#x53d6;Kakfa 0.11 ">
<node CREATED="1542849539447" ID="ID_1659837000" MODIFIED="1542849644595" TEXT="&#x53ea;&#x6709;Direct&#x6a21;&#x5f0f; &#xff0c;&#x8fd9;&#x4e2a;Direct&#x4e0e;1.6&#x7684;Direct&#x6a21;&#x5f0f;&#x4e0d;&#x4e00;&#x6837;&#xff0c;1.6 Direct&#x91c7;&#x7528;&#x7684;&#x662f;Simaple consumer api&#x5b9e;&#x73b0;&#x3002;spark2.3+kafka 0.11 &#x91c7;&#x7528;&#x4e86;&#x8bfb;&#x53d6;kafka new consumer  api &#x5b9e;&#x73b0;"/>
<node CREATED="1542849665246" ID="ID_1016617945" MODIFIED="1542849685357" TEXT="&#x5e76;&#x884c;&#x5ea6;&#x4e0e;&#x8bfb;&#x53d6;&#x7684;kafka&#x7684;topic&#x4e2d;partition&#x4e2a;&#x6570;&#x4e00;&#x81f4;"/>
<node CREATED="1542849886432" ID="ID_1085241738" MODIFIED="1542849898490" TEXT="kafka &#x53ef;&#x4ee5;&#x7ba1;&#x7406;&#x6d88;&#x8d39;&#x8005;offset"/>
</node>
<node CREATED="1542849337060" ID="ID_79590870" MODIFIED="1542850435677" TEXT="Direct&#x6a21;&#x5f0f; &#x7ba1;&#x7406;offset">
<node CREATED="1542849764763" ID="ID_1841615866" MODIFIED="1542850780305" TEXT="1.&#x4f7f;&#x7528;checkpoint&#x6765;&#x7ba1;&#x7406;&#x6d88;&#x8d39;&#x8005;offset">
<node CREATED="1542849788224" ID="ID_1333724521" MODIFIED="1542849820906" TEXT="&#x5f53;&#x4ee3;&#x7801;&#x903b;&#x8f91;&#x53d8;&#x5316;&#x65f6;&#xff0c;&#x6062;&#x590d;offset&#x7684;&#x540c;&#x65f6;&#x4f1a;&#x6062;&#x590d;&#x65e7;&#x7684;&#x903b;&#x8f91;"/>
<node CREATED="1542849821487" ID="ID_220197275" MODIFIED="1542849841815" TEXT="&#x91cd;&#x542f;&#x542f;&#x52a8;&#x65f6;&#xff0c;&#x4f1a;&#x6709;&#x91cd;&#x590d;&#x5904;&#x7406;&#x6570;&#x636e;&#x95ee;&#x9898;"/>
<node CREATED="1542849995755" ID="ID_175012968" MODIFIED="1542850040741" TEXT="StreamingFactory.getOrCreate(&quot;checkpiont&#x76ee;&#x5f55;&quot;,StreamingContext)"/>
</node>
<node CREATED="1542849843241" ID="ID_86868376" MODIFIED="1542850780309" TEXT="2.&#x4f7f;&#x7528;kafka &#x7ba1;&#x7406;&#x6d88;&#x8d39;&#x8005;offset&#xff08;Spark2.3+kafka 0.11 &#xff09;">
<node CREATED="1542850121170" ID="ID_946898238" MODIFIED="1542850780310" TEXT="&#x81ea;&#x52a8;&#x63d0;&#x4ea4;">
<node CREATED="1542849938592" ID="ID_411143224" MODIFIED="1542849972452" TEXT="&quot;enable.auto.commit&quot; -&gt; (true: java.lang.Boolean)//&#x9ed8;&#x8ba4;&#x662f;true&#xff0c;&#x5f00;&#x542f;&#x4e4b;&#x540e;&#x4f1a;&#x6bcf;&#x9694;5s&#x81ea;&#x52a8;&#x5411;Kafka &#x63d0;&#x4ea4;offset"/>
<node CREATED="1542849921561" ID="ID_72520148" MODIFIED="1542850073259" TEXT="&#x76f8;&#x5f53;&#x4e8e;&#x6570;&#x636e;&#x6700;&#x591a;&#x5904;&#x7406;&#x4e00;&#x6b21;,&#x6709;&#x53ef;&#x80fd;SparkStreaming&#x63a5;&#x6536;&#x5230;&#x6570;&#x636e;&#x4e4b;&#x540e;&#x6ca1;&#x6709;&#x5904;&#x7406;&#xff0c;&#x5c31;&#x63d0;&#x4ea4;&#x4e86;offset"/>
</node>
<node CREATED="1542850127899" ID="ID_162170218" MODIFIED="1542850162182" TEXT="&#x5f02;&#x6b65;&#x624b;&#x52a8;&#x63d0;&#x4ea4;&#xff08;&#x5efa;&#x8bae;&#xff09;">
<node CREATED="1542849949767" ID="ID_677355226" MODIFIED="1542850112641" TEXT="&quot;enable.auto.commit&quot; -&gt; (false: java.lang.Boolean)//&#x9ed8;&#x8ba4;&#x662f;true,&#x8bbe;&#x7f6e;&#x6210;false &#xff0c;&#x53ef;&#x4ee5;&#x81ea;&#x5df1;&#x4fdd;&#x8bc1;&#x6570;&#x636e;&#x5904;&#x7406;&#x5b8c;&#x4e4b;&#x540e;&#xff0c;&#x5f02;&#x6b65;&#x5411;Kafka&#x63d0;&#x4ea4;&#x6d88;&#x8d39;&#x8005;offset"/>
</node>
</node>
<node CREATED="1542850176750" ID="ID_257918306" MODIFIED="1542850780314" TEXT="3.&#x624b;&#x52a8;&#x7ef4;&#x62a4;&#x6d88;&#x8d39;&#x8005;offset">
<node CREATED="1542850188098" ID="ID_1562053548" MODIFIED="1542850239957" TEXT="&#x53ef;&#x4ee5;&#x5b58;&#x50a8;&#x5728;Mysql&#xff0c;HBase&#xff0c;Redis ,&#x3010;Zookeeper&#x3011;"/>
<node CREATED="1542850241284" ID="ID_1537720339" MODIFIED="1542850249770" TEXT="&#x5229;&#x7528;redis&#x5b58;&#x50a8;&#x6d88;&#x8d39;&#x8005;offset">
<node CREATED="1542850252179" ID="ID_1187575049" MODIFIED="1542850282207" TEXT="1.&#x7a0b;&#x5e8f;&#x542f;&#x52a8;&#xff0c;&#x4ece;redis&#x4e2d;&#x83b7;&#x53d6;&#x4e0a;&#x4e00;&#x6b21;&#x4fdd;&#x5b58;&#x7684;&#x6d88;&#x8d39;&#x8005;offset"/>
<node CREATED="1542850283794" ID="ID_834229117" MODIFIED="1542850300106" TEXT="2.&#x4f20;&#x9012;&#x7ed9;SparkStreaming&#xff0c;&#x63a5;&#x7740;&#x548c;&#x8fd9;&#x4e2a;&#x4f4d;&#x7f6e;&#x8bfb;&#x53d6;"/>
<node CREATED="1542850300932" ID="ID_1905282261" MODIFIED="1542850316823" TEXT="3.&#x6bcf;&#x4e00;&#x6279;&#x6b21;&#x4e2d;&#x83b7;&#x53d6;&#x5f53;&#x524d;offset &#x5b58;&#x50a8;&#x5728;Redis&#x4e2d;"/>
</node>
</node>
</node>
<node CREATED="1542850483752" ID="ID_245169398" MODIFIED="1542850491418" TEXT="&#x53c2;&#x6570;">
<node CREATED="1542850511835" ID="ID_461396897" MODIFIED="1542850517160" TEXT="spark.streaming.backpressure.enabled   false"/>
<node CREATED="1542850539747" ID="ID_432775569" MODIFIED="1542850544417" TEXT="spark.streaming.blockInterval&#x9;  200ms&#x9;"/>
<node CREATED="1542850550534" ID="ID_768817739" MODIFIED="1542850556225" TEXT="spark.streaming.receiver.maxRate   not set"/>
<node CREATED="1542850573961" ID="ID_1203414952" MODIFIED="1542850581438" TEXT="spark.streaming.receiver.writeAheadLog.enable  false"/>
<node CREATED="1542850590594" ID="ID_153696030" MODIFIED="1542850594525" TEXT="spark.streaming.stopGracefullyOnShutdown   false"/>
<node CREATED="1542850601327" ID="ID_1250522459" MODIFIED="1542850605509" TEXT="spark.streaming.kafka.maxRatePerPartition   not set"/>
</node>
<node CREATED="1542850650739" ID="ID_219766549" MODIFIED="1542850654286" TEXT="kafka&#x914d;&#x7f6e;&#x53c2;&#x6570;">
<node CREATED="1542850662683" ID="ID_998572574" MODIFIED="1542850663861" TEXT="&quot;bootstrap.servers&quot; "/>
<node CREATED="1542850669381" ID="ID_1602029666" MODIFIED="1542850669678" TEXT="&quot;key.deserializer&quot;"/>
<node CREATED="1542850673997" ID="ID_1288411512" MODIFIED="1542850674245" TEXT="&quot;value.deserializer&quot;"/>
<node CREATED="1542850678222" ID="ID_686320572" MODIFIED="1542850678870" TEXT="&quot;group.id&quot;"/>
<node CREATED="1542850683635" ID="ID_1848516983" MODIFIED="1542850780316" TEXT="&quot;auto.offset.reset&quot;">
<node CREATED="1542850688162" ID="ID_1553411711" MODIFIED="1542850688673" TEXT="earliest"/>
<node CREATED="1542850689512" ID="ID_1483724938" MODIFIED="1542850693229" TEXT="latest"/>
<node CREATED="1542850696091" ID="ID_1351222442" MODIFIED="1542850696439" TEXT="none"/>
</node>
<node CREATED="1542850704417" ID="ID_1707553202" MODIFIED="1542850713301" TEXT="&quot;enable.auto.commit&quot;  true"/>
<node CREATED="1542850719389" ID="ID_269076579" MODIFIED="1542850723681" TEXT="heartbeat.interval.ms  3s"/>
<node CREATED="1542850728148" ID="ID_1414930498" MODIFIED="1542850731505" TEXT="session.timeout.ms 10s"/>
<node CREATED="1542850737915" ID="ID_991870996" MODIFIED="1542850741285" TEXT="group.min.session.timeout.ms 6s"/>
<node CREATED="1542850747047" ID="ID_985417264" MODIFIED="1542850749595" TEXT="group.max.session.timeout.ms  300s"/>
</node>
</node>
</node>
</node>
</map>
