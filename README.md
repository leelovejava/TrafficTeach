# 车流量监控

## 前言
       
目的
   1.对业务场景抽象，熟练Spark编码
   2.增加自定义累加器，自定义UDF
   3.Spark 优化方式
   
项目
    数据处理架构


## 模块介绍

* 卡扣流量分析 Spark Core

* 卡扣车流量转化率 Spark Core

* 各区域车流量最高top5的道路统计 SparkSQL

* 稽查布控，道路实时拥堵统计 SparkStreaming

## hive表
`monitor_flow_action`表
– date 日期 天
– monitor_id 卡口号
– camera_id 摄像头编号
– car 车牌
– action_time 某个摄像头拍摄时间 s
– speed 通过卡扣的速度
– road_id 道路id
– area_id 区域ID

`monitor_camera_info`表 某一个卡扣对应的摄像头编号
– monitor_id：卡扣编号
– camera_id：摄像头编号

数据加载hive中
1). 创建表,加载数据load data `Data2File`
> hive -f createHiveTab.sql

2). 集群中提交spark作业,使用代码生成到hive `Data2Hive`

## 大数据开发流程
* 数据调研（对底层的数据的表结构进行调研，分析和研究）
* 需求分析（与PM讨论需求，画原型图 axure）
* 基于讨论出来的结果做出技术方案（某个难点用什么技术，数据库选型）
* 具体实施

## 功能点
* 根据使用者（平台使用者）指定的某些条件，筛选出指定的一批卡扣信息（比如根据区域、时间筛选）

* 检测卡扣状态，对于筛选出来的所有的卡口（不代表一个摄像头）信息统计
• 卡口正常数
• 异常数
• camera的正常数
• camera的异常数
• camera的详细信息（ monitor_id:camera_id）

* 车流量最多的TonN卡扣号
• 获取每一个卡扣的详细信息（ Top5 ）

* 随机抽取N个车辆信息，对这些数据可以进行多维度分析（因为随机抽取出来的N个车辆信息可以很权威的代表整个
区域的车辆）

* 计算出经常高速通过的TopN卡口 （查看哪些卡扣经常被高速通过，高速，中速，正常，低速 根据三个速度段进行四
次排序，高速通过的车辆数相同就比较中速通过的车辆数，以此来推）

* 跟车分析

## 需求分析

### 按条件筛选卡扣信息
• 可以指定 不同的条件，时间范围、区域范围、卡扣号等 可以灵活的分析不同区域的卡扣信息

###  监测卡扣状态
• 对符合条件的卡扣信息，可以动态的检查每一个卡扣的状态，查看卡扣是否正常工作，也可以查看摄像头

###  车流量最多的TonN卡扣
• 查看哪些卡扣的车流量最高，为什么会出现这么高的车流量。分析原因，例如今天出城的车辆非常多，啥原因，今天进
城的车辆非常多，啥原因？ 要造反？ 这个功能点里面也会拿到具体的车辆的信息，分析一下是京牌车造成的还是外地
车牌？

###  在符合条件的卡扣信息中随机抽取N个车辆信息

• 随机抽取N辆车的信息，可以权威的代表整个区域的车辆，这时候可以分析这些车的轨迹，看一下在不同的时间点车辆
的流动方向。以便于道路的规划。

###  计算出经常高速通过的TopN卡口

• 统计出是否存在飙车现象，或者经常进行超速行驶，可以在此处安装违章拍摄设备

###  跟车分析
• 计算出所有车是否被跟踪过，然后将结果存储在MySQL中，以便后期进行查询

## 项目分析
monitor_flow_action 监控数据表

monitor_camera_info 卡扣与摄像头基本关系表

### 1.卡扣监控

#### 统计: 正常的卡扣个数，异常的卡扣个数，正常的摄像头个数，异常的摄像头个数，异常的摄像头详细信息
	
#### 正常卡扣个数：
    
    monitor_camera_info 基本关系表中卡扣与摄像头的关系与在monitor_flow_action 监控数据表 中，卡扣与摄像头的关系完全对应上
    0001:11111,22222
    0001 11111 xxx
    0001 22222 xxx
		
	RDD思路-正常的卡扣数为例：
    		monitor_flow_action表 -> RDD<Monitor_id,Camera_id> -> RDD<Monitor_id,[camera_ids]> - RDD<Monitor_id,camera_ids>
    		monitor_camera_info表 -> RDD<Monitor_id,Camera_id> -> RDD<Monitor_id,[camera_ids]>
    		
#### 异常的卡扣个数：
	
	1.monitor_camera_info 基本关系表中 卡扣 与摄像头的关系，在监控的数据表中 一条都没有对应。
	
	2.monitor_camera_info 基本关系表中 卡扣 与摄像头的关系，在监控的数据表中 部分数据有对应。
		
