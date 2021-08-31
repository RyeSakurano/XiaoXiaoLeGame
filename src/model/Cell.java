package model;
 
import constant.Mycolor;
import java.util.Random;
 
/**
 * 单元格
 * 
 * @author k60
 */
public class Cell {
 
	/**
	 * x坐标
	 */
	public int X;
 
	/**
	 * y坐标
	 */
	public int Y;
 
	/**
	 * 颜色
	 */
	public Mycolor color;
	public int color_num;
 
	public Cell() {
		super();
		color_num = new Random().nextInt(5);
	}
 
	public Cell(int x, int y) {
		super();
		X = x;
		Y = y;
		color_num = new Random().nextInt(5);
	}
 
	public int getX() {
		return X;
	}
 
	public void setX(int x) {
		X = x;
	}
 
	public int getY() {
		return Y;
	}
 
	public void setY(int y) {
		Y = y;
	}
 
	public Mycolor getColor() {
		return color;
	}
 
	public void setColor(Mycolor color) {
		this.color = color;
		if(color.name().equals("RED")) color_num = 0;
		else if(color.name().equals("YELLOW")) color_num = 1;
		else if(color.name().equals("GREEN"))  color_num = 2;
		else if(color.name().equals("BLUE"))   color_num = 3;
		else color_num = 4;
	}
 
	public boolean nearCell(Cell cell) {
		if (cell != null) {
			if (this.X == cell.X && this.Y == (cell.Y + 1)) {
				return true;
			} else if (this.X == cell.X && this.Y == (cell.Y - 1)) {
				return true;
			} else if (this.X == (cell.X + 1) && this.Y == cell.Y) {
				return true;
			} else if (this.X == (cell.X - 1) && this.Y == cell.Y) {
				return true;
			}
		}
		return false;
	}
    

	public String toString() {
		return this.X+"_"+this.Y+":"+this.color;
				
	}
 

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}
 

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		return true;
	}
	
	public Cell clone(){
		Cell cell=new Cell();
		cell.setX(this.X);
		cell.setY(this.Y);
		cell.setColor(this.color);
		return cell;
	}
	
	
}
