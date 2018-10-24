import com.faunjoe.beans.Car;
import com.faunjoe.beans.Person;
import com.faunjoe.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 13:59
 */
public class MainConfigurationTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("-----------Person-------------");
        Person persion1 = (Person) applicationContext.getBean("person");
        Person persion2 = applicationContext.getBean(Person.class);
        System.out.println(persion1);
        System.out.println(persion2);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        for(String name : beanNamesForType){
            System.out.println(name);
        }

        System.out.println("-----------Car-------------");
        Car car1 = (Car) applicationContext.getBean("car01");
        Car car2 = applicationContext.getBean(Car.class);
        System.out.println(car1);
        System.out.println(car2);

        String[] carBeanNamesForType = applicationContext.getBeanNamesForType(Car.class);

        for(String name : carBeanNamesForType){
            System.out.println(name);
        }
    }
}
