package com.codelabware.intellij.ui.frame;

import com.codelabware.intellij.action.RefreshAction;
import com.intellij.find.FindModel;
import com.intellij.find.impl.FindInProjectUtil;
import com.intellij.ide.CommonActionsManager;
import com.intellij.ide.OccurenceNavigator;
import com.intellij.ide.actions.NextOccurenceToolbarAction;
import com.intellij.ide.actions.PreviousOccurenceToolbarAction;
import com.intellij.ide.todo.SetTodoFilterAction;
import com.intellij.ide.todo.TodoPanel;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.util.Disposer;
import com.intellij.ui.content.Content;
import com.intellij.usages.impl.UsagePreviewPanel;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 * <p>
 * BasePanel extends SimpleToolWindowPanel
 * </p>
 *
 * @author <a href="https://github.com/LiLittleCat">LiLittleCat</a>
 * @since 2023/2/28
 */

public abstract class BasePanel extends SimpleToolWindowPanel implements OccurenceNavigator, DataProvider, Disposable {
    protected static final Logger LOG = Logger.getInstance(TodoPanel.class);
    protected Project myProject;
    private Content myContent;

    public BasePanel(Project project, Content content) {
        super(false, true);
        myProject = project;
        myContent = content;
        initUI();
    }

    public BasePanel(boolean vertical, boolean borderless) {
        super(vertical, borderless);
    }

    private void initUI() {
        DefaultActionGroup group = new DefaultActionGroup();
        group.add(ActionManager.getInstance().getAction(IdeActions.ACTION_EDIT_SOURCE));
        group.addSeparator();
        group.addSeparator();
        group.add(ActionManager.getInstance().getAction(IdeActions.GROUP_VERSION_CONTROLS));
//        setContent(createCenterComponent());

        // Create tool bars and register custom shortcuts

        DefaultActionGroup toolbarGroup = new DefaultActionGroup();
        toolbarGroup.add(new RefreshAction("Refresh"));


        setToolbar(ActionManager.getInstance().createActionToolbar(ActionPlaces.TODO_VIEW_TOOLBAR, toolbarGroup, false).getComponent());

    }
}
