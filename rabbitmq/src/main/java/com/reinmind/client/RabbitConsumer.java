package com.reinmind.client;


import ch.qos.logback.core.util.TimeUtil;
import com.rabbitmq.client.*;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者队列
 *
 * @author zx
 * @date 2020/10/29
 */
public class RabbitConsumer {
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "175.24.66.148";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException,InterruptedException {
        Address[] addresses = new Address[]{
                new Address(IP_ADDRESS,PORT)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 这里的连接方式与生产者的demo略有不同，注意辨别区别
        // 创建连接
        Connection connection = factory.newConnection(addresses);
        // 创建信道
        final Channel channel = connection.createChannel();
        // 设置客户端最多接收未被ack的消息的个数
        channel.basicQos(20000);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv msg: " + new String(body));
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException exception){
                    exception.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,consumer);
        TimeUnit.SECONDS.sleep(100000);
        channel.close();
        connection.close();
    }
}
