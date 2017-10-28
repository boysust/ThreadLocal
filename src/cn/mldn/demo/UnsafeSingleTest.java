package cn.mldn.demo;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
public class UnsafeSingleTest {
   public static void main(String[] args) throws Exception{
	  Field field = Unsafe.class.getDeclaredField("theUnsafe");
	  field.setAccessible(true);  //取消掉封装
	  Unsafe unsafe = (Unsafe) field.get(null);
	  //不采用正规的实例化模式，利用JVM底层的c++实现实例化对象
	  Singleton instance = (Singleton) unsafe.allocateInstance(Singleton.class);
	  instance.print();  //这个时候并没有实例化Singleton类对象，而是直接调用方法
   }
}
class Singleton{
	private Singleton() {
		System.out.println("****实例化Singleton类对象********");
	}
	public void print() {
		System.out.println("wwww.mldn.cn");
	}
}
