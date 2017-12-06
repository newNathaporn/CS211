

import java.util.EnumMap;

enum MyColor{
	RED, GREEN, BLUE
}
public class EnumMapExample {
	public static void main (String ...string){
		EnumMap<MyColor,String> colorRGB = new EnumMap<MyColor,String>(MyColor.class);
		colorRGB.put(MyColor.GREEN,"0,255,0");
		colorRGB.put(MyColor.GREEN,"0,255,255");
		
		System.out.println(colorRGB.get(MyColor.GREEN));
	}

}
