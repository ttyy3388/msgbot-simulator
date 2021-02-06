package org.beuwi.msgbots.platform.gui.control;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;

import javafx.scene.layout.Priority;

import org.beuwi.msgbots.platform.gui.layout.StackPane;
import org.beuwi.msgbots.platform.gui.layout.VBox;
import org.beuwi.msgbots.setting.SharedSettings;

// Option Box
public class OptionItem extends VBox {
	private static final String DEFAULT_STYLE_CLASS = "option-box";
	private static final int DEFAULT_SPACING_VALUE = 10;

	// Title [ Content ]
	private final StringProperty titleProperty = new SimpleStringProperty();
	private final ObjectProperty<Node> contentProperty = new SimpleObjectProperty<>();

	// address : "type:head:value > "global:program:start_auto_compile"
	private final StringProperty addressProperty = new SimpleStringProperty();
	// value start_auto_compile
	// private final StringProperty valueProperty = new SimpleStringProperty();

	// Title Label
	private final Label label = new Label();
	// Content Panel
	private final StackPane panel = new StackPane();

	private OptionView parent;

	{
		VBox.setVgrow(panel, Priority.ALWAYS);
	}

	public OptionItem(/* @NamedArg("type") PrefType type */) {
		addressProperty().addListener(event -> {
			// 어드레스에 "{$name}"과 같이 변수 삽입 부분이 남아있다면 작동 X
			if (getAddress().indexOf("$") != -1) {
				return ;
			}

			if (getContent() instanceof Button) {
			}
			else if (getContent() instanceof CheckBox) {
				CheckBox control = (CheckBox) getContent();
				control.setSelected(SharedSettings.getData(getAddress()));
				control.selectedProperty().addListener(change -> {
					SharedSettings.setData(getAddress(), control.isSelected());
				});
			}
			else if (getContent() instanceof TextArea) {
				TextArea control = (TextArea) getContent();
				control.setText(SharedSettings.getData(getAddress()));
				control.focusedProperty().addListener(change -> {
					SharedSettings.setData(getAddress(), control.getText());
				});
			}
			else if (getContent() instanceof TextField) {
				TextField control = (TextField) getContent();
				control.setText(SharedSettings.getData(getAddress()));
				control.focusedProperty().addListener(change -> {
					SharedSettings.setData(getAddress(), control.getText());
				});
			}
			else if (getContent() instanceof ToggleButton) {
				ToggleButton control = (ToggleButton) getContent();
				control.setSelected(SharedSettings.getData(getAddress()));
				control.selectedProperty().addListener(change -> {
					SharedSettings.setData(getAddress(), control.isSelected());
				});
			}
			else if (getContent() instanceof ToggleSwitch) {
				ToggleSwitch control = (ToggleSwitch) getContent();
				control.setSelected(SharedSettings.getData(getAddress()));
				control.selectedProperty().addListener(change -> {
					SharedSettings.setData(getAddress(), control.isSelected());
				});
			}
			else if (getContent() instanceof Slider) {
				Slider control = (Slider) getContent();
				control.setValue(SharedSettings.getInt(getAddress()));
				control.focusedProperty().addListener(change -> {
					SharedSettings.setData(getAddress(), control.getValue());
				});
			}
			else if (getContent() instanceof ComboBox) {
				/* ComboBox control = (ComboBox) getContent();
				if (getAddress().equals("global:program:color_theme")) {
					control.selectItem(ThemeType.parse(SharedSettings.getData(getAddress())));
					control.selectedItemProperty().addListener(change -> {
						ThemeType theme = (ThemeType) control.getSelectedItem();
						SharedSettings.setData(getAddress(), theme.toString());
						SetColorThemeAction.execute(theme);
					});
				} */
			}
		});

		label.getStyleClass().add("title");
		panel.getStyleClass().add("content");
		panel.setAlignment(Pos.CENTER_LEFT);

		titleProperty().addListener(change -> {
			label.setText(getTitle());
		});

		contentProperty().addListener(change -> {
			panel.getChildren().setAll(getContent());
		});

		setSpacing(DEFAULT_SPACING_VALUE);
		getChildren().setAll(label, panel);
		getStyleClass().add(DEFAULT_STYLE_CLASS);
	}

	public void setTitle(String title) {
		titleProperty.set(title);
	}
	public void setContent(Node content) {
		contentProperty.set(content);
	}
	public void setAddress(String address) {
		addressProperty.set(address);
	}

	public String getTitle() {
		return titleProperty.get();
	}
	public String getAddress() {
		return addressProperty.get();
	}
	public Node getContent() {
		return contentProperty.get();
	}

	public StringProperty titleProperty() {
		return titleProperty;
	}
	public StringProperty addressProperty() {
		return addressProperty;
	}
	public ObjectProperty<Node> contentProperty() {
		return contentProperty;
	}
}