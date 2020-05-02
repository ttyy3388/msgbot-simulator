package org.beuwi.simulator.platform.application.views.actions;

import javafx.scene.control.SplitPane;
import org.beuwi.simulator.platform.application.views.parts.EditorAreaPart;
import org.beuwi.simulator.platform.ui.components.IPos;
import org.beuwi.simulator.platform.ui.editor.IEditorTab;

public class MoveEditorPaneAction
{
	private static SplitPane pane;

	public static void initialize()
	{
		pane = EditorAreaPart.getComponent();
	}

	public static void update(IEditorTab tab, IPos pos)
	{
		/* // IEditor Pane
		List<Node> panes = pane.getItems();

		IEditorPane editor = tab.getEditorPane();

		int index = panes.indexOf(editor);

		IEditorPane target = null;

		switch (pos)
		{
            case RIGHT :

				if (index + 1 < panes.size())
				{
                    target = (IEditorPane) panes.get(index + 1);
				}

				break;

            case LEFT :

			    if (index != 0)
                {
					target = (IEditorPane) panes.get(index - 1);
                }

				break;
		}

		editor.removeTab(tab);
		target.addTab(tab); */
	}
}