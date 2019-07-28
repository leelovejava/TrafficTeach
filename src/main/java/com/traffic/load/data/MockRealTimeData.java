package com.traffic.load.data;

import com.traffic.spark.util.DateUtils;
import com.traffic.spark.util.StringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

public class MockRealTimeData extends Thread {

    private static final Random random = new Random();
    private static final String[] locations = new String[]{"鲁", "京", "京", "京", "沪", "京", "京", "深", "京", "京"};
    private KafkaProducer<String, String> producer;

    public MockRealTimeData() {
        producer = new KafkaProducer<>(createProducerConfig());
    }

    private Properties createProducerConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "node1:9092,node2:9092,node3:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    public void run() {
        System.out.println("正在生产数据 ... ... ");
        while (true) {
            String date = DateUtils.getTodayDate();
            String baseActionTime = date + " " + StringUtils.fulFuill(random.nextInt(24) + "");
            baseActionTime = date + " " + StringUtils.fulFuill((Integer.parseInt(baseActionTime.split(" ")[1]) + 1) + "");
            String actionTime = baseActionTime + ":" + StringUtils.fulFuill(random.nextInt(60) + "") + ":" + StringUtils.fulFuill(random.nextInt(60) + "");
            String monitorId = StringUtils.fulFuill(4, random.nextInt(9) + "");
            String car = locations[random.nextInt(10)] + (char) (65 + random.nextInt(26)) + StringUtils.fulFuill(5, random.nextInt(99999) + "");
            String speed = random.nextInt(260) + "";
            String roadId = random.nextInt(50) + 1 + "";
            String cameraId = StringUtils.fulFuill(5, random.nextInt(9999) + "");
            String areaId = StringUtils.fulFuill(2, random.nextInt(8) + "");
            producer.send(new ProducerRecord<>("RoadRealTimeLog", date + "\t" + monitorId + "\t" + cameraId + "\t" + car + "\t" + actionTime + "\t" + speed + "\t" + roadId + "\t" + areaId));

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 启动Kafka Producer
     *
     * @param args
     */
    public static void main(String[] args) {
        MockRealTimeData producer = new MockRealTimeData();
        producer.start();
    }

}
