package cn.mldn.demo;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
public class UnsafeSingleTest {
   public static void main(String[] args) throws Exception{
	  Field field = Unsafe.class.getDeclaredField("theUnsafe");
	  field.setAccessible(true);  //ȡ������װ
	  Unsafe unsafe = (Unsafe) field.get(null);
	  //�����������ʵ����ģʽ������JVM�ײ��c++ʵ��ʵ��������
	  Singleton instance = (Singleton) unsafe.allocateInstance(Singleton.class);
	  instance.print();  //���ʱ��û��ʵ����Singleton����󣬶���ֱ�ӵ��÷���
   }
}
class Singleton{
	private Singleton() {
		System.out.println("****ʵ����Singleton�����********");
	}
	public void print() {
		System.out.println("wwww.mldn.cn");
	}
}
