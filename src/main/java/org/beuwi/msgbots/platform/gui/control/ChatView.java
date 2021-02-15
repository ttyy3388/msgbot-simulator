package org.beuwi.msgbots.platform.gui.control;

import javafx.collections.ListChangeListener;
import javafx.scene.control.SelectionMode;

public class ChatView extends ListView<ChatItem> {
	private static final String DEFAULT_STYLE_CLASS = "chat-view";

	public ChatView() {
		getItems().addListener((ListChangeListener<ChatItem>) change -> {
			while (change.next()) {
				for (ChatItem item : change.getRemoved()) {
					item.setView(null);
				}
				for (ChatItem item : change.getAddedSubList()) {
					item.setView(this);
				}
			}
		});

		/* new ContextMenu(
			new MenuItem("Select All", event -> {
				getSelectionModel().selectAll();
			})
		).setNode(this); */

		setAutoScroll(true);
		// setSelectionMode(SelectionMode.MULTIPLE);
		getStyleClass().add(DEFAULT_STYLE_CLASS);
	}
}