package com.spark.spark.test;

import java.util.Properties;
import java.util.Random;

import com.bjsxt.spark.util.DateUtils;
import com.bjsxt.spark.util.StringUtils;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 模拟实时数据
 * @author tianhao
 */
public class MockRealTimeData extends Thread {
	
	private static final Random random = new Random();
	private static final String[] locations = new String[]{"鲁","京","京","京","沪","京","京","深","京","京"};
	private Producer<String, String> producer;
	
	public MockRealTimeData() {
		producer = new Producer<>(createProducerConfig());
	}

	/**
	 * kafka配置
	 * @return
	 */
	private ProducerConfig createProducerConfig() {
		Properties props = new Properties();
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("metadata.broker.list", "node1:9092,node2:9092,node3:9092");
		return new ProducerConfig(props);
	}

	@Override
	public void run() {
		while(true) {	
			String date = DateUtils.getTodayDate();
			String baseActionTime = date + " " + StringUtils.fulfuill(random.nextInt(24)+"");
			baseActionTime = date + " " + StringUtils.fulfuill((Integer.parseInt(baseActionTime.split(" ")[1])+1)+"");
			String actionTime = baseActionTime + ":" + StringUtils.fulfuill(random.nextInt(60)+"") + ":" + StringUtils.fulfuill(random.nextInt(60)+"");
    		String monitorId = StringUtils.fulfuill(4, random.nextInt(9)+"");
    		String car = locations[random.nextInt(10)] + (char)(65+random.nextInt(26))+StringUtils.fulfuill(5,random.nextInt(99999)+"");
    		String speed = random.nextInt(260)+"";
    		String roadId = random.nextInt(50)+1+"";
    		String cameraId = StringUtils.fulfuill(5, random.nextInt(9999)+"");
    		String areaId = StringUtils.fulfuill(2,random.nextInt(8)+"");
    		// 发送kafka
			producer.send(new KeyedMessage<String, String>("RoadRealTimeLog", date+"\t"+monitorId+"\t"+cameraId+"\t"+car + "\t" + actionTime + "\t" + speed + "\t" + roadId + "\t" + areaId));  
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}
	}
	
	/**
	 * 启动Kafka Producer
	 * @param args
	 */
	public static void main(String[] args) {
		MockRealTimeData producer = new MockRealTimeData();
		producer.start();
	}
	
}
