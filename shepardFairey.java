import java.awt.*;
import java.util.*;
import java.util.List;
public class shepardFairey
{
	public static void method1(Picture p)
	{
		Pixel[] pixels = p.getPixels();
		int grey;
		double color;
		for(Pixel dot : pixels)
		{
			grey = (int)((dot.getRed() + dot.getGreen() + dot.getBlue()) / 3);
			color = grey / (255 / 4);
			if(color <= 1)
				dot.setColor(new Color(170, 57, 57));
			else if(color <= 2)
				dot.setColor(new Color(170, 150, 57));
			else if(color <= 3)
				dot.setColor(new Color(64, 48, 117));
			else if(color <= 4)
				dot.setColor(new Color(45, 136, 45));
		}
	}

	public static void method2(Picture p)
	{
		Pixel[] pixels = p.getPixels();
		int grey;
		double color;
		int s = 255;
		int b = 0;
		for(Pixel dot : pixels)
		{
			grey = (int)((dot.getRed() + dot.getGreen() + dot.getBlue()) / 3);
			if(grey < s)
				s = grey;
			if(grey > b)
				b = grey;
		}
		double space = (b - s) / 4;
		for(Pixel dot2 : pixels)
		{
			grey = (int)((dot2.getRed() + dot2.getGreen() + dot2.getBlue()) / 3);
			color = grey / space;

			if(color <= 1)
				dot2.setColor(new Color(255, 0, 0));
			else if(color <= 2)
				dot2.setColor(new Color(0, 0, 220));
			else if(color <= 3)
				dot2.setColor(new Color(100, 255, 255));
			else if(color <= 4)
				dot2.setColor(new Color(80, 160, 60));
		}
	}

	public static void main (String[] args)
	{
		//Picture pic1 = new Picture("images/spiderman.jpg");
		Picture pic2 = new Picture( FileChooser.pickAFile());

		//method1(pic1);
		method2(pic2);
		//pic1.explore();
		pic2.explore();
		//pic1.write("images/method1.jpg");
		pic2.write("images/method2.png"); //seems to have less jpeg compression artifacts
	}
}