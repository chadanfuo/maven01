package chap03;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WorkScheduler implements ApplicationContextAware{

	private WorkRunner workRunner;
	private ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx=applicationContext;
	}	
	public void makeAndRunner(){
		for(long order =1;order <=10;order++){
			//getbean을 하려면 컨테이너가 있어야하는데  
			//setApplicationContext -->GenericXmlApplicationContext 
			//ctx로 연결 ApplicationContextAware가 연결시킴
			Work work=ctx.getBean("workProto",Work.class);
			work.setOrder(order);
			workRunner.execute(work);
		}
	}
	public void setWorkRunner(WorkRunner workRunner){
		this.workRunner=workRunner;
	}
	
}
