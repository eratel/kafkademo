

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

public class kafkaProducer extends Thread {

	private String topic;

	public kafkaProducer(String topic) {
		super();
		this.topic = topic;
	}

	@Override
	public void run() {
		Producer<Integer, String> producer = createProducer();
		int i = 0;
		while (true) {
			producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i++));
			System.out.println("-------------"+i);
		}
	}

	private Producer<Integer, String> createProducer() {
		Properties properties = new Properties();
		properties.put("zookeeper.connect", "192.168.1.108:2181");// 声明zk
		properties.put("serializer.class", StringEncoder.class.getName());
		properties.put("metadata.broker.list", "192.168.1.108:9092");// 声明kafka
		properties.put("zk.connectiontimeout.ms", "15000");																				// broker
		return new Producer<Integer, String>(new ProducerConfig(properties));
	}

	public static void main(String[] args) {
		new kafkaProducer("test1").start();// 使用kafka集群中创建好的主题 test
		new kafkaProducer("test1").start();
		new kafkaProducer("test1").start();
		new kafkaProducer("test1").start();
		new kafkaProducer("test1").start();
		new kafkaProducer("test1").start();
	}

}