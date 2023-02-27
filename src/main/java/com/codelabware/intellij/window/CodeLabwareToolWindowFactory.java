package com.codelabware.intellij.window;

import com.codelabware.intellij.message.CodeLabwareBundle;
import com.codelabware.intellij.view.editor.Editor;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.EditorComboBox;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/LiLittleCat">LiLittleCat</a>
 * @since 2023/2/26
 */
public class CodeLabwareToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentManager contentManager = toolWindow.getContentManager();


//        Content labelContent = contentManager.getFactory().createContent(new Editor(project, Editor.JSON_FILE_TYPE), CodeLabwareBundle.message("plugin.name"), false);
        Content labelContent = contentManager.getFactory().createContent(new EditorTextField(project, Editor.JSON_FILE_TYPE), CodeLabwareBundle.message("plugin.name"), false);
        Content labelContent1 = contentManager.getFactory().createContent(new EditorComboBox("test"), CodeLabwareBundle.message("plugin.name"), false);
        contentManager.addContent(labelContent);
        contentManager.addContent(labelContent1);
//        // add actions to tool window
//        List<AnAction> anActionList = new ArrayList<>();
//        anActionList.add(new SettingsAction("Settings"));
//        anActionList.add(new RefreshAction("Refresh"));
//        toolWindow.setTitleActions(anActionList);
    }
}
