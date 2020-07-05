
package Ex6;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class AccessTest {


	public static void main(String[] args) {


		ArrayLife arrtest = new ArrayLife();
		Class c1 = arrtest.getClass();

		System.out.println("The name of the class is " + c1.getName());
		System.out.println("================");

		for (Method method : c1.getDeclaredMethods()) {
		
			int modifiers = method.getModifiers();

			if (Modifier.isPublic(modifiers)) {

				System.out.println(method.getName() + " (public)");

			}

			if (Modifier.isPrivate(modifiers)) {

				System.out.println(method.getName() + " (private)");

			}

		}

		System.out.println("================");
			
                Pattern p = new Pattern("Glider:Richard Guy (1970):20:20:1:1:010 001 111");
		Class c2 = p.getClass();

                System.out.println("The name of the class is " + c2.getName());
                System.out.println("================");

                for (Method method : c2.getDeclaredMethods()) {

                        int modifiers = method.getModifiers();

                        if (Modifier.isPublic(modifiers)) {

                                System.out.println(method.getName() + " (public)");

                        }

                        if (Modifier.isPrivate(modifiers)) {

                                System.out.println(method.getName() + " (private)");

                        }

                }

                System.out.println("================");
                                        





	}


}

