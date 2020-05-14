package com.crwu.training.jface;
/**
 * class  descï¼?
 * @author WuChengRui  
 * @date 2018-8-14  
 */
import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.lang.reflect.InvocationTargetException; 
import org.eclipse.core.runtime.IProgressMonitor; 
import org.eclipse.jface.action.Action; 
import org.eclipse.jface.action.MenuManager; 
import org.eclipse.jface.action.StatusLineManager; 
import org.eclipse.jface.action.ToolBarManager; 
import org.eclipse.jface.operation.IRunnableWithProgress; 
import org.eclipse.jface.resource.ImageDescriptor; 
import org.eclipse.jface.window.ApplicationWindow; 
import org.eclipse.swt.SWT; 
import org.eclipse.swt.widgets.Composite; 
import org.eclipse.swt.widgets.Control; 
import org.eclipse.swt.widgets.FileDialog; 
import org.eclipse.swt.widgets.Shell; 
import org.eclipse.swt.widgets.Text; 
import com.utils.FileUtils;
public class FileViewer extends ApplicationWindow { 
    Text text; 
    String content; 
    String lineDelimiter; 
    IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress() { 
        public void run(IProgressMonitor monitor) 
            throws InvocationTargetException, InterruptedException { 
            System.out.println("Running from thread: " + Thread.currentThread().getName()); 
            getShell().getDisplay().syncExec(new Runnable() { 
                public void run() { 
                    content = text.getText(); 
                    lineDelimiter = text.getLineDelimiter(); 
                } 
            }); 
            monitor.beginTask("Counting total number of lines", content.length()); 
            int lines = 1; 
            for(int i=0; i<content.length(); i++) { 
                if(monitor.isCanceled()) { 
                    monitor.done(); 
                    System.out.println("Action cancelled"); 
                    return; 
                } 
                if(i + lineDelimiter.length() < content.length()) { 
                    if(lineDelimiter.equals(content.substring(i, i+lineDelimiter.length()))) { 
                        lines ++; 
                    } 
                } 
                monitor.worked(1); 
                Thread.sleep(1); 
            } 
            monitor.done(); 
            System.out.println("Total number of lines: " + lines); 
        } 
    }; 
    Action actionCount = new Action("Count", ImageDescriptor.createFromFile(null, FileUtils.getSrcDir() + "/icons/logo.gif")) { 
        public void run() { 
            try { 
                FileViewer.this.run(true, true, runnableWithProgress); 
            } catch (InvocationTargetException e) { 
                e.printStackTrace(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
    }; 
    public FileViewer(Shell parentShell) { 
        super(parentShell); 
        addMenuBar(); 
        addStatusLine(); 
        addToolBar(SWT.FLAT); 
    } 
    protected Control createContents(Composite parent) { 
        getShell().setText("FileViewer v2.0"); 
        setStatus("Ready"); 
        text = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL); 
        text.setSize(300, 200); 
        return text; 
    } 
    Action actionOpenFile = new Action("Open", ImageDescriptor.createFromFile(null, FileUtils.getSrcDir() + "/icons/logo.gif")) { 
        public void run() { 
            FileDialog dialog = new FileDialog(getShell(), SWT.OPEN); 
            final String file = dialog.open(); 
            if(file != null) { 
                try { 
                    String content = readFileAsAString(new File(file)); 
                    text.setText(content); 
                    setStatus("File loaded successfully: " + file); 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                    setStatus("Failed to load file: " + file); 
                } 
            } 
        } 
    }; 
    protected MenuManager createMenuManager() { 
        MenuManager menuManager = new MenuManager(""); 
        MenuManager fileMenuManager = new MenuManager("&File"); 
        fileMenuManager.add(actionOpenFile); 
        menuManager.add(fileMenuManager); 
        MenuManager toolsMenuManager = new MenuManager("&Tools"); 
        toolsMenuManager.add(actionCount); 
        menuManager.add(toolsMenuManager); 
        return menuManager; 
    } 
    protected StatusLineManager createStatusLineManager() { 
        return super.createStatusLineManager(); 
    } 
    protected ToolBarManager createToolBarManager(int style) { 
        ToolBarManager toolBarManager = new ToolBarManager(style); 
        toolBarManager.add(actionOpenFile); 
        toolBarManager.add(actionCount); 
        return toolBarManager; 
    } 
    public static void main(String[] args) { 
        ApplicationWindow viewer = new FileViewer(null); 
        viewer.setBlockOnOpen(true); 
        viewer.open(); 
    } 
    public static String readFileAsAString(File file) throws IOException { 
        return new String(getBytesFromFile(file)); 
    } 
    public static byte[] getBytesFromFile(File file) throws IOException { 
        InputStream is = new FileInputStream(file); 
        long length = file.length(); 
        if (length > Integer.MAX_VALUE) { 
            throw new IllegalArgumentException("File is too large! (larger or equal to 2G)"); 
        } 
        byte[] bytes = new byte[(int) length]; 
        int offset = 0; 
        int numRead = 0; 
        while (offset < bytes.length 
            && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) { 
            offset += numRead; 
        } 
        if (offset < bytes.length) { 
            throw new IOException( 
                "Could not completely read file " + file.getName()); 
        } 
        is.close(); 
        return bytes; 
    } 
}

