package com.crwu.rcp.training.view;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import com.utils.ShellBack;
import com.utils.UiUtils;
import com.crwu.rcp.training.action.SelectionProviderAction;
import com.crwu.rcp.training.model.Country;
/**
 * class desc�??
 * 
 * @author WuChengRui
 * @date 2018-6-26
 */
public class SelectionProviderTestView extends ViewPart implements ISelectionListener, ISelectionChangedListener  , IPartListener{
    public static String ID = "com.crwu.rcp.training.view.SelectionProviderTestView";
    private ListViewer listViewer;
    private ISelection selection;
    ArrayList myListeners = new ArrayList();
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            @Override
            public void callBack(Shell shell) {
                ListViewer listViewer = new ListViewer(shell, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
                listViewer.setLabelProvider(new ListLabelProvider());
                listViewer.setContentProvider(new ContentProvider());
                listViewer.setInput(Country.getCountryList());
                listViewer.add(new Country("英国"));
            }
        });
    }
    @Override
    public void createPartControl(Composite parent) {
        listViewer = new ListViewer(parent, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        listViewer.setLabelProvider(new ListLabelProvider());
        listViewer.setContentProvider(new ContentProvider());
        listViewer.setInput(Country.getCountryList());
        listViewer.add(new Country("英国"));
        SelectionProviderAction selectionProviderAction = new SelectionProviderAction(getSite().getWorkbenchWindow());
        // MenuManager menuMgr = new MenuManager("#PopupMenu");
        // menuMgr.add(selectionProviderAction);
        //
        // Menu menu = menuMgr.createContextMenu(listViewer.getControl());
        // listViewer.getControl().setMenu(menu);
        //
        // getSite().registerContextMenu(menuMgr, listViewer);
        // getSite().setSelectionProvider(listViewer);
        listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
                
                ISelection selection2 = event.getSelection();
                setSelection(selection2);
            }
        });
        addSelectionChangedListener(this);
        getSite().getPage().addSelectionListener(this);
    }
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        if (!myListeners.contains(listener))
            myListeners.add(listener);
    }
    public void setSelection(ISelection selection) {
        this.selection = selection;
        SelectionChangedEvent event2 = new SelectionChangedEvent(listViewer, selection);
        for (Iterator i = myListeners.iterator(); i.hasNext();) {
            ISelectionChangedListener object = (ISelectionChangedListener) i.next();
            System.out.println(event2);
            object.selectionChanged(event2);
        }
    }
    static class ListLabelProvider extends LabelProvider {
        public String getText(Object element) {
            Country country = (Country) element;
            return country.getName();
        }
        public Image getImage(Object element) {
            return null;
        }
    }
    static class ContentProvider implements IStructuredContentProvider {
        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof List) {
                List list = (List) inputElement;
                return list.toArray();
            }
            return new Object[0];
        }
        public void dispose() {
        }
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }
    }
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        System.out.println("---------------------");
    }
    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
     */
    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        System.out.println("??????????????????");
    }
    
    @Override
    public void setFocus() {
        System.out.println(ID + "setFocus");
    }
    @Override
    public void partActivated(IWorkbenchPart part) {
        System.out.println(ID + "partActivated");
    }
    @Override
    public void partBroughtToTop(IWorkbenchPart part) {
        System.out.println(ID + "partBroughtToTop");
    }
    @Override
    public void partClosed(IWorkbenchPart part) {
        System.out.println(ID + "partClosed");
    }
    @Override
    public void partDeactivated(IWorkbenchPart part) {
        System.out.println(ID + "partDeactivated");
    }
    @Override
    public void partOpened(IWorkbenchPart part) {
        System.out.println(ID + "partOpened");
    }
    
}

