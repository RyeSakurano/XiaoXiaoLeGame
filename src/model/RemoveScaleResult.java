package model;
 
import java.util.List;
 
/** 
 * 消除刻度结果
 *
 * @author  k60
 */
public class RemoveScaleResult {
 
	/**
	 * 消除的单元格
	 */
	private List<List<Cell>> removeCellList;
	
	/**
	 * 新产生的单元格颜色列表
	 * 
	 * 产生规则：
	 * X轴,由左至右补
	 * Y轴，由下至上补
	 */
	private List<Cell> newCellList;
	
 
	public List<List<Cell>> getRemoveCellList() {
		return removeCellList;
	}
 
	public void setRemoveCellList(List<List<Cell>> removeCellList) {
		this.removeCellList = removeCellList;
	}
 
	public List<Cell> getNewCellList() {
		return newCellList;
	}
 
	public void setNewCellList(List<Cell> newCellList) {
		this.newCellList = newCellList;
	}
 
 
}
