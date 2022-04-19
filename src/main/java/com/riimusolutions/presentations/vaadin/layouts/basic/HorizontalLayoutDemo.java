package com.riimusolutions.presentations.vaadin.layouts.basic;

import com.riimusolutions.presentations.vaadin.util.Utils;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("horizontal-layout")
public class HorizontalLayoutDemo extends VerticalLayout {

    private final HorizontalLayout toolbar;
    private final TextField searchField;
    private final Button searchButton;

    public HorizontalLayoutDemo() {
        setSizeFull();
        Div container = Utils.createBorderContainer();
        container.setSizeFull();
        add(container);

        toolbar = new HorizontalLayout();
        toolbar.setSizeFull();
        toolbar.setBoxSizing(BoxSizing.BORDER_BOX);
        Utils.setBorder(toolbar, "green");

        searchField = new TextField();
        searchButton = new Button("Search");

        toolbar.add(searchField, searchButton);
        container.add(toolbar);

        RadioButtonGroup<Boolean> margin = Utils.createBooleanRadioGroup("Margin", false, toolbar::setMargin);
        RadioButtonGroup<Boolean> padding = Utils.createBooleanRadioGroup("Padding", false, toolbar::setPadding);
        RadioButtonGroup<Boolean> spacing = Utils.createBooleanRadioGroup("Spacing", true, toolbar::setSpacing);
        RadioButtonGroup<Boolean> flexGrow = Utils.createBooleanRadioGroup("Flex grow text", false,
                value -> toolbar.setFlexGrow(value ? 1D : 0D, searchField));

        ComboBox<JustifyContentMode> justifyContent = Utils.createJustifyContentComboBox(toolbar::setJustifyContentMode);
        ComboBox<Alignment> alignmentComboBox = Utils.createAlignmentComboBox(toolbar::setAlignItems);

        HorizontalLayout configurationToolbar = new HorizontalLayout();
        configurationToolbar.add(margin, padding, spacing, flexGrow, justifyContent, alignmentComboBox);
        add(configurationToolbar);

    }

}
