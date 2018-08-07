package 多线程;

import java.util.ArrayList;
import java.util.List;


public class 消费者生产者 {
	public static void main(String[] args) {
		List<Integer> li=new ArrayList<>();
		for(int i =0;i<10;i++)
		{
			Thread d=new Thread(new Producer(li),"producer"+i);
			Thread d2 =new Thread(new Consumer(li),"consumer"+i);
			d.start();
			
			d2.start(); 
		}
		for(int i=0;i<10;i++)
		{
			
		}
	}
	
}

class Producer implements Runnable
{
	int max_size=10;
	List<Integer> l;
	public Producer(List<Integer> li)
	{
		l=li;
	}
	public void run()
	{
		synchronized (l) {
			while(l.size()==max_size)
			{
				try {
					l.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" produce: "+(l.size()+1));
			l.add(l.size()+1);  
			l.notifyAll();
		}
	}
}


class Consumer implements Runnable
{
	int max_size=10;
	List<Integer> l;
	public Consumer(List<Integer> li)
	{
		l=li;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (l) {
			while(l.size()==0)
			{
				try {
					l.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" consume: "+ l.get(l.size()-1));
			l.remove(l.size()-1);
			l.notifyAll();
		}
		
	}
	
	
}
