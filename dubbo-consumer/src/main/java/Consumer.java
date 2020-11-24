import com.reinmind.service.interf.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        // Obtaining a remote service proxy
        GreetingService greetingService = (GreetingService) context.getBean("demoService");
        // Executing remote methods
        String hello = greetingService.sayHi("world");
        // Display the call result
        System.out.println(hello);
    }
}
