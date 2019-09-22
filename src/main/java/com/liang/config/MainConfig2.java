package com.liang.config;

import com.liang.condition.LiunxCondition;
import com.liang.condition.MyImportBeanDefinitionRegistrar;
import com.liang.condition.MyImportSelector;
import com.liang.condition.WindowsCondition;
import com.liang.entity.Color;
import com.liang.entity.ColorFactoryBean;
import com.liang.entity.Person;
import org.springframework.context.annotation.*;

/**
 * 类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
 * @author Liangxp
 * @date 2019/6/22 11:31
 */
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
     * @return
     * @Scope:调整作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 					每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 			以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     */
    @Lazy
    @Bean
    public Person person(){
        return new Person();
    }


    /**
     * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */
    @Bean("bill")
    public Person person1(){
        return new Person("Bill gates",63);
    }
    @Conditional(LiunxCondition.class)
    @Bean("liuns")
    public Person person2(){
        return new Person("liuns",48);
    }



    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
     * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
     * 			&colorFactoryBean
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

    /**
     * Spring中的@ Component，@ Repository和@Service注释有什么区别？
     *
     * @Controller,@Service和@Repository是特殊类型的@Component annotation.<context:component-scan>并没有错
     * 并将它们的下一个类注册为bean，就好像它们是用@Component注释一样。它们被扫描，因为它们本身用注释注释为@Component。
     * 如果我们定义自己的自定义注释并使用@Component进行注释，那么它也将被扫描<context:component-scan>
     * 1)、@Repository
     *     这是为了表明该类定义了一个数据存储库。@Repository有什么特别之处？
     *     除了指出这是一个基于注释的配置之外，@Repository的工作是捕获平台特定的异常，并将它们重新抛出为Spring的统一未经检查的异常之一。
     *     为此，我们提供了3886827546，我们需要在Spring的应用程序上下文中添加如下：
     *     <bean class="org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"/>
     * 2）、@Controller
     *     @Controller annotation指示特定类充当控制器的角色。 The@Controller annotation充当带注释的类的构造型，指示其角色。
     *     @Controller有什么特别之处？
     *     我们无法将此注释与其他任何类似的@Service或@Repository切换，即使它们看起来相同。调度程序扫描用@Controller注释的类，
     *     并检测其中的@RequestMapping个注释。我们只能使用@RequestMapping on @Controller注释类。
     * 3)、@Service
     *     @Services保留存储库层中的业务逻辑和调用方法。@Service有什么特别之处？
     *     除了它用于表明它持有业务逻辑这一事实之外，这个注释没有明显的特点，但是谁知道，spring可能在未来增加一些额外的特殊功能。
     */

}
