package com.codelabware.intellij.window;

import com.codelabware.intellij.ui.frame.SearchableListDemo;
import com.codelabware.intellij.view.editor.Editor;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author <a href="https://github.com/LiLittleCat">LiLittleCat</a>
 * @since 2023/2/26
 */
public class CodeLabwareToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {



        ContentManager contentManager = toolWindow.getContentManager();

//        Content labelContent = contentManager.getFactory().createContent(new Editor(project, Editor.JSON_FILE_TYPE), CodeLabwareBundle.message("plugin.name"), false);
//        Content labelContent = contentManager.getFactory().createContent(new EditorTextField(project, Editor.JSON_FILE_TYPE), CodeLabwareBundle.message("plugin.name"), false);
        Content labelContent = contentManager.getFactory().createContent(new SearchableListDemo(), "Welcome", false);
//        labelContent.setCloseable(true);


        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
            Content content = contentFactory.createContent(new Editor(project, Editor.JSON_FILE_TYPE), "New Content", false);
            contentManager.addContent(content);
        });

        labelContent.setActions( new ActionGroup() {
            @NotNull
            @Override
            public AnAction[] getChildren(@Nullable AnActionEvent e) {
                return new AnAction[]{new AnAction("Add") {
                    @Override
                    public void actionPerformed(@NotNull AnActionEvent e) {
                        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
                        Content content = contentFactory.createContent(new Editor(project, Editor.JSON_FILE_TYPE), "New Content", false);
                        contentManager.addContent(content);
                    }
                }};
            }
        }, "Add", addButton );

        contentManager.addContent(labelContent);




//        // add actions to tool window
//        List<AnAction> anActionList = new ArrayList<>();
//        anActionList.add(new SettingsAction("Settings"));
//        anActionList.add(new RefreshAction("Refresh"));
//        toolWindow.setTitleActions(anActionList);
    }
}