#### 正常的摄像头个数：

#### 异常的摄像头个数：

#### 异常的摄像头详细信息：0001:11111,22222,33333
		
	~0004:76789,27449,87911,61106,45624,37726,09506
	~0001:70037,23828,34361,92206,76657,26608
	~0003:36687,99260,49613,97165
	~0006:82302,11645,73565,36440
	~0002:60478,07738,53139,75127,16494,48312
	~0008:34144,27504,83395,62222,49656,18640
	~0007:19179,72906,55656,60720,74161,85939,51743,40565,13972,79216,35128,27369,84616,09553
	~0000:67157,85327,08658,57407,64297,15568,31898,36621
	~0005:09761,12853,91031,33015,52841,15425,45548,36528
	
#### 注意：

   求个数: 累加器实现(并行 分布式)
   
   异常的摄像头信息,用累加器实现,无非拼的是字符串
   
   更新累加器与take使用时，take算子可以触发多个job执行，可以造成累加器重复计算。
	
	./spark-submit --master spark://node1:7077,node2:7077 --jars ../lib/fastjson-1.2.11.jar,../lib/mysql-connector-java-5.1.6.jar  --class MonitorFlowAnalyze  ../lib/Test.jar 1
	
	
	 ~0001:13846,54785,51995,64341,45994,32228,82054,87746
	 ~0003:38780,08844,03281,07183,50318,87000,16722,11604,26508,45523,46380
	 ~0007:61833,19140,38387
	 ~0005:63920,23464,37389,01219,96765,24844,32101,24141~ 
	 ~0004:60778,35444,35403,68811,73819,81893
	 ~0006:09621,67028,96375,60036,91237,53743,10305
	 ~0002:24694,01172,25945,79625,83215,72235,26855
	 ~0008:24630,40432,96808,78708,28294
	 ~0000:68070,12865,49505,26035,36931,38053,91868
	 
### 2.通过车辆数最多的topN卡扣
	
### 3.统计topN卡扣下经过的所有车辆详细信息

### 4.车辆通过速度相对比较快的topN卡扣
  车速：
	120=<speed 		高速
	90<=speed<120	中速
	60<=speed<90	正常
	0<speed<60		低速

### 5.卡扣“0001”下所有车辆轨迹
	1.过滤日期范围内 卡扣“0001”下 有哪些车辆？
	2.过滤日期范围内 这些车辆经过卡扣的时间，按照时间升序排序
	
### 6.车辆碰撞

### 7.随机抽取车辆
	在一天中要随机抽取100辆车，抽取的车辆可以权威代表当天交通运行情况。
	假如这天一共有10000辆车，要随机抽取100辆车：
	sample(true,0.1,seed)
	
	00~01 100    100/10000*100 = 1 
	01~02 100	1
	02~03 100	1
	04~05 200	2
	05~06 200	2
	06~07 300	3
	08~09 500	5
	09~10 200	2
	10~11 200	2
	11~12 300	3
	12~13 500	5
	13~14 700	7
	。。
	。。
	。。
	
### 8.卡扣流量转换率

卡扣流量转换率，是指车辆运行连续卡口的转换率
如：一车辆经过卡口的轨迹为：0001，0002，0004，0001，0002，0003，0001，0002。
0001，0002：卡扣0001到卡扣0002的转换率为：经过卡扣0001，又经过卡扣0002的次数/经过卡扣0001的次数，针对上面的例子，
经过卡口0001的次数为：3次，经过卡口0001，又经过卡口0002的次数为：3次，那么卡扣0001到卡扣0002的转换率为：3/3=100%，同理：
0001，0002，0003 代表卡扣0001，0002到卡扣0003的转换率。
0001，0002，0003，0004代表卡扣0001，0002，0003到卡扣00004的转换率。
`MonitorOneStepConvertRateAnalyze.java`
    
一辆车的轨迹：
    0001->0002->0003->0001->0002->0004->0005->0001
    0001,0002----卡扣0001到卡扣0002 的车流量转化率：通过卡扣0001又通过卡扣0002的次数/通过卡扣0001的次数  2/3
    0001,0002,0003 ---- 卡扣0001,0002到0003的车辆转换率：通过卡扣0001,0002,0003的次数 /通过卡扣0001,0002
    0001,0002,0003,0004 -----卡扣0001,0002，0003到0004的车辆转换率：通过卡扣0001,0002,0003,0004的次数 /通过卡扣0001,0002,0003
    0001,0002,0003,0004,0005 -----卡扣0001,0002，0003,0004到0005的车辆转换率：通过卡扣0001,0002,0003,0004,0005的次数 /通过卡扣0001,0002,0003,0004的次数
