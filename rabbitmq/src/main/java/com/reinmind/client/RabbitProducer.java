package com.reinmind.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.ietf.jgss.MessageProp;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者客户端
 *
 * @author zx
 * @date 2020/10/29
 */
public class RabbitProducer {
    private final static String EXCHANGE_NAME = "exchange_demo";
    private final static String ROUTING_KEY = "routingkey_demo";
    private final static String QUEUE_NAME = "queue_demo";
    private final static String IP_ADDRESS = "175.24.66.148";
    private final static int PORT = 5672;

    public static void main(String[] args) throws IOException , TimeoutException,InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(IP_ADDRESS);
        connectionFactory.setPort(PORT);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建信道
        Channel channel = connection.createChannel();
        // 创建一个type="direct",持久化的，非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME,"headers",true,false,null);
        // 创建一个持久化，非排他的，非自动删除的队列
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);
        // 发送一条持久化的消息：hello,world!
        String message = "Hello Rabbit!";
        for (int i = 0; i < 10000; i++) {
            channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes());
        }
        // 关闭资源
        channel.close();
        connection.close();
    }
}
