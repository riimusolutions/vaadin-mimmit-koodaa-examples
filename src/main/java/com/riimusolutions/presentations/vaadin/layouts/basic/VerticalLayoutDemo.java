package com.riimusolutions.presentations.vaadin.layouts.basic;

import com.riimusolutions.presentations.vaadin.util.Utils;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("vertical-layout")
public class VerticalLayoutDemo extends VerticalLayout {

    public VerticalLayoutDemo() {
        setSizeFull();

        VerticalLayout content = new VerticalLayout();
        setFlexGrow(1, content);
        Utils.setBorder(content, "blue");
        add(content);

        for (int i = 0; i < 5; i++) {
            content.add(new Button("Button " + (i + 1)));
        }
        TextArea textArea = new TextArea();
        content.add(textArea);

        RadioButtonGroup<Boolean> margin = Utils.createBooleanRadioGroup("Margin", false, content::setMargin);
        RadioButtonGroup<Boolean> padding = Utils.createBooleanRadioGroup("Padding", true, content::setPadding);
        RadioButtonGroup<Boolean> spacing = Utils.createBooleanRadioGroup("Spacing", true, content::setSpacing);
        RadioButtonGroup<Boolean> flexGrow = Utils.createBooleanRadioGroup("Flex grow text", false,
                value -> content.setFlexGrow(value ? 1D : 0D, textArea));

        ComboBox<JustifyContentMode> justifyContent = Utils.createJustifyContentComboBox(content::setJustifyContentMode);
        ComboBox<Alignment> alignmentComboBox = Utils.createAlignmentComboBox(content::setAlignItems);

        HorizontalLayout configurationToolbar = new HorizontalLayout();
        configurationToolbar.add(margin, padding, spacing, flexGrow, justifyContent, alignmentComboBox);
        add(configurationToolbar);
    }

}