手动输入卡扣号：
	0001,0002,0003,0004,0005
求：
    0001,0002
    0001,0002,0003
    0001,0002,0003,0004
    0001,0002,0003,0004,0005
			
   粤A11111：
    ("0001"，100)
    ("0001,0002",30)
    ("0001,0002,0003",10)
   粤B22222：
    ("0001"，200)
    ("0001,0002",100)
    ("0001,0002,0003",70)
    ("0001,0002,0003,0004",10)

### 9.实时道路拥堵情况
	计算一段时间内卡扣下通过的车辆的平均速度。
	这段时间不能太短，也不能太长。就计算当前时间的前五分钟 当前卡扣下通过所有车辆的平均速度。
	每隔5s 计算一次当前卡扣过去5分钟 所有车辆的平均速度。
	
	SparkStreaming 窗口函数
	window lenth:5min
	slide interval:5s

### 10.动态改变广播变量
	
### 11.统计每个区域中车辆最多的前3道路
	道路车辆：道路中的每个卡扣经过的车辆累加
	
	天河区	元岗路1		0001=30,0002=50,0003=100,0004=20	200	
	天河区	元岗路2		0005=50,0006=100 					150
	天河区	元岗路3		100
	越秀区	xxx1		200
	越秀区	xxx2		150
	越秀区	xxx3		100
	
	
	Hive 表 --t1 :
		monitor_id		car		road_id		area_id	
		
		
		-----
		
		areaId	area_name	road_id		monitor_id	car ------	tmp_car_flow_basic
		
			
	sql:
		select area_name,road_id,count(car) as car_count,UDAF(monitor_id) as monitor_infos from t1 group by area_name,road_id		---- tmp_area_road_flow_count
		
	开窗函数：row_number() over (partition by xxx order by xxx ) rank
	
		select area_name,road_id,car_count,monitor_infos, row_number() over (partition by area_name order by car_count desc ) rank from tmp_area_road_flow_count  ---- tmp
		
		select area_name,road_id,car_count,monitor_infos from tmp where rank <=3
		
		
	-----------------------------------------------------------------------	
	总sql：
		select 
			area_name,road_id,car_count,monitor_infos 
		from 
			(
			select 
				area_name,road_id,car_count,monitor_infos, row_number() over (partition by area_id order by carCount desc ) rank 
			from 
				(
					select 
						area_name,road_id,count(car) as car_count ,UDAF(monitor_id) as monitor_infos
					from 
						t1 
					group by area_name,road_id
				) t2
			) t3
		where rank <=3
		
===================================================================================================================
sql:
		select prefix_area_name_road_id,count(car) as car_count,UDAF(monitor_id) as monitor_infos from t1 group by prefix_area_name_road_id		---- tmp_area_road_flow_count

	
		select area_name,road_id,car_count,monitor_infos, row_number() over (partition by area_name order by car_count desc ) rank from tmp_area_road_flow_count  ---- tmp
		
		select area_name,road_id,car_count,monitor_infos from tmp where rank <=3
		
		
	-----------------------------------------------------------------------	
	总sql：
		select 
			area_name,road_id,car_count,monitor_infos 
		from 
			(
			select 
				area_name,road_id,car_count,monitor_infos, row_number() over (partition by area_id order by carCount desc ) rank 
			from 
				(
					select 
						area_name,road_id,count(car) as car_count ,UDAF(monitor_id) as monitor_infos
					from 
						t1 
					group by area_name,road_id
				) t2
			) t3
		where rank <=3

各区域车流量最高topN的道路统计
1.会将小于spark.sql.autoBroadcastJoinThreshold值（默认为10M）的表广播到executor节点，不走shuffle过程,更加高效。
    sqlContext.setConf("spark.sql.autoBroadcastJoinThreshold", "20971520");  //单位：字节
2.在Hive中执行sql文件：
    hive –f  sql.sql
3.提交命令：
    --master spark://node1:7077,node2:7077 
    --jars  ../lib/mysql-connector-java-5.1.6.jar,../lib/fastjson-1.2.11.jar
    --driver-class-path ../lib/mysql-connector-java-5.1.6.jar:../lib/fastjson-1.2.11.jar 
    ../lib/Test.jar 
4

3.缉查布控，道路实时拥堵统计
 动态改变广播变量的值：可以通过transform和foreachRDD



屏蔽过多黄色警告,忽略java类方法的参数 与注释；
    File -> Settings -> Editor -> Inspections -> java ->javadoc:
    参数不一致的屏蔽：
        Declaration has problems in Javadoc refere 红色 改成 waring黄色
    参数没有注释：
        Dangling Javadoc comment 去掉勾选
        Declaration has Javadoc problems 去掉勾选
