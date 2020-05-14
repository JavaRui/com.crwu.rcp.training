package com.crwu.training.jface.tableviewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
/**
 * @author cr.wu
 * 
 *         2015-8-2
 */
public class SimpleTableSorter extends ViewerSorter{
	private static final int ASCENDING = 0;
	private static final int DESCENDING = 1;
	private int order;
	protected int column;
	private SimpleLabelProvider provider ;
	
	/**
     * 
     */
    public SimpleTableSorter() {
        provider = new SimpleLabelProvider();
    }
	
	public void doSort(int column) {
		if (column == this.column) {
			order = 1 - order;
		} else {
			this.column = column;
			order = ASCENDING;
		}
	}
	/**
	 * 
	 */
	public int compare(Viewer viewer, Object e1, Object e2) {
		int sort = 0;
		String object = provider.getColumnText(e1, column);
		String object2 = provider.getColumnText(e2, column);
		sort = object.compareTo(object2);
		if (order == DESCENDING) {
			sort = -sort;
		}
		return sort;
	}
}

