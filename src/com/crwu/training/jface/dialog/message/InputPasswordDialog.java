/**
 * 
 */
package com.crwu.training.jface.dialog.message;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.utils.ShellBack;
import com.utils.UiUtils;
/**
 * @author cr.wu
 *
 */
public class InputPasswordDialog extends TitleAreaDialog {
    private Text userName;
    private Text password;
    private Text confirm;
    public final String DEFAULT_INFO = "请输入要注册的用户名和密�?";
    /**
     * @param parentShell
     */
    public InputPasswordDialog(Shell parentShell) {
        super(parentShell);
        // TODO Auto-generated constructor stub
    }
    
    protected Control createContents(Composite parent){
        super.createContents(parent);
        this.getShell().setText("用户注册对话�?");
        this.setTitle("用户注册");
        this.setMessage("请输入要注册的用户名和密�?");
        return parent;
    }
    
    protected Control createDialogArea(Composite parent){
        super.createDialogArea(parent);
        Composite composite = new Composite(parent,SWT.NONE);
        composite.setLayout(new GridLayout(2,true));
        new Label(composite, SWT.NONE).setText("用户�?");;
        
        userName = new Text(composite,SWT.BORDER);
        userName.addFocusListener (new FocusAdapter() {
            public void focusLost(FocusEvent e){
                checkValid();
            }
        });
        
        new Label(composite,SWT.NONE).setText("password");;
        password = new Text(composite, SWT.BORDER);
        password.setEchoChar('*');
        new Label(composite,SWT.NONE).setText("confirm");;
        confirm = new Text(composite, SWT.BORDER);
        confirm.setEchoChar('*');
        confirm.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e){
                checkValid();
            }
        });
        return parent;
    }
    
    protected void checkValid(){
        if(!password.getText().equals(confirm.getText())){
            setMessage("确认密码不一致，请重新输�?",IMessageProvider.WARNING);
            
        }else if(userName.getText().equals("")){
            setMessage("用户名为�?",IMessageProvider.ERROR);
            
        }else setMessage(DEFAULT_INFO);
    }
    
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
                new InputPasswordDialog(shell).open();
                
            }
        });
    }
    
}

