package chap03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// setProperty1,BeanNameAware,ApplicationContextAware 찍고 before 찍고  @PostConstruct , xml :init-method="customInit" customInit() ,after,destory
public class MyBean implements BeanNameAware,ApplicationContextAware,InitializingBean,DisposableBean{
	public void setProperty1(String property1){
		System.out.println("MyBean.setProperty1() 실행");
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware.setBeanName() 실행");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware.setApplicationContext() 실행");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() 실행");
	}
	public void customInit(){
		System.out.println("MyBean.customInit() 실행");
	}
	@PostConstruct
	public void PostConstruct(){
		System.out.println("@PostConstruct() 실행");
	}
	@PreDestroy
	public void preDestory(){
		System.out.println("@PreDestory() 실행");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destory() 실행");
	}
	public void customDestory(){
		System.out.println("MyBean.customDestory() 실행");
	}

}
