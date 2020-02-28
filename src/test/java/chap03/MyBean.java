package chap03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// setProperty1,BeanNameAware,ApplicationContextAware ��� before ���  @PostConstruct , xml :init-method="customInit" customInit() ,after,destory
public class MyBean implements BeanNameAware,ApplicationContextAware,InitializingBean,DisposableBean{
	public void setProperty1(String property1){
		System.out.println("MyBean.setProperty1() ����");
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware.setBeanName() ����");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware.setApplicationContext() ����");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() ����");
	}
	public void customInit(){
		System.out.println("MyBean.customInit() ����");
	}
	@PostConstruct
	public void PostConstruct(){
		System.out.println("@PostConstruct() ����");
	}
	@PreDestroy
	public void preDestory(){
		System.out.println("@PreDestory() ����");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destory() ����");
	}
	public void customDestory(){
		System.out.println("MyBean.customDestory() ����");
	}

}
