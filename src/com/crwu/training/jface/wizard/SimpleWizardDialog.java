package com.crwu.training.jface.wizard;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import com.crwu.common.LayoutDataUtils;
/**
 * class desc�?
 * 
 * @author WuChengRui
 * @date 2018-9-17
 */
public class SimpleWizardDialog extends WizardDialog {
    private Control createHelpControl;
    public SimpleWizardDialog(Shell parentShell, IWizard newWizard) {
        super(parentShell, newWizard);
        //当页面发生修改，会根据当前的显示也判断是否需要显示help按钮
        addPageChangedListener(new IPageChangedListener() {
            @Override
            public void pageChanged(PageChangedEvent event) {
                WizardPage page = (WizardPage) event.getSelectedPage();
                if (page.getName().equals(BookSurveyWizard.Q2)) {
                    //显示按钮
                    LayoutDataUtils.setExclude(createHelpControl, true);
                } else {
                    //隐藏
                    LayoutDataUtils.setExclude(createHelpControl, false);
                }
            }
        });
    }
    @Override
    protected int getShellStyle() {
        return SWT.NO_TRIM;
    }
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        dealChildBtnTextToCh(parent);
    }
    /**
     * 将文字修改成中文,�?好就按钮i18的方式去进行配置
     * @param parent
     */
    private void dealChildBtnTextToCh(Composite parent) {
        Control[] children = parent.getChildren();
        for (Control c : children) {
            if (c instanceof Composite) {
                dealChildBtnTextToCh((Composite) c);
                continue;
            }
            Button btn = (Button) c;
            if (btn.getText().equals(IDialogConstants.OK_LABEL)) {
                btn.setText("好的");
            } else if (btn.getText().equals(IDialogConstants.CANCEL_LABEL)) {
                btn.setText("不要�?");
            } else if (btn.getText().equals(IDialogConstants.FINISH_LABEL)) {
                btn.setText("完成�?");
            } else if (btn.getText().equals(IDialogConstants.BACK_LABEL)) {
                btn.setText("回滚");
            } else if (btn.getText().equals(IDialogConstants.NEXT_LABEL)) {
                btn.setText("下一�?");
            }
            System.out.println(btn.getText());
        }
    }
    @Override
    protected Control createHelpControl(Composite parent) {
        createHelpControl = super.createHelpControl(parent);
        return createHelpControl;
    }
}

